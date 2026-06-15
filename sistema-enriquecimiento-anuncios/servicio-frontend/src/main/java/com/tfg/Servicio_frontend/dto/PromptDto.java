package com.tfg.Servicio_frontend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PromptDto {
    private UUID id;
    private String fuente;
    private String categoria;
    private String titulo;
    private String version;
    private Boolean activo;
    private String contenido;
}
