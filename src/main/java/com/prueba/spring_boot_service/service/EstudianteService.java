package com.prueba.spring_boot_service.service;

import com.prueba.spring_boot_service.model.Estudiante;

import java.util.List;
import java.util.Optional;

public interface EstudianteService {
    
    Estudiante saveEstudiante(Estudiante estudiante);
    
    void deleteEstudiante(Long estudianteId);
    
    List<Estudiante> findAllEstudiantes();
    
    Estudiante findEstudianteById(Long estudianteId);
    
    Estudiante updateEstudiante(Long estudianteId, Estudiante estudianteDetails);
}
