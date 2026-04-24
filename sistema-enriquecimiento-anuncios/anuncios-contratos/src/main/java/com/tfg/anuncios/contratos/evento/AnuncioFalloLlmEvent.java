package com.tfg.anuncios.contratos.evento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
