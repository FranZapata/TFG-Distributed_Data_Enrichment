package com.tfg.scraper_anuncios_wp.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDto {
    private Long idCategoria;
    private String codigoInterno;
    private Long idFuente;
    private String urlBase;
    private String nombre;
}
