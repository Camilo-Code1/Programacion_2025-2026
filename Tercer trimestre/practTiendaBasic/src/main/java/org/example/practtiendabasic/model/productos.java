package org.example.practtiendabasic.model;

import java.util.List;

public class productos {

    private int id_producto;
    private String nombre;
    private double precio;
    private int stock;
    private int categoriaSelec;
    private int  proveedorSelec;

    public productos(int id_producto, String nombre, double precio, int stock, int categoriaSelec, int proveedorSelec) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoriaSelec = categoriaSelec;
        this.proveedorSelec = proveedorSelec;
    }

    public productos(String nombre, double precio, int stock, int categoriaSelec, int proveedorSelec) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoriaSelec = categoriaSelec;
        this.proveedorSelec = proveedorSelec;
    }

    public int getId_producto() {
        return id_producto;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCategoriaSelec() {
        return categoriaSelec;
    }

    public void setCategoriaSelec(int categoriaSelec) {
        this.categoriaSelec = categoriaSelec;
    }

    public int getProveedorSelec() {
        return proveedorSelec;
    }

    public void setProveedorSelec(int proveedorSelec) {
        this.proveedorSelec = proveedorSelec;
    }

    @Override
    public String toString() {
        return "productos{" +
                "id_producto=" + id_producto +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                ", categoriaSelec=" + categoriaSelec +
                ", proveedorSelec=" + proveedorSelec +
                '}';
    }
}
