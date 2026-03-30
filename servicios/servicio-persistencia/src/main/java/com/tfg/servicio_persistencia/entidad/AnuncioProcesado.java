package com.tfg.servicio_persistencia.entidad;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "processed_ads")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnuncioProcesado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String idExterno;

    private String titulo;

    @Column(length = 2000)
    private String descripcion;

    private Double precio;

    private String moneda;

    private String ciudad;

    private String fechaPublicacion;

    private String categoriaDetectada;

    private String resumenGenerado;

    private Double scoreConfianza;
}
