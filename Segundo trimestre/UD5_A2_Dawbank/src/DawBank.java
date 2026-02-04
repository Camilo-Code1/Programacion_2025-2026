import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class DawBank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String menu = "\n1. Datos de la cuenta.\n" +
                "2. IBAN.\n" +
                "3. Titular.\n" +
                "4. Saldo.\n" +
                "5. Ingreso.\n" +
                "6. Retirada. \n" +
                "7. Movimientos. \n" +
                "8. Salir.  ";

        System.out.print("Bienvenido a DawBank (Presione intro para continuar)");
        sc.nextLine();

        String nombre = obtenerTextoNoVacio("Nombre del cliente:", sc);
        String dni = obtenerDniValido(sc);
        LocalDate fechaNacimiento = obtenerFechaValida(sc);
        String telefono = obtenerTelefonoValido(sc);
        String email = obtenerEmailValido(sc);

        sc = new Scanner(System.in);

        String direccion = obtenerTextoNoVacio("Dirección:", sc);

        sc = new Scanner(System.in);

        Cliente cliente = new Cliente(nombre, dni, fechaNacimiento, telefono, email, direccion);

        String iban = obtenerIbanValido(sc);
        CuentaBancaria nuevaCuenta = new CuentaBancaria(iban, cliente, 0);

        String opcion;
        do {

            System.out.println(menu);
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println(nuevaCuenta);
                    break;

                case "2":
                    System.out.println("El IBAN de la cuenta es: " + iban);
                    break;

                case "3":
                    System.out.println("El dueño de la cuenta es: " + cliente);
                    break;

                case "4":
                    System.out.println("El saldo de la cuenta es: " + nuevaCuenta.getSaldo());
                    break;

                case "5":
                    realizarIngreso(nuevaCuenta, sc);
                    break;

                case "6":
                    realizarRetirada(nuevaCuenta, sc);
                    break;

                case "7":
                    nuevaCuenta.mostrarMovimientos();
                    break;

                case "8":
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida");
                    break;
            }

        } while (!opcion.equals("8"));
    }


    private static void realizarIngreso(CuentaBancaria nuevaCuenta, Scanner sc) {

        System.out.print("Inserte la cantidad a ingresar: ");
        double cantidadIngresada = sc.nextDouble();
        nuevaCuenta.Ingreso(cantidadIngresada);
    }

    private static void realizarRetirada(CuentaBancaria nuevaCuenta, Scanner sc) throws MinimoCuenta {

        try {
            System.out.print("Inserte la cantidad a retirar: ");
            double cantidadRetirada = sc.nextDouble();
            nuevaCuenta.Retiro(cantidadRetirada);
        } catch (Exception e){
            System.out.println("\nError: " + e.getMessage());
        }

    }

    private static String obtenerIbanValido(Scanner scanner){
        String IBAN = scanner.nextLine();
        while (true) {
            System.out.println("Ingrese el IBAN de la cuenta (Formato: XX0000000000000000000000): ");
            IBAN = scanner.nextLine();
            if (validarIBAN (IBAN)) {
                return IBAN;
            }
            System.out.println("IBAN inválido. Por favor, inténtelo de nuevo");
        }
    }

    private static boolean validarIBAN(String IBAN) {
        return IBAN.matches("[A-Z]{2}\\d{22}");
    }

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
    private static String obtenerDniValido(Scanner sc) {
        while (true) {
            System.out.print("\nDNI (7 u 8 dígitos): ");
            String dni = sc.nextLine();

            if (dni.matches("\\d{7,8}")) {
                return dni;
            }
            System.out.println("DNI inválido.");
        }
    }
    private static String obtenerTelefonoValido(Scanner sc) {
        while (true) {
            System.out.print("\nTeléfono (9 dígitos): ");
            String tel = sc.nextLine();

            if (tel.matches("\\d{9}")) {
                return tel;
            }
            System.out.println("Teléfono inválido.");
        }
    }
    private static String obtenerEmailValido(Scanner sc) {
        while (true) {
            System.out.print("\nEmail (Ejemplo: usuario@gmail.com): ");
            String email = sc.nextLine();

            if (email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                return email;
            }
            System.out.println("Email inválido.");
        }
    }
}






