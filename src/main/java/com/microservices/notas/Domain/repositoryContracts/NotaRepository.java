package com.microservices.notas.Domain.repositoryContracts;

import com.microservices.notas.Domain.entities.Nota;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NotaRepository {
    Nota guardarNota(Nota nota);

    Nota buscarPorId(Integer id);

    List<Nota> notaByEstudianteAndYear(Integer estudiante, Integer year);

    List<Nota> notaByEstudianteAndBimestre(Integer estudiante, Integer bimestre);

    List<Nota> notaByEstudiante(Integer estudiante);

    List<Nota> notaByCursoAndBimestre(Integer curso, Integer bimestre);

    void eliminarNota(Integer id);
}
