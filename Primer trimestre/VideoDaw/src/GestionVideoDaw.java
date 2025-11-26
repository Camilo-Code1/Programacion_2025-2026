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

        System.out.println("Ingrese la dirección de la empresa: ");
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
                    System.out.println("Introduzca el titulo:");
                    String titulo = sc.nextLine();

                    Genero genero;
                    int gen = -1;

                    do {
                        System.out.println("Seleccione un género:");
                        for (Genero g : Genero.values()) {
                            System.out.println((g.ordinal() + 1) + ". " + g);
                        }
                        System.out.print("Opción: ");

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

                    break;
                case "3":
                    String dni = obtenerDNIValido().toUpperCase();

                    System.out.println("Introduzca el nombre del cliente: ");
                    String nombre = sc.nextLine();

                    System.out.println("Introduzca la dirección del cliente: ");
                    String direccion = sc.nextLine();

                    System.out.println("Introduzca el año de nacimiento del cliente: ");
                    String fechaNacimiento = sc.nextLine();

                    victima = new Cliente(dni, nombre, direccion, fechaNacimiento);
                    nuevoUsuario.agregarCliente(victima);
                    break;
                case "4":
                    System.out.println();
                    break;
                case "5":

                    break;
                case "6":
                    nuevoUsuario.mostrarPeliculas();
                    break;
                case "7":
                    nuevoUsuario.mostrarClientes();
                    break;
                case "8":
                    System.out.println("\nAviso: Saliendo del sistema.");
                    break;
                default:
                    System.out.print("\nOpción invalida. Por favor vuelva a intentarlo.");
                    break;
            }


        } while (!opcion.equals("8"));




    }

    private static String obtenerCIFValido () {
        Scanner sc = new Scanner(System.in);
        String cif = sc.nextLine();
        while (true) {
            System.out.println("Ingrese un CIF valido para la empresa (Ejemplo: A1234567J):");
            cif = sc.nextLine().toUpperCase();
            if (validarCIF(cif)) {
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
                return dni;
            }
            System.out.println("DNI invalido. Por favor vuelva a intentarlo.");
        }
    }
    private static boolean validarDNI(String dni) {
        return dni.matches("^\\d{8}[A-Za-z]$");
    }



}
