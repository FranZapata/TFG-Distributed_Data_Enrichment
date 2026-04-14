package com.tfg.anuncios.contratos.evento;

import com.fasterxml.jackson.databind.JsonNode;
import com.tfg.anuncios.contratos.enums.EstadoAnuncio;
import com.tfg.anuncios.contratos.valueobject.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnuncioProcesadoEvent {

    private AnuncioSinProcesarEvent anuncioOriginal;

    private BigDecimal precioValor;
    private String precioMoneda;
    private String descripcionLimpia;
    private Boolean esVigente;

    private JsonNode resultadoExtraccion;

    private BigDecimal confianzaGlobal;
    private String modeloLlm;
    private Instant fechaExtraccion;

    private Long idPlantillaPrompt;
}
