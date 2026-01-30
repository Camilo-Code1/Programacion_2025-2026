import java.time.LocalDate;

public class Persona {

    private String nombre;
    private String dni;
    private LocalDate fechaNacimiento;

    public Persona (String nombre, String dni, LocalDate fechaNacimiento){
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre() {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }


    @Override
    public String toString() {
        return "\n<>---Persona---<>" +
                "\nNombre: " + nombre +
                "\nDNI: " + dni  +
                "\nFecha de nacimiento: " + fechaNacimiento +
                "\n<><><><><><><><><><><><><><><>";
    }
}
