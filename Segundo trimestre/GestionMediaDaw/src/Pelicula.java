public class Pelicula extends Articulo {

    private static final long serialVersionUID = -1893269724330921147L;

    private int duracionH;
    private Genero genero;
    private double precioEntrada;

    public Pelicula(String titulo, int duracionH, Genero genero, double precioEntrada) {
        super(titulo);
        this.duracionH = duracionH;
        this.genero = genero;
        this.precioEntrada = precioEntrada;
    }

    public int getDuracionH() {
        return duracionH;
    }

    public Genero getGenero() {
        return genero;
    }

    public double getPrecioEntrada() {
        return precioEntrada;
    }

    public void setPrecioEntrada(double precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nPelicula: " +
                "duración: " + duracionH +
                " genero: " + genero +
                " precio de entrada: " + precioEntrada + "$" + " ]";
    }
}
