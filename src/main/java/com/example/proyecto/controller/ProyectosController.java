package com.example.proyecto.controller;

import com.example.proyecto.model.Proyecto;
import com.example.proyecto.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyectos")
@CrossOrigin(origins = "*")
public class ProyectosController {

    @Autowired
    private ProyectoService proyectoService;

    @GetMapping
    public List<Proyecto> getProyectos() {
        return proyectoService.getAllProyecto();
    }

    @GetMapping("/{id}")
    public Proyecto getProyecto(@PathVariable Long id) {
        return proyectoService.getProyectoById(id);
    }

    @PostMapping
    public Proyecto addProyecto(@RequestBody Proyecto proyecto) {
        return proyectoService.createProyecto(proyecto);
    }

    @PutMapping("/{id}")
    public Proyecto updateProyecto(@PathVariable Long id,
                                   @RequestBody Proyecto proyecto) {
        return proyectoService.updateProyecto(id, proyecto);
    }

    @DeleteMapping("/{id}")
    public void deleteProyecto(@PathVariable Long id) {
        proyectoService.deleteProyecto(id);
    }
}
