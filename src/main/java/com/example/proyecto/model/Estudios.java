package com.example.proyecto.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Entity
@Table(name="Estudios")
public class Estudios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descripcion;
    private String institucion;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_inicio;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_fin;

    public Estudios() {
    }

    public Estudios(String descripcion, Date fecha_fin, Date fecha_inicio, Long id, String institucion, String titulo) {
        this.descripcion = descripcion;
        this.fecha_fin = fecha_fin;
        this.fecha_inicio = fecha_inicio;
        this.id = id;
        this.institucion = institucion;
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
