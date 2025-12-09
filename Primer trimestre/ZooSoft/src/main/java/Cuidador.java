import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cuidador {

    private String dni;
    private String nombre;
    private LocalDate fechaContratacion;
    private TipoAnimal tipoAnimal;
    private boolean activo;

    private ArrayList <Animal> animalesACargo;

    public Cuidador(String dni, String nombre, LocalDate fechaContratacion, TipoAnimal tipoAnimal) {
        this.dni = dni;
        this.nombre = nombre;
        this.fechaContratacion = fechaContratacion;
        this.tipoAnimal = tipoAnimal;
        this.activo = true;

        this.animalesACargo = new ArrayList<>();
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public TipoAnimal getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(TipoAnimal tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }
    public boolean getActivo() {
        return activo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public List<Animal> getAnimalesACargo() { return animalesACargo; }


    @Override
    public String toString() {
        return "Cuidador{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fechaContratacion=" + fechaContratacion +
                ", tipoAnimal=" + tipoAnimal +
                ", activo=" + activo +
                ", animalesACargo=" + animalesACargo +
                '}';
    }

    public void mostrarCuidador() {
        System.out.println(this);
    }


}
