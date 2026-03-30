package com.tfg.scraper_anuncios_wp.aplicacion;

import com.tfg.anuncios.contratos.evento.AnuncioSinProcesarEvent;
import com.tfg.scraper_anuncios_wp.mapeador.ScrapedAnuncioAAnuncioSinprocesearEventMapeador;
import com.tfg.scraper_anuncios_wp.modelo.dto.ScrapedAnuncioSinProcesarDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioScraper {

    private final ScrapedAnuncioAAnuncioSinprocesearEventMapeador mapper;

    public ServicioScraper() {
        this.mapper = new ScrapedAnuncioAAnuncioSinprocesearEventMapeador();
    }

    public void ejecutarScraping() {

        System.out.println("Iniciando scraping...");

        // Obtener datos (mock de momento)
        List<ScrapedAnuncioSinProcesarDto> anuncios = obtenerDatosMock();

        // Procesar cada anuncio
        for (ScrapedAnuncioSinProcesarDto raw : anuncios) {

            AnuncioSinProcesarEvent event = mapper.map(raw);

            //Simular envío
            System.out.println("Evento generado: " + event.getTitulo());
        }

        System.out.println("Scraping finalizado.");
    }

    private List<ScrapedAnuncioSinProcesarDto> obtenerDatosMock() {
        ScrapedAnuncioSinProcesarDto ad1 = new ScrapedAnuncioSinProcesarDto();
        ad1.setExternalId("1");
        ad1.setTitulo("iPhone 13");
        ad1.setDescripcion("En perfecto estado");
        ad1.setPrecioTexto("600 €");
        ad1.setUbicacionTexto("Madrid");
        ad1.setUrl("https://wallapop.com/item/1");

        ScrapedAnuncioSinProcesarDto ad2 = new ScrapedAnuncioSinProcesarDto();
        ad2.setExternalId("2");
        ad2.setTitulo("Yamaha MT-07");
        ad2.setDescripcion("Moto como nueva");
        ad2.setPrecioTexto("4500 €");
        ad2.setUbicacionTexto("Valencia");
        ad2.setUrl("https://wallapop.com/item/2");

        return List.of(ad1, ad2);
    }
}
