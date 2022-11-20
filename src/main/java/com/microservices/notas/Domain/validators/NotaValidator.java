package com.microservices.notas.Domain.validators;

import com.microservices.notas.Application.exceptions.IncorrectResourceRequestException;
import com.microservices.notas.Domain.entities.Nota;
import com.microservices.notas.Domain.repositoryContracts.CursoRepository;
import com.microservices.notas.Domain.repositoryContracts.EstudianteRepository;

public class NotaValidator {
    private static CursoRepository cursoRepository;

    private static EstudianteRepository estudianteRepository;


    public static void validateSave(Nota nota){
        if (nota.getNotaAcad()==null || nota.getNotaAcad().isEmpty()){
            throw new IncorrectResourceRequestException("No no puso una nota");
        }

        if(!TipeNotasValdiator.validateNotas(nota.getNotaAcad())) {
            throw new IncorrectResourceRequestException("Nota no valida");
        }
        if (nota.getIdEstudiante()==null){
            throw new IncorrectResourceRequestException("No selecciono a algun estudiante");
        }
        if (!estudianteRepository.estudianteValido(nota.getIdEstudiante())){
            throw new IncorrectResourceRequestException("Estudinate no existe");
        }
        if (nota.getIdCurso()==null){
            throw new IncorrectResourceRequestException("no seleciona algun curso");
        }
        if (!cursoRepository.cursoValido(nota.getIdCurso())){
            throw new IncorrectResourceRequestException("no exsiste el curso");
        }
    }
}
