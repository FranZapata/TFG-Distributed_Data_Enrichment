package com.tfg.scraper_anuncios_wp;

import com.tfg.scraper_anuncios_wp.aplicacion.ServicioScraper;
import com.tfg.scraper_anuncios_wp.infraestructura.cliente.PlanificadorScraping;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ScraperAnunciosWpApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ScraperAnunciosWpApplication.class, args);

		System.out.println("instance_id: " + System.getenv("INSTANCE_ID"));

		PlanificadorScraping planificador = context.getBean(PlanificadorScraping.class);
		planificador.ejecutar();
	}

}
