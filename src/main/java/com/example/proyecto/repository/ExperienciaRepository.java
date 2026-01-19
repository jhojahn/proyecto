package com.example.proyecto.repository;

import com.example.proyecto.model.Experiencia;
import com.example.proyecto.model.Lenguaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienciaRepository extends JpaRepository<Experiencia, Long> {
}