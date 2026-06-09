package org.example.espinosa_de_los_monteros;

import java.io.Serializable;
import java.time.LocalDate;

public class Doctor extends Persona implements Serializable {

    private static final long serialVersionUID = 7187356594302461443L;

    private String numColegiado;
    private String fechaAlta;
    private int tipoConsultaId;

    public Doctor(String numColegiado, String nombre, String apellidos,
                  String telefono, String direccion, String email,
                  String fechaAlta, int tipoConsultaId) {
        super(nombre, apellidos, telefono, direccion, email); // llama al constructor de Persona
        this.numColegiado = numColegiado;
        this.fechaAlta = fechaAlta;
        this.tipoConsultaId = tipoConsultaId;
    }

    public String getNumColegiado() { return numColegiado; }
    public String getFechaAlta() { return fechaAlta; }
    public int getTipoConsultaId() { return tipoConsultaId; }

    @Override
    public String toString() {
        return nombre + " " + apellidos + " [" + numColegiado + "]";
    }
}
