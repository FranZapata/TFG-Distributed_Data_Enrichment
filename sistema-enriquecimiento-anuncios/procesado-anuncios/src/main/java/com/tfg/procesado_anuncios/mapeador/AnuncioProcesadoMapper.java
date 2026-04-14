package com.tfg.procesado_anuncios.mapeador;

import com.fasterxml.jackson.databind.JsonNode;
import com.tfg.anuncios.contratos.evento.AnuncioProcesadoEvent;
import com.tfg.anuncios.contratos.evento.AnuncioSinProcesarEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;

@Component
@RequiredArgsConstructor
public class AnuncioProcesadoMapper {

    public AnuncioProcesadoEvent map(AnuncioSinProcesarEvent original,
                                     JsonNode resultadoExtraccion,
                                     String modelo,
                                     Long idPlantillaPrompt){
        return AnuncioProcesadoEvent.builder()
                .anuncioOriginal(original)
                .precioValor(original.getPrecio().getValor())
                .precioMoneda(original.getPrecio().getMoneda())
                .descripcionLimpia(original.getDescripcion())
                .resultadoExtraccion(resultadoExtraccion)
                .confianzaGlobal(BigDecimal.valueOf(0.9)) // Mock por ahora
                .modeloLlm(modelo)
                .esVigente(true)
                .fechaExtraccion(Instant.now())
                .idPlantillaPrompt(idPlantillaPrompt)
                .build();

    }

}
