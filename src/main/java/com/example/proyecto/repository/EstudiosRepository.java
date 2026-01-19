package com.example.proyecto.repository;

import com.example.proyecto.model.Estudios;
import com.example.proyecto.model.Lenguaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudiosRepository extends JpaRepository<Estudios, Long> {
}