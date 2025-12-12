import java.time.LocalDate;

public class Libro {

    private String tituloLibro;
    private String autorLibro;
    private String isbn; // 13 digitos
    private LocalDate fechaPublicacion;
    private Genero genero;
    private TipoLibro tipo;

    public Libro(String tituloLibro, String autorLibro, String isbn, LocalDate fechaPublicacion, Genero genero, TipoLibro tipo) {
        this.tituloLibro = tituloLibro;
        this.autorLibro = autorLibro;
        this.isbn = isbn;
        this.fechaPublicacion = fechaPublicacion;
        this.genero = genero;
        this.tipo = tipo;
    }

    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public String getAutorLibro() {
        return autorLibro;
    }

    public void setAutorLibro(String autorLibro) {
        this.autorLibro = autorLibro;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    public TipoLibro getTipo() {
        return tipo;
    }

    public void setTipo(TipoLibro tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n<---Libro--->")
                .append("\nTitulo: ").append(tituloLibro)
                .append("\nAutor: ").append(autorLibro)
                .append("\nISBN: ").append(isbn)
                .append("\nFecha Publicacion: ").append(fechaPublicacion)
                .append("\nGenero: ").append(genero)
                .append("\nTipo: ").append(tipo);
        sb.append("\n<----------->");

        return sb.toString();

    }

    public void mostrarLibro() {
        System.out.println(this);
    }
}
