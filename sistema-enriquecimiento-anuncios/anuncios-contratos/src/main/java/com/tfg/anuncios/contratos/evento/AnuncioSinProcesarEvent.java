package com.tfg.anuncios.contratos.evento;

import com.fasterxml.jackson.databind.JsonNode;
import com.tfg.anuncios.contratos.enums.EstadoAnuncio;
import com.tfg.anuncios.contratos.valueobject.PrecioDto;
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

    private String idAnuncio;
    private String urlOrigen;
    private String titulo;
    private String descripcion;

    private String ubicacionTextoOriginal;
    private Long ubicacionLatitud;
    private Long ubicacionLongitud;

    private PrecioDto precio;


    private Instant fechaPublicacion;
    private Instant fechaCaptura;

    private EstadoAnuncio estado;

    private Long idFuenteFk;
    private Long idCategoriaFk;

    private JsonNode rawPayload;

}
