package com.proyectotaller.app.proyectotallertodoapp.model;

public class Board {
    private String titulo;
    private User propietario;
    private Long id;
    
    public Board(Long id,String titulo, User propietario) {
        this.titulo = titulo;
        this.propietario = propietario;
        this.id = id;
    }
    
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public User getPropietario() {
        return propietario;
    }
    public void setPropietario(User propietario) {
        this.propietario = propietario;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
