package com.microservices.notas.Application.controllers.Implement;

import com.microservices.notas.Application.controllers.NotaActitudinalController;
import com.microservices.notas.Application.converters.NotaActitudinalConverter;
import com.microservices.notas.Application.dto.NotaActitudinalDto;
import com.microservices.notas.Application.utils.WrapperResponse;
import com.microservices.notas.Domain.entities.NotaActitudinal;
import com.microservices.notas.Domain.services.NotaActitudinalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("notaActitudinal")
public class NotaActitudinalControllerImp implements NotaActitudinalController {
    private final NotaActitudinalService notaActitudinalService;

    private final NotaActitudinalConverter notaActitudinalConverter;

    public NotaActitudinalControllerImp(NotaActitudinalService notaActitudinalService, NotaActitudinalConverter notaActitudinalConverter) {
        this.notaActitudinalService = notaActitudinalService;
        this.notaActitudinalConverter = notaActitudinalConverter;
    }

    @Override
    public ResponseEntity<WrapperResponse<NotaActitudinalDto>> gaurdarNotaActitudinal(NotaActitudinalDto notaActitudinalDto) {
        NotaActitudinal notaActitudinal = notaActitudinalConverter.fromDTO(notaActitudinalDto);
        NotaActitudinal notaActitudinalNew = notaActitudinalService.guardarNotaActitudinal(notaActitudinal);
        NotaActitudinalDto response = notaActitudinalConverter.fromEntity(notaActitudinalNew);
        return new WrapperResponse<NotaActitudinalDto>(response).createResponse(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<WrapperResponse<NotaActitudinalDto>> editarNotaActitudinal(NotaActitudinalDto notaActitudinalDto) {
        NotaActitudinal notaActitudinal = notaActitudinalConverter.fromDTO(notaActitudinalDto);
        NotaActitudinal notaActitudinalNew = notaActitudinalService.editarNotaActitudinal(notaActitudinal);
        NotaActitudinalDto response = notaActitudinalConverter.fromEntity(notaActitudinalNew);
        return new WrapperResponse<NotaActitudinalDto>(response).createResponse();
    }

    @Override
    public ResponseEntity<WrapperResponse<NotaActitudinalDto>> getById(Integer id) {
        NotaActitudinal notaActitudinal = notaActitudinalService.buscarPorId(id);
        NotaActitudinalDto response = notaActitudinalConverter.fromEntity(notaActitudinal);
        return new WrapperResponse<NotaActitudinalDto>(response).createResponse();
    }

    @Override
    public ResponseEntity<WrapperResponse<NotaActitudinalDto>> eliminarNotaActitudinal(Integer id) {
        NotaActitudinal notaActitudinal = notaActitudinalService.eliminarNotaActitudinal(id);
        NotaActitudinalDto response = notaActitudinalConverter.fromEntity(notaActitudinal);
        return new WrapperResponse<NotaActitudinalDto>(response).createResponse();
    }
}
