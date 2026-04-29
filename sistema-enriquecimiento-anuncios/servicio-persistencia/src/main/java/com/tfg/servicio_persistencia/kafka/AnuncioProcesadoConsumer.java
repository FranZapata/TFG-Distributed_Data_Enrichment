package com.tfg.servicio_persistencia.kafka;

import com.tfg.anuncios.contratos.evento.AnuncioProcesadoEvent;
import com.tfg.servicio_persistencia.aplicacion.ServicioPersistenciaAnuncioProcesado;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class AnuncioProcesadoConsumer {
    private final ServicioPersistenciaAnuncioProcesado servicioPersistenciaAnuncio;

    @KafkaListener(
            topics = "anuncio_procesado",
            groupId = "persistencia-anuncios-procesados-group",
            concurrency = "3",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consumir(AnuncioProcesadoEvent evento, Acknowledgment ack){
        log.info("Procesando anuncios-procesado para persistencia: {}", evento.getAnuncioOriginal().getIdAnuncio());

        try {
            servicioPersistenciaAnuncio.procesar(evento);

            ack.acknowledge();
            log.info("Commit realizado para anuncio {}",
                    evento.getAnuncioOriginal().getIdAnuncio());
        }catch (Exception e){
            log.error("Error procesando anuncio {}, NO se hace commit",
                    evento.getAnuncioOriginal().getIdAnuncio(), e);
        }

    }
}
