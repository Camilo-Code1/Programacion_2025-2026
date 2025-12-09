import java.time.LocalDate;
import java.util.ArrayList;

public class Animal {

    private static int contadorAnimal = 1;

    private String idAnimal;

    private String nombreAnimal;
    private String especie;
    private TipoAnimal tipoAnimal;
    private LocalDate fechaNacimiento;
    private LocalDate fechaIngreso;

    private boolean activo;

    private Cuidador cuidadorAsignado;

    private ArrayList<TicketIncidencia> incidencias;

    public Animal(String nombreAnimal, String especie, TipoAnimal tipoAnimal, LocalDate fechaNacimiento, LocalDate fechaIngreso, Cuidador cuidadorAsignado) {
        this.idAnimal = String.format("A-%03d", contadorAnimal);
        contadorAnimal++;

        this.nombreAnimal = nombreAnimal;
        this.especie = especie;
        this.tipoAnimal = tipoAnimal;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
        this.cuidadorAsignado = cuidadorAsignado;
        this.activo = true;

        this.incidencias = new ArrayList<>();
    }

    public String getIdAnimal() {
        return idAnimal;
    }

    public String getNombreAnimal() {
        return nombreAnimal;
    }

    public void setNombreAnimal(String nombreAnimal) {
        this.nombreAnimal = nombreAnimal;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public TipoAnimal getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(TipoAnimal tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public boolean isActivo() {
        return activo;
    }

    public void darDeBaja() { activo = false; }
    public void reactivar() { activo = true; }


    public Cuidador getCuidadorAsignado() {
        return cuidadorAsignado;
    }

    public void setCuidadorAsignado(Cuidador cuidadorAsignado) {
        this.cuidadorAsignado = cuidadorAsignado;
    }

    public void agregarIncidencia(TicketIncidencia t) {
        incidencias.add(t);
    }


    @Override
    public String toString() {
        return "Animal{" +
                "idAnimal='" + idAnimal + '\'' +
                ", nombreAnimal='" + nombreAnimal + '\'' +
                ", especie='" + especie + '\'' +
                ", tipoAnimal=" + tipoAnimal +
                ", fechaNacimiento=" + fechaNacimiento +
                ", fechaIngreso=" + fechaIngreso +
                ", activo=" + activo +
                ", cuidadorAsignado=" + cuidadorAsignado +
                ", incidencias=" + incidencias +
                '}';
    }

    public void mostrarAnimal() {
        System.out.println(this);
    }
}
