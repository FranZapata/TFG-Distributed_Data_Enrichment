package com.tfg.scraper_anuncios_wp.mapeador;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tfg.anuncios.contratos.enums.EstadoAnuncio;
import com.tfg.anuncios.contratos.evento.AnuncioSinProcesarEvent;
import com.tfg.anuncios.contratos.valueobject.FuenteResumenDto;
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
        evento.setSourceMessageId(crudo.getExternalId());

        // Fuente
        FuenteResumenDto fuente = new FuenteResumenDto();
        fuente.setNombre("wallapop");
        fuente.setTipo("web");
        fuente.setUrlBase("https://es.wallapop.com");
        evento.setFuente(fuente);

        // Datos principales
        evento.setExternalId(crudo.getExternalId());
        evento.setUrlOrigen(crudo.getUrl());
        evento.setTitulo(crudo.getTitulo());
        evento.setDescripcion(crudo.getDescripcion());

        // Precio
        evento.setPrecio(parsePrecio(crudo.getPrecioTexto()));

        // Ubicación
        evento.setUbicacion(parseUbicacion(crudo.getUbicacionTexto()));

        // Fechas
        evento.setFechaPublicacion(parseFecha(crudo.getFechaPublicacionTexto()));
        evento.setFechaCaptura(Instant.now());

        // Estado
        evento.setEstado(EstadoAnuncio.CAPTURADO);

        // Raw payload
        evento.setRawPayload(parseRawPayload(crudo));

        return evento;
    }

    // =========================
    // Helpers
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
