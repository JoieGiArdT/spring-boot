package com.prueba.spring_boot_service.service;

import com.prueba.spring_boot_service.model.Estudiante;
import com.prueba.spring_boot_service.repository.EstudianteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;

@Service
@Transactional
public class EstudianteServiceImpl implements EstudianteService {

    private final EstudianteRepository estudianteRepository;

    public EstudianteServiceImpl(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    @Override
    public Estudiante saveEstudiante(@Valid Estudiante estudiante) {
        // Valida que el estudiante no sea nulo y que cumpla con las restricciones
        return estudianteRepository.save(estudiante);
    }

    @Override
    public Estudiante updateEstudiante(Long estudianteId, @Valid Estudiante estudiante) {
        Estudiante existingEstudiante = estudianteRepository.findById(estudianteId)
            .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con id: " + estudianteId));

        // Actualiza solo los campos necesarios
        existingEstudiante.setNombre(estudiante.getNombre());
        existingEstudiante.setEspecialidad(estudiante.getEspecialidad());
        existingEstudiante.setGrado(estudiante.getGrado());

        return estudianteRepository.save(existingEstudiante);  // Guarda cambios
    }

    @Override
    public void deleteEstudiante(Long estudianteId) {
        if (!estudianteRepository.existsById(estudianteId)) {
            throw new RuntimeException("No se puede eliminar. Estudiante con ID " + estudianteId + " no encontrado.");
        }
        estudianteRepository.deleteById(estudianteId);
    }

    @Override
    public Estudiante findEstudianteById(Long estudianteId) {
        return estudianteRepository.findById(estudianteId)
            .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con id: " + estudianteId));
    }

    @Override
    public List<Estudiante> findAllEstudiantes() {
        return estudianteRepository.findAll();
    }
}
