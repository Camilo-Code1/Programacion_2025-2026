package org.example.practtiendabasic.model;

public class habitaciones {

    private int id_habitacion;
    private String numero_habitacion;
    private tipoHabitacion tipo;
    private double precio_noche;
    private estadoHab estado;

    public habitaciones(int id_habitacion, String numero_habitacion, tipoHabitacion tipo, double precio_noche, estadoHab estado) {
        this.id_habitacion = id_habitacion;
        this.numero_habitacion = numero_habitacion;
        this.tipo = tipo;
        this.precio_noche = precio_noche;
        this.estado = estado;
    }

    public habitaciones(String numero_habitacion, tipoHabitacion tipo, double precio_noche, estadoHab estado) {
        this.numero_habitacion = numero_habitacion;
        this.tipo = tipo;
        this.precio_noche = precio_noche;
        this.estado = estado;
    }

    public int getId_habitacion() {
        return id_habitacion;
    }

    public String getNumero_habitacion() {
        return numero_habitacion;
    }

    public tipoHabitacion getTipo() {
        return tipo;
    }

    public void setTipo(tipoHabitacion tipo) {
        this.tipo = tipo;
    }

    public double getPrecio_noche() {
        return precio_noche;
    }

    public void setPrecio_noche(double precio_noche) {
        this.precio_noche = precio_noche;
    }

    public estadoHab getEstado() {
        return estado;
    }

    public void setEstado(estadoHab estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "habitaciones{" +
                "id_habitacion=" + id_habitacion +
                ", numero_habitacion='" + numero_habitacion + '\'' +
                ", tipo=" + tipo +
                ", precio_noche=" + precio_noche +
                ", estado=" + estado +
                '}';
    }
}
