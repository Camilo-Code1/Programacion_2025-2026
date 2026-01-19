import java.util.InputMismatchException;
import java.util.Scanner;

public class E1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Introduce un valor: ");
            int valor = sc.nextInt();

        } catch (InputMismatchException e) {
            System.out.println("\nValor introducido incorrecto");
            System.out.println("Error: " + e.getMessage());

        }

    }
}