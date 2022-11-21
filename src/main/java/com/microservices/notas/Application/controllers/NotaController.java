package com.microservices.notas.Application.controllers;

import com.microservices.notas.Application.dto.NotaDto;
import com.microservices.notas.Application.utils.WrapperResponse;

import com.microservices.notas.Domain.entities.NotaCompetencia;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface NotaController {
    @PostMapping("")
    ResponseEntity<WrapperResponse<NotaDto>> gaurdarNotaCompetencia(@RequestBody NotaDto notaDto);

    @PutMapping("")
    ResponseEntity<WrapperResponse<NotaDto>> editarNotaCompetencia(@RequestBody NotaDto notaDto);

    @GetMapping("{id}")
    ResponseEntity<WrapperResponse<NotaDto>> getById(@PathVariable("id") Integer id);

    @GetMapping("byCompetenciaAndBimestre/{cur}/{bim}")
    ResponseEntity<WrapperResponse<List<NotaDto>>> ListarByCusoAndBimestre(@PathVariable("cur") Integer curso, @PathVariable("bim") Integer bimestre);

    @GetMapping("byEstudianteAndYear/{id}/{year}")
    ResponseEntity<WrapperResponse<List<NotaDto>>> ListarByEstudianteAndYear(@PathVariable("id") Integer estudiante,@PathVariable("year") Integer year);

    @GetMapping("byEstudianteAndBimestre/{id}/{bim}")
    ResponseEntity<WrapperResponse<List<NotaDto>>> ListarByEstudianteAndBimestre(@PathVariable("id") Integer estudiante,@PathVariable("bim") Integer bimestre);

    @GetMapping("byEstudiante/{id}")
    ResponseEntity<WrapperResponse<List<NotaDto>>> ListarByEstudiante(@PathVariable("id") Integer estudiante);


    @DeleteMapping("{id}")
    ResponseEntity<WrapperResponse<NotaDto>> eliminarNotaCompetencia(@PathVariable("id") Integer id);




}
