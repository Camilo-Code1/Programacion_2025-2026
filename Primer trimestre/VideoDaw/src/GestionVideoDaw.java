import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class GestionVideoDaw {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String menu = "\n1. Crear y registrar VideoClub en la franquicia.\n" +
                "2. Registrar película en videoclub.\n" +
                "3. Crear y registrar cliente en videoclub.\n" +
                "4. Alquilar película.\n" +
                "5. Devolver película.\n" +
                "6. Dar de baja cliente.\n" +
                "7. Dar de baja película.\n" +
                "8. Salir.";

        String opcion = "";

        VideoDaw nuevoUsuario;
        Pelicula peliculon;
        Cliente victima;

        String cif = "";
        String direccionEm = "";


        System.out.print("Bienvenido a Dawbank" +
                " (Presione intro para continuar)");

        cif = obtenerCIFValido().toUpperCase();

        System.out.println("\nIngrese la dirección de la empresa: ");
        direccionEm = sc.nextLine();

        nuevoUsuario = new VideoDaw(direccionEm, cif);

        do {
            sc = new Scanner(System.in);

            System.out.print("");
            System.out.println(menu);
            System.out.print("");

            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println(nuevoUsuario.mostrarInfoVideoDaw());
                    break;
                case "2":
                    registrarPelicula(sc, nuevoUsuario);

                    break;
                case "3":
                    crearRegistrarCliente(sc, nuevoUsuario);
                    break;
                case "4":
                    System.out.println("Ingrese el numero de socio:");
                    String socio = sc.nextLine().toUpperCase();

                    System.out.println("Ingrese el codigo de pelicula:");
                    String codPeli = sc.nextLine().toUpperCase();

                    boolean alquilado = nuevoUsuario.alquilarPeicula(socio, codPeli);

                    if (alquilado) {
                        System.out.println("¡Pelicula alquilada exitosamente!");
                    } else {
                        System.out.println("Error: No se pudo realizar el alquiler");
                    }

                    break;
                case "5":

                    break;
                case "6":
                    System.out.println("Ingrese el número de socio (Ej: S-005):");
                    String numSocio = sc.nextLine().toUpperCase();

                    boolean darBajonCliente = nuevoUsuario.darBajaCliente(numSocio);

                    if (darBajonCliente) {
                        System.out.println("Cliente dado de baja correctamente");
                    } else {
                        System.out.println("No se pudo dar de baja. El cliente no existe o ya esta dado de baja");
                    }
                    break;
                case "7":
                    System.out.println("Ingrese el codigo de la pelicula (Ej: P-007)");
                    String cod = sc.nextLine().toUpperCase();

                    boolean darBajonPelicula = nuevoUsuario.darBajaPelicula(cod);
                    if (darBajonPelicula) {
                        System.out.println("Pelicula dado de baja correctamente");
                    } else {
                        System.out.println("No se pudo dar de baja. La pelicula no existe o ya esta dado de baja");
                    }
                    break;
                case "8":
                    System.out.println("\nAviso: Saliendo del sistema.");
                    break;
                case "9":
                    nuevoUsuario.mostrarPeliculas();
                    break;
                case "10":
                    nuevoUsuario.mostrarClientes();
                    break;
                default:
                    System.out.print("\nOpción invalida. Por favor vuelva a intentarlo.");
                    break;
            }


        } while (!opcion.equals("8"));




    }

    private static void registrarPelicula(Scanner sc, VideoDaw nuevoUsuario) {
        System.out.println("Introduzca el titulo:");
        String titulo = sc.nextLine();

        Genero genero;
        int gen = -1;

        do {
            System.out.println("Seleccione un género:");
            for (Genero g : Genero.values()) {
                System.out.println((g.ordinal() + 1) + ". " + g);
            }
            System.out.println("Opción: ");

            String entrada = sc.nextLine();


            if (entrada.matches("\\d+")) {
                gen = Integer.parseInt(entrada);
            } else {
                System.out.println("Error: Debe ingresar un número.");
                continue;
            }

            if (gen < 1 || gen > Genero.values().length) {
                System.out.println("Opción fuera de rango. Intente nuevamente.");
            }

        } while (gen < 1 || gen > Genero.values().length);

        genero = Genero.values()[gen - 1];


        String entrada;
        boolean alquiladaValida = false;
        boolean alquilada = false;

        do {
            System.out.print("¿Está alquilada? (true/false): ");
            entrada = sc.nextLine().toLowerCase();

            if (entrada.equals("true") || entrada.equals("false")) {
                alquilada = Boolean.parseBoolean(entrada);
                alquiladaValida = true;
            } else {
                System.out.println("Debe ingresar 'true' o 'false'.");
            }

        } while (!alquiladaValida);


        Pelicula p = new Pelicula(titulo, genero, alquilada);
        nuevoUsuario.agregarPelicula(p);
        System.out.println("Película agregada correctamente.");
    }

    private static void crearRegistrarCliente(Scanner sc, VideoDaw nuevoUsuario) {
        Cliente victima;
        String dni = obtenerDNIValido().toUpperCase();

        System.out.println("Introduzca el nombre del cliente: ");
        String nombre = sc.nextLine();

        System.out.println("Introduzca la dirección del cliente: ");
        String direccion = sc.nextLine();


        LocalDate fechaNacimiento = obtenerFechaValida();

        victima = new Cliente(dni, nombre, direccion, fechaNacimiento);
        nuevoUsuario.agregarCliente(victima);
    }

    private static String obtenerCIFValido () {
        Scanner sc = new Scanner(System.in);
        String cif = sc.nextLine();
        while (true) {
            System.out.println("Ingrese un CIF valido para la empresa (Ejemplo: A1234567J):");
            cif = sc.nextLine().toUpperCase();
            if (validarCIF(cif)) {
                System.out.println("\nCIF admitido correctamente.");
                return cif;

            }
            System.out.println("CIF invalido. Por favor vuelva a intentarlo.");
        }
    }
    private static boolean validarCIF(String cif) {
        return cif.matches("^[A-HJNP-S]\\d{7}[0-9A-J]$");
    }

    private static String obtenerDNIValido () {
        Scanner sc = new Scanner(System.in);
        String dni;
        while (true) {
            System.out.println("Ingrese el DNI del cliente (Ejemplo: 87654321M):");
            dni = sc.nextLine().toUpperCase();
            if (validarDNI(dni)) {
                System.out.println("\nDNI admitido correctamente.");
                return dni;
            }
            System.out.println("DNI invalido. Por favor vuelva a intentarlo.");
        }
    }
    private static boolean validarDNI(String dni) {
        return dni.matches("^\\d{8}[A-Za-z]$");
    }

    private static LocalDate obtenerFechaValida() {
        Scanner sc = new Scanner(System.in);
        String fecha;

        while (true) {
            System.out.println("Ingrese la fecha de nacimiento (dd-MM-yyyy):");
            fecha = sc.nextLine();

            if (validarFecha(fecha)) {

                String[] partes = fecha.split("-");
                int dia = Integer.parseInt(partes[0]);
                int mes = Integer.parseInt(partes[1]);
                int año = Integer.parseInt(partes[2]);

                return LocalDate.of(año, mes, dia);
            }

            System.out.println("Fecha inválida. Por favor vuelva a intentarlo.");
        }
    }


    private static boolean validarFecha(String fecha) {
        return fecha.matches("^\\d{2}-\\d{2}-\\d{4}$");
    }


}
