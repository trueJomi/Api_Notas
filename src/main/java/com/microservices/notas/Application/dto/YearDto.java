package com.microservices.notas.Application.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Setter
@Getter
public class YearDto {
    private Integer idYear;
    private  Integer year;
    private List<BimestreDto> bimestres;
}
