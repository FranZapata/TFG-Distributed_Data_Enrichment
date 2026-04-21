package com.tfg.servicio_persistencia.infraestructura.persitencia.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "anuncio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnuncioSinProcesarEntity {

    @Id
    @Column(name = "ID_ANUNCIO")
    private String idAnuncio;

    private String urlOrigen;
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    private String ubicacionTextoOriginal;
    private Long ubicacionLatitud;
    private Long ubicacionLongitud;
    private Instant fechaPublicacion;
    private Instant fechaCaptura;

    @Column(name = "ID_FUENTE_FK")
    private Long idFuenteFk;

    @Column(name = "ID_CATEGORIA_FK")
    private Long idCategoriaFk;
}
