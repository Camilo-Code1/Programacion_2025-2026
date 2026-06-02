package org.example.practtiendabasic.model;

public class categorias {

    private int id_categoria;
    private String nombre;

    public categorias(int id_categoria, String nombre){
        this.id_categoria = id_categoria;
        this.nombre = nombre;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "ID categoria:" + id_categoria +
                " Nombre:'" + nombre;
    }
}

