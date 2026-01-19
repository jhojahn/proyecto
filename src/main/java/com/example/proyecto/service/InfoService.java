package com.example.proyecto.service;

import com.example.proyecto.model.Info;
import com.example.proyecto.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoService {

    @Autowired
    private InfoRepository infoRepository;

    public List<Info> getAllInfo() {
        return infoRepository.findAll();
    }

    public Info getInfoById(Long id) {
        return infoRepository.findById(id).orElse(null);
    }

    public Info createInfo(Info info) {
        return infoRepository.save(info);
    }

    public Info updateInfo(Long id, Info info) {
        info.setId(id);
        return infoRepository.save(info);
    }

    public void deleteInfo(Long id) {
        infoRepository.deleteById(id);
    }
}