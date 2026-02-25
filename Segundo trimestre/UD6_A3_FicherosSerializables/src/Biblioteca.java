import java.io.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Biblioteca implements Serializable {

    private static final long serialVersionUID = -4914514719223067957L;

    private Map<String, Libro> libros;

    public Biblioteca() {
        libros = new HashMap<>();
    }

    // ----------------------------
    // CRUD EN MEMORIA
    // ----------------------------

    public boolean agregarLibro(String ISBN, String titulo, String autor, LocalDate fechaPublicacion) {

        if (libros.containsKey(ISBN)) {
            return false; // Ya existe
        }

        libros.put(ISBN, new Libro(ISBN, titulo, autor, fechaPublicacion));
        return true;
    }

    public boolean eliminarLibro(String ISBN) {
        return libros.remove(ISBN) != null;
    }

    public void mostrarLibros() {

        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }

        for (Libro li : libros.values()) {
            System.out.println(li);
        }
    }

    public String obtenerDatosPorValor() {

        if (libros.isEmpty()) {
            return "No hay libros registrados.";
        }

        StringBuilder info = new StringBuilder();

        for (Libro li : libros.values()) {
            info.append(li.getISBN())
                    .append(" - ")
                    .append(li.getTitulo())
                    .append("\n");
        }

        return info.toString();
    }

    public Libro buscarPorISBN(String ISBN) {
        return libros.get(ISBN);
    }

    // ----------------------------
    // PERSISTENCIA
    // ----------------------------

    public void cargarDatos() {

        File archivo = new File("src/resource/almacen.dat");

        if (!archivo.exists()) {
            return;
        }

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(archivo))) {

            libros = (Map<String, Libro>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error cargando datos: " + e.getMessage());
        }
    }

    public void escribirFichero() {

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(
                             new FileOutputStream("src/resource/almacen.dat"))) {

            oos.writeObject(libros);
            System.out.println("Datos guardados correctamente.");

        } catch (IOException e) {
            System.out.println("Error guardando datos: " + e.getMessage());
        }
    }
}