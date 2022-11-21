package com.microservices.notas.Application.controllers.Implement;

import com.microservices.notas.Application.controllers.NotaCompetenciaController;
import com.microservices.notas.Application.converters.NotaCompetenciaConverter;
import com.microservices.notas.Application.dto.NotaCompetenciaDto;
import com.microservices.notas.Application.utils.WrapperResponse;
import com.microservices.notas.Domain.entities.NotaCompetencia;
import com.microservices.notas.Domain.services.NotaCompetenciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("notaCompetencia")
public class NotaCompetenciaControllerImp implements NotaCompetenciaController {


    private final NotaCompetenciaService notaCompetenciaService;
    private final NotaCompetenciaConverter notaCompetenciaConverter;

    public NotaCompetenciaControllerImp(NotaCompetenciaService notaCompetenciaService, NotaCompetenciaConverter notaCompetenciaConverter) {
        this.notaCompetenciaService = notaCompetenciaService;
        this.notaCompetenciaConverter = notaCompetenciaConverter;
    }

    @Override
    public ResponseEntity<WrapperResponse<NotaCompetenciaDto>> gaurdarNotaCompetencia(NotaCompetenciaDto notaCompetenciaDto) {
        NotaCompetencia notaCompetencia = notaCompetenciaConverter.fromDTO(notaCompetenciaDto);
        NotaCompetencia notaCompetenciaNew = notaCompetenciaService.guardarNotaCompetencia(notaCompetencia);
        NotaCompetenciaDto response = notaCompetenciaConverter.fromEntity(notaCompetenciaNew);
        return new WrapperResponse<NotaCompetenciaDto>(response).createResponse(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<WrapperResponse<NotaCompetenciaDto>> editarNotaCompetencia(NotaCompetenciaDto notaCompetenciaDto) {
        NotaCompetencia notaCompetencia = notaCompetenciaConverter.fromDTO(notaCompetenciaDto);
        NotaCompetencia notaCompetenciaEdit = notaCompetenciaService.editarNotaCompetencia(notaCompetencia);
        NotaCompetenciaDto response = notaCompetenciaConverter.fromEntity(notaCompetenciaEdit);
        return new WrapperResponse<NotaCompetenciaDto>(response).createResponse();
    }

    @Override
    public ResponseEntity<WrapperResponse<NotaCompetenciaDto>> getById(Integer id) {
        NotaCompetencia notaCompetencia = notaCompetenciaService.buscarPorId(id);
        NotaCompetenciaDto response = notaCompetenciaConverter.fromEntity(notaCompetencia);
        return new WrapperResponse<NotaCompetenciaDto>(response).createResponse();
    }

    @Override
    public ResponseEntity<WrapperResponse<NotaCompetenciaDto>> eliminarNotaCompetencia(Integer id) {
        NotaCompetencia notaCompetencia = notaCompetenciaService.eliminarNotaCompetencia(id);
        NotaCompetenciaDto response = notaCompetenciaConverter.fromEntity(notaCompetencia);
        return new WrapperResponse<NotaCompetenciaDto>(response).createResponse();
    }
}
