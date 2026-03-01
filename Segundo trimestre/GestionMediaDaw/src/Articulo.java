import java.io.Serializable;

public abstract class Articulo implements Serializable {

    private static final long serialVersionUID = 4620095091290394684L;

    private String id;
    private String titulo;
    private boolean disponible;

    private static int incremental = 1;

    public Articulo(String id, String titulo, boolean disponible) {
        this.id = String.format("A-%03d", incremental++);
        this.titulo = titulo;
        this.disponible = true;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    @Override
    public String toString() {
        return "Articulo: " +
                "ID:" + id  +
                " Titulo: " + titulo +
                " Disponible:" + disponible;
    }
}
