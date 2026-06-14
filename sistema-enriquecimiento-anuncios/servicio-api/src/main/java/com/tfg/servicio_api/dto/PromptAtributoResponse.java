package com.tfg.servicio_api.dto;

public record PromptAtributoResponse(
        String nombreAtributo,
        TipoAtributo tipoAtributo,
        Boolean esFiltrable
) {
}
