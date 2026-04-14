package com.tfg.procesado_anuncios.modelo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PeticionLlmDto {

    private String model;
    private String prompt;
    private boolean stream;
}
