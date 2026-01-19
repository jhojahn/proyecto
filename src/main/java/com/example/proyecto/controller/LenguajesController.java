package com.example.proyecto.controller;

import com.example.proyecto.model.Lenguaje;
import com.example.proyecto.service.LenguajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lenguajes")
@CrossOrigin(origins = "*")
public class LenguajesController {

    @Autowired
    private LenguajeService lenguajeService;

    @GetMapping
    public List<Lenguaje> getLenguajes() {
        return lenguajeService.getAllLenguaje();
    }

    @GetMapping("/{id}")
    public Lenguaje getLenguaje(@PathVariable Long id) {
        return lenguajeService.getLenguajeById(id);
    }

    @PostMapping
    public Lenguaje addLenguaje(@RequestBody Lenguaje lenguaje) {
        return lenguajeService.createLenguaje(lenguaje);
    }

    @PutMapping("/{id}")
    public Lenguaje updateLenguaje(@PathVariable Long id,
                                   @RequestBody Lenguaje lenguaje) {
        return lenguajeService.updateLenguaje(id, lenguaje);
    }

    @DeleteMapping("/{id}")
    public void deleteLenguaje(@PathVariable Long id) {
        lenguajeService.deleteLenguaje(id);
    }
}
