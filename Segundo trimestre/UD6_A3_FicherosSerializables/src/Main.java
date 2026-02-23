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
                "3. Mostrar libros sin guardar. \n" +
                "4. Eliminar libro por ISBN del fichero. \n" +
                "5. Eliminar libros por ISBN. \n" +
                "6. Guardar libro en el fichero. \n" +
                "7. Salir. ";

        String opcion = "";

        do {
            System.out.println(menu);
            opcion = sc.nextLine();
            switch (opcion) {
                case "1":
                    System.out.println("Inserte el ISBN del libro: ");
                    String ISBN = sc.nextLine();

                    System.out.println("Inserte el Titulo del libro: ");
                    String Titulo = sc.nextLine();

                    System.out.println("Inserte el autor del libro: ");
                    String autor = sc.nextLine();

                    System.out.println("Inserte la fecha de publicacion: ");
                    LocalDate fechaPublicacion = obtenerFechaValida(sc);

                    nuevoContenido.agregarLibro(ISBN, Titulo, autor, fechaPublicacion);
                    break;
                case "2":
                    nuevoContenido.leerFichero();
                    break;
                case "3":
                    nuevoContenido.escribirFichero();
                    break;
                case "4":
                    nuevoContenido.mostrarLibros();
                    break;
                case "5":

                    break;
                case "6":

                    break;
                case "7":

                    break;


            }
        } while (!opcion.equals("7"));
    }

    private static LocalDate obtenerFechaValida(Scanner sc) {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (true) {
            System.out.println("Ingrese la fecha (dd/MM/yyyy):");
            String fecha = sc.nextLine();

            try {
                return LocalDate.parse(fecha, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Fecha inválida. Intente de nuevo.");
            }
        }
    }
}
