package com.microservices.notas.Domain.validators;

import com.microservices.notas.Application.exceptions.IncorrectResourceRequestException;
import com.microservices.notas.Domain.entities.NotaActitudinal;
import com.microservices.notas.Domain.repositoryContracts.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class NotaActitudinalValidator {

    private static EstudianteRepository estudianteRepository;


    public static void validateSave(NotaActitudinal notaActitudinal){

        if(notaActitudinal.getNotaAct().isEmpty() || notaActitudinal.getNotaAct()==null){
            throw new IncorrectResourceRequestException("No no puso una nota");
        }

        if(!TipeNotasValdiator.validateNotas(notaActitudinal.getNotaAct())){
            throw new IncorrectResourceRequestException("Nota no valida");
        }

        if (notaActitudinal.getIdEstudiante()==null){
            throw new IncorrectResourceRequestException("No selecciono a algun estudiante");
        }

        if(!estudianteRepository.estudianteValido(notaActitudinal.getIdEstudiante())) {
            throw new IncorrectResourceRequestException("No existe este estudiante");
        }
    }


}
