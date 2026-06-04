package org.example.practtiendabasic.model;

public class personal {

    private int id_personal;
    private String nombre;
    private String dni_empleado;
    private String telefono;
    private TipoPersonal tipo_personal;

    public personal(int id_personal, String nombre, String dni_empleado, String telefono, TipoPersonal tipo_personal) {
        this.id_personal = id_personal;
        this.nombre = nombre;
        this.dni_empleado = dni_empleado;
        this.telefono = telefono;
        this.tipo_personal = tipo_personal;
    }

    public personal(String nombre, String dni_empleado, String telefono, TipoPersonal tipo_personal) {
        this.nombre = nombre;
        this.dni_empleado = dni_empleado;
        this.telefono = telefono;
        this.tipo_personal = tipo_personal;
    }

    public int getId_personal() {
        return id_personal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni_empleado() {
        return dni_empleado;
    }

    public void setDni_empleado(String dni_empleado) {
        this.dni_empleado = dni_empleado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public TipoPersonal getTipo_personal() {
        return tipo_personal;
    }

    public void setTipo_personal(TipoPersonal tipo_personal) {
        this.tipo_personal = tipo_personal;
    }

    @Override
    public String toString() {
        return "personal{" +
                "id_personal=" + id_personal +
                ", nombre='" + nombre + '\'' +
                ", dni_empleado='" + dni_empleado + '\'' +
                ", telefono='" + telefono + '\'' +
                ", tipo_personal=" + tipo_personal +
                '}';
    }
}
