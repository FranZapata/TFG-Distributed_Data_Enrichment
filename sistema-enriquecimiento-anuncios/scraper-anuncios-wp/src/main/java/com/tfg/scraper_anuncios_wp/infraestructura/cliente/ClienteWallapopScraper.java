package com.tfg.scraper_anuncios_wp.infraestructura.cliente;

import com.microsoft.playwright.*;
import com.tfg.scraper_anuncios_wp.modelo.dto.ScrapedAnuncioSinProcesarDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClienteWallapopScraper {

    public List<ScrapedAnuncioSinProcesarDto> scrape(){
        List<ScrapedAnuncioSinProcesarDto> resultados = new ArrayList<>();

        try (Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false) // ver navegador
            );

            Page page = browser.newPage();

            // URL básica (luego la haremos dinámica)
            page.navigate("https://es.wallapop.com/app/search?keywords=moto");

            // esperar a que cargue contenido
            page.waitForTimeout(5000);

            // Aceptar cookies si aparecen
           /* try {
                page.getByText("Aceptar todo").click();
            } catch (Exception ignored) {
            }*/

            aceptarCoockies(page);

            // obtener elementos
            List<Locator> items = page.locator("a[href*='/item/']").all();

            for (Locator item : items) {

                //Construir URL
                String url = item.getAttribute("href");
                if (url != null && !url.startsWith("http")){
                    url = "https://es.wallapop.com" + url;
                }

                String externalId = extractIdDesdeUrl(url);
                String titulo = item.getAttribute("title");
                String precio = obtenerTexto(item.locator("strong"));

                // Validación para evitar eventos basura o datos inconsistentes
                if (titulo == null || precio == null || url == null){
                    continue;
                }

                // Construir DTO
                ScrapedAnuncioSinProcesarDto dto = new ScrapedAnuncioSinProcesarDto();
                dto.setExternalId(externalId);
                dto.setUrl(url);
                dto.setTitulo(titulo);
                dto.setPrecioTexto(precio);

                // Obtener Descripción y ubicación
                enriquecerConDetalle(browser, dto);

                // De momento a null
                dto.setFechaPublicacionTexto(null);


                resultados.add(dto);
            }

            browser.close();
        }

        return resultados;
    }

    private String extractIdDesdeUrl(String url) {
        if (url == null) return null;

        try {
            return url.substring(url.lastIndexOf("-") + 1);
        } catch (Exception e) {
            return null;
        }
    }

    private void aceptarCoockies(Page page){
        // Aceptar cookies si aparecen
        try {
            page.getByText("Aceptar todo").click();
        } catch (Exception ignored) {
        }
    }

    private String obtenerTexto(Locator locator) {
        try {
            if (locator.count() > 0) {
                return locator.first().innerText().trim();
            }
        } catch (Exception ignored) {}

        return null;
    }

    private void enriquecerConDetalle(Browser buscador, ScrapedAnuncioSinProcesarDto dto){
        try {
            Page detallePage = buscador.newPage();
            detallePage.navigate(dto.getUrl());
            detallePage.waitForTimeout(1500);
            aceptarCoockies(detallePage);

            String descripcion = obtenerTexto(
                    detallePage.locator("section[class*=\"ItemDetailTwoColumns__description\"]")
            );

            String ubicacion = obtenerTexto(
                    detallePage.locator("a[class*=\"item-detail-location_ItemDetailLocation\"]")
            );

            dto.setDescripcion(descripcion);
            dto.setUbicacionTexto(ubicacion);

            detallePage.close();

        } catch (Exception e) {
            System.out.println("Error al obtener descripción y ubicación: " + e.toString());
        }
    }
}
