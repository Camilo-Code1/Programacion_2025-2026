import java.time.LocalDate;
import java.util.Scanner;

public class Gestion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String menu = "\n1. Registrar libro físico.\n" +
                "2. Registrar libro digital.\n" +
                "3. Eliminar libro.\n" +
                "4. Mostrar información general de la biblioteca.\n" +
                "5. Mostrar número de libros almacenados.\n" +
                "6. Mostrar información de todos los libros.\n" +
                "7. Buscar libro por ISBN.\n" +
                "8. Salir de la aplicación.";

        String submenu = "A. Mostrar lista de Libros físicos.\n" +
                "B. Mostrar lista de libros digitales\n" +
                "C. Mostrar todos los libros.";

        String opcion = "";

        // Libro variables
        String tituloLibro, autorLibro, isbn;
        LocalDate fechaPublicacion;
        Genero genero;

        Biblioteca nuevoUsuario;

        System.out.println("\nBienvenido");
        String nombreBiblioteca = obtenerTextoNoVacio(
                "Inserte el nombre de la Biblioteca:", sc);

        String codigoBiblioteca = obtenerCodBibliotecaValido().toUpperCase();

        System.out.println("Inserte la fecha de la creación de la Biblioteca: ");
        LocalDate fechaApertura = obtenerFechaValida();

        int capacidadMaximaLibros = obtenerEnteroValido(
                "Ingrese la capacidad máxima de la Biblioteca:", sc);

        nuevoUsuario = new Biblioteca(nombreBiblioteca, codigoBiblioteca, fechaApertura, capacidadMaximaLibros);


        do {
            System.out.println(menu);
            opcion = sc.nextLine();

            switch (opcion) {

                case "1":
                    tituloLibro = obtenerTextoNoVacio("Inserte el nombre del libro:", sc);
                    autorLibro = obtenerTextoNoVacio("Inserte el autor del libro:", sc);

                    isbn = obtenerISBNValido().toUpperCase();

                    if (nuevoUsuario.buscarLibroNeutral(isbn) != null) {
                        System.out.println("Error: Ya existe un libro registrado con ese ISBN.");
                        break;
                    }

                    System.out.println("Inserte la fecha en la que fue publicada: ");
                    fechaPublicacion = obtenerFechaValida();

                    genero = getGenero(sc);

                    int numeroEstanteria = obtenerEnteroValido(
                            "Inserte el número de la estantería:", sc);

                    String pasillo = obtenerTextoNoVacio(
                            "Inserte el pasillo donde está la estantería:", sc);

                    Estado estado = getEstado(sc);

                    LibroFisico lf = new LibroFisico(
                            tituloLibro, autorLibro, isbn, fechaPublicacion,
                            genero, TipoLibro.FISICO, numeroEstanteria,
                            pasillo, estado
                    );

                    nuevoUsuario.agregarLibroFisico(lf);
                    System.out.println("Registro agregado exitosamente. ISBN: " + isbn);
                    break;


                case "2":
                    tituloLibro = obtenerTextoNoVacio("Inserte el nombre del libro:", sc);
                    autorLibro = obtenerTextoNoVacio("Inserte el autor del libro:", sc);

                    isbn = obtenerISBNValido().toUpperCase();

                    if (nuevoUsuario.buscarLibroNeutral(isbn) != null) {
                        System.out.println("Error: Ya existe un libro registrado con ese ISBN.");
                        break;
                    }

                    System.out.println("Inserte la fecha en la que fue publicada: ");
                    fechaPublicacion = obtenerFechaValida();

                    genero = getGenero(sc);

                    Formato formato = getFormato(sc);

                    double tamanio = obtenerDoubleValido("Inserte el tamaño del libro (MB):", sc);

                    LibroDigital ld = new LibroDigital(tituloLibro, autorLibro, isbn,
                            fechaPublicacion, genero, TipoLibro.DIGITAL,
                            formato, tamanio);

                    nuevoUsuario.agregarLibroDigital(ld);
                    System.out.println("Registro agregado exitosamente. ISBN: " + isbn);
                    break;


                case "3":
                    String isbnEliminar = obtenerTextoNoVacio("Inserte el ISBN del libro a eliminar:", sc);
                    nuevoUsuario.eliminarLibro(isbnEliminar);
                    break;

                case "4":
                    System.out.println(nuevoUsuario.msotrarInfoBiblioteca());
                    break;

                case "5":
                    nuevoUsuario.mostrarNumeroLibros();
                    break;

                case "6":
                    System.out.println(submenu);
                    String opcionSubmenu = sc.nextLine().toUpperCase();

                    switch (opcionSubmenu) {
                        case "A": nuevoUsuario.mostrarLibrosFisicos(); break;
                        case "B": nuevoUsuario.mostrarLibrosDigitales(); break;
                        case "C": nuevoUsuario.mostrarLibros(); break;
                        default: System.out.println("Opción inválida.");
                    }
                    break;

                case "7":
                    isbn = obtenerTextoNoVacio("Inserte el ISBN:", sc);
                    nuevoUsuario.buscarLibroMostrar(isbn);
                    break;

                case "8":
                    System.out.println("Saliendo del programa");
                    break;

                case "9":
                    genero = getGenero(sc);
                    nuevoUsuario.mostrarLibrosAgrupadosPorGenero(genero);
                    break;

                default:
                    System.out.println("\nOpción no válida.");
                    break;
            }

        } while (!opcion.equals("8"));
    }

    // -------------------------
    // MÉTODOS DE VALIDACIÓN
    // -------------------------

    private static String obtenerTextoNoVacio(String mensaje, Scanner sc) {
        String entrada;
        do {
            System.out.println(mensaje);
            entrada = sc.nextLine().trim();

            if (entrada.isEmpty()) {
                System.out.println("Error: El campo no puede quedar vacío.");
            }
        } while (entrada.isEmpty());
        return entrada;
    }

    private static int obtenerEnteroValido(String mensaje, Scanner sc) {
        while (true) {
            System.out.println(mensaje);
            String entrada = sc.nextLine();

            if (entrada.matches("\\d+")) {
                return Integer.parseInt(entrada);
            }
            System.out.println("Error: Debe ingresar un número entero válido.");
        }
    }

    private static double obtenerDoubleValido(String mensaje, Scanner sc) {
        while (true) {
            System.out.println(mensaje);
            String entrada = sc.nextLine();

            if (entrada.matches("\\d+(\\.\\d+)?")) {
                return Double.parseDouble(entrada);
            }
            System.out.println("Error: Debe ingresar un número válido (ej: 10.5).");
        }
    }

    private static LocalDate obtenerFechaValida() {
        Scanner sc = new Scanner(System.in);
        String fecha;

        while (true) {
            System.out.println("Ingrese la fecha (dd/MM/yyyy):");
            fecha = sc.nextLine();

            if (validarFecha(fecha)) {
                String[] p = fecha.split("/");
                int dia = Integer.parseInt(p[0]);
                int mes = Integer.parseInt(p[1]);
                int anio = Integer.parseInt(p[2]);

                // Validación adicional de rango
                if (dia >= 1 && dia <= 30 && mes >= 1 && mes <= 12) {
                    return LocalDate.of(anio, mes, dia);
                }
            }

            System.out.println("Fecha inválida. Intente de nuevo.");
        }
    }

    private static boolean validarFecha(String fecha) {
        // dd/MM/yyyy
        return fecha.matches("^\\d{2}/\\d{2}/\\d{4}$");
    }


    private static String obtenerCodBibliotecaValido() {
        Scanner sc = new Scanner(System.in);
        String codigo;

        while (true) {
            System.out.println("Ingrese el código de la biblioteca (Ej: ABC123):");
            codigo = sc.nextLine().toUpperCase();

            if (codigo.matches("^[A-Z]{3}\\d{3}$")) {
                return codigo;
            }
            System.out.println("Código inválido. Intente de nuevo.");
        }
    }

    private static String obtenerISBNValido() {
        Scanner sc = new Scanner(System.in);
        String isbn;

        while (true) {
            System.out.println("Ingrese el ISBN (13 dígitos):");
            isbn = sc.nextLine();

            if (isbn.matches("^\\d{13}$")) {
                return isbn;
            }
            System.out.println("ISBN inválido.");
        }
    }

    // Métodos ENUM existentes (sin cambios)
    private static Formato getFormato(Scanner sc) {
        Formato tipo;
        int in = -1;

        do {
            System.out.println("Introduzca el tipo de libro: ");
            for (Formato libro : Formato.values()) {
                System.out.println((libro.ordinal() + 1) + ". " + libro);
            }
            System.out.print("Opcion: ");
            String entrada = sc.nextLine();

            if (entrada.matches("\\d+")) {
                in = Integer.parseInt(entrada);
            } else {
                System.out.println("\nOpcion no valida. Debe de ingresar un numero.");
                continue;
            }
            if (in < 1 || in > Formato.values().length) {
                System.out.println("\nError: Numero fuera de rango. Intente de nuevo.");
            }
        } while (in < 1 || in > Formato.values().length);

        return Formato.values()[in - 1];
    }

    private static Genero getGenero(Scanner sc) {
        Genero genero;
        int in = -1;

        do {
            System.out.println("Introduzca el genero del libro: ");
            for (Genero ge : Genero.values()) {
                System.out.println((ge.ordinal() + 1) + ". " + ge);
            }
            System.out.print("Opcion: ");
            String entrada = sc.nextLine();

            if (entrada.matches("\\d+")) {
                in = Integer.parseInt(entrada);
            } else {
                System.out.println("\nOpcion no valida. Debe de ingresar un numero.");
                continue;
            }
            if (in < 1 || in > Genero.values().length) {
                System.out.println("\nError: Numero fuera de rango. Intente de nuevo.");
            }
        } while (in < 1 || in > Genero.values().length);

        return Genero.values()[in - 1];
    }


    private static Estado getEstado(Scanner sc) {
        Estado estado;
        int in = -1;

        do {
            System.out.println("Introduzca el estado del libro: ");
            for (Estado es : Estado.values()) {
                System.out.println((es.ordinal() + 1) + ". " + es);
            }
            System.out.print("Opcion: ");
            String entrada = sc.nextLine();

            if (entrada.matches("\\d+")) {
                in = Integer.parseInt(entrada);
            } else {
                System.out.println("\nOpcion no valida. Debe de ingresar un numero.");
                continue;
            }
            if (in < 1 || in > Estado.values().length) {
                System.out.println("\nError: Numero fuera de rango. Intente de nuevo.");
            }
        } while (in < 1 || in > Estado.values().length);

        return Estado.values()[in - 1];
    }
}
