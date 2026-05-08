package com.tfg.servicio_persistencia.infraestructura.persitencia.repositorio;

import com.tfg.servicio_persistencia.infraestructura.persitencia.entidad.AnuncioProcesadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AnuncioProcesadoRepository extends JpaRepository<AnuncioProcesadoEntity, Long> {

    @Modifying
    @Query("""
        UPDATE AnuncioProcesadoEntity ap
        SET ap.esVigente = false
        WHERE ap.anuncio.idAnuncio = :idAnuncioBase
        AND ap.esVigente = true
    """)
    void marcarNoVigentes(
            @Param("idAnuncioBase") String idAnuncioFk
    );
}
