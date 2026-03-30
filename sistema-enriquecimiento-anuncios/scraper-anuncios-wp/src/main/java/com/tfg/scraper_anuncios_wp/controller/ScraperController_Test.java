package com.tfg.scraper_anuncios_wp.controller;

import com.tfg.scraper_anuncios_wp.kafka.RawAdProducer;
import com.tfg.scraper_anuncios_wp.modelo.dto.ScrapedAnuncioSinProcesarDto;
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


        return "Mensaje enviado a Kafka correctamente!!";
    }

}
