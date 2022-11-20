package com.microservices.notas.Application.converters;

import com.microservices.notas.Application.dto.NotaCompetenciaDto;
import com.microservices.notas.Domain.entities.Bimestre;
import com.microservices.notas.Domain.entities.NotaCompetencia;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class NotaCompetenciaConverter extends AbstractConverter<NotaCompetencia, NotaCompetenciaDto> {

    private BimestreConverter bimestreConverter;

    @Override
    public NotaCompetenciaDto fromEntity(NotaCompetencia entity) {
        if(entity==null){
            return null;
        }


        return NotaCompetenciaDto.builder()
                .idNotaComp(entity.getIdNotaComp())
                .notaComp(entity.getNotaComp())
                .idBimestre(bimestreConverter.fromEntity(entity.getIdBimestre()))
                .idCompetencia(entity.getIdCompetencia())
                .idEstudiante(entity.getIdEstudiante())
                .build();
    }

    @Override
    public NotaCompetencia fromDTO(NotaCompetenciaDto dto) {
        if(dto==null){
            return null;
        }

        Bimestre bimestre= bimestreConverter.fromDTO(dto.getIdBimestre());


        return NotaCompetencia.builder()
                .idNotaComp(dto.getIdNotaComp())
                .notaComp(dto.getNotaComp())
                .idBimestre(bimestre)
                .idCompetencia(dto.getIdCompetencia())
                .idEstudiante(dto.getIdEstudiante())
                .build();
    }
}
