import java.time.LocalDate;

public class LibroDigital extends Libro{

    private Formato formato;
    private double tamanio;
    private String idInterno;

    private static int contadorLibrosDigitales = 1;

    public LibroDigital (String tituloLibro, String autorLibro, String isbn, LocalDate fechaPublicacion, Genero genero, TipoLibro tipo, Formato formato, double tamanio) {
        super(tituloLibro, autorLibro, isbn, fechaPublicacion, genero, tipo);
        this.formato = formato;
        this.tamanio = tamanio;
        this.idInterno = String.format("LD-%03d", contadorLibrosDigitales);
        contadorLibrosDigitales++;

    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    public double getTamanio() {
        return tamanio;
    }

    public void setTamanio(double tamanio) {
        this.tamanio = tamanio;
    }

    public String getIdInterno() {
        return idInterno;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n<---Libro Digital--->" +
                "\nFormato: " + formato +
                "\nTamanio: " + tamanio +
                "\nID: " + idInterno +
                "\n<------------------->";
    }


}
