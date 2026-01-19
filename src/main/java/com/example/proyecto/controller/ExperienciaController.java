package com.example.proyecto.controller;

import com.example.proyecto.model.Experiencia;
import com.example.proyecto.service.ExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experiencias")
@CrossOrigin(origins = "*")
public class ExperienciaController {

    @Autowired
    private ExperienciaService experienciaService;

    @GetMapping
    public List<Experiencia> getExperiencias() {
        return experienciaService.getAllExperiencia();
    }

    @GetMapping("/{id}")
    public Experiencia getExperiencia(@PathVariable Long id) {
        return experienciaService.getExperienciaById(id);
    }

    @PostMapping
    public Experiencia addExperiencia(@RequestBody Experiencia experiencia) {
        return experienciaService.createExperiencia(experiencia);
    }

    @PutMapping("/{id}")
    public Experiencia updateExperiencia(@PathVariable Long id,
                                         @RequestBody Experiencia experiencia) {
        return experienciaService.updateExperiencia(id, experiencia);
    }

    @DeleteMapping("/{id}")
    public void deleteExperiencia(@PathVariable Long id) {
        experienciaService.deleteExperiencia(id);
    }
}
