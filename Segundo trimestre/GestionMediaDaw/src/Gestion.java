import java.util.ArrayList;
import java.util.List;

public class Gestion {

    private List<Cliente> GestionCliente = new ArrayList<Cliente>();
    private List<Articulo> Inventario = new ArrayList();

    public void agregarArticulo (Articulo nuevoArticulo) {
        Inventario.add(nuevoArticulo);
    }

    public void mostrarInventario () {
        for (Articulo articulo : Inventario) {
            System.out.println(articulo);
        }
    }

    public void mostrarArticulosFiltro(){
        for (Articulo articulo : Inventario) {
            System.out.println(articulo.getId() +  " / " + articulo.getTitulo());
        }
    }

    public void agregarCliente (Cliente nuevoCliente) {
        GestionCliente.add(nuevoCliente);
    }
    public void mostrarCliente () {
        for (Cliente cliente : GestionCliente) {
            System.out.println(cliente);
        }
    }

    public void mostrarClienteFiltro(){
        for (Cliente c : GestionCliente) {
            System.out.println(c.getDni() +  " / " + c.getNombre());
        }
    }

    public Articulo buscarArticulo (String id) {
        for (Articulo articulo : Inventario) {
            if (articulo.getId().equals(id)) {
                return articulo;
            }
        }
        return null;
    }

    public Cliente buscarCliente (String dni) {
        for (Cliente cliente : GestionCliente) {
            if (cliente.getDni().equals(dni)) {
                return cliente;
            }
        }
        return null;
    }

    public boolean alquilarArticulo (String id, String dni) {
       Articulo a = buscarArticulo(id);
       Cliente c = buscarCliente(dni);

       // Validar existencia
       if (a == null) {
           System.out.println("No existe el articulo " + id);
           return false;
       }
       if (c == null) {
           System.out.println("No existe el cliente " + dni);
           return false;
       }

       // Disponibilidad
       if (!a.isDisponible()){
           System.out.println("El articulo " + a.getTitulo() + " ya esta alquilado");
           return false;
       }

       boolean exitoAlquiler = c.agregarArticuloCliente(a);

       if (exitoAlquiler) {
           a.setDisponible(false);
           System.out.println("Alquiler realizo con exito de " + a.getTitulo() + " para el cliente " + c.getNombre());
           return true;
       }
        return false;
    }

    public boolean devolverArticulo (String id, String dni) {
        Articulo a = buscarArticulo(id);
        Cliente c = buscarCliente(dni);

        if (a == null || c == null) {
            System.out.println("Error: No se encontro el articulo o el cliente");
            return false;
        }

        boolean eliminado = c.devolverArticuloCliente(a);
        if (eliminado) {
            a.setDisponible(true);
            System.out.println("Devolución exitosa: " + a.getTitulo() + " devuelto por " + c.getNombre());
            return true;
        } else {
            System.out.println("Error: El cliente " + c.getNombre() + " no tiene alquilado el artículo " + id);
            return false;
        }

    }



}
