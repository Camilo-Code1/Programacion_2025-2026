import java.util.Scanner;

public class E12 {
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        double valor1;
        double valor2;

        System.out.println("Ingresa el primer valor: ");
        valor1 = leer.nextDouble();

        System.out.println("Ingresa el segundo valor: ");
        valor2 = leer.nextDouble();

        double mayor = Math.max(valor1, valor2);

        System.out.println("El mayor valor: " + mayor);




    }
}
