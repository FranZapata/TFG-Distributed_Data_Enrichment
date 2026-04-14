package com.tfg.scraper_anuncios_wp.infraestructura.persistencia.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Fuente")
@Getter
@Setter
public class FuenteEntity {

    @Id
    @Column(name = "ID_FUENTE")
    private Long idFuente;

    private String nombre;
    private String tipo;

    @Column(name = "url_base")
    private String urlBase;

    private boolean activa;
}
