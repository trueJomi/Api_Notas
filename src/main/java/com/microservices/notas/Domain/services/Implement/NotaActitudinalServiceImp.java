package com.microservices.notas.Domain.services.Implement;

import com.microservices.notas.Application.exceptions.GeneralServiceException;
import com.microservices.notas.Application.exceptions.IncorrectResourceRequestException;
import com.microservices.notas.Domain.entities.Bimestre;
import com.microservices.notas.Domain.entities.NotaActitudinal;
import com.microservices.notas.Domain.repositoryContracts.BimestreRepository;
import com.microservices.notas.Domain.repositoryContracts.NotaActitudinalRepository;
import com.microservices.notas.Domain.services.NotaActitudinalService;
import com.microservices.notas.Domain.validators.NotaActitudinalValidator;
import com.microservices.notas.Domain.validators.TipeNotasValdiator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaActitudinalServiceImp implements NotaActitudinalService {

    private final NotaActitudinalRepository notaActitudinalRepository;

    private final BimestreRepository bimestreRepository;


    public NotaActitudinalServiceImp(NotaActitudinalRepository notaActitudinalRepository, BimestreRepository bimestreRepository) {
        this.notaActitudinalRepository = notaActitudinalRepository;

        this.bimestreRepository = bimestreRepository;
    }

    @Override
    public NotaActitudinal guardarNotaActitudinal(NotaActitudinal notaActitudinal){
        Bimestre bimestre = bimestreRepository.buscarById(notaActitudinal.getIdBimestre().getIdBimestre());
        notaActitudinal.setIdBimestre(bimestre);
//        NotaActitudinalValidator.validateSave(notaActitudinal);
        return notaActitudinalRepository.guardarNotaActitudinal(notaActitudinal);
    }

    @Override
    public NotaActitudinal editarNotaActitudinal(NotaActitudinal notaActitudinal){
        Integer idNotaActitudinal= notaActitudinal.getIdNotaAct();
        NotaActitudinal editNotaActitudinal=notaActitudinalRepository.buscarPorId(idNotaActitudinal);
        if(!TipeNotasValdiator.validateNotas(notaActitudinal.getNotaAct())){
            throw new IncorrectResourceRequestException("Nota no valida");
        }
        editNotaActitudinal.setNotaAct(notaActitudinal.getNotaAct());
        return notaActitudinalRepository.guardarNotaActitudinal(editNotaActitudinal);
    }

    @Override
    public List<NotaActitudinal> ListarByEstudiante(Integer estudiante) {
        return notaActitudinalRepository.notaActitudinalByEstudiante(estudiante);
    }

    @Override
    public List<NotaActitudinal> ListarEstudianteAndBimestre(Integer estudiante, Integer bimestre) {
        return notaActitudinalRepository.ListarByEstudianteAndBimestre(estudiante,bimestre);
    }

    @Override
    public List<NotaActitudinal> ListarByYearAndEstudiante(Integer estudiante, Integer year) {
        return notaActitudinalRepository.NotaActitudinalByYearAndEstudiante(estudiante,year);
    }

    @Override
    public List<NotaActitudinal> ListarByIdBimestre(Integer bimestre) {
        return notaActitudinalRepository.notaActitudinalByIdBimestre(bimestre);
    }

    @Override
    public NotaActitudinal buscarPorId(Integer id){
        return notaActitudinalRepository.buscarPorId(id);
    }

    @Override
    public NotaActitudinal eliminarNotaActitudinal(Integer id){
        NotaActitudinal notaActitudinal= notaActitudinalRepository.buscarPorId(id);
        notaActitudinalRepository.eliminarNotaActitudinal(notaActitudinal.getIdNotaAct());
        return notaActitudinal;
    }

}
