import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Articulo {

    private String cod;
    private String titulo;
    private LocalDate fechaRegistro;
    private LocalDate FechaBaja;

    private static int incremental = 1;

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");


    public Articulo(String titulo, LocalDate fechaRegistro) {
        this.cod = String.format("P-%03d", incremental++);
        this.titulo = titulo;
        this.fechaRegistro = LocalDate.now();
        this.FechaBaja = null;
    }

    public String getCod() {
        return cod;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public LocalDate getFechaBaja() {
        return FechaBaja;
    }

    @Override
    public String toString() {
        return "Articulo: " +
                "Cod: " + cod +
                " Titulo: " + titulo +
                " Fecha de registro: " + fechaRegistro +
                " FechaBaja: " + FechaBaja;
    }
}
