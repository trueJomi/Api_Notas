package com.microservices.notas.Domain.repositoryContracts;

import com.microservices.notas.Domain.entities.NotaActitudinal;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NotaActitudinalRepository {
    NotaActitudinal guardarNotaActitudinal(NotaActitudinal notaActitudinal);

    List<NotaActitudinal> notaActitudinalByEstudiante(Integer estudiante);

    List<NotaActitudinal> ListarByEstudianteAndBimestre(Integer estudiante, Integer bimestre);

    List<NotaActitudinal> NotaActitudinalByYearAndEstudiante(Integer estudiante,Integer year);

    List<NotaActitudinal> notaActitudinalByIdBimestre(Integer bimestre);


    NotaActitudinal buscarPorId(Integer id);

    void eliminarNotaActitudinal(Integer id);



}
