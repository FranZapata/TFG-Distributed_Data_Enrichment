package com.tfg.anuncios.contratos.valueobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuenteResumenDto {

    private String nombre;
    private String tipo;
    private String urlBase;

}
