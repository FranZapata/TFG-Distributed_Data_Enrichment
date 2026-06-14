package com.tfg.servicio_api.entidad;

import jakarta.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "ID_CATEGORIA_FK")
    private CategoriaEntity categoria;
}
