package com.microservices.notas.Application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class NotaDto {

    private Integer idNotaAcad;
    private String notaAcad;
    private Integer idEstudiante;
    private Integer idCurso;
    private BimestreDto idBimestre;
}
