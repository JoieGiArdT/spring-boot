package com.prueba.spring_boot_service.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.prueba.spring_boot_service.service.EstudianteService;
import com.prueba.spring_boot_service.model.Estudiante;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @PostMapping
    public ResponseEntity<Estudiante> saveEstudiante(@Valid @RequestBody Estudiante estudiante) {
        Estudiante nuevoEstudiante = estudianteService.saveEstudiante(estudiante);
        return new ResponseEntity<>(nuevoEstudiante, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> updateEstudiante(@PathVariable Long id, @Valid @RequestBody Estudiante estudiante) {
        try {
            Estudiante actualizadoEstudiante = estudianteService.updateEstudiante(id, estudiante);
            return new ResponseEntity<>(actualizadoEstudiante, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteEstudiante(@PathVariable Long id) {
        try {
            estudianteService.deleteEstudiante(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> getEstudianteById(@PathVariable Long id) {
        try {
            Estudiante estudiante = estudianteService.findEstudianteById(id);
            return new ResponseEntity<>(estudiante, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Estudiante>> getAllEstudiantes() {
        List<Estudiante> estudiantes = estudianteService.findAllEstudiantes();
        return new ResponseEntity<>(estudiantes, HttpStatus.OK);
    }
}
