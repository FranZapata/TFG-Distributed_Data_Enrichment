package com.tfg.procesado_anuncios.infraestructura.kafka;
import com.tfg.anuncios.contratos.evento.AnuncioSinProcesarEvent;
import com.tfg.procesado_anuncios.aplicacion.ServicioProcesadoAnuncio;
import com.tfg.procesado_anuncios.infraestructura.excepciones.ExcepcionLlmParse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executor;

@Component
@RequiredArgsConstructor
@Slf4j
public class AnuncioSinProcesarConsumer {

    private final ServicioProcesadoAnuncio servicioProcesadoAnuncio;

    @KafkaListener(topics = "anuncio_sinprocesar", groupId = "procesado-anuncios-group", containerFactory = "kafkaListenerContainerFactory")
    public void consumir(AnuncioSinProcesarEvent evento, Acknowledgment ack){


        try {
            log.info("Recibido anuncio sin procesar: {}", evento.getIdAnuncio());

            servicioProcesadoAnuncio.procesar(evento);

            ack.acknowledge();
            log.info("Offset commit realizado para anuncio {}", evento.getIdAnuncio());


        } catch (ExcepcionLlmParse e){
            ack.acknowledge();
        } catch (Exception e){
            log.error("Error procesando anuncio {}", evento.getIdAnuncio(), e);
            throw e;
        }
    };
}
