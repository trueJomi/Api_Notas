package com.microservices.notas.Domain.services;

import com.microservices.notas.Domain.entities.Nota;

import java.util.List;

public interface NotaService {
    Nota guardarNota(Nota nota);

    Nota editarNota(Nota nota);

    Nota buscarPorId(Integer id);

    List<Nota> ListarByEstudianteAndYear(Integer estudiante, Integer year);

    List<Nota> ListarByEstudianteAndBimestre(Integer estudiante, Integer bimestre);

    List<Nota> ListarByEstudiante(Integer estudiante);

    List<Nota> ListarByCursoAndBimestre(Integer curso, Integer bimestre);

    Nota eliminarNota(Integer id);
}
