package com.tfg.procesado_anuncios.model;

import lombok.Data;

@Data
public class RawAd {
    private String idExterno;
    private String categoriaDetectada;
    private String titulo;
    private String descripcion;
    private Double precio;
    private String moneda;
    private String ciudad;
    private String fechaPublicacion;
}
