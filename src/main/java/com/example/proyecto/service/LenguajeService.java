package com.example.proyecto.service;

import com.example.proyecto.model.Lenguaje;
import com.example.proyecto.repository.LenguajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class LenguajeService {

    @Autowired
    private LenguajeRepository lenguajeRepository;

    public List<Lenguaje> getAllLenguaje() {
        return lenguajeRepository.findAll();
    }

    public Lenguaje getLenguajeById(Long id) {
        return lenguajeRepository.findById(id).orElse(null);
    }

    public Lenguaje createLenguaje(Lenguaje lenguaje) {
        return lenguajeRepository.save(lenguaje);
    }

    public Lenguaje updateLenguaje(Long id, Lenguaje lenguaje) {
        lenguaje.setId(id);
        return lenguajeRepository.save(lenguaje);
    }

    public void deleteLenguaje(Long id) {
        lenguajeRepository.deleteById(id);
    }
}
