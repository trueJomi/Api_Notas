package com.microservices.notas.Domain.validators;

import com.microservices.notas.Application.exceptions.IncorrectResourceRequestException;
import com.microservices.notas.Domain.entities.NotaCompetencia;
import com.microservices.notas.Domain.repositoryContracts.CompetenciaRepository;
import com.microservices.notas.Domain.repositoryContracts.EstudianteRepository;

public class NotaCompetenciaValidator {
    private static CompetenciaRepository competenciaRepository;

    private static EstudianteRepository estudianteRepository;

    public static void valdiateSave(NotaCompetencia notaCompetencia){

        if (notaCompetencia.getNotaComp()==null || notaCompetencia.getNotaComp().isEmpty()){
            throw new IncorrectResourceRequestException("No no puso una nota");
        }

        if(!TipeNotasValdiator.validateNotas(notaCompetencia.getNotaComp())){
            throw new IncorrectResourceRequestException("Nota no valida");
        }
        if (notaCompetencia.getIdEstudiante()==null){
            throw new IncorrectResourceRequestException("No selecciono a algun estudiante");
        }
        if (!estudianteRepository.estudianteValido(notaCompetencia.getIdNotaComp())){
            throw new IncorrectResourceRequestException("Estudinate no existe");
        }
        if (notaCompetencia.getIdCompetencia()==null){
            throw new IncorrectResourceRequestException("no seleciona alguna competencia");
        }
        if (!competenciaRepository.competanciaValidar(notaCompetencia.getIdCompetencia())){
            throw new IncorrectResourceRequestException("no exsiste la competencia");
        }
    }

}
