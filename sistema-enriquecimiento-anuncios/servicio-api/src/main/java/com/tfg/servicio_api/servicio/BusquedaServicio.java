package com.tfg.servicio_api.servicio;

import com.tfg.servicio_api.dto.BusquedaRequest;
import com.tfg.servicio_api.dto.BusquedaResponse;
import com.tfg.servicio_api.repositorio.AnuncioProcesadoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BusquedaServicio {

    private final AnuncioProcesadoRepositorio anuncioProcesadoRepositorio;

    public List<BusquedaResponse> buscar(
             BusquedaRequest request) {

        return anuncioProcesadoRepositorio
                .findByAnuncio_Categoria_IdCategoriaOrderByFechaExtraccionDesc(
                        request.idCategoria())
                .stream()
                .map(a -> new BusquedaResponse(
                        a.getIdAnuncioProcesado(),
                        a.getAnuncio().getIdAnuncio(),
                        a.getAnuncio().getTitulo(),
                        a.getPrecioValor(),
                        a.getPrecioMoneda(),
                        a.getAnuncio().getUbicacionTextoOriginal(),
                        a.getAnuncio().getFechaPublicacion(),
                        a.getAnuncio()
                                .getCategoria()
                                .getNombre(),
                        a.getConfianzaGlobal(),
                        a.getEsVigente(),
                        a.getAnuncio().getUrlOrigen(),
                        a.getResultadoExtraccion()
                ))
                .toList();
    }
}
