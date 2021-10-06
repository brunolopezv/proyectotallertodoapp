package com.proyectotaller.app.proyectotallertodoapp.model;

import java.sql.Date;
import java.util.List;

public class Card {
    private Long id;
    private String titulo;
    private String descripcion;
    private Date fecha;
    private List<User> responsables;
    private User propietario;
    
    public Card(Long id, String titulo, String descripcion, Date fecha, List<User> responsables, User propietario) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.responsables = responsables;
        this.propietario = propietario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

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

    public List<User> getResponsables() {
        return responsables;
    }

    public void setResponsables(List<User> responsables) {
        this.responsables = responsables;
    }

    public User getPropietario() {
        return propietario;
    }

    public void setPropietario(User propietario) {
        this.propietario = propietario;
    }

   
        
}
