package com.tfg.servicio_persistencia.consumidor;

import com.tfg.servicio_persistencia.entidad.AnuncioProcesado;
import com.tfg.servicio_persistencia.modelo.EventoAnuncioProcesado;
import com.tfg.servicio_persistencia.repositorio.RepositorioAnuncioProcesado;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ConsumidorAnuncioProcesado {

    private final RepositorioAnuncioProcesado repositorio;

    @KafkaListener(topics = "processed_ads", groupId = "grupo-persistencia")
    public void escuchar(EventoAnuncioProcesado evento){

        log.info("Evento recibido: {}", evento.getTitulo());

        AnuncioProcesado entidad = new AnuncioProcesado();

        entidad.setIdExterno(evento.getIdExterno());
        entidad.setTitulo(evento.getTitulo());
        entidad.setDescripcion(evento.getDescripcion());
        entidad.setPrecio(evento.getPrecio());
        entidad.setMoneda(evento.getMoneda());
        entidad.setCiudad(evento.getCiudad());
        entidad.setFechaPublicacion(evento.getFechaPublicacion());
        entidad.setCategoriaDetectada(evento.getCategoriaDetectada());
        entidad.setResumenGenerado(evento.getResumenGenerado());
        entidad.setScoreConfianza(evento.getScoreConfianza());

        repositorio.save(entidad);

        log.info("Anuncio persistido en DB");
    }
}
