import java.util.Scanner;

public class E6 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el valor de N (longitud del array): ");
        int n = sc.nextInt();
        System.out.println("Introduce el valor de M (valor que rellena el array): ");
        int m = sc.nextInt();

        int [] valores = new int[n];

        for (int i = 0; i < valores.length; i++) {
            valores[i] = m;
        }
        System.out.println("El array con el valor M en todas sus posiciones es: ");
        for (int i = 0; i < valores.length; i++) {
            System.out.print(valores[i] + " ");
        }



    }
}
