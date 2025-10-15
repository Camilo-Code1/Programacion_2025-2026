import java.util.Random;
import java.util.Scanner;

public class E8 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double [] numerosAleatorios = new double [100];

        Random rand = new Random();

        for (int i = 0; i < numerosAleatorios.length; i++) {



            numerosAleatorios[i] = rand.nextDouble(2);
        }

        System.out.println("Los numeros almacenados en el array son: ");
        for (double num : numerosAleatorios) {
            System.out.println(num);
        }

        double r;
        double numerosSuperior = 0;

        System.out.println("\nIntroduzca el valor R (Entre 0 a 1): ");
        r = sc.nextDouble();

        System.out.println("\nNumeros mayores a R: ");
        boolean encontrado = false;
        for (double num : numerosAleatorios) {
        if (num > r) {
            System.out.println(num);
            encontrado = true;
        }
        }
        if (!encontrado) {
            System.out.println("No se encontraron numeros mayores a R");
        }
    }
}
