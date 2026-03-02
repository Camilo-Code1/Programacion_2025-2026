import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Gestion {

    private List<Cliente> GestionCliente = new ArrayList<Cliente>();
    private List<Articulo> Inventario = new ArrayList();

    // MÉTODOS AGREGAR Y MOSTRAR

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

    public void mostrarArticulosNO_Disponibles() {
        for (Articulo articulo : Inventario) {
            if (!articulo.isDisponible()) {
                System.out.println(articulo);
            }
        }
    }

    // Eliminar

    public boolean eliminarArticulo(String id) {
        Articulo articulo = buscarArticulo(id);

        if (articulo == null) {
            System.out.println("Error: No se encontró el artículo con ID: " + id);
            return false;
        }

        if (!articulo.isDisponible()) {
            System.out.println("BLOQUEADO: El artículo '" + articulo.getTitulo() + "' está alquilado actualmente.");
            return false;
        }

        Inventario.remove(articulo);
        System.out.println("Artículo '" + articulo.getTitulo() + "' eliminado con éxito.");
        return true;
    }

    public boolean eliminarCliente(String dni) {
        Cliente cliente = buscarCliente(dni);

        if (cliente == null) {
            System.out.println("Error: No se encontró el cliente con DNI: " + dni);
            return false;
        }

        if (!cliente.getListaAlquidados().isEmpty()) {
            System.out.println("BLOQUEADO: El cliente " + cliente.getNombre() + " tiene artículos pendientes de devolución.");
            return false;
        }

        GestionCliente.remove(cliente);
        System.out.println("Cliente " + cliente.getNombre() + " eliminado con éxito.");
        return true;
    }



    // METODOS DE BUSQUEDA, ALQUILER Y DEVOLUCIÓN

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



    // FICHEROS

    public void cargarDatos(){

        File archivo = new File("src/resources/med.dat");

        if(!archivo.exists()){
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream
                (new FileInputStream(archivo))) {

            Inventario = (List<Articulo>) ois.readObject();
            GestionCliente = (List<Cliente>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los datos: " + e.getMessage());
        }
    }

    public void escribirDatosFichero() {
        try (FileOutputStream fos = new FileOutputStream("src/resources/med.dat");
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {

                oos.writeObject(Inventario);
                oos.writeObject(GestionCliente);

                System.out.println("Datos escritos correctamente en el archivo.");

            } catch (IOException e) {
                System.out.println("Error al escribir los datos: " + e.getMessage());
            }
    }


}
