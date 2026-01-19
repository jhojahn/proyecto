package com.example.proyecto.service;

import com.example.proyecto.model.Estudios;
import com.example.proyecto.model.Experiencia;
import com.example.proyecto.repository.ExperienciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienciaService {
    @Autowired
    private ExperienciaRepository experienciaRepository;

    public List<Experiencia> getAllExperiencia() {return experienciaRepository.findAll();}
    public Experiencia getExperienciaById(Long id) {return experienciaRepository.findById(id).orElse(null);}
    public Experiencia createExperiencia(Experiencia experiencia) {
        return experienciaRepository.save(experiencia);
    }

    public Experiencia addExperiencia(Experiencia experiencia) {
        return experienciaRepository.save(experiencia);
    }
    public Experiencia updateExperiencia(Long id, Experiencia experiencia) {
        experiencia.setId(id);
        return experienciaRepository.save(experiencia);
    }
    public void deleteExperiencia(Long id) {
        experienciaRepository.deleteById(id);
    }



}
