package com.microservices.notas.Infraestructures.implement;

import com.microservices.notas.Application.exceptions.ResourceNotFoundException;
import com.microservices.notas.Domain.entities.Bimestre;
import com.microservices.notas.Domain.repositoryContracts.BimestreRepository;
import com.microservices.notas.Infraestructures.Repositories.BimestreRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BimestreRspositoryImp implements BimestreRepository {

    @Autowired
    private BimestreRepositoryJPA db;

    @Override
    public Bimestre guardarBimestre(Bimestre estudiante) {
        return db.save(estudiante);
    }

    @Override
    public Bimestre buscarById(Integer id) {
        return db.findById(id).orElseThrow(()-> new ResourceNotFoundException("No Existe este bimestre: "+id));
    }

    @Override
    public void eliminarBimestre(Integer id) {
        db.deleteById(id);
    }
}
