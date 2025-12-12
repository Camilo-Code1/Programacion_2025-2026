import java.time.LocalDate;

public class LibroFisico extends Libro {

    private int numeroEstanteria;
    private String pasilloEstanteria;
    private Estado estado;

    public LibroFisico (String tituloLibro, String autorLibro, String isbn, LocalDate fechaPublicacion, Genero genero, TipoLibro tipo, int numeroEstanteria, String pasilloEstanteria, Estado estado) {
        super(tituloLibro, autorLibro, isbn, fechaPublicacion, genero, tipo);
        this.numeroEstanteria = numeroEstanteria;
        this.pasilloEstanteria = pasilloEstanteria;
        this.estado = estado;
    }

    public int getNumeroEstanteria() {
        return numeroEstanteria;
    }

    public void setNumeroEstanteria(int numeroEstanteria) {
        this.numeroEstanteria = numeroEstanteria;
    }

    public String getPasilloEstanteria() {
        return pasilloEstanteria;
    }

    public void setPasilloEstanteria(String pasilloEstanteria) {
        this.pasilloEstanteria = pasilloEstanteria;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }


    @Override
    public String toString() {
        return super.toString() +
                "\n<---Libro Fisico--->" +
                "\nNumero Estanteria: " + numeroEstanteria +
                "\nPasillo Estanteria: " + pasilloEstanteria +
                "\nEstado: " + estado +
                "\n<---------->";
    }


    public void mostrarLibroFisico() {
        System.out.println(this);
    }


}

