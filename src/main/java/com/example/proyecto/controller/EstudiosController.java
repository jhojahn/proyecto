package com.example.proyecto.controller;

import com.example.proyecto.model.Estudios;
import com.example.proyecto.service.EstudiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/estudios")
@CrossOrigin(origins = "*")
public class EstudiosController {

    @Autowired
    private EstudiosService estudiosService;

    // ✅ HTML (renderiza vista)
    @GetMapping("")
    public String estudiosForm(Model model) {
        model.addAttribute("estudio", new Estudios());
        return "admin/estudios-form";
    }

    // ✅ HTML (POST del formulario)
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("estudio") Estudios estudio){
        estudiosService.createEstudios(estudio);
        return "redirect:/admin/estudios?ok";
    }

    // ✅ JSON
    @ResponseBody
    @GetMapping("/listar")
    public List<Estudios> getEstudios() {
        return estudiosService.getAllEstudios();
    }

    // ✅ JSON
    @ResponseBody
    @GetMapping("/{id}")
    public Estudios getEstudio(@PathVariable Long id) {
        return estudiosService.getEstudiosById(id);
    }

    // ✅ JSON (crear por API)
    @ResponseBody
    @PostMapping("")
    public Estudios addEstudio(@RequestBody Estudios estudios) {
        return estudiosService.createEstudios(estudios);
    }

    // ✅ JSON
    @ResponseBody
    @PutMapping("/{id}")
    public Estudios updateEstudio(@PathVariable Long id, @RequestBody Estudios estudios) {
        return estudiosService.updateEstudios(id, estudios);
    }

    // ✅ JSON
    @ResponseBody
    @DeleteMapping("/{id}")
    public void deleteEstudio(@PathVariable Long id) {
        estudiosService.deleteEstudios(id);
    }
}
