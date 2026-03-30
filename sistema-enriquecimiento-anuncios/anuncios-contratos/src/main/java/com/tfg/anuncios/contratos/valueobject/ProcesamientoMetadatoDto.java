package com.tfg.anuncios.contratos.valueobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProcesamientoMetadatoDto {

    private String modeloLlm;
    private String promptNombre;
    private String promptVersion;
    private Boolean exito;
    private String errorMensaje;
    private Instant fechaProcesamiento;

}
