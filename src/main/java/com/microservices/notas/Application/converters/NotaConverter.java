package com.microservices.notas.Application.converters;

import com.microservices.notas.Application.dto.NotaDto;
import com.microservices.notas.Domain.entities.Bimestre;
import com.microservices.notas.Domain.entities.Nota;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class NotaConverter extends AbstractConverter<Nota, NotaDto> {

    private BimestreConverter bimestreConverter;


    @Override
    public NotaDto fromEntity(Nota entity) {
        if(entity==null){
            return null;
        }
        return NotaDto.builder()
                .idNotaAcad(entity.getIdNotaAcad())
                .notaAcad(entity.getNotaAcad())
                .idBimestre(bimestreConverter.fromEntity(entity.getIdBimestre()))
                .idEstudiante(entity.getIdEstudiante())
                .idCurso(entity.getIdCurso())
                .build();
    }

    @Override
    public Nota fromDTO(NotaDto dto) {
        if(dto==null){
            return null;
        }
        Bimestre bimestre= bimestreConverter.fromDTO(dto.getIdBimestre());

        return Nota.builder()
                .idNotaAcad(dto.getIdNotaAcad())
                .notaAcad(dto.getNotaAcad())
                .idBimestre(bimestre)
                .idEstudiante(dto.getIdEstudiante())
                .idCurso(dto.getIdCurso())
                .build();
    }
}
