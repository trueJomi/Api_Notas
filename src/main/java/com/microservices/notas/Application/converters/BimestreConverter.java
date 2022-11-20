package com.microservices.notas.Application.converters;

import com.microservices.notas.Application.dto.BimestreDto;
import com.microservices.notas.Domain.entities.Bimestre;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class BimestreConverter extends AbstractConverter<Bimestre,BimestreDto>{
    @Override
    public BimestreDto fromEntity(Bimestre entity) {
        if(entity==null){
            return null;
        }
        return BimestreDto.builder()
                .idBimestre(entity.getIdBimestre())
                .bimestre(entity.getBimestre())
                .build();
    }

    @Override
    public Bimestre fromDTO(BimestreDto dto) {
        if(dto==null){
            return null;
        }
        return Bimestre.builder()
                .idBimestre(dto.getIdBimestre())
                .bimestre(dto.getBimestre())
                .build();
    }
}
