package org.example.practtiendabasic.model;

import java.time.LocalDate;

public class pacientes {

    private int id_paciente;
    private String nombre_completo;
    private LocalDate fecha_nacimiento;
    private String historial_clinico;

    public pacientes(int id_paciente, String nombre_completo, LocalDate fecha_nacimiento, String historial_clinico) {
        this.id_paciente = id_paciente;
        this.nombre_completo = nombre_completo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.historial_clinico = historial_clinico;
    }

    public pacientes(String nombre_completo, LocalDate fecha_nacimiento, String historial_clinico) {
        this.nombre_completo = nombre_completo;
        this.fecha_nacimiento = fecha_nacimiento;
        this.historial_clinico = historial_clinico;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getHistorial_clinico() {
        return historial_clinico;
    }

    public void setHistorial_clinico(String historial_clinico) {
        this.historial_clinico = historial_clinico;
    }

    @Override
    public String toString() {
        return "pacientes{" +
                "id_paciente=" + id_paciente +
                ", nombre_completo='" + nombre_completo + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", historial_clinico='" + historial_clinico + '\'' +
                '}';
    }
}
