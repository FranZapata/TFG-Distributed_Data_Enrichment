package com.tfg.Servicio_frontend.servicio.mock;

import com.tfg.Servicio_frontend.servicio.GraficaServicio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MockGraficasServicio implements GraficaServicio {
    @Override
    public Map<String, Integer> getAveragePrices() {
        return Map.of("GS500", 1800,
                "CB500F", 3200,
                "ER5", 1600,
                "MT03", 4200);
    }

    @Override
    public Map<String, Integer> getMostPublishedModels() {
        return Map.of("GS500", 35,
                "CB500F", 20,
                "ER5", 18,
                "MT03", 12);
    }

    @Override
    public Map<String, Integer> getStatusDistribution() {
        return Map.of( "Nuevo", 10,
                "Seminuevo", 30,
                "Usado", 60);
    }

    @Override
    public List<Integer> getPriceEvolution() {
        return List.of(1800,1850,1900,1750,2100,2200,2450);
    }
}
