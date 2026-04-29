package com.tfg.servicio_persistencia.aplicacion;

import com.tfg.anuncios.contratos.evento.AnuncioSinProcesarEvent;
import com.tfg.servicio_persistencia.infraestructura.persitencia.entidad.AnuncioSinProcesarEntity;
import com.tfg.servicio_persistencia.infraestructura.persitencia.repositorio.AnuncioSinProcesarRepository;
import com.tfg.servicio_persistencia.mapeador.AnuncioSinProcesarEntityMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ServicioPersistenciaAnuncio {
    private final AnuncioSinProcesarRepository anuncioSinProcesarRepository;

    private final AnuncioSinProcesarEntityMapper anuncioSinProcesarEntityMapper;

    public AnuncioSinProcesarEntity insrtarOActualizarAnuncio(AnuncioSinProcesarEvent evento){
        try {
            // 1️⃣ Insertar o recuperar anuncio
            return anuncioSinProcesarRepository
                    .findById(evento.getIdAnuncio())
                    .map(existing -> actualizarAnuncio(existing, evento))
                    .orElseGet(() -> crearAnuncio(evento));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private AnuncioSinProcesarEntity crearAnuncio(AnuncioSinProcesarEvent evento) {

        AnuncioSinProcesarEntity nuevo = anuncioSinProcesarEntityMapper.map(evento);
        return anuncioSinProcesarRepository.save(nuevo);
    }

    private AnuncioSinProcesarEntity actualizarAnuncio(AnuncioSinProcesarEntity existing, AnuncioSinProcesarEvent evento) {

        existing.setUrlOrigen(evento.getUrlOrigen());
        existing.setTitulo(evento.getTitulo());
        existing.setDescripcion(evento.getDescripcion());
        existing.setUbicacionTextoOriginal(evento.getUbicacionTextoOriginal());
        existing.setFechaPublicacion(evento.getFechaPublicacion());
        existing.setFechaCaptura(evento.getFechaCaptura());
        existing.setIdFuenteFk(evento.getIdFuenteFk());
        existing.setIdCategoriaFk(evento.getIdCategoriaFk());

        return anuncioSinProcesarRepository.save(existing);
    }
}
