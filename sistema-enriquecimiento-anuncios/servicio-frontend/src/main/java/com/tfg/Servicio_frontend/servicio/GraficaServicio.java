package com.tfg.Servicio_frontend.servicio;

import java.util.List;
import java.util.Map;

public interface GraficaServicio {
    Map<String, Integer> getAveragePrices();
    Map<String, Integer> getMostPublishedModels();
    Map<String, Integer> getStatusDistribution();
    List<Integer> getPriceEvolution();
}
