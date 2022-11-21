package com.microservices.notas.Application.controllers;

import com.microservices.notas.Application.dto.NotaActitudinalDto;
import com.microservices.notas.Application.utils.WrapperResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface NotaActitudinalController {
    @PostMapping("")
    ResponseEntity<WrapperResponse<NotaActitudinalDto>> gaurdarNotaActitudinal(@RequestBody NotaActitudinalDto notaActitudinalDto);

    @PutMapping("")
    ResponseEntity<WrapperResponse<NotaActitudinalDto>> editarNotaActitudinal(@RequestBody NotaActitudinalDto notaActitudinalDto);

    @GetMapping("{id}")
    ResponseEntity<WrapperResponse<NotaActitudinalDto>> getById(@PathVariable("id") Integer id);

    @GetMapping("byEstudiantes/{id}")
    ResponseEntity<WrapperResponse<List<NotaActitudinalDto>>> ListarByEstudiantes(@PathVariable("id") Integer estudiante);

    @GetMapping("byEstudiantesAndBimestres/{idE}/{idB}")
    ResponseEntity<WrapperResponse<List<NotaActitudinalDto>>> ListarByEstudiantesAndBimestre(@PathVariable("idE") Integer estudiante,@PathVariable("idB") Integer bimestre);

    @GetMapping("byEstudianteAndYear/{idE}/{idY}")
    ResponseEntity<WrapperResponse<List<NotaActitudinalDto>>> ListarByEstudianteAndYear(@PathVariable("idE") Integer estudiante,@PathVariable("idY") Integer year);

    @GetMapping("byBimestre/{bim}")
    ResponseEntity<WrapperResponse<List<NotaActitudinalDto>>> ListarByBimestre(@PathVariable("bim") Integer bimestre);

    @DeleteMapping("{id}")
    ResponseEntity<WrapperResponse<NotaActitudinalDto>> eliminarNotaActitudinal(@PathVariable("id") Integer id);

}
