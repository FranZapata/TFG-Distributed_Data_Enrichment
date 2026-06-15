package com.tfg.Servicio_frontend.servicio;

import com.tfg.Servicio_frontend.dto.PromptDto;

import java.util.List;

public interface PromptServicio {
    List<PromptDto> buscarTodo();
    void save(PromptDto prompt);
}
