package com.tfg.Servicio_frontend.servicio.mock;

import com.tfg.Servicio_frontend.dto.PromptDto;
import com.tfg.Servicio_frontend.servicio.PromptServicio;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MockPromptServicio implements PromptServicio {
    private final List<PromptDto> prompts = new ArrayList<>();

    @PostConstruct
    public void init() {

        prompts.add(
                PromptDto.builder()
                        .id(UUID.randomUUID())
                        .fuente("Wallapop")
                        .categoria("Motor")
                        .titulo("Motor Enrichment")
                        .version("v1.0.0")
                        .activo(false)
                        .contenido("Analiza este anuncio...")
                        .build()
        );

        prompts.add(
                PromptDto.builder()
                        .id(UUID.randomUUID())
                        .fuente("Wallapop")
                        .categoria("Motor")
                        .titulo("Motor Enrichment")
                        .version("v1.1.0")
                        .activo(true)
                        .contenido("Versión mejorada...")
                        .build()
        );

        prompts.add(
                PromptDto.builder()
                        .id(UUID.randomUUID())
                        .fuente("Wallapop")
                        .categoria("Inmobiliario")
                        .titulo("Real Estate")
                        .version("v1.0.0")
                        .activo(true)
                        .contenido("Analiza este inmueble...")
                        .build()
        );
    }

    @Override
    public List<PromptDto> buscarTodo() {
        return prompts;
    }

    @Override
    public void save(PromptDto prompt) {
        prompts.add(prompt);
    }
}
