package com.microservices.notas.Application.controllers;

import com.microservices.notas.Application.dto.NotaActitudinalDto;
import com.microservices.notas.Application.utils.WrapperResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface NotaActitudinalController {
    @PostMapping("")
    ResponseEntity<WrapperResponse<NotaActitudinalDto>> gaurdarNotaActitudinal(@RequestBody NotaActitudinalDto notaActitudinalDto);

    @PutMapping("")
    ResponseEntity<WrapperResponse<NotaActitudinalDto>> editarNotaActitudinal(@RequestBody NotaActitudinalDto notaActitudinalDto);

    @GetMapping("{id}")
    ResponseEntity<WrapperResponse<NotaActitudinalDto>> getById(@PathVariable("id") Integer id);

    @DeleteMapping("{id}")
    ResponseEntity<WrapperResponse<NotaActitudinalDto>> eliminarNotaActitudinal(@PathVariable("id") Integer id);

}
