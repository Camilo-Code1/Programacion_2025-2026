import java.util.Arrays;


public class E11 {
    public static void main(String[] args) {

        int [] bucle_1 = new int [100];


        for  (int i = 0; i < bucle_1.length; i++) {
            bucle_1[i] = i + 1;
        }

        int [] bucle_2 = new int [bucle_1.length];

        System.out.println("Numeros de bucle 1: ");
        for(int i = 0; i < bucle_1.length; i++) {
            System.out.print(bucle_1[i] + " ");
            bucle_2[i] = bucle_1[bucle_1.length - 1 - i];
        }


        System.out.println(" ");

        System.out.println("\nNumeros de bucle 2: ");
        for(int i = 0; i < bucle_2.length; i++) {
            System.out.print(bucle_2[i] + " ");
        }
    }
}
