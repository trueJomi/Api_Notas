package com.microservices.notas.Domain.services.Implement;

import com.microservices.notas.Application.exceptions.GeneralServiceException;
import com.microservices.notas.Application.exceptions.IncorrectResourceRequestException;
import com.microservices.notas.Domain.entities.Bimestre;
import com.microservices.notas.Domain.entities.Nota;
import com.microservices.notas.Domain.repositoryContracts.BimestreRepository;
import com.microservices.notas.Domain.repositoryContracts.NotaRepository;
import com.microservices.notas.Domain.services.NotaService;
import com.microservices.notas.Domain.validators.NotaValidator;
import com.microservices.notas.Domain.validators.TipeNotasValdiator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaServiceImp implements NotaService {

    private final NotaRepository notaRepository;
    private final BimestreRepository bimestreRepository;


    public NotaServiceImp(NotaRepository notaRepository, BimestreRepository bimestreRepository) {
        this.notaRepository = notaRepository;
        this.bimestreRepository = bimestreRepository;
    }

    @Override
    public Nota guardarNota(Nota nota) {
        Bimestre bimestre = bimestreRepository.buscarById(nota.getIdBimestre().getIdBimestre());
        nota.setIdBimestre(bimestre);
//        NotaValidator.validateSave(nota);
        return notaRepository.guardarNota(nota);
    }

    @Override
    public Nota editarNota(Nota nota) {
        Nota editNota=notaRepository.buscarPorId(nota.getIdNotaAcad());
        if(!TipeNotasValdiator.validateNotas(nota.getNotaAcad())){
            throw new IncorrectResourceRequestException("Nota no valida");
        }
        editNota.setNotaAcad(nota.getNotaAcad());
        return notaRepository.guardarNota(editNota);
    }

    @Override
    public Nota buscarPorId(Integer id) {
        return notaRepository.buscarPorId(id);
    }

    @Override
    public List<Nota> ListarByEstudianteAndYear(Integer estudiante, Integer year) {
        return notaRepository.notaByEstudianteAndYear(estudiante,year);
    }

    @Override
    public List<Nota> ListarByEstudianteAndBimestre(Integer estudiante, Integer bimestre) {
        return notaRepository.notaByEstudianteAndBimestre(estudiante,bimestre);
    }

    @Override
    public List<Nota> ListarByEstudiante(Integer estudiante) {
        return notaRepository.notaByEstudiante(estudiante);
    }

    @Override
    public List<Nota> ListarByCursoAndBimestre(Integer curso, Integer bimestre) {
        return notaRepository.notaByCursoAndBimestre(curso,bimestre);
    }


    @Override
    public Nota eliminarNota(Integer id) {
        Nota nota=notaRepository.buscarPorId(id);
        notaRepository.eliminarNota(nota.getIdNotaAcad());
        return nota;
    }
}
