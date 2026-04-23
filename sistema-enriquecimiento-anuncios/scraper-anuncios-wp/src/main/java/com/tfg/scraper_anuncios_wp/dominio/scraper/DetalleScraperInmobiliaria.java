package com.tfg.scraper_anuncios_wp.dominio.scraper;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.tfg.scraper_anuncios_wp.modelo.dto.CategoriaDto;
import com.tfg.scraper_anuncios_wp.modelo.dto.ScrapedAnuncioSinProcesarDto;
import org.springframework.stereotype.Component;

@Component("inmobiliaria")
public class DetalleScraperInmobiliaria implements DetalleScraperExtension{

    @Override
    public void ampliarDescripcion(Page detallePage, ScrapedAnuncioSinProcesarDto dto){

        //Primero pulsamos el boton Ver todo si existe, para que se abra el desplegable con toda la información
        try {
            detallePage.locator("walla-button >> text=Ver todo").click();
        } catch (Exception ignored) {
        }

        StringBuilder descripcionAmpliadad = new StringBuilder();

        // Recorremos en un bucle todas las características que pueda tener la sección características
        Locator caracteristicas = detallePage.locator("dl > div");
        for (int i = 0; i < caracteristicas.count(); i++){
            Locator item = caracteristicas.nth(i);
            descripcionAmpliadad.append("\n")
                    .append(item.locator("dt").innerText().trim())
                    .append(": ")
                    .append(item.locator("dd").innerText().trim());
        }

        descripcionAmpliadad.insert(0, dto.getDescripcion() + "\n");

        dto.setDescripcion(descripcionAmpliadad.toString());
    }
}
