package com.tfg.scraper_anuncios_wp.aplicacion;

import com.tfg.scraper_anuncios_wp.infraestructura.persistencia.RepositorioCategoria;
import com.tfg.scraper_anuncios_wp.modelo.dto.CategoriaDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicioCategoria {
    private final RepositorioCategoria repositorioCategoria;

    public List<CategoriaDto> obtenerCategoriasActivas(){
        return repositorioCategoria.obtenerCategoriasPorFuente("Wallapop")
                .stream()
                .map(c -> new CategoriaDto(
                        c.getIdCategoria(),
                        c.getCodigoInterno(),
                        c.getFuente().getIdFuente(),
                        c.getFuente().getUrlBase()
                ))
                .toList();
    }
}
