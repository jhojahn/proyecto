package com.example.proyecto.controller;

import com.example.proyecto.model.Info;
import com.example.proyecto.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/info")
@CrossOrigin(origins = "*")
public class InfoController {

    @Autowired
    private InfoService infoService;

    @GetMapping("")
    public String infoForm(Model model) {
        model.addAttribute("info", new Info());
        model.addAttribute("infos", infoService.getAllInfo());
        return "admin/info-form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("info") Info info) {
        infoService.createInfo(info);
        return "redirect:/admin/info?ok";
    }


    @ResponseBody
    @GetMapping("/listar")
    public List<Info> getInfo() {
        return infoService.getAllInfo();
    }

    @ResponseBody
    @GetMapping("/{id}")
    public Info getInfoById(@PathVariable Long id) {
        return infoService.getInfoById(id);
    }

    @ResponseBody
    @PostMapping("")
    public Info addInfo(@RequestBody Info info) {
        return infoService.createInfo(info);
    }

    @ResponseBody
    @PutMapping("/{id}")
    public Info updateInfo(@PathVariable Long id, @RequestBody Info info) {
        return infoService.updateInfo(id, info);
    }


    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        infoService.deleteInfo(id);
        return "redirect:/admin/info?deleted";
    }
}
