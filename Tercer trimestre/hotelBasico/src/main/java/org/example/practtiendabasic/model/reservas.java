package org.example.practtiendabasic.model;

import java.time.LocalDate;

public class reservas {

    private int id_reserve;
    private int id_huesped;
    private int id_habitacion;
    private LocalDate fecha_entrada;
    private LocalDate fecha_salida;
    private double monto_total;
    private EstadoDeReserva estado_reserva;

    public reservas(int id_reserve, int id_huesped, int id_habitacion, LocalDate fecha_entrada, LocalDate fecha_salida, double monto_total, EstadoDeReserva estado_reserva) {
        this.id_reserve = id_reserve;
        this.id_huesped = id_huesped;
        this.id_habitacion = id_habitacion;
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
        this.monto_total = monto_total;
        this.estado_reserva = estado_reserva;
    }

    public reservas(int id_huesped, int id_habitacion, LocalDate fecha_entrada, LocalDate fecha_salida, double monto_total, EstadoDeReserva estado_reserva) {
        this.id_huesped = id_huesped;
        this.id_habitacion = id_habitacion;
        this.fecha_entrada = fecha_entrada;
        this.fecha_salida = fecha_salida;
        this.monto_total = monto_total;
        this.estado_reserva = estado_reserva;
    }

    public int getId_reserve() {
        return id_reserve;
    }

    public int getId_huesped() {
        return id_huesped;
    }

    public void setId_huesped(int id_huesped) {
        this.id_huesped = id_huesped;
    }

    public int getId_habitacion() {
        return id_habitacion;
    }

    public void setId_habitacion(int id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public LocalDate getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(LocalDate fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public LocalDate getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(LocalDate fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public double getMonto_total() {
        return monto_total;
    }

    public void setMonto_total(double monto_total) {
        this.monto_total = monto_total;
    }

    public EstadoDeReserva getEstado_reserva() {
        return estado_reserva;
    }

    public void setEstado_reserva(EstadoDeReserva estado_reserva) {
        this.estado_reserva = estado_reserva;
    }

    @Override
    public String toString() {
        return "reservas{" +
                "id_reserve=" + id_reserve +
                ", id_huesped=" + id_huesped +
                ", id_habitacion=" + id_habitacion +
                ", fecha_entrada=" + fecha_entrada +
                ", fecha_salida=" + fecha_salida +
                ", monto_total=" + monto_total +
                ", estado_reserva=" + estado_reserva +
                '}';
    }
}
