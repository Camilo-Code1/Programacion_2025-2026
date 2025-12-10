import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Animal {

    private static int contadorAnimal = 1;

    private String idAnimal;

    private String nombreAnimal;
    private String especie;
    private TipoAnimal tipoAnimalAnim;
    private LocalDate fechaNacimiento;
    private LocalDate fechaIngreso;

    private boolean activo;

    private Cuidador cuidadorAsignado;

    private ArrayList<TicketIncidencia> incidencias;

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");


    public Animal(String nombreAnimal, String especie, TipoAnimal tipoAnimalAnim, LocalDate fechaNacimiento, LocalDate fechaIngreso, Cuidador cuidadorAsignado) {
        this.idAnimal = String.format("A-%03d", contadorAnimal);
        contadorAnimal++;

        this.nombreAnimal = nombreAnimal;
        this.especie = especie;
        this.tipoAnimalAnim = tipoAnimalAnim;
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

    public TipoAnimal getTipoAnimalAnim() {
        return tipoAnimalAnim;
    }

    public void setTipoAnimalAnim(TipoAnimal tipoAnimalAnim) {
        this.tipoAnimalAnim = tipoAnimalAnim;
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
        StringBuilder sb = new StringBuilder();

        sb.append("\n<---Animal--->")
                .append("\nIDAnimal: ").append(idAnimal)
                .append("\nNombre de animal: ").append(nombreAnimal)
                .append("\nEspecie: ").append(especie)
                .append("\nTipoAnimal: ").append(tipoAnimalAnim)
                .append("\nFecha de nacimiento: ").append(fechaNacimiento)
                .append("\nFecha de ingreso: ").append(fechaIngreso)
                .append("\nEstado: ").append(activo ? "Sí" : "No")
                .append("\nCuidador asignado: ").append(cuidadorAsignado.getNombre())
                .append("\nIncidencias: ");

        if (incidencias.isEmpty()) {
            sb.append("Ninguna");
        } else {
            for (TicketIncidencia t : incidencias) {
                sb.append("\n  - ").append(t.getDescripcion());
            }
        }

        sb.append("\n<-------------->");

        return sb.toString();
    }


    public void mostrarAnimal() {
        System.out.println(this);
    }
}
