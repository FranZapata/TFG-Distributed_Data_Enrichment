package com.tfg.scraper_anuncios_wp.infraestructura.persistencia.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Entity
@Table(name = "Categoria")
@Getter
@Setter
public class CategoriaEntity {

    @Id
    @Column(name = "ID_CATEGORIA")
    private Long idCategoria;

    private String nombre;

    @Column(name = "Codigo_interno")
    private String codigoInterno;

    @ManyToOne
    @JoinColumn(name = "ID_FUENTE_FK")
    private FuenteEntity fuente;

    @OneToOne
    @JoinColumn(name = "ID_CATEGORIAPADRE_FK")
    private CategoriaEntity categoria;
}
