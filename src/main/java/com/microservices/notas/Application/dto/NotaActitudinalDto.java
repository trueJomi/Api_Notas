package com.microservices.notas.Application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Setter
@Getter
public class NotaActitudinalDto {

    private Integer idNotaAct;
    private String notaAct;
    private Integer idEstudiante;
    private BimestreDto idBimestre;
}
