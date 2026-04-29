package com.tfg.procesado_anuncios.infraestructura.excepciones;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

@Getter
public class ExcepcionLlmParse extends RuntimeException{
    private final String respuestaLlm;
    private final  Instant fecha;
    private final int intentos;

    public ExcepcionLlmParse(String mensaje, String respuestaLlm,Instant fecha, int intentos, Throwable causa){
        super(mensaje,causa);
        this.respuestaLlm = respuestaLlm;
        this.fecha = fecha;
        this.intentos = intentos;
    }
}
