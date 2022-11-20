package com.microservices.notas.Domain.services;

import com.microservices.notas.Domain.entities.NotaCompetencia;

import java.util.List;

public interface NotaCompetenciaService {
    NotaCompetencia guardarNotaCompetencia(NotaCompetencia notaCompetencia);

    NotaCompetencia editarNotaCompetencia(NotaCompetencia notaCompetencia);

    NotaCompetencia buscarPorId(Integer id);

    List<NotaCompetencia> ListarByCompetenciaAndBimestre(String competencia, Integer bimestre);

    List<NotaCompetencia> ListarByEstudianteAndYear(Integer estudiante, Integer year);

    List<NotaCompetencia> ListarByEstudianteAndBimestre(Integer estudiante, Integer bimestre);

    List<NotaCompetencia> ListarByEstudiante(Integer estudiante);

    NotaCompetencia eliminarNotaCompetencia(Integer id);
}
