import java.io.Serializable;

public abstract class Persona implements Serializable {

    private static final long serialVersionUID = -2316243068985457681L;

    private String id;
    private String nombre;
    private int edad;
    private String telefono;

    public Persona(String id, String nombre, int edad, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
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

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public abstract String getTipo();

    @Override
    public String toString() {
        return "[ PERSONA" +
                " | ID:" + id  +
                " | Nombre: " + nombre  +
                " | Edad: " + edad +
                " | Telefono: " + telefono +
                " | Tipo: " + getTipo();
    }
}
