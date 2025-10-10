import java.util.Scanner;

public class E7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int nota;

        System.out.println("Ingrese su califacion final (1-10): ");
        nota = sc.nextInt();

        if (nota < 3) {
            System.out.println("Muy deficiente");
        } else if (nota < 5) {
            System.out.println("Insuficiente");
        } else if (nota < 6) {
            System.out.println("Bien");
        } else if (nota < 9) {
            System.out.println("Notable");
        } else if (nota<=10) {
            System.out.println("Sobresaliente");
        }

    }
}
