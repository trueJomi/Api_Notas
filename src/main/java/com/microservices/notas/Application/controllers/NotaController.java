package com.microservices.notas.Application.controllers;

import com.microservices.notas.Application.dto.NotaDto;
import com.microservices.notas.Application.utils.WrapperResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface NotaController {
    @PostMapping("")
    ResponseEntity<WrapperResponse<NotaDto>> gaurdarNotaCompetencia(@RequestBody NotaDto notaDto);

    @PutMapping("")
    ResponseEntity<WrapperResponse<NotaDto>> editarNotaCompetencia(@RequestBody NotaDto notaDto);

    @GetMapping("{id}")
    ResponseEntity<WrapperResponse<NotaDto>> getById(@PathVariable("id") Integer id);

    @DeleteMapping("{id}")
    ResponseEntity<WrapperResponse<NotaDto>> eliminarNotaCompetencia(@PathVariable("id") Integer id);




}
