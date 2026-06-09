package org.example.practtiendabasic.model;

import java.time.LocalDate;

public class Mascota {

    private String Pasaporte;
    private String Nombre;
    private Double Peso;
    private LocalDate FechaNacimiento;
    private String Propietario_dni;
    private int Tipo_idTipo;

    public Mascota(String pasaporte, String nombre, Double peso, LocalDate fechaNacimiento, String propietario_dni, int tipo_idTipo) {
        Pasaporte = pasaporte;
        Nombre = nombre;
        Peso = peso;
        FechaNacimiento = fechaNacimiento;
        Propietario_dni = propietario_dni;
        Tipo_idTipo = tipo_idTipo;
    }

    public Mascota(String nombre, Double peso, LocalDate fechaNacimiento, String propietario_dni, int tipo_idTipo) {
        Nombre = nombre;
        Peso = peso;
        FechaNacimiento = fechaNacimiento;
        Propietario_dni = propietario_dni;
        Tipo_idTipo = tipo_idTipo;
    }

    public String getPasaporte() {
        return Pasaporte;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Double getPeso() {
        return Peso;
    }

    public void setPeso(Double peso) {
        Peso = peso;
    }

    public LocalDate getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
    }

    public String getPropietario_dni() {
        return Propietario_dni;
    }

    public void setPropietario_dni(String propietario_dni) {
        Propietario_dni = propietario_dni;
    }

    public int getTipo_idTipo() {
        return Tipo_idTipo;
    }

    public void setTipo_idTipo(int tipo_idTipo) {
        Tipo_idTipo = tipo_idTipo;
    }

    @Override
    public String toString() {
        return "Mascota{" +
                "Pasaporte='" + Pasaporte + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", Peso=" + Peso +
                ", FechaNacimiento=" + FechaNacimiento +
                ", Propietario_dni='" + Propietario_dni + '\'' +
                ", Tipo_idTipo=" + Tipo_idTipo +
                '}';
    }
}
