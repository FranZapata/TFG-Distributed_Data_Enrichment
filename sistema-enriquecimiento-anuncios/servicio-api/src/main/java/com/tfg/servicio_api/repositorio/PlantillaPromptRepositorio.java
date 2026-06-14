package com.tfg.servicio_api.repositorio;

import com.tfg.servicio_api.entidad.PlantillaPromptEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlantillaPromptRepositorio extends JpaRepository<PlantillaPromptEntity,Long> {

    List<PlantillaPromptEntity> findByActivoTrue();

    Optional<PlantillaPromptEntity>
    findByCategoria_IdCategoriaAndActivoTrue(Long idCategoria);
}
