package org.example.practtiendabasic.model;

public class huespedes {

    private int id_huesped;
    private String nombre_completo;
    private String documento_identidad;
    private String telefono;

    public huespedes(int id_huesped, String nombre_completo, String documento_identidad, String telefono) {
        this.id_huesped = id_huesped;
        this.nombre_completo = nombre_completo;
        this.documento_identidad = documento_identidad;
        this.telefono = telefono;
    }

    public huespedes(String nombre_completo, String documento_identidad, String telefono) {
        this.nombre_completo = nombre_completo;
        this.documento_identidad = documento_identidad;
        this.telefono = telefono;
    }

    public int getId_huesped() {
        return id_huesped;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public void setDocumento_identidad(String documento_identidad) {
        this.documento_identidad = documento_identidad;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "huespedes{" +
                "id_huesped=" + id_huesped +
                ", nombre_completo='" + nombre_completo + '\'' +
                ", documento_identidad='" + documento_identidad + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
