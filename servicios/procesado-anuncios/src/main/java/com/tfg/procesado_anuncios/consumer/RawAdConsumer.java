package com.tfg.procesado_anuncios.consumer;

import com.tfg.procesado_anuncios.model.RawAd;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class RawAdConsumer {

    @KafkaListener(topics = "raw_ads", groupId = "processing-group")
    public void listen(RawAd rawAd){
        System.out.println("============ NUEVO EVENTO RECIVIDO ===============");
        System.out.println(rawAd);
        System.out.println("==================================================");
    }
}
