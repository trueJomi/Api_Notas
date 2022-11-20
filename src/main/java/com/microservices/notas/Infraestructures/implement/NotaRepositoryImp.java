package com.microservices.notas.Infraestructures.implement;

import com.microservices.notas.Application.exceptions.ResourceNotFoundException;
import com.microservices.notas.Domain.entities.Nota;
import com.microservices.notas.Domain.repositoryContracts.NotaRepository;
import com.microservices.notas.Infraestructures.Repositories.NotaRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotaRepositoryImp implements NotaRepository {

    @Autowired
    private NotaRepositoryJPA db;


    @Override
    public Nota guardarNota(Nota nota) {
        return db.save(nota);
    }

    @Override
    public Nota buscarPorId(Integer id) {
        return db.findById(id).orElseThrow(()-> new ResourceNotFoundException("No Existe la nota: "+id));
    }

    @Override
    public List<Nota> notaByEstudianteAndYear(Integer estudiante, Integer year) {
        return db.notaByEstudianteAndYear(estudiante,year);
    }

    @Override
    public List<Nota> notaByEstudianteAndBimestre(Integer estudiante, Integer bimestre) {
        return db.notaByEstudianteAndBimestre(estudiante,bimestre);
    }

    @Override
    public List<Nota> notaByEstudiante(Integer estudiante) {
        return db.notaByEstudiante(estudiante);
    }

    @Override
    public List<Nota> notaByCursoAndBimestre(Integer curso, Integer bimestre) {
        return db.notaByCursoAndBimestre(curso,bimestre);
    }

    @Override
    public void eliminarNota(Integer id) {
        db.deleteById(id);
    }
}
