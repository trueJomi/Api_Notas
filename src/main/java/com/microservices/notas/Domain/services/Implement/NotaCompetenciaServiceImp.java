package com.microservices.notas.Domain.services.Implement;

import com.microservices.notas.Application.exceptions.IncorrectResourceRequestException;
import com.microservices.notas.Domain.entities.Bimestre;
import com.microservices.notas.Domain.entities.NotaCompetencia;
import com.microservices.notas.Domain.repositoryContracts.*;
import com.microservices.notas.Domain.services.NotaCompetenciaService;
import com.microservices.notas.Domain.validators.TipeNotasValdiator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaCompetenciaServiceImp implements NotaCompetenciaService {

    private final NotaCompetenciaRepository notaCompetenciaRepository;

    private final BimestreRepository bimestreRepository;

    public NotaCompetenciaServiceImp(NotaCompetenciaRepository notaCompetenciaRepository, BimestreRepository bimestreRepository) {
        this.notaCompetenciaRepository = notaCompetenciaRepository;
        this.bimestreRepository = bimestreRepository;
    }

    @Override
    public NotaCompetencia guardarNotaCompetencia(NotaCompetencia notaCompetencia) {
        Bimestre bimestre = bimestreRepository.buscarById(notaCompetencia.getIdBimestre().getIdBimestre());
        notaCompetencia.setIdBimestre(bimestre);
//        NotaCompetenciaValidator.valdiateSave(notaCompetencia);
        return notaCompetenciaRepository.guardarNotaCompetencia(notaCompetencia);
    }

    @Override
    public NotaCompetencia editarNotaCompetencia(NotaCompetencia notaCompetencia) {
        NotaCompetencia oldNotaCompetencia= notaCompetenciaRepository.buscarPorId(notaCompetencia.getIdNotaComp());
        if(!TipeNotasValdiator.validateNotas(notaCompetencia.getNotaComp())){
            throw new IncorrectResourceRequestException("Nota no valida");
        }
        oldNotaCompetencia.setNotaComp(notaCompetencia.getNotaComp());
        return notaCompetenciaRepository.guardarNotaCompetencia(oldNotaCompetencia);
    }

    @Override
    public NotaCompetencia buscarPorId(Integer id) {
        return notaCompetenciaRepository.buscarPorId(id);
    }

    @Override
    public List<NotaCompetencia> ListarByCompetenciaAndBimestre(Integer competencia, Integer bimestre) {
        return notaCompetenciaRepository.notaCompetenciaByCompetenciaAndBimestre(competencia,bimestre);
    }

    @Override
    public List<NotaCompetencia> ListarByEstudianteAndYear(Integer estudiante, Integer year) {
        return notaCompetenciaRepository.notaCompetenciaByEstudianteAndYear(estudiante,year);
    }

    @Override
    public List<NotaCompetencia> ListarByEstudianteAndBimestre(Integer estudiante, Integer bimestre) {
        return notaCompetenciaRepository.notaCompetenciaByEstudianteAndBimestre(estudiante,bimestre);
    }

    @Override
    public List<NotaCompetencia> ListarByEstudiante(Integer estudiante) {
        return notaCompetenciaRepository.notaCompetenciaByEstudiante(estudiante);
    }

    @Override
    public NotaCompetencia eliminarNotaCompetencia(Integer id) {
        NotaCompetencia notaCompetencia = notaCompetenciaRepository.buscarPorId(id);
        notaCompetenciaRepository.eliminarNotaCompetencia(notaCompetencia.getIdNotaComp());
        return notaCompetencia;
    }
}
