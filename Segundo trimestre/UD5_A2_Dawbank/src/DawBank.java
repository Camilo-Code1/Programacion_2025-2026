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

        String opcion = "";

        CuentaBancaria nuevaCuenta;

        System.out.print("Bienvenido a Dawbank" +
                " (Presione intro para continuar)");

        String iban = obtenerIbanValido(sc);

        System.out.println("Ingrese el titular de la cuenta: ");
        String titular = sc.nextLine();

        double saldo = 0;

        nuevaCuenta = new CuentaBancaria(iban, titular, saldo);

        do {
            sc = new Scanner(System.in);
            System.out.print("");
            System.out.println(menu);
            System.out.print("");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":

                    System.out.println(nuevaCuenta);

                    break;
                case "2":

                    System.out.println("El IBAN de la cuenta es: " + iban);

                    break;
                case "3":

                    System.out.println("El Titular de la cuenta es: " + titular);

                    break;
                case "4":

                    System.out.println("El saldo de la cuenta es: " + nuevaCuenta.getSaldo());

                    break;
                case "5":

                    realizarIngreso(nuevaCuenta);
                    break;

                case "6":

                    realizarRetirada(nuevaCuenta);
                    break;
                case "7":

                    nuevaCuenta.mostrarMovimientos();

                    break;
                case "8":


                    break;
            }
        } while (!opcion.equals("8"));






    }


    private static void realizarIngreso(CuentaBancaria nuevaCuenta) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Inserte la cantidad a ingresar: ");
        double cantidadIngresada = sc.nextDouble();
        nuevaCuenta.Ingreso(cantidadIngresada);
    }

    private static void realizarRetirada(CuentaBancaria nuevaCuenta) throws MinimoCuenta {
        Scanner sc = new Scanner(System.in);

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


}