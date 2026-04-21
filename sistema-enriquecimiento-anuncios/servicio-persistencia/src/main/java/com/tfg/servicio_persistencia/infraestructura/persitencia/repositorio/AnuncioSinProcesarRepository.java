package com.tfg.servicio_persistencia.infraestructura.persitencia.repositorio;

import com.tfg.servicio_persistencia.infraestructura.persitencia.entidad.AnuncioSinProcesarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnuncioSinProcesarRepository extends JpaRepository<AnuncioSinProcesarEntity, String> {

}
