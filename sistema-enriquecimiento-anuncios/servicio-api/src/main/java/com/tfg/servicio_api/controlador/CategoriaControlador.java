package com.tfg.servicio_api.controlador;

import com.tfg.servicio_api.dto.CategoriaResponse;
import com.tfg.servicio_api.dto.FiltroResponse;
import com.tfg.servicio_api.entidad.CategoriaEntity;
import com.tfg.servicio_api.servicio.CategoriaServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
public class CategoriaControlador {

    private final CategoriaServicio servicio;

    @GetMapping
    public List<CategoriaResponse> getCategorias() {
        return servicio.getCategorias();
    }

    @GetMapping("/{id}/filtros")
    public List<FiltroResponse> getFiltros(@PathVariable Long id){

        return servicio.getFiltros(id);
    }
}
