package com.tfg.servicio_persistencia.infraestructura.persitencia.entidad;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "anuncioprocesado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnuncioProcesadoEntity {

    @Id
    @Column(name = "ID_ANUNCIOPROCESADO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAnuncioProcesado;

    private BigDecimal precioValor;
    private String precioMoneda;

    @Column(columnDefinition = "TEXT")
    private String descripcionLimpia;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private String resultadoExtraccion;

    private BigDecimal confianzaGlobal;
    private String modeloLlm;
    private Boolean esVigente;
    private Instant fechaExtraccion;

    @Column(name = "ID_PLANTILLAPROMPT_FK")
    private Long idPlantillaPromptFk;

    @ManyToOne
    @JoinColumn(name = "ID_ANUNCIO_FK")
    private AnuncioSinProcesarEntity anuncio;
}
