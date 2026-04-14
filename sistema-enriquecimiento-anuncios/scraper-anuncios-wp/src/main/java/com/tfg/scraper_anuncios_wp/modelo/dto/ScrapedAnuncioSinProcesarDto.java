package com.tfg.scraper_anuncios_wp.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScrapedAnuncioSinProcesarDto {

    private String externalId;
    private String titulo;
    private String descripcion;

    private String precioTexto;
    private String ubicacionTexto;

    private String urlOrigen;

    private String fechaPublicacionTexto;
    private String fechaCaptura;

    private Long idFuente;
    private Long idCategoria;

    private String rawJson;

}
