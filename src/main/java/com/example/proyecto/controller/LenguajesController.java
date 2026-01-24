package com.example.proyecto.controller;

import com.example.proyecto.model.Lenguaje;
import com.example.proyecto.service.LenguajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/lenguajes")
@CrossOrigin(origins = "*")
public class LenguajesController {

    @Autowired
    private LenguajeService lenguajeService;

    @GetMapping("")
    public String lenguajeForm(Model model) {
        model.addAttribute("lenguaje", new Lenguaje());
        return "admin/lenguaje-form";
    }


    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("lenguaje") Lenguaje lenguaje) {
        lenguajeService.createLenguaje(lenguaje);
        return "redirect:/admin/lenguajes?ok";
    }


    @ResponseBody
    @GetMapping("/listar")
    public List<Lenguaje> getLenguajes() {
        return lenguajeService.getAllLenguaje();
    }

    @ResponseBody
    @GetMapping("/{id}")
    public Lenguaje getLenguaje(@PathVariable Long id) {
        return lenguajeService.getLenguajeById(id);
    }

    @ResponseBody
    @PostMapping("")
    public Lenguaje addLenguaje(@RequestBody Lenguaje lenguaje) {
        return lenguajeService.createLenguaje(lenguaje);
    }

    @ResponseBody
    @PutMapping("/{id}")
    public Lenguaje updateLenguaje(@PathVariable Long id, @RequestBody Lenguaje lenguaje) {
        return lenguajeService.updateLenguaje(id, lenguaje);
    }


    @ResponseBody
    @DeleteMapping("/{id}")
    public void deleteLenguaje(@PathVariable Long id) {
        lenguajeService.deleteLenguaje(id);
    }
}
