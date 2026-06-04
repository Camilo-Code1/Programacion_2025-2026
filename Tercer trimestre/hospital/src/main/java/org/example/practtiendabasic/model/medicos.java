package org.example.practtiendabasic.model;

public class medicos extends personal {

    private String especialidad;
    private String licencia_medica;

    public medicos(int id_personal, String nombre, String dni_empleado, String telefono, TipoPersonal tipo_personal, String especialidad, String licencia_medica) {
        super(id_personal, nombre, dni_empleado, telefono, tipo_personal);
        this.especialidad = especialidad;
        this.licencia_medica = licencia_medica;
    }

    public medicos(String nombre, String dni_empleado, String telefono, TipoPersonal tipo_personal, String especialidad, String licencia_medica) {
        super(nombre, dni_empleado, telefono, tipo_personal);
        this.especialidad = especialidad;
        this.licencia_medica = licencia_medica;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getLicencia_medica() {
        return licencia_medica;
    }

    public void setLicencia_medica(String licencia_medica) {
        this.licencia_medica = licencia_medica;
    }

    @Override
    public String toString() {
        return "medicos{" +
                "especialidad='" + especialidad + '\'' +
                ", licencia_medica='" + licencia_medica + '\'' +
                '}';
    }
}
