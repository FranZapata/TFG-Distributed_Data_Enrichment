package com.tfg.servicio_api.dto;

import java.util.List;

public record PromptDetalladoResponse(
        Long id,
        String nombre,
        String version,
        String contenido,
        Boolean activo,
        Long categoriaId,
        List<PromptAtributoResponse> atributos
) {
}
