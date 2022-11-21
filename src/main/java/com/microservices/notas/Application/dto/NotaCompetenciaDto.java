package com.microservices.notas.Application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class NotaCompetenciaDto {

    private Integer idNotaComp;
    private String notaComp;
    private Integer idEstudiante;
    private Integer idCompetencia;
    private BimestreDto idBimestre;
}
