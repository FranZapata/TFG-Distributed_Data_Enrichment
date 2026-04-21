package com.tfg.servicio_persistencia.aplicacion;

import com.tfg.anuncios.contratos.evento.AnuncioProcesadoEvent;
import com.tfg.servicio_persistencia.infraestructura.persitencia.entidad.AnuncioProcesadoEntity;
import com.tfg.servicio_persistencia.infraestructura.persitencia.entidad.AnuncioSinProcesarEntity;
import com.tfg.servicio_persistencia.infraestructura.persitencia.repositorio.AnuncioProcesadoRepository;
import com.tfg.servicio_persistencia.infraestructura.persitencia.repositorio.AnuncioSinProcesarRepository;
import com.tfg.servicio_persistencia.mapeador.AnuncioProcesadoEntityMapper;
import com.tfg.servicio_persistencia.mapeador.AnuncioSinProcesarEntityMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ServicioPersistenciaAnuncio {

    private final AnuncioProcesadoRepository anuncioProcesadoRepository;
    private final AnuncioSinProcesarRepository anuncioSinProcesarRepository;

    private final AnuncioProcesadoEntityMapper anuncioProcesadoEntityMapper;
    private final AnuncioSinProcesarEntityMapper anuncioSinProcesarEntityMapper;

    public void procesar(AnuncioProcesadoEvent evento){
        log.info("Procesando anuncios para persistencia: {}", evento.getAnuncioOriginal().getIdAnuncio());

        try {
            // 1️⃣ Insertar o recuperar anuncio
            AnuncioSinProcesarEntity anuncioSinProcesar = anuncioSinProcesarRepository
                    .findById(evento.getAnuncioOriginal().getIdAnuncio())
                    .map(existing -> actualizarAnuncio(existing, evento))
                    .orElseGet(() -> crearAnuncio(evento));

            AnuncioProcesadoEntity anuncioProcesadoEntity = anuncioProcesadoEntityMapper.map(evento);
            anuncioProcesadoEntity.setAnuncio(anuncioSinProcesar);
            anuncioProcesadoRepository.save(anuncioProcesadoEntity);

            log.info("Anuncio persistido correctamente: {}",
                    evento.getAnuncioOriginal().getIdAnuncio());
        }catch (Exception e) {
            log.error("Error al persistir anuncio: {}",
                    evento.getAnuncioOriginal().getIdAnuncio(), e);

            throw e;
        }




    }

    private AnuncioSinProcesarEntity crearAnuncio(AnuncioProcesadoEvent event) {

        AnuncioSinProcesarEntity nuevo = anuncioSinProcesarEntityMapper.map(event);
        return anuncioSinProcesarRepository.save(nuevo);
    }

    private AnuncioSinProcesarEntity actualizarAnuncio(AnuncioSinProcesarEntity existing, AnuncioProcesadoEvent event) {

        var original = event.getAnuncioOriginal();

        existing.setUrlOrigen(original.getUrlOrigen());
        existing.setTitulo(original.getTitulo());
        existing.setDescripcion(original.getDescripcion());
        existing.setUbicacionTextoOriginal(original.getUbicacionTextoOriginal());
        existing.setFechaPublicacion(original.getFechaPublicacion());
        existing.setFechaCaptura(original.getFechaCaptura());
        existing.setIdFuenteFk(original.getIdFuenteFk());
        existing.setIdCategoriaFk(original.getIdCategoriaFk());

        return anuncioSinProcesarRepository.save(existing);
    }
}
