import java.util.Scanner;

public class E7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el valor de N (longitud del array): ");
        int p = sc.nextInt();

        int [] valores = new int[p];


        System.out.println("Introduzca los valores del array: ");
        for (int i = 0; i < valores.length; i++) {
            System.out.print(valores[i] + (i+1) + ": ");
            valores[i] = sc.nextInt();

        }
        System.out.println("Los numeros que hay en el array son: ");
        for (int i = 0; i < valores.length; i++){
            System.out.print(valores[i]+" ");
        }

    }
}
