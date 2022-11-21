package com.microservices.notas.Application.controllers.Implement;

import com.microservices.notas.Application.controllers.NotaController;
import com.microservices.notas.Application.converters.NotaConverter;
import com.microservices.notas.Application.dto.NotaCompetenciaDto;
import com.microservices.notas.Application.dto.NotaDto;
import com.microservices.notas.Application.utils.WrapperResponse;
import com.microservices.notas.Domain.entities.Nota;
import com.microservices.notas.Domain.entities.NotaCompetencia;
import com.microservices.notas.Domain.services.Implement.NotaServiceImp;
import com.microservices.notas.Domain.services.NotaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("nota")
public class NotaControllerImp implements NotaController {
    private final NotaService notaService;

    private final NotaConverter notaConverter;

    public NotaControllerImp(NotaService notaService, NotaConverter notaConverter) {
        this.notaService = notaService;
        this.notaConverter = notaConverter;
    }

    @Override
    public ResponseEntity<WrapperResponse<NotaDto>> gaurdarNotaCompetencia(NotaDto notaDto) {
        Nota nota = notaConverter.fromDTO(notaDto);
        Nota notaNew = notaService.guardarNota(nota);
        NotaDto response = notaConverter.fromEntity(notaNew);
        return new WrapperResponse<NotaDto>(response).createResponse(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<WrapperResponse<NotaDto>> editarNotaCompetencia(NotaDto notaDto) {
        Nota nota = notaConverter.fromDTO(notaDto);
        Nota notaEdit = notaService.editarNota(nota);
        NotaDto response = notaConverter.fromEntity(notaEdit);
        return new WrapperResponse<NotaDto>(response).createResponse();
    }

    @Override
    public ResponseEntity<WrapperResponse<NotaDto>> getById(Integer id) {
        Nota nota = notaService.buscarPorId(id);
        NotaDto response = notaConverter.fromEntity(nota);
        return new WrapperResponse<NotaDto>(response).createResponse();
    }

    @Override
    public ResponseEntity<WrapperResponse<List<NotaDto>>> ListarByCusoAndBimestre(Integer curso, Integer bimestre) {
        List<Nota> nota = notaService.ListarByCursoAndBimestre(curso,bimestre);
        List<NotaDto> response = notaConverter.fromEntity(nota);
        return new WrapperResponse<List<NotaDto>>(response).createResponse();
    }

    @Override
    public ResponseEntity<WrapperResponse<List<NotaDto>>> ListarByEstudianteAndYear(Integer estudiante, Integer year) {
        List<Nota> nota = notaService.ListarByEstudianteAndYear(estudiante, year);
        List<NotaDto> response = notaConverter.fromEntity(nota);
        return new WrapperResponse<List<NotaDto>>(response).createResponse();
    }

    @Override
    public ResponseEntity<WrapperResponse<List<NotaDto>>> ListarByEstudianteAndBimestre(Integer estudiante, Integer bimestre) {
        List<Nota> nota = notaService.ListarByEstudianteAndBimestre(estudiante, bimestre);
        List<NotaDto> response = notaConverter.fromEntity(nota);
        return new WrapperResponse<List<NotaDto>>(response).createResponse();
    }

    @Override
    public ResponseEntity<WrapperResponse<List<NotaDto>>> ListarByEstudiante(Integer estudiante) {
        List<Nota> nota = notaService.ListarByEstudiante(estudiante);
        List<NotaDto> response = notaConverter.fromEntity(nota);
        return new WrapperResponse<List<NotaDto>>(response).createResponse();
    }

    @Override
    public ResponseEntity<WrapperResponse<NotaDto>> eliminarNotaCompetencia(Integer id) {
        Nota nota = notaService.eliminarNota(id);
        NotaDto response = notaConverter.fromEntity(nota);
        return new WrapperResponse<NotaDto>(response).createResponse();
    }
}
