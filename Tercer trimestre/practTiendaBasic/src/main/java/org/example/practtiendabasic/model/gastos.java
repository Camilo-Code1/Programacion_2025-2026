package org.example.practtiendabasic.model;

import java.time.LocalDate;

public class gastos {

    private int id_gasto;
    private String concepto;
    private double monto;
    private LocalDate fecha;
    private int id_proveedor;

    public gastos(int id_gasto, String concepto, double monto, LocalDate fecha, int id_proveedor) {
        this.id_gasto = id_gasto;
        this.concepto = concepto;
        this.monto = monto;
        this.fecha = fecha;
        this.id_proveedor = id_proveedor;
    }

    public gastos(String concepto, double monto, int id_proveedor) {
        this.concepto = concepto;
        this.monto = monto;
        this.id_proveedor = id_proveedor;
    }

    public gastos(int id_gasto, String concepto, double monto, int id_proveedor) {
        this.id_gasto = id_gasto;
        this.concepto = concepto;
        this.monto = monto;
        this.id_proveedor = id_proveedor;
    }

    public int getId_gasto() {
        return id_gasto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    @Override
    public String toString() {
        return "gastos{" +
                "id_gasto=" + id_gasto +
                ", concepto='" + concepto + '\'' +
                ", monto=" + monto +
                ", fecha=" + fecha +
                ", id_proveedor=" + id_proveedor +
                '}';
    }
}
