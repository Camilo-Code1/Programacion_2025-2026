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

    public void actualizarAnimalesACargo(List<Animal> listaAnimales) {
        animalesACargo.clear();
        for (Animal a : listaAnimales) {
            if (a.getCuidadorAsignado() == this) {
                animalesACargo.add(a);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n<---Cuidador--->")
                .append("\nDNI: ").append(dni)
                .append("\nNombre: ").append(nombre)
                .append("\nFecha de contratacion: ").append(fechaContratacion)
                .append("\nTipo de Animal: ").append(tipoAnimal)
                .append("\nEstado: ").append(activo ? "Sí" : "No")
                .append("\nAnimales a cargo: ");

        if (animalesACargo.isEmpty()) {
            sb.append("Ninguno");
        } else {
            for (Animal a : animalesACargo) {
                sb.append("\n  - ").append(a.getNombreAnimal());
            }
        }

        sb.append("\n<-------------->");

        return sb.toString();
    }

    public void mostrarCuidador() {
        System.out.println(this);
    }



}
