package com.example.proyecto.controller;

import com.example.proyecto.repository.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final InfoRepository infoRepository;
    private final EstudiosRepository estudiosRepository;
    private final ExperienciaRepository experienciaRepository;
    private final LenguajeRepository lenguajeRepository;
    private final ProyectoRepository proyectoRepository;

    public HomeController(InfoRepository infoRepository,
                          EstudiosRepository estudiosRepository,
                          ExperienciaRepository experienciaRepository,
                          LenguajeRepository lenguajeRepository,
                          ProyectoRepository proyectoRepository) {

        this.infoRepository = infoRepository;
        this.estudiosRepository = estudiosRepository;
        this.experienciaRepository = experienciaRepository;
        this.lenguajeRepository = lenguajeRepository;
        this.proyectoRepository = proyectoRepository;
    }

    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("info", infoRepository.findAll());
        model.addAttribute("estudios", estudiosRepository.findAll());
        model.addAttribute("experiencias", experienciaRepository.findAll());
        model.addAttribute("lenguajes", lenguajeRepository.findAll());
        model.addAttribute("proyectos", proyectoRepository.findAll());

        return "index";
    }
}
