package com.tfg.servicio_persistencia.mapeador;

import com.tfg.anuncios.contratos.evento.AnuncioFalloLlmEvent;
import com.tfg.servicio_persistencia.infraestructura.persitencia.entidad.AnuncioFalloLlmEntity;
import org.springframework.stereotype.Component;

@Component
public class AnuncioFalloLlmMapper {
    public AnuncioFalloLlmEntity map(AnuncioFalloLlmEvent evento){
        return AnuncioFalloLlmEntity.builder()
                .respuestaCruda(evento.getRespuestaCruda())
                .error(evento.getError())
                .modelo(evento.getModelo())
                .fechaIntento(evento.getFecha())
                .intentos(evento.getIntentos())
                .idPlantillaPromptFk(evento.getIdPlantillaPrompt())
                .build();
    }
}
