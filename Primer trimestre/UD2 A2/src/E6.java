import java.util.Scanner;

public class E6 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numero;

        System.out.println("Ingrese un numero hasta donde contar: ");
        numero = sc.nextInt();

        System.out.println("");
        for  (int i = 1; i <= numero; i++) {
            System.out.println(i);
        }

    }
}
