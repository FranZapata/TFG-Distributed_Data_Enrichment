package com.tfg.servicio_persistencia.aplicacion;

import com.tfg.anuncios.contratos.evento.AnuncioProcesadoEvent;
import com.tfg.servicio_persistencia.infraestructura.persitencia.entidad.AnuncioProcesadoEntity;
import com.tfg.servicio_persistencia.infraestructura.persitencia.entidad.AnuncioSinProcesarEntity;
import com.tfg.servicio_persistencia.infraestructura.persitencia.repositorio.AnuncioProcesadoRepository;
import com.tfg.servicio_persistencia.mapeador.AnuncioProcesadoEntityMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ServicioPersistenciaAnuncioProcesado {

    private final AnuncioProcesadoRepository anuncioProcesadoRepository;
    private final AnuncioProcesadoEntityMapper anuncioProcesadoEntityMapper;
    private final ServicioPersistenciaAnuncio servicioPersistenciaAnuncio;

    public void procesar(AnuncioProcesadoEvent evento){

        try {
            AnuncioSinProcesarEntity anuncioSinProcesar = servicioPersistenciaAnuncio.insrtarOActualizarAnuncio(evento.getAnuncioOriginal());

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
}