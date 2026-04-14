package com.tfg.procesado_anuncios.infraestructura.kafka;
import com.tfg.anuncios.contratos.evento.AnuncioSinProcesarEvent;
import com.tfg.procesado_anuncios.aplicacion.ServicioProcesadoAnuncio;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class AnuncioSinProcesarConsumer {

    private final ServicioProcesadoAnuncio servicioProcesadoAnuncio;

    @KafkaListener(topics = "anuncio_sinprocesar", groupId = "procesado-anuncios-group")
    public void consumir(AnuncioSinProcesarEvent evento){

        log.info("Recibido anuncio sin procesar: {}",evento.getIdAnuncio());
        servicioProcesadoAnuncio.procesar(evento);
    };
}
