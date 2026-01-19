package com.example.proyecto.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Lenguajes")
public class Lenguaje {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nombre;
        private String icono_url;

    public Lenguaje() {}

    public Lenguaje(String icono_url, Long id, String nombre) {
        this.icono_url = icono_url;
        this.id = id;
        this.nombre = nombre;
    }

    @ManyToMany(mappedBy = "lenguajes")
    private List<Proyecto> proyectos;

    public String getIcono_url() {
        return icono_url;
    }

    public void setIcono_url(String icono_url) {
        this.icono_url = icono_url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
