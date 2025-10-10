import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class E1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

       double valores [] = new double [10];

        for (int i = 0; i < valores.length; i++){
            System.out.println("Ingrese el valor de la lista "+(i+1)+":");
            valores[i] = sc.nextDouble();
        }

        System.out.println("Los numeros que hay en el array son: ");
        for (int i = 0; i < valores.length; i++){
            System.out.print(valores[i]+" ");
        }

//
//        int [] numerosAleatorios = new int [10];
//
//        Random rand = new Random();
//
//        for (int i = 0; i < numerosAleatorios.length; i++) {
//            numerosAleatorios[i] = rand.nextInt(201);
//        }
//
//        System.out.println("Los numeros almacenados en el array son: ");
//        for (int num : numerosAleatorios) {
//            System.out.println(num);
//        }

    }
}