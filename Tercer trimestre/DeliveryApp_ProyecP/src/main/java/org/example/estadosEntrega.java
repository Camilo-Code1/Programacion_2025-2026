package org.example;

public class estadosEntrega {

    private int id;
    private String estado;

    public estadosEntrega(int id, String estado) {
        this.id = id;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "Estado de entrega: " +
                estado;
    }
}
