package com.tfg.procesado_anuncios.infraestructura.kafka;

import com.tfg.anuncios.contratos.evento.AnuncioProcesadoEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AnuncioProcesadoProducer {
    private final KafkaTemplate<String, AnuncioProcesadoEvent> kafkaTemplate;

    public void enviar(AnuncioProcesadoEvent event){

        kafkaTemplate.send(
                "anuncio_procesado",
                event.getAnuncioOriginal().getIdAnuncio(),
                event
        );
    }

}
