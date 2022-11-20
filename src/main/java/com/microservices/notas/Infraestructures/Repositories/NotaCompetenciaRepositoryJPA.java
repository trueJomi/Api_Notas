package com.microservices.notas.Infraestructures.Repositories;

import com.microservices.notas.Domain.entities.NotaCompetencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotaCompetenciaRepositoryJPA extends JpaRepository<NotaCompetencia,Integer> {
    @Query("SELECT nc FROM NotaCompetencia nc WHERE " +
            "nc.idEstudiante=:est")
    List<NotaCompetencia> notaCompetenciaByEstudiante(@Param("est")Integer estudiante);

    @Query("SELECT nc FROM NotaCompetencia nc WHERE " +
            "nc.idEstudiante=:est AND nc.idBimestre.idBimestre=:bim")
    List<NotaCompetencia> notaCompetenciaByEstudianteAndBimestre(@Param("est")Integer idEstudiante, @Param("bim") Integer bimestre);

    @Query("SELECT nc FROM NotaCompetencia nc WHERE " +
            "nc.idEstudiante=:est AND nc.idBimestre.idYear.idYear=:year")
    List<NotaCompetencia> notaCompetenciaByEstudianteAndYear(@Param("est")Integer idEstudiante, @Param("year") Integer year);
    @Query("SELECT nc FROM NotaCompetencia nc WHERE " +
            "nc.idCompetencia=:comp AND  nc.idBimestre.idBimestre=:bim")
    List<NotaCompetencia> notaCompetenciaByCompetenciaAndBimestre(@Param("comp")String competencia,@Param("bim") Integer bimestre);

}
