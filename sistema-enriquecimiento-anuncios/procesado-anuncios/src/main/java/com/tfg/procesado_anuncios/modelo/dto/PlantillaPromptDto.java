package com.tfg.procesado_anuncios.modelo.dto;

public class PlantillaPromptDto {
    private Long idPlantillaPrompt;
    private String contenido;

    public PlantillaPromptDto(Long idPlantillaPrompt, String contenido) {
        this.idPlantillaPrompt = idPlantillaPrompt;
        this.contenido = contenido;
    }

    public Long getIdPlantillaPrompt() { return idPlantillaPrompt; }
    public String getContenido() { return contenido; }
}
