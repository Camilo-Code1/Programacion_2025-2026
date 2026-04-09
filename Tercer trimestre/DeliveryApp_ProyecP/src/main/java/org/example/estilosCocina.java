package org.example;

public class estilosCocina {

    private int id;
    private String nombre;

    public estilosCocina(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public estilosCocina(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
