import java.io.Serializable;
import java.time.LocalDate;

public class Libro implements Serializable {

    private static final long serialVersionUID = -3254969815367249452L;

    private String ISBN;
    private String titulo;
    private String autor;
    private LocalDate fechaPublicacion;

    public Libro(String ISBN, String titulo, String autor, LocalDate fechaPublicacion) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    @Override
    public String toString() {
        return "\n<---Libro--->" +
                "\nISBN: " + ISBN  +
                "\nTitulo:" + titulo  +
                "\nAutor='" + autor +
                "\nFecha de Publicacion: " + fechaPublicacion +
                "\n<------------>";
    }
}
