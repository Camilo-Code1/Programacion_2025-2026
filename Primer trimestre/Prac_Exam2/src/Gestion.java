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

        System.out.println("Ingrese el nombre de la empresa: ");
        String nombre = sc.nextLine();

        String cif = obtenerCIFValido().toUpperCase();

        nuevoUsuario = new Empresa(nombre, cif);

        do {
            sc.nextLine();

            System.out.println("");
            System.out.println(menu);
            System.out.println("");

            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println(nuevoUsuario.mostrarinfoEmpresa());
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
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
}