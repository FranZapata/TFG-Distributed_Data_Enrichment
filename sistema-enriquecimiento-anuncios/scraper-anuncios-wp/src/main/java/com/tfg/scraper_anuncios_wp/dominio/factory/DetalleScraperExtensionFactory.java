package com.tfg.scraper_anuncios_wp.dominio.factory;

import com.tfg.scraper_anuncios_wp.dominio.scraper.DetalleScraperExtension;
import com.tfg.scraper_anuncios_wp.modelo.dto.CategoriaDto;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DetalleScraperExtensionFactory {

    private final Map<String, DetalleScraperExtension> extensiones;

    public DetalleScraperExtensionFactory(Map<String, DetalleScraperExtension> extensiones){
        this.extensiones = extensiones;
    }

    public DetalleScraperExtension get(String nombre){

        if (nombre.equalsIgnoreCase("inmobiliaria")){
            return extensiones.get("inmobiliaria");
        }

        return extensiones.get("default");
    }
}
