import java.util.Scanner;

public class E8 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double valor1;
        double valor2;

        System.out.print("Por favor inserte el primer valor: ");
        valor1 = sc.nextDouble();

        System.out.print("Por favor inserte el segundo valor: ");
        valor2 = sc.nextDouble();

        System.out.print("El orden en ascenderte segun los valores insertados es: ");

        if  (valor1 > valor2) {
            System.out.print(valor2 + ", "  + valor1);
        }
        else if  (valor1 < valor2) {
            System.out.print(valor1 + ", "  + valor2);
        }

    }
}
