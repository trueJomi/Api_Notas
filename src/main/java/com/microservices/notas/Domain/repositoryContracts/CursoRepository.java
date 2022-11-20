package com.microservices.notas.Domain.repositoryContracts;

import org.springframework.stereotype.Component;

public interface CursoRepository {
    Boolean cursoValido(Integer id) ;
}
