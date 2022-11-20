package com.microservices.notas.Application.controllers.Implement;

import com.microservices.notas.Application.controllers.NotaCompetenciaController;
import com.microservices.notas.Application.dto.NotaCompetenciaDto;
import com.microservices.notas.Application.utils.WrapperResponse;
import com.microservices.notas.Domain.services.NotaCompetenciaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("notaCompetencia")
public class NotaCompetenciaControllerImp implements NotaCompetenciaController {


    private NotaCompetenciaService notaCompetenciaService;

    @Override
    public ResponseEntity<WrapperResponse<NotaCompetenciaDto>> gaurdarNotaCompetencia(NotaCompetenciaDto notaCompetencia) {
        return null;
    }

    @Override
    public ResponseEntity<WrapperResponse<NotaCompetenciaDto>> editarNotaCompetencia(NotaCompetenciaDto notaCompetencia) {
        return null;
    }

    @Override
    public ResponseEntity<WrapperResponse<NotaCompetenciaDto>> getById(Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<WrapperResponse<NotaCompetenciaDto>> eliminarNotaCompetencia(Integer id) {
        return null;
    }
}
