import java.time.LocalDate;

public class Trabajador {

    private String nombre;
    private LocalDate fechaNacimieto;
    private String dni;
    private String direccion;
    private String numeroSS;

    private static int contadorTrabajadores = 0;

    public Trabajador(String nombre, LocalDate fechaNacimieto, String dni, String direccion, String numeroSS) {
        this.contadorTrabajadores = contadorTrabajadores++;
        this.nombre = nombre;
        this.fechaNacimieto = fechaNacimieto;
        this.dni = dni;
        this.direccion = direccion;
        this.numeroSS = numeroSS;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public LocalDate getFechaNacimieto() {
        return fechaNacimieto;
    }
    public void setFechaNacimieto(LocalDate fechaNacimieto) {
        this.fechaNacimieto = fechaNacimieto;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getNumeroSS() {
        return numeroSS;
    }
    public void setNumeroSS(String numeroSS) {
        this.numeroSS = numeroSS;
    }

    public void mostrarInfoTrabajadores() {
        System.out.println("-----------------------------");
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Fecha de nacimiento: " + this.fechaNacimieto);
        System.out.println("DNI: " + this.dni);
        System.out.println("Direccion: " + this.direccion);
        System.out.println("Numero SS: " + this.numeroSS);
        System.out.println("-----------------------------");
    }



}
