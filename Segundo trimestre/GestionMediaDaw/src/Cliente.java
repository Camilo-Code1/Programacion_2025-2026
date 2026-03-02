import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cliente implements Serializable {

    private static final long serialVersionUID = -2331692428789509573L;

    private String dni;
    private String nombre;
    private List<Articulo> listaAlquidados = new ArrayList<Articulo>();

    public Cliente(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Articulo> getListaAlquidados() {
        return listaAlquidados;
    }

    public boolean agregarArticuloCliente (Articulo art){
        if(listaAlquidados.size() < 3){
            listaAlquidados.add(art);
            return true;

        }
        System.out.println("Limite alcanzado: No se pueden alquimar más de 3 articulos");
        return false;
    }

    public boolean devolverArticuloCliente (Articulo art){
        return listaAlquidados.remove(art);
    }

    public void mostrarListaAlquilados(){
        for(Articulo art: listaAlquidados){
            System.out.println(art);
        }
    }

    @Override
    public String toString() {
        return "Cliente: " +
                "DNI:" + dni +
                " nombre: " + nombre +
                "\nLista de Articulos alquidados: " + listaAlquidados;
    }
}
