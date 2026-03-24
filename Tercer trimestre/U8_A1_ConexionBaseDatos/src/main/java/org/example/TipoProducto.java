package org.example;

public class TipoProducto {

    private int id;
    private String nombre;

    public TipoProducto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }


    public TipoProducto(String nombre) {
        this.nombre = nombre;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }

    @Override
    public String toString() {
        return "\n[ TipoProducto ID: " + id + " Nombre: " + nombre + "]";
    }
}