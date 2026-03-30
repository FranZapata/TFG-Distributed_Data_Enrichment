package com.tfg.anuncios.contratos.evento;

import com.fasterxml.jackson.databind.JsonNode;
import com.tfg.anuncios.contratos.enums.EstadoAnuncio;
import com.tfg.anuncios.contratos.valueobject.FuenteResumenDto;
import com.tfg.anuncios.contratos.valueobject.PrecioDto;
import com.tfg.anuncios.contratos.valueobject.UbicacionDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnuncioSinProcesarEvent {

    private String eventId;
    private Instant eventTimestamp;

    private String sourceMessageId;

    private FuenteResumenDto fuente;

    private String externalId;
    private String urlOrigen;
    private String titulo;
    private String descripcion;

    private PrecioDto precio;
    private UbicacionDto ubicacion;

    private Instant fechaPublicacion;
    private Instant fechaCaptura;

    private EstadoAnuncio estado;

    private JsonNode rawPayload;

}
