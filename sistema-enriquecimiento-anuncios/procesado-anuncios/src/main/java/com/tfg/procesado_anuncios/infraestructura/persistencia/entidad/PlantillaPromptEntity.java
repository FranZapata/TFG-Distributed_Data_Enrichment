package com.tfg.procesado_anuncios.infraestructura.persistencia.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "plantillaprompt")
@Getter
@Setter
public class PlantillaPromptEntity {
    @Id
    @Column(name = "ID_PLANTILLAPROMPT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlantillaPrompt;

    private String nombre;
    private String version;

    @Column(name = "contenido", columnDefinition = "TEXT")
    private String contenido;

    private Boolean activo;

    @Column(name = "ID_CATEGORIA_FK")
    private Long idCategoriaFk;
}
