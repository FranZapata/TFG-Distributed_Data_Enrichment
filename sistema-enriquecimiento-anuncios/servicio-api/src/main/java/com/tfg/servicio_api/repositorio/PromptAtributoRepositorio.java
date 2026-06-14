package com.tfg.servicio_api.repositorio;

import com.tfg.servicio_api.entidad.PlantillaPromptEntity;
import com.tfg.servicio_api.entidad.PromptAtributoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PromptAtributoRepositorio extends JpaRepository<PromptAtributoEntity,Long> {

    List<PromptAtributoEntity> findByIdPlantillaPromptFk(Long idPlantillaPrompt);
    List<PromptAtributoEntity> findByIdPlantillaPromptFkAndEsFiltrableTrue(Long idPlantillaPrompt);
}
