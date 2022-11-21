package com.microservices.notas.Application.controllers;


import com.microservices.notas.Application.dto.NotaCompetenciaDto;
import com.microservices.notas.Application.utils.WrapperResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface NotaCompetenciaController {
    @PostMapping("")
    ResponseEntity<WrapperResponse<NotaCompetenciaDto>> gaurdarNotaCompetencia(@RequestBody NotaCompetenciaDto notaCompetencia);

    @PutMapping("")
    ResponseEntity<WrapperResponse<NotaCompetenciaDto>> editarNotaCompetencia(@RequestBody NotaCompetenciaDto notaCompetencia);

    @GetMapping("{id}")
    ResponseEntity<WrapperResponse<NotaCompetenciaDto>> getById(@PathVariable("id") Integer id);

    @GetMapping("byCompetenciaAndBimestre/{comp}/{bim}")
    ResponseEntity<WrapperResponse<List<NotaCompetenciaDto>>> ListarbyCompetenciaAndBimestre(@PathVariable("comp") Integer competencia,@PathVariable("bim") Integer bimestre);

    @GetMapping("byEstudainteAndYear/{id}/{year}")
    ResponseEntity<WrapperResponse<List<NotaCompetenciaDto>>> ListarbyEstudianteAndYear(@PathVariable("id") Integer estudiante,@PathVariable("year") Integer year);

    @GetMapping("byEstudianteAndBimestre/{id}/{bim}")
    ResponseEntity<WrapperResponse<List<NotaCompetenciaDto>>> ListarbyEstudianteAndBimestre(@PathVariable("id") Integer estudiante,@PathVariable("bim") Integer bimestre);

    @GetMapping("byEstudiante/{id}")
    ResponseEntity<WrapperResponse<List<NotaCompetenciaDto>>> ListarbyEstudiante(@PathVariable("id") Integer estudiante);


    @DeleteMapping("{id}")
    ResponseEntity<WrapperResponse<NotaCompetenciaDto>> eliminarNotaCompetencia(@PathVariable("id") Integer id);

}
