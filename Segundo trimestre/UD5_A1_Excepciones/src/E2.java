import java.util.InputMismatchException;
import java.util.Scanner;

public class E2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {

            System.out.println("Introduce el primer valor: ");
            int a = sc.nextInt();
            System.out.println("Introduce el segundo valor: ");
            int b = sc.nextInt();

            int resultado = a/b;

            System.out.println("El resultado es: " + resultado);

        } catch(InputMismatchException | ArithmeticException e) {

            e.printStackTrace();

        } finally{

            System.out.println("\nPrograma finalizado");

        }



    }
}
