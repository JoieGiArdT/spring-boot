package com.prueba.spring_boot_service.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "PRUEBAESTUDIANTE")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 150, message = "El nombre no debe exceder los 150 caracteres")
    @Column(name = "Nombre", nullable = false, length = 150)
    private String nombre;

    @NotBlank(message = "La especialidad es obligatoria")
    @Size(max = 500, message = "La especialidad no debe exceder los 500 caracteres")
    @Column(name = "Especialidad", nullable = false, length = 500)
    private String especialidad;

    @NotBlank(message = "El grado es obligatorio")
    @Size(max = 2, message = "El grado debe tener máximo 2 caracteres")
    @Column(name = "Grado", nullable = false, length = 2)
    private String grado;
}
