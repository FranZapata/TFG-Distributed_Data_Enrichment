package com.tfg.Servicio_frontend.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AnuncioInmobiliarioDto extends AnuncioDto{
    private String tipoPropiedad;
    private Integer metrosCuadrados;
}
