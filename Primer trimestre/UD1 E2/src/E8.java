import java.util.Scanner;

public class E8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese un numero");
        int numero = sc.nextInt();

        int factorial = 1;
        for (int i = 1; i <= numero; i++) {
            factorial = factorial * i;
        }
        System.out.println("el factorial es: " + factorial);

    }
}
