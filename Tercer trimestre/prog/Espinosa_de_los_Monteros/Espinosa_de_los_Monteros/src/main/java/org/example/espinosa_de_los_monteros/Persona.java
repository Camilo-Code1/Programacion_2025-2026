package org.example.espinosa_de_los_monteros;

import java.io.Serializable;

public class Persona implements Serializable {

    private static final long serialVersionUID = -2642145632018018721L;

    protected String nombre;
    protected String apellidos;
    protected String telefono;
    protected String direccion;
    protected String email;

    public Persona(String nombre, String apellidos, String telefono,
                   String direccion, String email) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
    }

    // Getters y setters comunes
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

