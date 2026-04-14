package com.tfg.procesado_anuncios.aplicacion;

import com.tfg.procesado_anuncios.infraestructura.persistencia.RepositorioPlantillaPrompt;
import com.tfg.procesado_anuncios.infraestructura.persistencia.entidad.PlantillaPromptEntity;
import com.tfg.procesado_anuncios.modelo.dto.PlantillaPromptDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ServicioPlantillaPrompt {
    private final RepositorioPlantillaPrompt repositorioPlantillaPrompt;

    public PlantillaPromptDto obtenerPlantillaPrompt(Long idCategoria){
        PlantillaPromptEntity entity =  repositorioPlantillaPrompt.findByIdCategoriaFkAndActivoTrue(idCategoria)
                .orElseThrow(() -> new RuntimeException(
                        "No existe prompt activo para categoria: " + idCategoria
                ));

        return new PlantillaPromptDto(entity.getIdPlantillaPrompt(), entity.getContenido());
    }

}
