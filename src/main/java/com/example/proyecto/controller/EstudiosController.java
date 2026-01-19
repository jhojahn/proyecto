package com.example.proyecto.controller;

import com.example.proyecto.model.Estudios;
import com.example.proyecto.service.EstudiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudios")
@CrossOrigin(origins = "*")
public class EstudiosController {

    @Autowired
    private EstudiosService estudiosService;

    @GetMapping
    public List<Estudios> getEstudios() {
        return estudiosService.getAllEstudios();
    }

    @GetMapping("/{id}")
    public Estudios getEstudio(@PathVariable Long id) {
        return estudiosService.getEstudiosById(id);
    }

    @PostMapping
    public Estudios addEstudio(@RequestBody Estudios estudios) {
        return estudiosService.createEstudios(estudios);
    }

    @PutMapping("/{id}")
    public Estudios updateEstudio(@PathVariable Long id,
                                  @RequestBody Estudios estudios) {
        return estudiosService.updateEstudios(id, estudios);
    }

    @DeleteMapping("/{id}")
    public void deleteEstudio(@PathVariable Long id) {
        estudiosService.deleteEstudios(id);
    }
}
