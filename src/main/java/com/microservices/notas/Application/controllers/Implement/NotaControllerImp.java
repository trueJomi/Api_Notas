package com.microservices.notas.Application.controllers.Implement;

import com.microservices.notas.Application.controllers.NotaController;
import com.microservices.notas.Application.dto.NotaDto;
import com.microservices.notas.Application.utils.WrapperResponse;
import com.microservices.notas.Domain.services.Implement.NotaServiceImp;
import com.microservices.notas.Domain.services.NotaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("nota")
public class NotaControllerImp implements NotaController {
    private NotaService notaService;


    @Override
    public ResponseEntity<WrapperResponse<NotaDto>> gaurdarNotaCompetencia(NotaDto notaDto) {
        return null;
    }

    @Override
    public ResponseEntity<WrapperResponse<NotaDto>> editarNotaCompetencia(NotaDto notaDto) {
        return null;
    }

    @Override
    public ResponseEntity<WrapperResponse<NotaDto>> getById(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<WrapperResponse<NotaDto>> eliminarNotaCompetencia(NotaDto notaDto) {
        return null;
    }
}
