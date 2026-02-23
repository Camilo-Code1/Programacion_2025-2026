import java.io.*;
import java.time.LocalDate;
import java.util.LinkedList;

public class Biblioteca implements Serializable {

    private static final long serialVersionUID = -4914514719223067957L;

    LinkedList <Libro> nuevoLibro = new LinkedList<>();

    public void agregarLibro(String ISBN, String titulo, String autor, LocalDate fechaPublicacion) {
        nuevoLibro.add(new Libro(ISBN, titulo, autor, fechaPublicacion));
    }

    public void mostrarLibros() {
        for (Libro li : nuevoLibro) {
            System.out.println(li);
        }
    }

    public void cargarDatos() {
        File archivo = new File("src/resource/almacen.dat");

        if (!archivo.exists()) {
            return;
        }

        try (ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream(archivo))) {

            nuevoLibro = (LinkedList<Libro>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public void leerFichero() {

        try(FileInputStream fis = new FileInputStream("src/resource/almacen.dat");
            ObjectInputStream ois = new ObjectInputStream(fis)) {

            nuevoLibro = (LinkedList<Libro>) ois.readObject();

            for (Libro lib : nuevoLibro) {
                System.out.println(lib);
            }

        } catch (EOFException e) {
            System.out.println("Archivo vacio.");
        } catch (IOException |ClassNotFoundException e) {
            System.out.println("Error: "+ e.getMessage());
        }
    }

    public void escribirFichero() {
        try( FileOutputStream fos = new FileOutputStream("src/resource/almacen.dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(nuevoLibro);

            System.out.println("Escritura completa");


            nuevoLibro.clear();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


}
