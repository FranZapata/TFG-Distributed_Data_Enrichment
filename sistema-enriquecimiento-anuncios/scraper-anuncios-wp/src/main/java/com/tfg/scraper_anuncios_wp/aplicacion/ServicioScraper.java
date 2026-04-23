package com.tfg.scraper_anuncios_wp.aplicacion;

import com.tfg.anuncios.contratos.evento.AnuncioSinProcesarEvent;
import com.tfg.scraper_anuncios_wp.infraestructura.cliente.ClienteWallapopScraper;
import com.tfg.scraper_anuncios_wp.infraestructura.kafka.AnuncioSinProcesarProducer;
import com.tfg.scraper_anuncios_wp.mapeador.ScrapedAnuncioAAnuncioSinprocesearEventMapeador;
import com.tfg.scraper_anuncios_wp.modelo.dto.CategoriaDto;
import com.tfg.scraper_anuncios_wp.modelo.dto.ScrapedAnuncioSinProcesarDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioScraper {

    private final ScrapedAnuncioAAnuncioSinprocesearEventMapeador mapper;
    private final ClienteWallapopScraper scraperClient;
    private final AnuncioSinProcesarProducer producer;

    public ServicioScraper(ClienteWallapopScraper scraperClient, AnuncioSinProcesarProducer producer, ServicioCategoria servicioCategoria) {
        this.scraperClient = scraperClient;
        this.producer = producer;
        this.mapper = new ScrapedAnuncioAAnuncioSinprocesearEventMapeador();
    }

    public void ejecutarScraping(CategoriaDto categoria) {

        System.out.println("Iniciando scraping...");

        // Obtener datos
        List<ScrapedAnuncioSinProcesarDto> anuncios = scraperClient.scrape(categoria);

        // Procesar cada anuncio
        for (ScrapedAnuncioSinProcesarDto raw : anuncios) {

            try {
                AnuncioSinProcesarEvent event = mapper.map(raw);
                producer.enviar(event);
            } catch (Exception e){
                System.out.println("Error procesando anuncio: " + raw.getExternalId());
                System.out.println("ERROR: " + e.toString());

            }


        }

        System.out.println("Scraping " + categoria.getNombre() + " finalizado.");
    }
}
