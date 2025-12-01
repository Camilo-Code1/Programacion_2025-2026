import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pelicula {

    private static int contadorPeliculas = 1;

    private String cod;
    private String titulo;
    private Genero genero;
    private String fechaRegistro;
    private String fechaBaja;
    private boolean isAlquilada;

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public Pelicula(String titulo, Genero genero) {
        this.cod = String.format("P-%03d", contadorPeliculas);
        contadorPeliculas++;

        this.titulo = titulo;
        this.genero = genero;
        this.fechaRegistro = LocalDateTime.now().format(dtf);
        this.fechaBaja = null;
        this.isAlquilada = false;
    }

    public String getCod() {
        return cod;
    }
    public void setCod(String cod) {
        this.cod = cod;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Genero getGenero() {
        return genero;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    public String getFechaRegistro() {
        return fechaRegistro;
    }
    public String getFechaBaja() {
        return fechaBaja;
    }
    public void setFechaBaja(String fechaBaja) {
        this.fechaBaja = fechaBaja;
    }
    public boolean isAlquilada() {
        return isAlquilada;
    }
    public void setAlquilada(boolean alquilada) {
        this.isAlquilada = alquilada;
    }

    public void mostrarInfoPelicula() {
        System.out.println("-----------------------------");
        System.out.println("Codigo: " + cod);
        System.out.println("Titulo: " + titulo);
        System.out.println("Genero: " + genero);
        System.out.println("Fecha registro: " + fechaRegistro);
        System.out.println("Fecha de baja: " + (fechaBaja == null ? "—" : fechaBaja));
        System.out.println("Alquilada: " + (isAlquilada ? "Sí" : "No"));
        System.out.println("-----------------------------");
    }



}
