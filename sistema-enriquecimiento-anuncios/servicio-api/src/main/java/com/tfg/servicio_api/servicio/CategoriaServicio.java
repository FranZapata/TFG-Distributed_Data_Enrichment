package com.tfg.servicio_api.servicio;

import com.tfg.servicio_api.dto.CategoriaResponse;
import com.tfg.servicio_api.dto.FiltroResponse;
import com.tfg.servicio_api.entidad.CategoriaEntity;
import com.tfg.servicio_api.entidad.PlantillaPromptEntity;
import com.tfg.servicio_api.repositorio.CategoriaRepositorio;
import com.tfg.servicio_api.repositorio.PlantillaPromptRepositorio;
import com.tfg.servicio_api.repositorio.PromptAtributoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaServicio {
    private final CategoriaRepositorio categoriaRepositorio;
    private final PlantillaPromptRepositorio plantillaPromptRepositorio;
    private final PromptAtributoRepositorio atributoRepositorio;

    public List<CategoriaResponse> getCategorias() {
        return categoriaRepositorio.findAll()
                .stream()
                .map(c -> new CategoriaResponse(
                        c.getIdCategoria(),
                        c.getNombre(),
                        c.getFuente().getIdFuente(),
                        c.getFuente().getNombre()
                ))
                .toList();
    }

    public List<FiltroResponse> getFiltros(
            Long idCategoria) {

        PlantillaPromptEntity prompt =
                plantillaPromptRepositorio
                        .findByCategoria_IdCategoriaAndActivoTrue(
                                idCategoria)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "No existe prompt activo"));

        return atributoRepositorio
                .findByIdPlantillaPromptFkAndEsFiltrableTrue(
                        prompt.getIdPlantillaPrompt())
                .stream()
                .map(a -> new FiltroResponse(
                        a.getNombreAtributo(),
                        a.getTipoAtributo()))
                .toList();
    }
}
