package org.example.practtiendabasic.model;

public class enfermeros extends personal{

    private String turno;
    private String area_asignada;

    public enfermeros(int id_personal, String nombre, String dni_empleado, String telefono, TipoPersonal tipo_personal, String turno, String area_asignada) {
        super(id_personal, nombre, dni_empleado, telefono, tipo_personal);
        this.turno = turno;
        this.area_asignada = area_asignada;
    }

    public enfermeros(String nombre, String dni_empleado, String telefono, TipoPersonal tipo_personal, String turno, String area_asignada) {
        super(nombre, dni_empleado, telefono, tipo_personal);
        this.turno = turno;
        this.area_asignada = area_asignada;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getArea_asignada() {
        return area_asignada;
    }

    public void setArea_asignada(String area_asignada) {
        this.area_asignada = area_asignada;
    }

    @Override
    public String toString() {
        return "enfermeros{" +
                "turno='" + turno + '\'' +
                ", area_asignada='" + area_asignada + '\'' +
                '}';
    }
}
