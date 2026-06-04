package org.example.practtiendabasic.model;

import java.sql.Time;
import java.time.LocalDate;

public class citas_medicas {

    private int id_cita;
    private int id_paciente;
    private int id_medico;
    private LocalDate fecha_cita;
    private Time hora_cita;
    private String motivo;
    private EstadoEnum estado;

    public citas_medicas(int id_cita, int id_paciente, int id_medico, LocalDate fecha_cita, Time hora_cita, String motivo, EstadoEnum estado) {
        this.id_cita = id_cita;
        this.id_paciente = id_paciente;
        this.id_medico = id_medico;
        this.fecha_cita = fecha_cita;
        this.hora_cita = hora_cita;
        this.motivo = motivo;
        this.estado = estado;
    }

    public citas_medicas(int id_paciente, int id_medico, LocalDate fecha_cita, Time hora_cita, String motivo, EstadoEnum estado) {
        this.id_paciente = id_paciente;
        this.id_medico = id_medico;
        this.fecha_cita = fecha_cita;
        this.hora_cita = hora_cita;
        this.motivo = motivo;
        this.estado = estado;
    }

    public int getId_cita() {
        return id_cita;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    public LocalDate getFecha_cita() {
        return fecha_cita;
    }

    public void setFecha_cita(LocalDate fecha_cita) {
        this.fecha_cita = fecha_cita;
    }

    public Time getHora_cita() {
        return hora_cita;
    }

    public void setHora_cita(Time hora_cita) {
        this.hora_cita = hora_cita;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public EstadoEnum getEstado() {
        return estado;
    }

    public void setEstado(EstadoEnum estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "citas_medicas{" +
                "id_cita=" + id_cita +
                ", id_paciente=" + id_paciente +
                ", id_medico=" + id_medico +
                ", fecha_cita=" + fecha_cita +
                ", hora_cita=" + hora_cita +
                ", motivo='" + motivo + '\'' +
                ", estado=" + estado +
                '}';
    }
}
