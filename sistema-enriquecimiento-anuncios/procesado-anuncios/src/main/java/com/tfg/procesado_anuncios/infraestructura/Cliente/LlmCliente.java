package com.tfg.procesado_anuncios.infraestructura.Cliente;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tfg.procesado_anuncios.infraestructura.excepciones.ExcepcionLlmParse;
import com.tfg.procesado_anuncios.modelo.dto.PeticionLlmDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;

@Component
@RequiredArgsConstructor
@Slf4j
public class LlmCliente {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Value("${ollama.maxIntentos}")
    private int maxIntentos;

    public JsonNode generar(String prompt, String url, String modelo){

        int intentos = 0;
        String ultimaRespuesta = null;

        while (intentos<maxIntentos){
            try {
                String response = llamarLLM(prompt,url,modelo);
                ultimaRespuesta = response;

                return parsearRespuesta(response, intentos);

            } catch (ExcepcionLlmParse e){
                intentos++;
                ultimaRespuesta = e.getRespuestaLlm();

                log.warn("Error en intento {} de llamada LLM", intentos, e);

                if (intentos >= maxIntentos) {
                    throw e;
                }
            } catch (Exception e){
                intentos++;

                log.warn("Error en intento {} de llamada LLM", intentos, e);

                if (intentos >= maxIntentos) {
                    log.error("Fallo definitivo tras reintentos");
                    throw new RuntimeException("LLM fallo tras reintentos", e);
                }
            }
        }
        throw new RuntimeException("Error inesperado LLM");
    }

    private String llamarLLM(String prompt, String url, String modelo) {
        // Preparamos petición
        PeticionLlmDto peticion = PeticionLlmDto.builder()
                .model(modelo)
                .prompt(prompt)
                .stream(false)
                .build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<PeticionLlmDto> entity = new HttpEntity<>(peticion, headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);
        return response.getBody();
    }

    private JsonNode parsearRespuesta(String responseBody, int intento) {
        try {
            JsonNode json = objectMapper.readTree(responseBody);

            if (!json.has("response")) {
                throw new ExcepcionLlmParse("Respuesta sin campo response",
                        responseBody,
                        Instant.now(),
                        intento,
                        null
                );
            }

            String jsonInterno = json.get("response").asText();
            return objectMapper.readTree(jsonInterno);

        } catch (Exception e) {
            throw new ExcepcionLlmParse("Error parseando JSON del LLM",
                    responseBody,
                    Instant.now(),
                    intento,
                    e);
        }
    }
}
