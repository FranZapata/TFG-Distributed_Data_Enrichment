package com.tfg.scraper_anuncios_wp.kafka;


import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RawAdProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "raw_ads";

    public void send(String key, String message){
        kafkaTemplate.send(TOPIC, key, message)
                .whenComplete((result, ex) -> {
                    if (ex == null){
                        log.info("Mensaje enviado correctamente a Kafka. Offset={}",
                                result.getRecordMetadata().offset());
                    } else {
                        log.error("Error enviando mensaje a Kafka", ex);
                    }

                });
    }

}
