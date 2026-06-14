package com.tfg.servicio_api.controlador;

import com.tfg.servicio_api.dto.BusquedaRequest;
import com.tfg.servicio_api.dto.BusquedaResponse;
import com.tfg.servicio_api.servicio.BusquedaServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/buscar")
@RequiredArgsConstructor
public class BusquedaControlador {

    private final BusquedaServicio servicio;

    @PostMapping
    public List<BusquedaResponse> buscar(@RequestBody BusquedaRequest request){
        return servicio.buscar(request);
    }
}
