package com.microservices.notas.Application.converters;

import com.microservices.notas.Application.dto.NotaActitudinalDto;
import com.microservices.notas.Domain.entities.Bimestre;
import com.microservices.notas.Domain.entities.NotaActitudinal;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class NotaActitudinalConverter extends AbstractConverter<NotaActitudinal, NotaActitudinalDto>{

    private BimestreConverter bimestreConverter;
    @Override
    public NotaActitudinalDto fromEntity(NotaActitudinal entity) {
        if(entity==null){
            return null;
        }
        return NotaActitudinalDto.builder()
                .idNotaAct(entity.getIdNotaAct())
                .notaAct(entity.getNotaAct())
                .idBimestre(bimestreConverter.fromEntity(entity.getIdBimestre()))
                .idEstudiante(entity.getIdEstudiante())
                .build();
    }

    @Override
    public NotaActitudinal fromDTO(NotaActitudinalDto dto) {
        if(dto==null){
            return null;
        }
        Bimestre bimestre=bimestreConverter.fromDTO(dto.getIdBimestre());

        return NotaActitudinal.builder()
                .idNotaAct(dto.getIdNotaAct())
                .notaAct(dto.getNotaAct())
                .idBimestre(bimestre)
                .idEstudiante(dto.getIdEstudiante())
                .build();
    }
}
