package com.example.proyecto.service;

import com.example.proyecto.model.Estudios;
import com.example.proyecto.repository.EstudiosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class EstudiosService {
    @Autowired
    private EstudiosRepository estudiosRepository;

    public List<Estudios> getAllEstudios() {return estudiosRepository.findAll();}
    public Estudios getEstudiosById(Long id) {return estudiosRepository.findById(id).orElse(null);}
    public Estudios createEstudios(Estudios estudios) {
        return estudiosRepository.save(estudios);
    }

    public Estudios addEstudios(Estudios estudio) {
        return estudiosRepository.save(estudio);
    }
    public Estudios updateEstudios(Long id, Estudios estudios) {
        estudios.setId(id);
        return estudiosRepository.save(estudios);
    }
    public void deleteEstudios(Long id) {
        estudiosRepository.deleteById(id);
    }

}
