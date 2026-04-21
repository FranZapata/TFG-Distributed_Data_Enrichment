package com.tfg.servicio_persistencia.kafka;

import com.tfg.anuncios.contratos.evento.AnuncioProcesadoEvent;
import com.tfg.servicio_persistencia.aplicacion.ServicioPersistenciaAnuncio;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class AnuncioProcesadoConsumer {
    private final ServicioPersistenciaAnuncio servicioPersistenciaAnuncio;

    @KafkaListener(
            topics = "anuncio_procesado",
            groupId = "persistencia-anuncios-group"
    )
    public void consumir(AnuncioProcesadoEvent evento){
        servicioPersistenciaAnuncio.procesar(evento);
    }
}
