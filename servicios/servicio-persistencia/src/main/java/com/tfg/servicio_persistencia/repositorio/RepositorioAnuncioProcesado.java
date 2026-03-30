package com.tfg.servicio_persistencia.repositorio;


import com.tfg.servicio_persistencia.entidad.AnuncioProcesado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositorioAnuncioProcesado extends JpaRepository<AnuncioProcesado, Long> {

}
