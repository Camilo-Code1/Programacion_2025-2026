import java.util.ArrayList;
import java.util.List;

public class Huesped extends Persona{

    private String nacionalidad;
    private List<String> preferencias;
    private int numeroHabitacion;
    private boolean hospedado;
    private int puntosClub;


    public Huesped(String id, String nombre, int edad, String telefono
            , String nacionalidad) {
        super(id, nombre, edad, telefono);
        this.nacionalidad = nacionalidad;
        this.preferencias = new ArrayList<>();
        this.hospedado = false;
        this.numeroHabitacion = 0;
        this.puntosClub = 0;

    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public List<String> getPreferencias() {
        return preferencias;
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public boolean isHospedado() {
        return hospedado;
    }

    public int getPuntosClub() {
        return puntosClub;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public void setHospedado(boolean hospedado) {
        this.hospedado = hospedado;
    }

    public void registrarPreferencias(String pref) {
        this.preferencias.add(pref);
    }

    @Override
    public String getTipo(){
        return (puntosClub > 500) ? "Huesped VIP" : "Huesped estandar";
    }

    @Override
    public String toString() {
        return super.toString() +
                " | Nacionalidad: " + nacionalidad +
                " | Preferencias: " + preferencias +
                " | Numero de habitacion: " + (numeroHabitacion) +
                " | Hospedado: " + hospedado +
                " | PuntosClub:" + puntosClub +
                " ]";
    }
}
