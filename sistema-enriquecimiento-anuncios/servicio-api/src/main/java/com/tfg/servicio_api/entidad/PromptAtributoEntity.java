package com.tfg.servicio_api.entidad;

import com.tfg.servicio_api.dto.TipoAtributo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Promptatributos")
@Getter
@Setter
public class PromptAtributoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PROMPTATRIBUTO")
    private Long idPromptAtributo;

    @Column(name = "ID_PLANTILLAPROMPT_FK")
    private Long idPlantillaPromptFk;

    @Column(name = "Nombre")
    private String nombreAtributo;

    @Enumerated(EnumType.STRING)
    @Column(name = "Tipo")
    private TipoAtributo tipoAtributo;

    @Column(name = "Filtrable")
    private Boolean esFiltrable;
}
