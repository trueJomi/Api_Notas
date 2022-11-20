package com.microservices.notas.Application.controllers;


import com.microservices.notas.Application.dto.NotaCompetenciaDto;
import com.microservices.notas.Application.utils.WrapperResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface NotaCompetenciaController {
    @PostMapping("")
    ResponseEntity<WrapperResponse<NotaCompetenciaDto>> gaurdarNotaCompetencia(@RequestBody NotaCompetenciaDto notaCompetencia);

    @PutMapping("")
    ResponseEntity<WrapperResponse<NotaCompetenciaDto>> editarNotaCompetencia(@RequestBody NotaCompetenciaDto notaCompetencia);

    @GetMapping("{id}")
    ResponseEntity<WrapperResponse<NotaCompetenciaDto>> getById(@PathVariable("id") Integer id);

    @DeleteMapping("{id}")
    ResponseEntity<WrapperResponse<NotaCompetenciaDto>> eliminarNotaCompetencia(@PathVariable("id") Integer id);

}
