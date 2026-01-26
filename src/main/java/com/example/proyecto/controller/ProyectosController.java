package com.example.proyecto.controller;



import com.example.proyecto.model.Proyecto;
import com.example.proyecto.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/proyectos")
@CrossOrigin(origins = "*")
public class ProyectosController {

    @Autowired
    private ProyectoService proyectoService;


    @GetMapping("")
    public String proyectoForm(Model model) {
        model.addAttribute("proyecto", new Proyecto());
        model.addAttribute("proyectos", proyectoService.getAllProyecto());
        return "admin/proyecto-form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("proyecto") Proyecto proyecto) {
        proyectoService.createProyecto(proyecto);
        return "redirect:/admin/proyectos?ok";
    }


    @ResponseBody
    @GetMapping("/listar")
    public List<Proyecto> getProyectos() {
        return proyectoService.getAllProyecto();
    }


    @ResponseBody
    @GetMapping("/{id}")
    public Proyecto getProyecto(@PathVariable Long id) {
        return proyectoService.getProyectoById(id);
    }


    @ResponseBody
    @PostMapping("")
    public Proyecto addProyecto(@RequestBody Proyecto proyecto) {
        return proyectoService.createProyecto(proyecto);
    }


    @ResponseBody
    @PutMapping("/{id}")
    public Proyecto updateProyecto(@PathVariable Long id, @RequestBody Proyecto proyecto) {
        return proyectoService.updateProyecto(id, proyecto);
    }



    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        proyectoService.deleteProyecto(id);
        return "redirect:/admin/proyectos?deleted";
    }
}
