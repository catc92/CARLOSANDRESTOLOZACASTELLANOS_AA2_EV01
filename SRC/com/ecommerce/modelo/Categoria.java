package com.ecommerce.modelo;

// CLASE: Estándar PascalCase
public class Categoria {
    
    // VARIABLES: Estándar camelCase
    private int idCategoria;
    private String nombre;
    private String descripcion;

    // CONSTRUCTOR VACÍO:
    public Categoria() {
    }

    // CONSTRUCTOR COMPLETO (opcional pero útil)
    public Categoria(int idCategoria, String nombre, String descripcion) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // METODOS GETTERS y SETTERS: Estándar camelCase
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}