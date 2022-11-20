package com.microservices.notas.Domain.services;

import com.microservices.notas.Domain.entities.NotaActitudinal;

import java.util.List;

public interface NotaActitudinalService {

    NotaActitudinal guardarNotaActitudinal(NotaActitudinal notaActitudinal);

    NotaActitudinal editarNotaActitudinal(NotaActitudinal notaActitudinal);


    List<NotaActitudinal> ListarByEstudiante(Integer estudiante);

    List<NotaActitudinal> ListarEstudianteAndBimestre(Integer estudiante, Integer bimestre);

    List<NotaActitudinal> ListarByYearAndEstudiante(Integer estudiante,Integer year);

    List<NotaActitudinal> ListarByIdBimestre(Integer bimestre);

    NotaActitudinal buscarPorId(Integer id);


    NotaActitudinal eliminarNotaActitudinal(Integer id);
}
