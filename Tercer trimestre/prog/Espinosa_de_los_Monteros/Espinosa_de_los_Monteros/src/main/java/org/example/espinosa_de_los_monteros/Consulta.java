package org.example.espinosa_de_los_monteros;

import java.io.Serializable;

public class Consulta implements Serializable {

    private static final long serialVersionUID = 7094058709518453675L;

    private String observaciones;
    private String fecha;
    private int tipoConsultaId;
    private String pacienteDni;
    private String doctorNumColegiado;
    private int doctorTipoConsultaId;


    public Consulta(String observaciones, String fecha,
                    int tipoConsultaId, String pacienteDni,
                    String doctorNumColegiado, int doctorTipoConsultaId) {

        this.observaciones = observaciones;
        this.fecha = fecha;
        this.tipoConsultaId = tipoConsultaId;
        this.pacienteDni = pacienteDni;
        this.doctorNumColegiado = doctorNumColegiado;
        this.doctorTipoConsultaId = doctorTipoConsultaId;
    }

    // Getters
    public String getObservaciones() { return observaciones; }
    public String getFecha() { return fecha; }
    public int getTipoConsultaId() { return tipoConsultaId; }
    public String getPacienteDni() { return pacienteDni; }
    public String getDoctorNumColegiado() { return doctorNumColegiado; }
    public int getDoctorTipoConsultaId() { return doctorTipoConsultaId; }


    @Override
    public String toString() {
        return "Consulta #" +  " - " + fecha + " - Paciente: " + pacienteDni;
    }


}