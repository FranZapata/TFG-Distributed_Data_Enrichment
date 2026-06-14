package com.tfg.servicio_api.repositorio;

import com.tfg.servicio_api.entidad.AnuncioProcesadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnuncioProcesadoRepositorio extends JpaRepository<AnuncioProcesadoEntity, Long> {

    List<AnuncioProcesadoEntity> findByAnuncio_Categoria_IdCategoriaOrderByFechaExtraccionDesc(Long idCategoria);
}
