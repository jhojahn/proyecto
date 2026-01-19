package com.example.proyecto.service;

import com.example.proyecto.model.Proyecto;
import com.example.proyecto.repository.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectoService {
    @Autowired
    private ProyectoRepository proyectoRepository;

    public List<Proyecto> getAllProyecto() {
        return proyectoRepository.findAll();
    }

    public Proyecto getProyectoById(Long id) {
        return proyectoRepository.findById(id).orElse(null);
    }

    public Proyecto createProyecto(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    public Proyecto addProyecto(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }
    public Proyecto updateProyecto(Long id, Proyecto proyecto) {
        proyecto.setId(id);
        return proyectoRepository.save(proyecto);
    }
    public void deleteProyecto(Long id) {
        proyectoRepository.deleteById(id);
    }
}
