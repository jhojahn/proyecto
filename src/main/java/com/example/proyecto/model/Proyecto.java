package com.example.proyecto.model;


import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="Proyectos")
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private String github_url;
    private String image_url;
    private Date fecha;

    public Proyecto() {
    }

    public Proyecto(String descripcion, Date fecha, String github_url, Long id, String image_url, String nombre) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.github_url = github_url;
        this.id = id;
        this.image_url = image_url;
        this.nombre = nombre;
    }

    @ManyToMany
    @JoinTable(
            name = "proyecto_lenguaje",
            joinColumns = @JoinColumn(name = "proyecto_id",referencedColumnName = "id")
    )
    private List<Lenguaje> lenguajes;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getGithub_url() {
        return github_url;
    }

    public void setGithub_url(String github_url) {
        this.github_url = github_url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
