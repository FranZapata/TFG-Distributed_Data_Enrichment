package com.tfg.servicio_persistencia.infraestructura.persitencia.repositorio;

import com.tfg.servicio_persistencia.infraestructura.persitencia.entidad.AnuncioProcesadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnuncioProcesadoRepository extends JpaRepository<AnuncioProcesadoEntity, Long> {

}
