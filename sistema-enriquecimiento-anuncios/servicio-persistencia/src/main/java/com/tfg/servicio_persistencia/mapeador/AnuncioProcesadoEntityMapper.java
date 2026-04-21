package com.tfg.servicio_persistencia.mapeador;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tfg.anuncios.contratos.evento.AnuncioProcesadoEvent;
import com.tfg.servicio_persistencia.infraestructura.persitencia.entidad.AnuncioProcesadoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnuncioProcesadoEntityMapper {

    public AnuncioProcesadoEntity map(AnuncioProcesadoEvent evento){
        return AnuncioProcesadoEntity.builder()
                .precioValor(evento.getPrecioValor())
                .precioMoneda(evento.getPrecioMoneda())
                .descripcionLimpia(evento.getDescripcionLimpia())
                .resultadoExtraccion(
                        evento.getResultadoExtraccion() != null
                            ? evento.getResultadoExtraccion().toString()
                            : null)
                .confianzaGlobal(evento.getConfianzaGlobal())
                .modeloLlm(evento.getModeloLlm())
                .esVigente(evento.getEsVigente())
                .fechaExtraccion(evento.getFechaExtraccion())
                .idPlantillaPromptFk(evento.getIdPlantillaPrompt())
                .build();
    }
}
