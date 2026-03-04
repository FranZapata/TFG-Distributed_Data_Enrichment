package com.tfg.procesado_anuncios.modelo;

import lombok.Data;

@Data
public class EventoAnuncioSinProcesar {
    private String idExterno;
    private String titulo;
    private String descripcion;
    private Double precio;
    private String moneda;
    private String ciudad;
    private String fechaPublicacion;
}
