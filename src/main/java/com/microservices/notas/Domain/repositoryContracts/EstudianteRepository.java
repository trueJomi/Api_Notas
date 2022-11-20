package com.microservices.notas.Domain.repositoryContracts;

import org.springframework.stereotype.Component;

public interface EstudianteRepository {
    Boolean estudianteValido(Integer id);
}
