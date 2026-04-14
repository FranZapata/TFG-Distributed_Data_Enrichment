package com.tfg.scraper_anuncios_wp.infraestructura.cliente;

import com.tfg.scraper_anuncios_wp.aplicacion.ServicioCategoria;
import com.tfg.scraper_anuncios_wp.aplicacion.ServicioScraper;
import com.tfg.scraper_anuncios_wp.modelo.dto.CategoriaDto;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PlanificadorScraping {

    private final ServicioCategoria servicioCategoria;
    private final ServicioScraper servicioScraper;

    public void ejecutar() {

        long duracion = calcularDuracion();
        long inicio = System.currentTimeMillis();

        while (System.currentTimeMillis() - inicio < duracion) {

            List<CategoriaDto> categorias = servicioCategoria.obtenerCategoriasActivas();

            for (CategoriaDto categoria : categorias) {

                servicioScraper.ejecutarScraping(categoria);
            }
        }

        System.out.println("Fin de jornada scraping");
    }

    private long calcularDuracion() {
        int base = 1 * 60; // minutos
        int variacion = randomEntre(-10, 10);

        return (base + variacion) * 60_000L; // segundos
    }

    private int randomEntre(int min, int max) {
        return min + (int)(Math.random() * (max - min));
    }
}
