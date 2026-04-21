package com.tfg.scraper_anuncios_wp.mapeador;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tfg.anuncios.contratos.enums.EstadoAnuncio;
import com.tfg.anuncios.contratos.evento.AnuncioSinProcesarEvent;
import com.tfg.anuncios.contratos.valueobject.PrecioDto;
import com.tfg.anuncios.contratos.valueobject.UbicacionDto;
import com.tfg.scraper_anuncios_wp.modelo.dto.ScrapedAnuncioSinProcesarDto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public class ScrapedAnuncioAAnuncioSinprocesearEventMapeador {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public AnuncioSinProcesarEvent map(ScrapedAnuncioSinProcesarDto crudo){
        AnuncioSinProcesarEvent evento = new AnuncioSinProcesarEvent();

        // Metadata evento
        evento.setEventId(UUID.randomUUID().toString());
        evento.setEventTimestamp(Instant.now());

        // Datos principales
        evento.setIdAnuncio(crudo.getExternalId());
        evento.setUrlOrigen(crudo.getUrlOrigen());
        evento.setTitulo(crudo.getTitulo());
        evento.setDescripcion(crudo.getDescripcion());

        // Precio
        evento.setPrecio(parsePrecio(crudo.getPrecioTexto()));

        // Ubicación
        evento.setUbicacionTextoOriginal(crudo.getUbicacionTexto());

        // Fechas
        evento.setFechaPublicacion(parseFecha(crudo.getFechaPublicacionTexto()));
        evento.setFechaCaptura(parseFecha(crudo.getFechaCaptura()));

        // Estado
        evento.setEstado(EstadoAnuncio.CAPTURADO);

        // Raw payload
        evento.setRawPayload(parseRawPayload(crudo));

        // FK
        evento.setIdFuenteFk(crudo.getIdFuente());
        evento.setIdCategoriaFk(crudo.getIdCategoria());

        return evento;
    }

    // =========================
    // Utils
    // =========================

    private PrecioDto parsePrecio(String precioTexto) {
        try {
            if (precioTexto == null) return null;

            String limpio = precioTexto.replaceAll("[^0-9,\\.]", "")
                    .replace(",", ".");

            BigDecimal valor = new BigDecimal(limpio);

            PrecioDto precio = new PrecioDto();
            precio.setValor(valor);
            precio.setMoneda("EUR");

            return precio;

        } catch (Exception e) {
            return null;
        }
    }

    private UbicacionDto parseUbicacion(String ubicacionTexto) {

        UbicacionDto ubicacion = new UbicacionDto();
        ubicacion.setTextoOriginal(ubicacionTexto);

        // de momento simple (pendiente de mejorar)
        ubicacion.setCiudad(ubicacionTexto);
        ubicacion.setPais("España");

        return ubicacion;
    }

    private Instant parseFecha(String fechaTexto) {
        // simplificado por ahora
        return Instant.now();
    }

    private JsonNode parseRawPayload(ScrapedAnuncioSinProcesarDto raw) {
        try {
            return objectMapper.valueToTree(raw);
        } catch (Exception e) {
            return null;
        }
    }

}
