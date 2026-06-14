package com.tfg.servicio_api.servicio;

import com.tfg.servicio_api.dto.*;
import com.tfg.servicio_api.entidad.PlantillaPromptEntity;
import com.tfg.servicio_api.entidad.PromptAtributoEntity;
import com.tfg.servicio_api.repositorio.PlantillaPromptRepositorio;
import com.tfg.servicio_api.repositorio.PromptAtributoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlantillaPromptServicio {

    private final PlantillaPromptRepositorio plantillaPromptRepositorio;
    private final PromptAtributoRepositorio atributoRepositorio;

    public List<PromptResponse> getPlantillasPrompts(){
        return plantillaPromptRepositorio.findAll()
                .stream()
                .map(c -> new PromptResponse(
                        c.getIdPlantillaPrompt(),
                        c.getNombre(),
                        c.getVersion(),
                        c.getActivo(),
                        c.getCategoria().getIdCategoria(),
                        c.getCategoria().getNombre()
                ))
                .toList();
    }

    public List<PromptResponse> getPromptsActivos() {

        return plantillaPromptRepositorio.findByActivoTrue()
                .stream()
                .map(prompt -> new PromptResponse(
                        prompt.getIdPlantillaPrompt(),
                        prompt.getNombre(),
                        prompt.getVersion(),
                        prompt.getActivo(),
                        prompt.getCategoria().getIdCategoria(),
                        prompt.getCategoria().getNombre()
                ))
                .toList();
    }

    public PlantillaPromptEntity getPromptActivoCategoria(
            Long idCategoria) {

        return plantillaPromptRepositorio
                .findByCategoria_IdCategoriaAndActivoTrue(idCategoria)
                .orElseThrow(() ->
                        new RuntimeException(
                                "No existe prompt activo"));
    }

    public PromptDetalladoResponse getPlantillaPrompt(Long id){
        PlantillaPromptEntity plantillaPrompt = plantillaPromptRepositorio.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("PlantillaPrompt no encontrada")
                );
        List<PromptAtributoEntity> atributos =
                atributoRepositorio.findByIdPlantillaPromptFk(id);

        List<PromptAtributoResponse> atributosResponse =
                atributos.stream()
                        .map(a -> new PromptAtributoResponse(
                                a.getNombreAtributo(),
                                a.getTipoAtributo(),
                                a.getEsFiltrable()
                        ))
                        .toList();

        return new PromptDetalladoResponse(
                plantillaPrompt.getIdPlantillaPrompt(),
                plantillaPrompt.getNombre(),
                plantillaPrompt.getVersion(),
                plantillaPrompt.getContenido(),
                plantillaPrompt.getActivo(),
                plantillaPrompt.getCategoria().getIdCategoria(),
                atributosResponse
        );
    }
}
