import java.util.Scanner;

public class E2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

            String opcion = "";

            double valor1;
            double valor2;

            do {
                sc = new Scanner(System.in);

                System.out.println("\n1. Sumar\n" +
                        "2. Restar\n" +
                        "3. Multiplicar\n" +
                        "4. Dividir\n" +
                        "5. Salir");
                System.out.print("");
                opcion = sc.nextLine();

                switch (opcion) {
                    case "1":
                        sc = new Scanner(System.in);

                        System.out.println("Ingresa el valor del primer numero: ");
                        valor1 = sc.nextDouble();

                        System.out.println("Ingresa el valor del segundo numero: ");
                        valor2 = sc.nextDouble();

                        double suma = valor1 + valor2;

                        System.out.println("\nEl resultado es: " + suma);
                        break;

                    case "2":
                        sc = new Scanner(System.in);

                        System.out.println("Ingresa el valor del primer numero: ");
                        valor1 = sc.nextDouble();

                        System.out.println("Ingresa el valor del segundo numero: ");
                        valor2 = sc.nextDouble();

                        double resta = valor1 - valor2;

                        System.out.println("\nEl resultado es: " + resta);
                        break;

                    case "3":
                        sc = new Scanner(System.in);

                        System.out.println("Ingresa el valor del primer numero: ");
                        valor1 = sc.nextDouble();

                        System.out.println("Ingresa el valor del segundo numero: ");
                        valor2 = sc.nextDouble();

                        double multiplicacion = valor1 * valor2;
                        System.out.println("\nEl resultado es: " + multiplicacion);
                        break;

                    case "4":
                        sc = new Scanner(System.in);

                        System.out.println("Ingresa el valor del primer numero: ");
                        valor1 = sc.nextDouble();

                        System.out.println("Ingresa el valor del segundo numero: ");
                        valor2 = sc.nextDouble();

                        double division = valor1 / valor2;

                        System.out.println("\nEl resultado es: " + division);
                        break;

                    case "5":
                        sc = new Scanner(System.in);

                        System.out.println("\nSaliendo del programa. Hasta pronto");
                        break;

                    default:
                        System.out.print("\nOpcion invalida. Por favor, intentelo de nuevo");
                        break;

                }

            } while (!opcion.equals("5"));




    }
}
