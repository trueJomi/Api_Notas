package com.microservices.notas.Domain.services.Implement;

import com.microservices.notas.Application.exceptions.GeneralServiceException;
import com.microservices.notas.Domain.entities.Bimestre;
import com.microservices.notas.Domain.entities.NotaCompetencia;
import com.microservices.notas.Domain.repositoryContracts.*;
import com.microservices.notas.Domain.services.NotaCompetenciaService;
import com.microservices.notas.Domain.validators.NotaCompetenciaValidator;
import com.microservices.notas.Domain.validators.TipeNotasValdiator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaCompetenciaServiceImp implements NotaCompetenciaService {

    private final NotaComponentciaRepository notaComponentciaRepository;

    private final BimestreRepository bimestreRepository;

    public NotaCompetenciaServiceImp(NotaComponentciaRepository notaComponentciaRepository, BimestreRepository bimestreRepository) {
        this.notaComponentciaRepository = notaComponentciaRepository;
        this.bimestreRepository = bimestreRepository;
    }

    @Override
    public NotaCompetencia guardarNotaCompetencia(NotaCompetencia notaCompetencia) {
        Bimestre bimestre = bimestreRepository.buscarById(notaCompetencia.getIdBimestre().getIdBimestre());
        notaCompetencia.setIdBimestre(bimestre);
        NotaCompetenciaValidator.valdiateSave(notaCompetencia);
        return notaComponentciaRepository.guardarNotaCompetencia(notaCompetencia);
    }

    @Override
    public NotaCompetencia editarNotaCompetencia(NotaCompetencia notaCompetencia) {
        NotaCompetencia oldNotaCompetencia= notaComponentciaRepository.buscarPorId(notaCompetencia.getIdNotaComp());
        if(!TipeNotasValdiator.validateNotas(notaCompetencia.getNotaComp())){
            throw new GeneralServiceException("Nota no valida");
        }
        oldNotaCompetencia.setNotaComp(notaCompetencia.getNotaComp());
        return notaComponentciaRepository.guardarNotaCompetencia(oldNotaCompetencia);
    }

    @Override
    public NotaCompetencia buscarPorId(Integer id) {
        return notaComponentciaRepository.buscarPorId(id);
    }

    @Override
    public List<NotaCompetencia> ListarByCompetenciaAndBimestre(String competencia, Integer bimestre) {
        return notaComponentciaRepository.notaCompetenciaByCompetenciaAndBimestre(competencia,bimestre);
    }

    @Override
    public List<NotaCompetencia> ListarByEstudianteAndYear(Integer estudiante, Integer year) {
        return notaComponentciaRepository.notaCompetenciaByEstudianteAndYear(estudiante,year);
    }

    @Override
    public List<NotaCompetencia> ListarByEstudianteAndBimestre(Integer estudiante, Integer bimestre) {
        return notaComponentciaRepository.notaCompetenciaByEstudianteAndBimestre(estudiante,bimestre);
    }

    @Override
    public List<NotaCompetencia> ListarByEstudiante(Integer estudiante) {
        return notaComponentciaRepository.notaCompetenciaByEstudiante(estudiante);
    }

    @Override
    public NotaCompetencia eliminarNotaCompetencia(Integer id) {
        NotaCompetencia notaCompetencia =notaComponentciaRepository.buscarPorId(id);
        notaComponentciaRepository.eliminarNotaCompetencia(notaCompetencia.getIdNotaComp());
        return notaCompetencia;
    }
}
