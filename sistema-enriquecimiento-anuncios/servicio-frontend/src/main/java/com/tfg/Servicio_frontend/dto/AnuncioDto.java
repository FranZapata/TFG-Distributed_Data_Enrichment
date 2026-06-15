package com.tfg.Servicio_frontend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnuncioDto {
    private String idAnuncio;
    private String categoria;

    private String titulo;
    private String descripcion;
    private Double precioValor;

    private String urlImagen;
    private String urlOrigen;

    private String ubicacion;
    private String estado;
}
