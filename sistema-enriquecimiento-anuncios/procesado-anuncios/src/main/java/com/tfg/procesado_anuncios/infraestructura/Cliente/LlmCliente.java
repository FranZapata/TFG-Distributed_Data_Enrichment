package com.tfg.procesado_anuncios.infraestructura.Cliente;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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

@Component
@RequiredArgsConstructor
@Slf4j
public class LlmCliente {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public JsonNode generar(String prompt, String url, String modelo){
        try {
            PeticionLlmDto peticion = PeticionLlmDto.builder()
                    .model(modelo)
                    .prompt(prompt)
                    .stream(false)
                    .build();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            HttpEntity<PeticionLlmDto> entity = new HttpEntity<>(peticion, headers);
            ResponseEntity<String> response = restTemplate.postForEntity(url, entity, String.class);

            JsonNode resultado;
            try {
                JsonNode json = objectMapper.readTree(response.getBody());
                String jsonInterno = json.get("response").asText();
                resultado = objectMapper.readTree(jsonInterno);
            } catch (Exception e) {
                throw new RuntimeException("Error parseando LLM",e);
            }

            log.info("Respuesta LLM recibida");
            return resultado;

        } catch (Exception e){
            log.error("Error llamando al LLM", e);
            throw new RuntimeException("Error en llamada al LLM", e);
        }
    }
}
