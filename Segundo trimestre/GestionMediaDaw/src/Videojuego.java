public class Videojuego extends Articulo{

    private static final long serialVersionUID = -8760379699587359016L;

    private String plataforma;
    private Pegi pegiAsignado;
    private double precioXdia;

    public Videojuego(String titulo, String plataforma, Pegi pegiAsignado, double precioXdia ) {
        super(titulo);

        this.plataforma = plataforma;
        this.pegiAsignado = pegiAsignado;
        this.precioXdia = precioXdia;

    }

    public String getPlataforma() {
        return plataforma;
    }

    public Pegi getPegiAsignado() {
        return pegiAsignado;
    }

    public double getPrecioXdia() {
        return precioXdia;
    }

    public void setPrecioXdia(double precioXdia) {
        this.precioXdia = precioXdia;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nVideojuego: " +
                "Plataforma: " + plataforma +
                " PEGI asignado: " + pegiAsignado +
                " Precio por dia: " + precioXdia + "$" +
                " ]";
    }
}
