package com.tfg.anuncios.contratos.valueobject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UbicacionDto {

    private String textoOriginal;
    private String ciudad;
    private String provincia;
    private String comunidadAutonoma;
    private String pais;

}
