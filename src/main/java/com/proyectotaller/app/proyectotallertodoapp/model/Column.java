package com.proyectotaller.app.proyectotallertodoapp.model;

public class Column {
    private Long id;
    private String titulo;
    private Integer orden;
    
    public Column(Long id, String titulo, Integer orden) {
        this.id = id;
        this.titulo = titulo;
        this.orden = orden;
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
    public Integer getOrden() {
        return orden;
    }
    public void setOrden(Integer orden) {
        this.orden = orden;
    }

}
