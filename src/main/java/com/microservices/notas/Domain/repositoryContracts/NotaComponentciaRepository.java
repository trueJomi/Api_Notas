package com.microservices.notas.Domain.repositoryContracts;

import com.microservices.notas.Domain.entities.NotaCompetencia;

import java.util.List;

public interface NotaComponentciaRepository {

    NotaCompetencia guardarNotaCompetencia(NotaCompetencia notaCompetencia);

    NotaCompetencia buscarPorId(Integer id);

    List<NotaCompetencia> notaCompetenciaByCompetenciaAndBimestre(String competencia, Integer bimestre);

    List<NotaCompetencia> notaCompetenciaByEstudianteAndYear(Integer estudiante, Integer year);

    List<NotaCompetencia> notaCompetenciaByEstudianteAndBimestre(Integer estudiante, Integer bimestre);

    List<NotaCompetencia> notaCompetenciaByEstudiante(Integer estudiante);

    void eliminarNotaCompetencia(Integer id);


}
