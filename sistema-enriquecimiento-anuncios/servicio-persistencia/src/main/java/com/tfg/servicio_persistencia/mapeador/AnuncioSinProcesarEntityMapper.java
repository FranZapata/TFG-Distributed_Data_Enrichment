package com.tfg.servicio_persistencia.mapeador;

import com.tfg.anuncios.contratos.evento.AnuncioProcesadoEvent;
import com.tfg.anuncios.contratos.evento.AnuncioSinProcesarEvent;
import com.tfg.servicio_persistencia.infraestructura.persitencia.entidad.AnuncioProcesadoEntity;
import com.tfg.servicio_persistencia.infraestructura.persitencia.entidad.AnuncioSinProcesarEntity;
import org.springframework.stereotype.Component;

@Component
public class AnuncioSinProcesarEntityMapper {
    public AnuncioSinProcesarEntity map(AnuncioProcesadoEvent evento){
        AnuncioSinProcesarEvent original = evento.getAnuncioOriginal();

        return AnuncioSinProcesarEntity.builder()
                .idAnuncio(original.getIdAnuncio())
                .urlOrigen(original.getUrlOrigen())
                .titulo(original.getTitulo())
                .descripcion(original.getDescripcion())
                .ubicacionTextoOriginal(original.getUbicacionTextoOriginal())
                .ubicacionLatitud(original.getUbicacionLatitud())
                .ubicacionLongitud(original.getUbicacionLongitud())
                .fechaPublicacion(original.getFechaPublicacion())
                .fechaCaptura(original.getFechaCaptura())
                .idFuenteFk(original.getIdFuenteFk())
                .idCategoriaFk(original.getIdCategoriaFk())
                .build();
    }
}
