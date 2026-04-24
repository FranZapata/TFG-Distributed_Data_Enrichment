package com.tfg.procesado_anuncios.infraestructura.kafka;

import com.tfg.anuncios.contratos.evento.AnuncioFalloLlmEvent;
import com.tfg.anuncios.contratos.evento.AnuncioProcesadoEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AnuncioFalloLlmProducer {
    private final KafkaTemplate<String, AnuncioFalloLlmEvent> kafkaTemplate;

    public void enviar(AnuncioFalloLlmEvent event){
        kafkaTemplate.send("anuncio_fallo_llm", event.getAnuncio().getIdAnuncio(), event);
    }
}
