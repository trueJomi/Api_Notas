package com.microservices.notas.Application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Setter
@Getter
public class BimestreDto {

    private Integer idBimestre;
    private Integer bimestre;

}
