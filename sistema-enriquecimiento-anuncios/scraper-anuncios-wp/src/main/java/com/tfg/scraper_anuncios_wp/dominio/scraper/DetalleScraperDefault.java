package com.tfg.scraper_anuncios_wp.dominio.scraper;

import com.microsoft.playwright.Page;
import com.tfg.scraper_anuncios_wp.modelo.dto.CategoriaDto;
import com.tfg.scraper_anuncios_wp.modelo.dto.ScrapedAnuncioSinProcesarDto;
import org.springframework.stereotype.Component;

@Component("default")
public class DetalleScraperDefault implements DetalleScraperExtension{

    @Override
    public void ampliarDescripcion(Page detallePage, ScrapedAnuncioSinProcesarDto dto){
        // no hacemos nada para el caso por defecto
    }

}
