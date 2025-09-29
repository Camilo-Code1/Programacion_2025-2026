import java.util.Scanner;

public class E9 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double valor1;
        double valor2;


        System.out.print("Ingrese el primer valor: ");
        valor1 = sc.nextDouble();

        System.out.print("Ingrese el segundo valor: ");
        valor2 = sc.nextDouble();

        double mayor = Math.max(valor1, valor2);


        if (valor1 == valor2) {
            System.out.print("\nLos valores son iguales");
        } else {
            System.out.println("El mayor valor: " + mayor);
        }

    }
}
