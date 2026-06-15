package com.tfg.Servicio_frontend.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AnuncioMotoDto extends AnuncioDto{
    private String marca;
    private String modelo;
    private int kilometros;
    private Boolean esParaA2;
}
