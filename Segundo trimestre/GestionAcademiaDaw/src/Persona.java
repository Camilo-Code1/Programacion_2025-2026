import java.io.Serializable;

public abstract class Persona implements Serializable {

    private static final long serialVersionUID = -7248488895733474883L;

    private String id;
    private String nombre;
    private int edad;

    public Persona(String id, String nombre, int edad) {
        this.id = id;
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

    public abstract String getRol();

    @Override
    public String toString() {
        return "[ Persona:" +
                " | ID: " + id +
                " | Nombre: " + nombre  +
                " | Edad:" + edad +
                " | Rol: " + getRol();
    }
}
