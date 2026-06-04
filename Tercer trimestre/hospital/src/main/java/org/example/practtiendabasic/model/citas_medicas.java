package org.example.practtiendabasic.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class citas_medicas {

    private int id_cita;
    private int id_paciente;
    private int id_medico;
    private LocalDate fecha_cita;
    private LocalTime hora_cita;
    private String motivo;
    private EstadoEnum estado;

    public citas_medicas(int id_cita, int id_paciente, int id_medico, LocalDate fecha_cita, LocalTime hora_cita, String motivo, EstadoEnum estado) {
        this.id_cita = id_cita;
        this.id_paciente = id_paciente;
        this.id_medico = id_medico;
        this.fecha_cita = fecha_cita;
        this.hora_cita = hora_cita;
        this.motivo = motivo;
        this.estado = estado;
    }

    public citas_medicas(int id_paciente, int id_medico, LocalDate fecha_cita, LocalTime hora_cita, String motivo) {
        this.id_paciente = id_paciente;
        this.id_medico = id_medico;
        this.fecha_cita = fecha_cita;
        this.hora_cita = hora_cita;
        this.motivo = motivo;
        this.estado = EstadoEnum.Pendiente;
    }

    // ==========================================
    // GETTERS Y SETTERS
    // ==========================================

    public int getId_cita() { return id_cita; }
    public void setId_cita(int id_cita) { this.id_cita = id_cita; }

    public int getId_paciente() { return id_paciente; }
    public void setId_paciente(int id_paciente) { this.id_paciente = id_paciente; }

    public int getId_medico() { return id_medico; }
    public void setId_medico(int id_medico) { this.id_medico = id_medico; }

    public LocalDate getFecha_cita() { return fecha_cita; }
    public void setFecha_cita(LocalDate fecha_cita) { this.fecha_cita = fecha_cita; }

    public LocalTime getHora_cita() { return hora_cita; }
    public void setHora_cita(LocalTime hora_cita) { this.hora_cita = hora_cita; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }

    public EstadoEnum getEstado() { return estado; }
    public void setEstado(EstadoEnum estado) { this.estado = estado; }

    @Override
    public String toString() {
        return "Cita Médica N° " + id_cita + " [Paciente ID: " + id_paciente + ", Médico ID: " + id_medico + "]";
    }
}