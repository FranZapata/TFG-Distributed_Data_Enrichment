package com.tfg.procesado_anuncios.aplicacion;

import com.fasterxml.jackson.databind.JsonNode;
import com.tfg.anuncios.contratos.evento.AnuncioFalloLlmEvent;
import com.tfg.anuncios.contratos.evento.AnuncioProcesadoEvent;
import com.tfg.anuncios.contratos.evento.AnuncioSinProcesarEvent;
import com.tfg.procesado_anuncios.infraestructura.Cliente.LlmCliente;
import com.tfg.procesado_anuncios.infraestructura.excepciones.ExcepcionLlmParse;
import com.tfg.procesado_anuncios.infraestructura.kafka.AnuncioFalloLlmProducer;
import com.tfg.procesado_anuncios.infraestructura.kafka.AnuncioProcesadoProducer;
import com.tfg.procesado_anuncios.mapeador.AnuncioProcesadoMapper;
import com.tfg.procesado_anuncios.modelo.dto.PlantillaPromptDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ServicioProcesadoAnuncio {

    private final ServicioPlantillaPrompt servicioPlantillaPrompt;
    private final LlmCliente llmCliente;
    private final AnuncioProcesadoMapper mapper;
    private final AnuncioProcesadoProducer producer;
    private final AnuncioFalloLlmProducer falloLlmProducer;

    @Value("${ollama.url}")
    private String url;

    @Value("${ollama.modelo}")
    private String modelo;

    public void procesar(AnuncioSinProcesarEvent eventoAnuncioSinProcesar) {

        log.info("Procesando anuncio: {}", eventoAnuncioSinProcesar.getIdAnuncio());

        PlantillaPromptDto plantillaPromptDto = servicioPlantillaPrompt.obtenerPlantillaPrompt(eventoAnuncioSinProcesar.getIdCategoriaFk());

        String contenidoPlantillaPrompt = plantillaPromptDto.getContenido();
        String promptFinal = contenidoPlantillaPrompt.replace("{DESCRIPCION}", eventoAnuncioSinProcesar.getDescripcion());
        log.info("Prompt final: {}", promptFinal);

        try {
            JsonNode respuesta = llmCliente.generar(promptFinal,url, modelo);
            log.info("JSON LLM: {}", respuesta);

            AnuncioProcesadoEvent eventoAnuncioProcesado = mapper.map(eventoAnuncioSinProcesar, respuesta, modelo, plantillaPromptDto.getIdPlantillaPrompt());

            producer.enviar(eventoAnuncioProcesado);
        }catch(ExcepcionLlmParse e){
            log.error("Fallo LLM, enviando a topic de errores");
            falloLlmProducer.enviar(
                    AnuncioFalloLlmEvent.builder()
                            .anuncio(eventoAnuncioSinProcesar)
                            .respuestaCruda(e.getRespuestaLlm())
                            .fecha(e.getFecha())
                            .intentos(e.getIntentos())
                            .error(e.getMessage())
                            .modelo(modelo)
                            .idPlantillaPrompt(plantillaPromptDto.getIdPlantillaPrompt())
                            .build()
            );
            throw e;
        }
    }
}
