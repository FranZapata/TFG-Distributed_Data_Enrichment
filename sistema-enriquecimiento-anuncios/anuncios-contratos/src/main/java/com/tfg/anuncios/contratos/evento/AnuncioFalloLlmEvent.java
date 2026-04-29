package com.tfg.anuncios.contratos.evento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnuncioFalloLlmEvent {
    private AnuncioSinProcesarEvent anuncio;

    private String respuestaCruda;
    private String error;
    private String modelo;
    private Long idPlantillaPrompt;
    private Instant fecha;
    private int intentos;
}
