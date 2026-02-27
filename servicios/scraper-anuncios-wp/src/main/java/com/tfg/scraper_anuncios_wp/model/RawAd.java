package com.tfg.scraper_anuncios_wp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class RawAd {

    @JsonProperty("id_externo")
    private String idExterno;

    @JsonProperty("categoria_detectada")
    private String categoriaDetectada;

    private String titulo;

    private String descripcion;

    private String precio;

    private String url;

    @JsonProperty("fecha_scraping")
    private Instant fechaScraping;
}
