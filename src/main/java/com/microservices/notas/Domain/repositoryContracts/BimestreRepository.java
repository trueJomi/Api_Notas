package com.microservices.notas.Domain.repositoryContracts;

import com.microservices.notas.Domain.entities.Bimestre;
import org.springframework.stereotype.Component;

@Component
public interface BimestreRepository {
    Bimestre guardarBimestre(Bimestre estudiante);

    Bimestre buscarById(Integer id);

    void eliminarBimestre(Integer id);
}
