package com.tfg.servicio_api.controlador;

import com.tfg.servicio_api.dto.FiltroResponse;
import com.tfg.servicio_api.dto.PromptDetalladoResponse;
import com.tfg.servicio_api.dto.PromptResponse;
import com.tfg.servicio_api.servicio.PlantillaPromptServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/prompts")
@RequiredArgsConstructor
public class PlantillaPromptControlador {

    private final PlantillaPromptServicio servicio;

    @GetMapping
    public List<PromptResponse> getPrompts() {

        return servicio.getPlantillasPrompts();
    }

    @GetMapping("/{id}")
    public PromptDetalladoResponse getPrompt(@PathVariable Long id){
        return servicio.getPlantillaPrompt(id);
    }

    @GetMapping("/active")
    public List<PromptResponse> getPromptsActivos() {

        return servicio.getPromptsActivos();
    }
}
