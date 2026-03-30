package com.tfg.anuncios.contratos.valueobject;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrecioDto {
    private BigDecimal valor;
    private String moneda;

}
