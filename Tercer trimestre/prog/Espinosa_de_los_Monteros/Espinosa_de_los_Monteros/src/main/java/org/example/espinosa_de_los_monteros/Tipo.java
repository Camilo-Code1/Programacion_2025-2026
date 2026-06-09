package org.example.espinosa_de_los_monteros;


import java.io.Serializable;

public class Tipo implements Serializable {

    private static final long serialVersionUID = 7692602257165602115L;

    private int id;
    private String tipo;


    public Tipo(int id ,String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }


    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return tipo;
    }
}