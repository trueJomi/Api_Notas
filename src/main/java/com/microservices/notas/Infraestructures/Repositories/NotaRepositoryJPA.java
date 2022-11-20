package com.microservices.notas.Infraestructures.Repositories;

import com.microservices.notas.Domain.entities.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotaRepositoryJPA extends JpaRepository<Nota,Integer> {
    @Query("SELECT n FROM Nota n WHERE " +
            "n.idCurso=:cur AND  n.idBimestre.idBimestre=:bi")
    List<Nota> notaByCursoAndBimestre(@Param("cur")Integer curso,@Param("bi") Integer bimestre);

    @Query("SELECT n FROM Nota n WHERE " +
            "n.idEstudiante=:est")
    List<Nota> notaByEstudiante(@Param("est")Integer idEstudiante);

    @Query("SELECT n FROM Nota n WHERE " +
            "n.idEstudiante=:est AND n.idBimestre.idBimestre=:bim")
    List<Nota> notaByEstudianteAndBimestre(@Param("est")Integer idEstudiante, @Param("bim") Integer bimestre);

    @Query("SELECT n FROM Nota n WHERE " +
            "n.idEstudiante=:est AND n.idBimestre.idYear.idYear=:year")
    List<Nota> notaByEstudianteAndYear(@Param("est")Integer idEstudiante, @Param("year") Integer year);
}