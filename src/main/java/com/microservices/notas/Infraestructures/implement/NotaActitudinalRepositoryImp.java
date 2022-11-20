package com.microservices.notas.Infraestructures.implement;

import com.microservices.notas.Application.exceptions.ResourceNotFoundException;
import com.microservices.notas.Domain.entities.NotaActitudinal;
import com.microservices.notas.Domain.repositoryContracts.NotaActitudinalRepository;
import com.microservices.notas.Infraestructures.Repositories.NotaActitudinalRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotaActitudinalRepositoryImp implements NotaActitudinalRepository {

    @Autowired
    private NotaActitudinalRepositoryJPA db;

    @Override
    public NotaActitudinal guardarNotaActitudinal(NotaActitudinal notaActitudinal) {
        return db.save(notaActitudinal);
    }

    @Override
    public List<NotaActitudinal> notaActitudinalByEstudiante(Integer estudiante) {
        return notaActitudinalByIdBimestre(estudiante);
    }

    @Override
    public List<NotaActitudinal> ListarByEstudianteAndBimestre(Integer estudiante, Integer bimestre) {
        return db.notaActitudinalByEstudianteAndBimestre(estudiante,bimestre);
    }

    @Override
    public List<NotaActitudinal> NotaActitudinalByYearAndEstudiante(Integer estudiante, Integer year) {
        return db.notaActitudinalByEstudianteAndYear(estudiante,year);
    }

    @Override
    public List<NotaActitudinal> notaActitudinalByIdBimestre(Integer bimestre) {
        return db.notaActitudinalByIdBimestre(bimestre);
    }

    @Override
    public NotaActitudinal buscarPorId(Integer id) {
        return db.findById(id).orElseThrow(()-> new ResourceNotFoundException("No Existe la nota: "+id));
    }

    @Override
    public void eliminarNotaActitudinal(Integer id) {
        db.deleteById(id);
    }
}
