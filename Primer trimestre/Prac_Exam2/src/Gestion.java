import java.time.LocalDate;
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

        System.out.print("Bienvenido a Dawbank" +
                " (Presione intro para continuar)");

        System.out.println("\nIngrese el nombre de la empresa: ");
        String nombreEmp = sc.nextLine();

        String cif = obtenerCIFValido().toUpperCase();

        nuevoUsuario = new Empresa(nombreEmp, cif);

        do {
            sc = new Scanner(System.in);

            System.out.println("");
            System.out.println(menu);
            System.out.println("");

            opcion = sc.nextLine();

            switch (opcion) {
                case "0":

                    break;
                case "1":
                    System.out.println("Ingrese el nombre de la persona: ");
                    String nombre = sc.nextLine();

                    LocalDate fechaNacimiento = obtenerFechaValida();

                    String dni = obtenerDNIValido();

                    System.out.println("Ingrese la direccion de la persona: ");
                    String direccion = sc.nextLine();

                    String numeroSS = obtenerNumSS();

                    Trabajador t = new Trabajador(nombre, fechaNacimiento, dni, direccion,numeroSS);
                    personasTemporales.add(t);

                    break;
                case "2":
                    if (personasTemporales.isEmpty()) {
                        System.out.println("No hay personas creadas para poder registrar");
                        return;
                    }
                    System.out.println("Personas disponibles para registrar: ");
                    for (int i = 0; i < personasTemporales.size(); i++) {
                        Trabajador tra = personasTemporales.get(i);
                        System.out.println(i + ", " + tra.getNombre() + " - " + tra.getDni());
                    }

                    System.out.println("Seleccione el índice de la persona a registrar: ");
                    int index = Integer.parseInt(sc.nextLine());

                    if (index < 0 || index >= personasTemporales.size()) {
                        System.out.println("Índice inválido.");
                        break;
                    }

                    Trabajador trabajadorRegistrar = personasTemporales.get(index);

                    // REGISTRAR EN LA EMPRESA
                    nuevoUsuario.agregarTrabajador(trabajadorRegistrar);

                    // ELIMINAR DE TEMPORALES
                    personasTemporales.remove(index);

                    System.out.println("\n¡Trabajador registrado con éxito!");
                    break;
                case "3":
                    System.out.println(nuevoUsuario.mostrarinfoEmpresa());
                    break;
                case "4":
                    nuevoUsuario.mostrarTrabajadores();
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "7":
                    break;
                case "8":
                    break;
                case "9":
                    break;

            }

        } while (!opcion.equals("8"));


    }

    private static String obtenerCIFValido () {
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

    private static String obtenerNumSS () {
        Scanner sc = new Scanner(System.in);
        String numeroSS;
        while (true) {
            System.out.println("Ingrese el numero de la seguridad social de la persona (Ejemplo: 280123456701)");
            numeroSS = sc.nextLine().toUpperCase();
            if (validarNSS(numeroSS)) {
                System.out.println("\nNumero de la seguridad social admitido correctamente.");
                return numeroSS;
            }
            System.out.println("NSS invalido. Por favor vuelva a intentarlo.");
        }
    }

    private static boolean validarNSS(String nss) {
        return nss.matches("^\\d{12}$");
    }

}