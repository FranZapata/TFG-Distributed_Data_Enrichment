package com.tfg.scraper_anuncios_wp.infraestructura.persistencia;

import com.tfg.scraper_anuncios_wp.infraestructura.persistencia.entidad.CategoriaEntity;
import com.tfg.scraper_anuncios_wp.modelo.dto.CategoriaDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioCategoria extends JpaRepository<CategoriaEntity, Long> {

    @Query("""
        SELECT c
        FROM CategoriaEntity c
        WHERE c.fuente.nombre = :nombreFuente
    """)
    List<CategoriaEntity> obtenerCategoriasPorFuente(@Param("nombreFuente") String nombreFuente);


}
