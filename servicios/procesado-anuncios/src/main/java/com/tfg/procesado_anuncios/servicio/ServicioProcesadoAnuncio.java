package com.tfg.procesado_anuncios.servicio;

import com.tfg.procesado_anuncios.kafka.ProductorAnuncioProcesado;
import com.tfg.procesado_anuncios.llm.LlmClient;
import com.tfg.procesado_anuncios.modelo.EventoAnuncioProcesado;
import com.tfg.procesado_anuncios.modelo.EventoAnuncioSinProcesar;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServicioProcesadoAnuncio {

    private final LlmClient llmClient;
    private final ProductorAnuncioProcesado productorAnuncioProcesado;

    public void procesar(EventoAnuncioSinProcesar anuncioSinProcesar){

        //Lllamada llm simulada
        String categoria = llmClient.detectCategory(anuncioSinProcesar.getDescripcion());

        //Construcción evento enriquecido
        EventoAnuncioProcesado anuncioProcesado = new EventoAnuncioProcesado(
                anuncioSinProcesar.getIdExterno(),
                anuncioSinProcesar.getTitulo(),
                anuncioSinProcesar.getDescripcion(),
                anuncioSinProcesar.getPrecio(),
                anuncioSinProcesar.getMoneda(),
                anuncioSinProcesar.getCiudad(),
                anuncioSinProcesar.getFechaPublicacion(),
                categoria,
                "Resumen simulado",
                0.95
        );

        //Publicar en Kafka
        productorAnuncioProcesado.send(anuncioProcesado);
    }

}
