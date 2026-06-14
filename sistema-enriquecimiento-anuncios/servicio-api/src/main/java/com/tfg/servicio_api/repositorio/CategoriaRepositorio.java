package com.tfg.servicio_api.repositorio;


import com.tfg.servicio_api.entidad.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepositorio extends JpaRepository<CategoriaEntity, Long> {
}
