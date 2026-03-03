import java.io.Serializable;

public abstract class Persona implements Serializable {

    private static final long serialVersionUID = -2316243068985457681L;

    private String id;
    private String nombre;
    private int edad;

    private static int incremental = 1;

    public Persona(String nombre, int edad) {
        this.id = String.format("P-%03d", incremental++);
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public abstract String getTipo();

    @Override
    public String toString() {
        return "\n[ Persona: " +
                " ID: " + id  +
                " | Nombre: " + nombre +
                " | Edad:" + edad +
                " | Tipo: " + getTipo();
    }
}
