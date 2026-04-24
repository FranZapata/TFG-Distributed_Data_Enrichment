package com.tfg.procesado_anuncios.infraestructura.excepciones;

import lombok.RequiredArgsConstructor;

public class ExcepcionLlmParse extends RuntimeException{
    private final String respuestaLlm;

    public ExcepcionLlmParse(String mensaje, String respuestaLlm, Throwable causa){
        super(mensaje,causa);
        this.respuestaLlm = respuestaLlm;
    }

    public String getRespuestaLlm() {
        return respuestaLlm;
    }
}
