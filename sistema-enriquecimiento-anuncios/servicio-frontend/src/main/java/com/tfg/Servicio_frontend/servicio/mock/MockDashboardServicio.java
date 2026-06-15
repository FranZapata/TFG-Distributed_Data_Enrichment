package com.tfg.Servicio_frontend.servicio.mock;

import com.tfg.Servicio_frontend.servicio.AnuncioServicio;
import com.tfg.Servicio_frontend.servicio.DashboardServicio;
import org.springframework.stereotype.Service;

@Service
public class MockDashboardServicio implements DashboardServicio {
    private final AnuncioServicio anuncioServicio;

    public MockDashboardServicio(AnuncioServicio servicio){
        this.anuncioServicio = servicio;
    }

    @Override
    public Integer getTotalAds() {
        return anuncioServicio.buscarTodo().size();
    }

    @Override
    public Integer getMotorAds() {
        return (int) anuncioServicio.buscarTodo().stream()
                .filter(ad -> "Motor".equals(ad.getCategoria()))
                .count();
    }

    @Override
    public Integer getInmobiliarioAds() {
        return (int)
                anuncioServicio.buscarTodo()
                        .stream()
                        .filter(ad ->
                                "Inmobiliario".equals(
                                        ad.getCategoria()
                                )
                        )
                        .count();
    }

    @Override
    public Integer getSavedSearches() {
        return 8;
    }
}
