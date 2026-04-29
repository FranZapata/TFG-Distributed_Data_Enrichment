package com.tfg.servicio_persistencia.kafka;

import com.tfg.anuncios.contratos.evento.AnuncioFalloLlmEvent;
import com.tfg.servicio_persistencia.aplicacion.ServicioPersistenciaAnuncioFallido;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class AnuncioFalloLlmConsumer {
    private final ServicioPersistenciaAnuncioFallido servicioPersistenciaAnuncioFallido;

    @KafkaListener(
            topics = "anuncio_fallo_llm",
            groupId = "persistencia-anuncios-fallidos-group",
            concurrency = "1",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consumir(AnuncioFalloLlmEvent evento, Acknowledgment ack){
        try {
            log.info("Procesando anuncio-fallo para persistencia: {}", evento.getAnuncio().getIdAnuncio());

            servicioPersistenciaAnuncioFallido.procesar(evento);

            ack.acknowledge();
            log.info("Commit realizado para anuncio {}",
                    evento.getAnuncio().getIdAnuncio());
        } catch (Exception e) {
            log.error("Error procesando anuncio {}, NO se hace commit",
                    evento.getAnuncio().getIdAnuncio(), e);
        }

    }
}
