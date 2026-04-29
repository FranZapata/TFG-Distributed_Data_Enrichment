package com.tfg.servicio_persistencia.aplicacion;

import com.tfg.anuncios.contratos.evento.AnuncioFalloLlmEvent;
import com.tfg.servicio_persistencia.infraestructura.persitencia.entidad.AnuncioFalloLlmEntity;
import com.tfg.servicio_persistencia.infraestructura.persitencia.entidad.AnuncioSinProcesarEntity;
import com.tfg.servicio_persistencia.infraestructura.persitencia.repositorio.AnuncioFalloLlmRepository;
import com.tfg.servicio_persistencia.mapeador.AnuncioFalloLlmMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ServicioPersistenciaAnuncioFallido {

    private final AnuncioFalloLlmRepository anuncioFalloLlmRepository;
    private final AnuncioFalloLlmMapper anuncioFalloLlmMapper;
    private final ServicioPersistenciaAnuncio servicioPersistenciaAnuncio;

    public void procesar(AnuncioFalloLlmEvent evento){
        try{
            AnuncioSinProcesarEntity anuncioSinProcesar = servicioPersistenciaAnuncio.insrtarOActualizarAnuncio(evento.getAnuncio());

            AnuncioFalloLlmEntity anuncioFalloLlmEntity = anuncioFalloLlmMapper.map(evento);
            anuncioFalloLlmEntity.setAnuncio(anuncioSinProcesar);
            anuncioFalloLlmRepository.save(anuncioFalloLlmEntity);

            log.info("Anuncio persistido correctamente: {}",
                    evento.getAnuncio().getIdAnuncio());
        } catch (Exception e) {
            log.error("Error al persistir anuncio: {}",
                    evento.getAnuncio().getIdAnuncio(), e);

            throw e;
        }
    }
}