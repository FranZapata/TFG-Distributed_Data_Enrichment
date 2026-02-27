package com.tfg.scraper_anuncios_wp.controller;

import com.tfg.scraper_anuncios_wp.kafka.RawAdProducer;
import com.tfg.scraper_anuncios_wp.model.RawAd;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tools.jackson.databind.ObjectMapper;

import java.time.Instant;

@RestController
@RequiredArgsConstructor
public class ScraperController_Test {

    private final RawAdProducer producer;
    private final ObjectMapper objectMapper;

    @GetMapping("/test")
    public  String sendTestAd() throws Exception{

        RawAd ad = RawAd.builder()
                .idExterno("wallapop_123")
                .categoriaDetectada("motor_moto")
                .titulo("Yamaha R6")
                .descripcion("Moto en perfecto estado")
                .precio("4500")
                .url("https://wallapop.com/ad/123")
                .fechaScraping(Instant.now())
                .build();

        String json = objectMapper.writeValueAsString(ad);
        producer.send(ad.getIdExterno(),json);

        return "Mensaje enviado a Kafka correctamente!!";
    }

}
