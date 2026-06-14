package com.tfg.servicio_api.dto;

import java.math.BigDecimal;
import java.time.Instant;

public record BusquedaResponse(
        Long idAnuncioProcesado,
        String idAnuncio,
        String titulo,
        BigDecimal precio,
        String moneda,
        String ubicacion,
        Instant fechaPublicacion,
        String categoria,
        BigDecimal confianza,
        Boolean vigente,
        String url,
        String resultadoExtraccion
) {
}
