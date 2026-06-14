package com.tfg.servicio_api.dto;

public record CategoriaResponse(
        Long id,
        String nombre,
        Long idFuente,
        String fuente
) {
}
