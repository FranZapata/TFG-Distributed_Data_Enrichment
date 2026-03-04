package com.tfg.procesado_anuncios.llm;

import org.springframework.stereotype.Service;

@Service
public class LlmClient {

    public String detectCategory(String descripcion) {
        if(descripcion.toLowerCase().contains("moto")){
            return "Motor";
        }
        return "OTROS";
    }
}
