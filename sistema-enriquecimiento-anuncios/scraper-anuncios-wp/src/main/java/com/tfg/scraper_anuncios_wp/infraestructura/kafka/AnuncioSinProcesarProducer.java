package com.tfg.scraper_anuncios_wp.infraestructura.kafka;

import com.tfg.anuncios.contratos.evento.AnuncioSinProcesarEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class AnuncioSinProcesarProducer {

    private static final String TOPIC = "anuncio_sinprocesar";
    private final KafkaTemplate<String,Object> kafkaTemplate;

    public AnuncioSinProcesarProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviar(AnuncioSinProcesarEvent event){
        String key = event.getExternalId();
        kafkaTemplate.send(TOPIC, key, event);
        System.out.println("Enviado a Kafka: " + event.getTitulo());
    }
}
