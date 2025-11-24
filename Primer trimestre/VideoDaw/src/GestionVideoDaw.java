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
        String direccion = "";
        String fechaAlta = "";

        System.out.print("Bienvenido a Dawbank" +
                " (Presione intro para continuar)");

        cif = obtenerCIFValido().toUpperCase();

        System.out.println("Ingrese la dirección de la empresa: ");
        direccion = sc.nextLine();

        nuevoUsuario = new VideoDaw(direccion, cif);

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




                    System.out.println("Seleccione un género:");
                    for (Genero g  : Genero.values()) {
                        System.out.println(g.ordinal() + 1 + "." + g);
                    }
                    int gen = sc.nextInt();

                    Genero genero = Genero.values()[gen - 1];


//                    Genero genero;
//                    int gen;
//
//                    do {
//                        System.out.println("Seleccione un género:");
//                        for (Genero g : Genero.values()) {
//                            System.out.println((g.ordinal() + 1) + ". " + g);
//                        }
//                        System.out.print("Opción: ");
//                        gen = sc.nextInt();
//                        sc.nextLine(); // limpiar buffer
//                    } while (gen < 1 || gen > Genero.values().length);
//
//                    genero = Genero.values()[gen - 1];
//


                    System.out.println("¿Esta alquilada? (true/false):) ");
                    boolean alquilada = sc.nextBoolean();

                    Pelicula p = new Pelicula(titulo, genero, alquilada);
                    nuevoUsuario.agregarPelicula(p);
                    System.out.println("Película agregada correctamente.");

                    break;
                case "3":
                    System.out.println();
                    break;
                case "4":
                    System.out.println();
                    break;
                case "5":

                    break;
                case "6":

                    break;
                case "7":

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

}
