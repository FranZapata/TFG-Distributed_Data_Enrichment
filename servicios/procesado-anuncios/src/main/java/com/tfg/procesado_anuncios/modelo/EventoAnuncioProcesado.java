package com.tfg.procesado_anuncios.modelo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventoAnuncioProcesado {

    private String idExterno;
    private String titulo;
    private String descripcion;
    private Double precio;
    private String moneda;
    private String ciudad;
    private String fechaPublicacion;

    private String categoriaDetectada;
    private String resumenGenerado;
    private Double scoreConfianza;
}
