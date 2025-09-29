import java.util.Scanner;

public class E11 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double valor1;
        double valor2;

        System.out.print("\nPor favor ingrese el primer valor: ");
        valor1 = sc.nextDouble();

        System.out.print("Por favor ingrese el segundo valor: ");
        valor2 = sc.nextDouble();

        double suma  = valor1 + valor2;
        double resta = valor1 - valor2;
        double producto = valor1 * valor2;
        double division = valor1 / valor2;

        System.out.println("\nEl valor de la suma es: " + suma);
        System.out.println("El valor de la resta es: " + resta);
        System.out.println("El valor de la multiplicacion es: " + producto);
        System.out.println("El valor  de la division es: " + division);



    }
}
