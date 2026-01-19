package com.example.proyecto.controller;

import com.example.proyecto.model.Info;
import com.example.proyecto.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/info")
@CrossOrigin(origins = "*")
public class InfoController {

    @Autowired
    private InfoService infoService;

    @GetMapping
    public List<Info> getInfo() {
        return infoService.getAllInfo();
    }

    @GetMapping("/{id}")
    public Info getInfoById(@PathVariable Long id) {
        return infoService.getInfoById(id);
    }

    @PostMapping
    public Info addInfo(@RequestBody Info info) {
        return infoService.createInfo(info);
    }

    @PutMapping("/{id}")
    public Info updateInfo(@PathVariable Long id,
                           @RequestBody Info info) {
        return infoService.updateInfo(id, info);
    }

    @DeleteMapping("/{id}")
    public void deleteInfo(@PathVariable Long id) {
        infoService.deleteInfo(id);
    }
}
