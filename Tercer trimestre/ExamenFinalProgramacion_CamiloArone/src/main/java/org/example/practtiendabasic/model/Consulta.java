package org.example.practtiendabasic.model;

import java.time.LocalDate;

public class Consulta {

    private int idConsulta;
    private LocalDate fecha;
    private int Duracion;
    private String Observaciones;
    private String Mascota_Pasaporte;
    private String Mascota_Propietario_dni;

    public Consulta(int idConsulta, LocalDate fecha, int duracion, String observaciones, String mascota_Pasaporte, String mascota_Propietario_dni) {
        this.idConsulta = idConsulta;
        this.fecha = fecha;
        Duracion = duracion;
        Observaciones = observaciones;
        Mascota_Pasaporte = mascota_Pasaporte;
        Mascota_Propietario_dni = mascota_Propietario_dni;
    }

    public Consulta(LocalDate fecha, int duracion, String observaciones, String mascota_Pasaporte, String mascota_Propietario_dni) {
        this.fecha = fecha;
        Duracion = duracion;
        Observaciones = observaciones;
        Mascota_Pasaporte = mascota_Pasaporte;
        Mascota_Propietario_dni = mascota_Propietario_dni;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getDuracion() {
        return Duracion;
    }

    public void setDuracion(int duracion) {
        Duracion = duracion;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String observaciones) {
        Observaciones = observaciones;
    }

    public String getMascota_Pasaporte() {
        return Mascota_Pasaporte;
    }

    public void setMascota_Pasaporte(String mascota_Pasaporte) {
        Mascota_Pasaporte = mascota_Pasaporte;
    }

    public String getMascota_Propietario_dni() {
        return Mascota_Propietario_dni;
    }

    public void setMascota_Propietario_dni(String mascota_Propietario_dni) {
        Mascota_Propietario_dni = mascota_Propietario_dni;
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "idConsulta=" + idConsulta +
                ", fecha=" + fecha +
                ", Duracion=" + Duracion +
                ", Observaciones='" + Observaciones + '\'' +
                ", Mascota_Pasaporte='" + Mascota_Pasaporte + '\'' +
                ", Mascota_Propietario_dni='" + Mascota_Propietario_dni + '\'' +
                '}';
    }
}
