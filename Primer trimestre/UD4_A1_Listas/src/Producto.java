public class Producto implements Comparable<Producto> {

    private String nombre;
    private int cantidad;

    public Producto(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    @Override
    public int compareTo(Producto otro) {
        return this.nombre.compareTo(otro.nombre);
    }

    @Override
    public String toString() {
        return nombre + " - " + cantidad;
    }
}
