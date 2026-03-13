import java.io.Serializable;
import java.time.LocalDate;

public abstract class Persona implements Serializable {

    private static final long serialVersionUID = 4620095091290394684L;

    private String nombre;
    private LocalDate fechaNacimiento;
    private String dni;
    private String direccion;

    public Persona (String nombre, LocalDate fechaNacimiento, String dni, String direccion){
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getDni() {
        return dni;
    }

    public String getDireccion() {
        return direccion;
    }

    @Override
    public String toString() {
        return "\n[ Persona" +
                "| Nombre: " + nombre  +
                "| Fecha de nacimiento: " + fechaNacimiento +
                "| DNI: " + dni  +
                "| Direccion: " + direccion  +
                ']';
    }
}
