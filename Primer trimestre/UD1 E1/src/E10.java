import java.util.Scanner;

public class E10 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double valor1;
        double valor2;
        double valor3;

        System.out.print("Ingrese el primer valor: ");
        valor1 = sc.nextDouble();

        System.out.print("Ingrese el segundo valor: ");
        valor2 = sc.nextDouble();

        System.out.print("Ingrese el tercer valor: ");
        valor3 = sc.nextDouble();

        double mayorPrimeraParte = Math.max(valor1, valor2);
        double mayorSegundaParte = Math.max(mayorPrimeraParte, valor3);

        System.out.print("El mayor valor: " + mayorSegundaParte);

    }
}
