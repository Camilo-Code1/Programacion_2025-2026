package org.example.practtiendabasic.model;

public class Propietario {

    private String dni;
    private String Nombre;
    private String Apellido;
    private String Telefono;
    private String Direcion;
    private String Email;

    public Propietario(String dni, String nombre, String apellido, String telefono, String direcion, String email) {
        this.dni = dni;
        Nombre = nombre;
        Apellido = apellido;
        Telefono = telefono;
        Direcion = direcion;
        Email = email;
    }

    public Propietario(String nombre, String apellido, String telefono, String direcion, String email) {
        Nombre = nombre;
        Apellido = apellido;
        Telefono = telefono;
        Direcion = direcion;
        Email = email;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getDirecion() {
        return Direcion;
    }

    public void setDirecion(String direcion) {
        Direcion = direcion;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "Propietario{" +
                "dni='" + dni + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", Direccion='" + Direcion + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}
