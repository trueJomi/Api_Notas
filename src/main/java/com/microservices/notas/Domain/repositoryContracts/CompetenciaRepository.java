package com.microservices.notas.Domain.repositoryContracts;

import org.springframework.stereotype.Component;


public interface CompetenciaRepository {
    Boolean competanciaValidar(Integer id);
}
