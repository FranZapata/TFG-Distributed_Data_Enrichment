package com.tfg.scraper_anuncios_wp.dominio.scraper;

import com.microsoft.playwright.Page;
import com.tfg.scraper_anuncios_wp.modelo.dto.CategoriaDto;
import com.tfg.scraper_anuncios_wp.modelo.dto.ScrapedAnuncioSinProcesarDto;

public interface DetalleScraperExtension {
    void ampliarDescripcion(Page detallePage, ScrapedAnuncioSinProcesarDto dto);
}
