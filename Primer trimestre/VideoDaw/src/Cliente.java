import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cliente {

    private String dni;
    private String nombre;
    private String numSocio; // S-0001
    private String direccion;
    private String fechaNacimiento;
    private String fechaBaja;
    private int peliculasAlquiladas;

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public Cliente(String dni, String nombre, String numSocio, String direccion, String fechaNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.numSocio = numSocio;
        this.direccion = direccion;
        this.fechaNacimiento = LocalDateTime.now().format(dtf);
        this.fechaBaja = fechaBaja;
        this.peliculasAlquiladas = 0;

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
    public String getNumSocio() {
        return numSocio;
    }
    public void setNumSocio(String numSocio) {
        this.numSocio = numSocio;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getFechaBaja() {
        return fechaBaja;
    }


    public void mostrarInfoCliente() {
        System.out.println("-----------------------------");
        System.out.println("DNI: " + dni);
        System.out.println("Nombre: " + nombre);
        System.out.println("Numero de socio: " + numSocio);
        System.out.println("Dirección: " + direccion);
        System.out.println("Fecha de nacimiento: " + fechaNacimiento);
        System.out.println("Fecha de baja: " + fechaBaja);
        System.out.println("Peliculas alquidas: " + peliculasAlquiladas);
        System.out.println("-----------------------------");
    };

}
