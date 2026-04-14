package com.tfg.procesado_anuncios.infraestructura.persistencia;

import com.tfg.procesado_anuncios.infraestructura.persistencia.entidad.PlantillaPromptEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositorioPlantillaPrompt extends JpaRepository<PlantillaPromptEntity, Long> {

    Optional<PlantillaPromptEntity> findByIdCategoriaFkAndActivoTrue(Long categoriaId);
}
