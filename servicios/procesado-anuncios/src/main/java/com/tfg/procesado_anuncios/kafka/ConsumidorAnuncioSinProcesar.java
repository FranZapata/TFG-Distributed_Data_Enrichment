package com.tfg.procesado_anuncios.kafka;

import com.tfg.procesado_anuncios.modelo.EventoAnuncioSinProcesar;
import com.tfg.procesado_anuncios.servicio.ServicioProcesadoAnuncio;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ConsumidorAnuncioSinProcesar {

    private final ServicioProcesadoAnuncio servicioProcesadoAnuncio;

    @KafkaListener(topics = "raw_ads", groupId = "processing-group")
    public void listen(EventoAnuncioSinProcesar evento){
        servicioProcesadoAnuncio.procesar(evento);
    };
}
