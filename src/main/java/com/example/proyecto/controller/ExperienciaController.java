package com.example.proyecto.controller;

import com.example.proyecto.model.Experiencia;
import com.example.proyecto.service.ExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/experiencia")
@CrossOrigin(origins = "*")
public class ExperienciaController {

    @Autowired
    private ExperienciaService experienciaService;

    @GetMapping("")
    public String experienciaForm(Model model) {
        model.addAttribute("experiencia", new Experiencia());
        model.addAttribute("experiencias", experienciaService.getAllExperiencia());
        return "admin/experiencia-form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("experiencia") Experiencia experiencia) {
        experienciaService.createExperiencia(experiencia);
        return "redirect:/admin/experiencias?ok";
    }


    @ResponseBody
    @GetMapping("/listar")
    public List<Experiencia> getExperiencias() {
        return experienciaService.getAllExperiencia();
    }


    @ResponseBody
    @GetMapping("/{id}")
    public Experiencia getExperiencia(@PathVariable Long id) {
        return experienciaService.getExperienciaById(id);
    }

    @ResponseBody
    @PostMapping("")
    public Experiencia addExperiencia(@RequestBody Experiencia experiencia) {
        return experienciaService.createExperiencia(experiencia);
    }

    @ResponseBody
    @PutMapping("/{id}")
    public Experiencia updateExperiencia(@PathVariable Long id, @RequestBody Experiencia experiencia) {
        return experienciaService.updateExperiencia(id, experiencia);
    }



    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        experienciaService.deleteExperiencia(id);
        return "redirect:/admin/experiencia?deleted";
    }
}
