package com.tfg.servicio_api.dto;

public record PromptResponse(
        Long id,
        String nombre,
        String version,
        Boolean activo,
        Long categoriaId,
        String categoriaNombre
) {
}
