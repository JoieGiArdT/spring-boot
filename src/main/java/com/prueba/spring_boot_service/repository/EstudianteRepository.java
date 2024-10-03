package com.prueba.spring_boot_service.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.prueba.spring_boot_service.model.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long>{

}
