package com.microservices.notas.Infraestructures.Repositories;

import com.microservices.notas.Domain.entities.NotaActitudinal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotaActitudinalRepositoryJPA extends JpaRepository<NotaActitudinal,Integer> {

    @Query("SELECT na FROM NotaActitudinal na WHERE " +
            "na.idEstudiante=:est")
    List<NotaActitudinal> notaActitudinalByEstudiante(@Param("est")Integer idEstudiante);

    @Query("SELECT na FROM NotaActitudinal na WHERE " +
            "na.idEstudiante=:est AND na.idBimestre=:bi")
    List<NotaActitudinal> notaActitudinalByEstudianteAndBimestre(@Param("est")Integer idEstudiante,@Param("bi") Integer idBimestre);

    @Query("SELECT na FROM NotaActitudinal na WHERE " +
            "na.idEstudiante=:est AND na.idBimestre.idYear.idYear=:year")
    List<NotaActitudinal> notaActitudinalByEstudianteAndYear(@Param("est")Integer idEstudiante,@Param("year") Integer idYear);


    @Query("SELECT na FROM NotaActitudinal na WHERE " +
            "na.idBimestre=:bim")
    List<NotaActitudinal> notaActitudinalByIdBimestre(@Param("bim") Integer idBimestre);

}
