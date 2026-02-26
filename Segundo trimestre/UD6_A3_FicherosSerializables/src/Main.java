import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Biblioteca nuevoContenido = new Biblioteca();

        nuevoContenido.cargarDatos();

        String menu = "\n1. Crear libro y registarlo en la Biblioteca.\n" +
                "2. Mostrar libros existentes por atributo.\n" +
                "3. Mostrar libros. \n" +
                "4. Eliminar libros por ISBN. \n" +
                "5. Guardar libro en el fichero. \n" +
                "6. Salir. ";

        String opcion = "";

        do {
            System.out.println(menu);

            System.out.println("\nPor favor recuerde guardar todos los cambios antes de salir.");

            opcion = sc.nextLine();
            switch (opcion) {
                case "1":

                    String ISBN = obtenerISBNValido(sc);

                    System.out.println("Inserte el Titulo del libro: ");
                    String Titulo = sc.nextLine();

                    System.out.println("Inserte el autor del libro: ");
                    String autor = sc.nextLine();

                    LocalDate fechaPublicacion = obtenerFechaValida(sc);

                    nuevoContenido.agregarLibro(ISBN, Titulo, autor, fechaPublicacion);
                    break;
                case "2":
                    System.out.println(nuevoContenido.obtenerDatosPorValor());
                    break;
                case "3":
                    nuevoContenido.mostrarLibros();
                    break;
                case "4":
                    sc = new Scanner(System.in);

                    System.out.println("Estos son los ISBN registrados: ");
                    System.out.println(nuevoContenido.recorrerIsbn());

                    System.out.println("Por favor, inserte el ISBN del libro que desea eliminar: ");
                    ISBN = sc.nextLine();

                    if (nuevoContenido.eliminarLibro(ISBN)){
                        System.out.println("Se elimino correctamente el libro seleccionado.");
                    } else {
                        System.out.println("Hubo un problema a la hora de la eliminación");
                    }

                    break;
                case "5":
                    nuevoContenido.escribirFichero();
                    break;
                case "6":

                    break;


            }
        } while (!opcion.equals("7"));
    }

    private static LocalDate obtenerFechaValida(Scanner sc) {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (true) {
            System.out.println("Ingrese la fecha de publicación (dd/MM/yyyy):");
            String fecha = sc.nextLine();

            try {
                return LocalDate.parse(fecha, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Fecha inválida. Intente de nuevo.");
            }
        }
    }
    private static String obtenerISBNValido(Scanner sc) {

        while (true) {
            System.out.println("Ingrese el ISBN (13 dígitos, sin guiones):");
            String isbn = sc.nextLine().trim();

            if (isbn.matches("\\d{13}")) {
                return isbn;
            } else {
                System.out.println("ISBN inválido. Debe contener exactamente 13 números.");
            }
        }
    }
}
