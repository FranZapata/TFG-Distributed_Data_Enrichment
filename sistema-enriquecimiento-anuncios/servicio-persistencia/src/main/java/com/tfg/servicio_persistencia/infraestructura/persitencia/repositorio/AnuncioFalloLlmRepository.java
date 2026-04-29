package com.tfg.servicio_persistencia.infraestructura.persitencia.repositorio;

import com.tfg.servicio_persistencia.infraestructura.persitencia.entidad.AnuncioFalloLlmEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnuncioFalloLlmRepository extends JpaRepository<AnuncioFalloLlmEntity, String> {
}
