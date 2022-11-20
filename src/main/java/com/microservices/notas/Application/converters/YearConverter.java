package com.microservices.notas.Application.converters;

import com.microservices.notas.Application.dto.YearDto;
import com.microservices.notas.Domain.entities.Bimestre;
import com.microservices.notas.Domain.entities.Year;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component

public class YearConverter extends AbstractConverter<Year, YearDto> {

    private BimestreConverter bimestreConverter;
    @Override
    public YearDto fromEntity(Year entity) {
        if(entity==null){
            return null;
        }



        return YearDto.builder()
                .idYear(entity.getIdYear())
                .year(entity.getYear())
                .bimestres(bimestreConverter.fromEntity(entity.getBimestres()))
                .build();
    }

    @Override
    public Year fromDTO(YearDto dto) {
        if(dto==null){
            return null;
        }

        List<Bimestre> bimestres = bimestreConverter.fromDTO(dto.getBimestres());

        return Year.builder()
                .idYear(dto.getIdYear())
                .year(dto.getYear())
                .bimestres(bimestres)
                .build();
    }
}
