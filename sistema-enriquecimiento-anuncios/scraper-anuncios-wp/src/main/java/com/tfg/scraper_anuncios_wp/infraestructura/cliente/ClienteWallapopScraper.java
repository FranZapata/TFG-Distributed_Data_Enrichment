package com.tfg.scraper_anuncios_wp.infraestructura.cliente;

import com.microsoft.playwright.*;
import com.tfg.scraper_anuncios_wp.modelo.dto.CategoriaDto;
import com.tfg.scraper_anuncios_wp.modelo.dto.ScrapedAnuncioSinProcesarDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class ClienteWallapopScraper {

    @Value("${scraper.offset-step}")
    private int offsetStep;

    public List<ScrapedAnuncioSinProcesarDto> scrape(CategoriaDto categoria){
        List<ScrapedAnuncioSinProcesarDto> resultados = new ArrayList<>();

        try (Playwright playwright = Playwright.create()) {

            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false) // ver navegador
            );

            Page page = browser.newPage();

            // Abrir navegador con URL de la categoría correspondiente
            page.navigate(categoria.getUrlBase() + "/search?category_id=" + categoria.getCodigoInterno() + "&order_by=newest");

            // esperar a que cargue contenido
            page.waitForTimeout(5000);

            // Aceptar cookies si aparecen
            aceptarCoockies(page);

            // Pulsar botón cargar más
            Locator boton = page.locator("button:has-text('Cargar más')");

            if (boton.isVisible()) {
                boton.click();
                page.waitForTimeout(2000);
            }

            // Variables bucle
            int instanceId = obtenerInstanceId();
            int itemsProcesados = instanceId * offsetStep; //offsetStep marca el número de anuncios que va a escrapear el servicio
            int maxItems = itemsProcesados + offsetStep;
            Locator items = page.locator("a[href*='/item/']");
            int total = items.count();

            while(itemsProcesados < maxItems){

                // Bucle que hace scroll hasta cargar nuevos anuncios
                while(itemsProcesados >= total){
                    // scroll humano
                    page.mouse().wheel(0, randomBetween(1000, 2500));
                    page.waitForTimeout(randomBetween(800, 2000));

                    // Cargamos items
                    items = page.locator("a[href*='/item/']");
                    total = items.count();
                }

                for (int i = itemsProcesados; i < total; i++) {

                    Locator item = items.nth(i);

                    //Construir URL
                    String url = item.getAttribute("href");
                    if (url != null && !url.startsWith("http")){
                        url = categoria.getUrlBase() + url;
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
                    dto.setUrlOrigen(url);
                    dto.setTitulo(titulo);
                    dto.setPrecioTexto(precio);
                    dto.setFechaCaptura(String.format("%02d/%02d/%04d",LocalDateTime.now().getDayOfMonth(),LocalDateTime.now().getMonthValue(),LocalDateTime.now().getYear()));
                    dto.setIdCategoria(categoria.getIdCategoria());
                    dto.setIdFuente(categoria.getIdFuente());


                    // Obtener Descripción y ubicación
                    enriquecerConDetalle(browser, dto);

                    // De momento a null
                    dto.setFechaPublicacionTexto(null);

                    resultados.add(dto);
                }

                itemsProcesados = total;

                // Pausa larga ocasional
                if (Math.random() < 0.2) {
                    page.waitForTimeout(randomBetween(3000, 6000));
                }
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

    private int randomBetween(int inicio, int fin){
        Random r = new Random();
        return r.nextInt(fin-inicio) + inicio;
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
            detallePage.navigate(dto.getUrlOrigen());
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

    private int obtenerInstanceId(){
        String env = System.getenv("INSTANCE_ID");
        return env != null ? Integer.parseInt(env) : 0;
    }
}
