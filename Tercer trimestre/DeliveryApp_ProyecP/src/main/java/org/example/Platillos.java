package org.example;

public class Platillos {

    private int id;
    private String nombre;
    private double precio;
    private estilosCocina id_estilo;

    public Platillos(int id, String nombre, double precio, estilosCocina id_estilo) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.id_estilo = id_estilo;
    }
    public Platillos(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Platillos(String nombre, double precio, estilosCocina id_estilo) {
        this.nombre = nombre;
        this.precio = precio;
        this.id_estilo = id_estilo;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public estilosCocina getId_estilo() {
        return id_estilo;
    }

    public void setId_estilo(estilosCocina id_estilo) {
        this.id_estilo = id_estilo;
    }

    @Override
    public String toString() {
        return "\nPlatillos:" +
                " ID: " + id +
                " | Nombre: " + nombre +
                " | Precio: " + precio +
                " | Estilo: " + id_estilo +
                '}';
    }
}
