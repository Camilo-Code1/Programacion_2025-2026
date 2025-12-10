import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;

public class Gestion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String menu = "1. Crear persona\n" +
                "2. Registrar trabajador en empresa\n" +
                "3. Mostrar información general de la empresa\n" +
                "4. Mostrar el numero de trabajadores actuales\n" +
                "5. Mostrar información de todos los trabajadores\n" +
                "6. Eliminar trabajador de la empresa\n" +
                "7. Eliminar persona del programa\n" +
                "8. Salir de la aplicación";

        String opcion = "";

        Empresa nuevoUsuario;
        ArrayList<Trabajador> personasTemporales = new ArrayList<>();

        System.out.print("Bienvenido a Dawbank (Presione intro para continuar)");
        System.out.println("\nIngrese el nombre de la empresa: ");
        String nombreEmp = sc.nextLine();

        String cif = obtenerCIFValido().toUpperCase();

        nuevoUsuario = new Empresa(nombreEmp, cif);

        do {
            sc = new Scanner(System.in);

            System.out.println();
            System.out.println(menu);
            System.out.println();

            opcion = sc.nextLine();

            switch (opcion) {

                case "1":
                    System.out.println("Ingrese el nombre de la persona: ");
                    String nombre = sc.nextLine();

                    LocalDate fechaNacimiento;

                    while (true) {
                        fechaNacimiento = obtenerFechaValida();

                        if(esMayorDeEdad(fechaNacimiento)) {
                            break;
                        } else {
                            System.out.println("Error: El cliente debe de ser mayor de edad");
                        }
                    }

                    String dni = obtenerDNIValido();

                    System.out.println("Ingrese la direccion de la persona: ");
                    String direccion = sc.nextLine();

                    String numeroSS = obtenerNumSS();

                    Trabajador t = new Trabajador(nombre, fechaNacimiento, dni, direccion, numeroSS);
                    personasTemporales.add(t);

                    break;


                case "2":
                    if (personasTemporales.isEmpty()) {
                        System.out.println("No hay personas creadas para registrar.");
                        continue;
                    }

                    System.out.println("Personas disponibles para registrar:");
                    for (int i = 0; i < personasTemporales.size(); i++) {
                        Trabajador tra = personasTemporales.get(i);
                        System.out.println(i + ". " + tra.getNombre() + " - " + tra.getDni());
                    }

                    int index = leerIndiceValido(sc, personasTemporales.size());

                    Trabajador trabajadorRegistrar = personasTemporales.get(index);

                    nuevoUsuario.agregarTrabajador(trabajadorRegistrar);
                    personasTemporales.remove(index);

                    System.out.println("¡Trabajador registrado con éxito!");
                    break;


                case "3":
                    System.out.println(nuevoUsuario.mostrarinfoEmpresa());
                    break;


                case "4":
                    System.out.println("\nEl número de trabajadores actuales es: " + nuevoUsuario.getNumTrabajadores());
                    break;


                case "5":
                    nuevoUsuario.mostrarTrabajadores();
                    break;


                case "6":
                    nuevoUsuario.eliminarTrabajador();
                    break;


                case "7":
                    if (personasTemporales.isEmpty()) {
                        System.out.println("No hay personas temporales para eliminar.");
                        break;
                    }

                    System.out.println("Personas disponibles para eliminar:");
                    for (int i = 0; i < personasTemporales.size(); i++) {
                        Trabajador tra = personasTemporales.get(i);
                        System.out.println(i + ". " + tra.getNombre() + " - " + tra.getDni());
                    }

                    int inde = leerIndiceValido(sc, personasTemporales.size());

                    Trabajador trabajadorEliminar = personasTemporales.remove(inde);
                    System.out.println("¡La persona " + trabajadorEliminar.getNombre() + " ha sido eliminada con éxito!");
                    break;


                case "8":
                    System.out.println("Aviso: Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }

        } while (!opcion.equals("8"));
    }



    private static int leerIndiceValido(Scanner sc, int limite) {
        int numero = -1;

        do {
            System.out.print("Ingrese un número válido: ");
            String entrada = sc.nextLine();

            if (!entrada.matches("\\d+")) {
                System.out.println("Error: Debe ingresar un número entero.");
                continue;
            }

            numero = Integer.parseInt(entrada);

            if (numero < 0 || numero >= limite) {
                System.out.println("Error: Índice fuera de rango.");
            }

        } while (numero < 0 || numero >= limite);

        return numero;
    }


    // VALIDADORES


    private static String obtenerCIFValido() {
        Scanner sc = new Scanner(System.in);
        String cif;
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

    private static String obtenerDNIValido() {
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
                int annio = Integer.parseInt(partes[2]);

                return LocalDate.of(annio, mes, dia);
            }

            System.out.println("Fecha inválida. Por favor vuelva a intentarlo.");
        }
    }

    private static boolean validarFecha(String fecha) {
        return fecha.matches("^\\d{2}-\\d{2}-\\d{4}$");
    }

    private static String obtenerNumSS() {
        Scanner sc = new Scanner(System.in);
        String numeroSS;
        while (true) {
            System.out.println("Ingrese el número de seguridad social (Ejemplo: 280123456701)");
            numeroSS = sc.nextLine().toUpperCase();
            if (validarNSS(numeroSS)) {
                System.out.println("\nNúmero admitido correctamente.");
                return numeroSS;
            }
            System.out.println("NSS inválido. Intente nuevamente.");
        }
    }

    private static boolean validarNSS(String nss) {
        return nss.matches("^\\d{12}$");
    }

    private static boolean esMayorDeEdad(LocalDate fechaNacimiento) {
        int edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
        return edad >= 18;
    }
}
