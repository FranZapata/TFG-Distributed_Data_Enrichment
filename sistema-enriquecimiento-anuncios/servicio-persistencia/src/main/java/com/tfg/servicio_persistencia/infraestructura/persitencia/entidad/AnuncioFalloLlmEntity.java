package com.tfg.servicio_persistencia.infraestructura.persitencia.entidad;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "anunciofallollm")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnuncioFalloLlmEntity {

    @Id
    @Column(name = "ID_ANUNCIOFALLOLLM")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnuncioFalloLlm;

    private String respuestaCruda;
    private String error;
    private String modelo;
    private Instant fechaIntento;
    private int intentos;

    @Column(name = "ID_PLANTILLAPROMPT_FK")
    private Long idPlantillaPromptFk;

    @ManyToOne
    @JoinColumn(name = "ID_ANUNCIO_FK")
    private AnuncioSinProcesarEntity anuncio;
}
