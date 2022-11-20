package com.microservices.notas.Infraestructures.implement;

import com.microservices.notas.Application.exceptions.ResourceNotFoundException;
import com.microservices.notas.Domain.entities.NotaCompetencia;
import com.microservices.notas.Domain.repositoryContracts.NotaComponentciaRepository;
import com.microservices.notas.Infraestructures.Repositories.NotaCompetenciaRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotaCompetenciaImp implements NotaComponentciaRepository {

    @Autowired
    private NotaCompetenciaRepositoryJPA db;

    @Override
    public NotaCompetencia guardarNotaCompetencia(NotaCompetencia notaCompetencia) {
        return db.save(notaCompetencia);
    }

    @Override
    public NotaCompetencia buscarPorId(Integer id) {
        return db.findById(id).orElseThrow(()-> new ResourceNotFoundException("No Existe la nota: "+id));
    }

    @Override
    public List<NotaCompetencia> notaCompetenciaByCompetenciaAndBimestre(String competencia, Integer bimestre) {
        return db.notaCompetenciaByCompetenciaAndBimestre(competencia,bimestre);
    }

    @Override
    public List<NotaCompetencia> notaCompetenciaByEstudianteAndYear(Integer estudiante, Integer year) {
        return db.notaCompetenciaByEstudianteAndYear(estudiante,year);
    }

    @Override
    public List<NotaCompetencia> notaCompetenciaByEstudianteAndBimestre(Integer estudiante, Integer bimestre) {
        return db.notaCompetenciaByEstudianteAndBimestre(estudiante,bimestre);
    }

    @Override
    public List<NotaCompetencia> notaCompetenciaByEstudiante(Integer estudiante) {
        return notaCompetenciaByEstudiante(estudiante);
    }

    @Override
    public void eliminarNotaCompetencia(Integer id) {
        db.deleteById(id);
    }
}
