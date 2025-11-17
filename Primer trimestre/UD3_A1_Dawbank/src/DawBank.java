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
                "6. Retirada.\n" +
                "7. Movimientos.\n" +
                "8. Salir.";

        String opcion = "";

//        CuentaBancaria nuevoUsuario = new CuentaBancaria("ES6621000418401234567891", "Aitor Gutierrez", 30);

        CuentaBancaria nuevoUsuario;
        Movimiento mov;

        String iban = "";
        String titular = "";
        double saldo = 0;

        System.out.print("Bienvenido a Dawbank" +
                " (Presione intro para continuar)");

        iban = obtenerIbanValido(sc);
        System.out.println("Ingrese el titular de la cuenta: ");
        titular  = sc.nextLine();

        nuevoUsuario = new CuentaBancaria(iban, titular, saldo);


        do {
            sc = new Scanner(System.in);

            System.out.print("");
            System.out.println(menu);
            System.out.print("");

            opcion = sc.nextLine();

            switch (opcion) {
                case "1":

                    System.out.println(nuevoUsuario.infoCuentaBancaria());

                    break;
                case "2":
                    System.out.println("IBAN: " + nuevoUsuario.getIban());
                    break;
                case "3":
                    System.out.println("Titular: " + nuevoUsuario.getTitular());
                    break;
                case "4":
                    System.out.println("Saldo: " + nuevoUsuario.getSaldo());
                    break;
                case "5":
                    realizarIngreso(nuevoUsuario);
                    break;
                case "6":
                    realizarRetirada(nuevoUsuario);
                    break;
                case "7":
                    nuevoUsuario.MostrarMovimientos();
                    break;
                case "8":
                    System.out.println("Aviso: Saliendo del sistema.");
                    break;
                default:
                    System.out.print("Opción invalida. Por favor vuelva a intentarlo.");
                    break;

            }



        } while (!opcion.equals("8"));

    }

    private static void realizarIngreso(CuentaBancaria nuevoUsuario) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Inserte la cantidad a ingresar: ");
        double cantidadIngresada = sc.nextDouble();
        nuevoUsuario.Ingreso(cantidadIngresada);
    }

    private static void realizarRetirada(CuentaBancaria nuevoUsuario) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Inserte la cantidad a retirar: ");
        double cantidadRetirada = sc.nextDouble();
        nuevoUsuario.Retiro(cantidadRetirada);
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
}