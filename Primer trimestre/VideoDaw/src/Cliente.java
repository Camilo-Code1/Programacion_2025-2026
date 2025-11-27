import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cliente {

    private String dni;
    private String nombre;
    private String numSocio; // S-0001
    private String direccion;
    private LocalDate fechaNacimiento;
    private String fechaBaja;
    private int peliculasAlquiladas;

    private static int numSociosReg = 1;


    public Cliente(String dni, String nombre, String direccion, LocalDate fechaNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.numSocio = String.format("S-%03d", numSociosReg);
        numSociosReg++;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaBaja = null;
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
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getFechaBaja() {
        return fechaBaja;
    }
    public void setFechaBaja(String fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public void mostrarInfoCliente() {
        System.out.println("-----------------------------");
        System.out.println("DNI: " + dni);
        System.out.println("Nombre: " + nombre);
        System.out.println("Numero de socio: " + numSocio);
        System.out.println("Dirección: " + direccion);
        System.out.println("Fecha de nacimiento: " + fechaNacimiento);
        System.out.println("Fecha de baja: " + (fechaBaja == null ? "—" : fechaBaja));
        System.out.println("Peliculas alquidas: " + peliculasAlquiladas);
        System.out.println("-----------------------------");
    };

}
