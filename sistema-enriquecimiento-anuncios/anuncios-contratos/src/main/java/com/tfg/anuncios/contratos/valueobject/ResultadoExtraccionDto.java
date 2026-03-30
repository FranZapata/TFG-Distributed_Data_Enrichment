package com.tfg.anuncios.contratos.valueobject;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultadoExtraccionDto {

    private JsonNode datosExtraidos;
    private BigDecimal confianzaGlobal;
    private String versionEsquema;
    private List<String> observaciones;

}
