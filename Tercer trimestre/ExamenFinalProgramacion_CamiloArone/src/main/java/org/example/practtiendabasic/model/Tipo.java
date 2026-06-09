package org.example.practtiendabasic.model;

public class Tipo {

    private int idTipo;
    private String Tipo;

    public Tipo(int idTipo, String tipo) {
        this.idTipo = idTipo;
        Tipo = tipo;
    }

    public Tipo(String tipo) {
        Tipo = tipo;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    @Override
    public String toString() {
        return "Tipo{" +
                "idTipo=" + idTipo +
                ", Tipo='" + Tipo + '\'' +
                '}';
    }
}
