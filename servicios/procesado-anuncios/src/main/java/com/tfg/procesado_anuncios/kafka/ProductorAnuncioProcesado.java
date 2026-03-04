package com.tfg.procesado_anuncios.kafka;

import com.tfg.procesado_anuncios.modelo.EventoAnuncioProcesado;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductorAnuncioProcesado {

    private final KafkaTemplate<String, EventoAnuncioProcesado> kafkaTemplate;

    public void send(EventoAnuncioProcesado evento) {
        kafkaTemplate.send("processed_ads", evento.getIdExterno(), evento);
    }
}
