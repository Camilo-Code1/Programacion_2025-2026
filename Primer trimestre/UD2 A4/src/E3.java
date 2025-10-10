import java.util.Scanner;

public class E3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double valores [] = new double [10];

        for (int i = 0; i < valores.length; i++){
            System.out.println("Ingrese el valor de la lista "+(i+1)+":");
            valores[i] = sc.nextDouble();
        }

        System.out.println("Los numeros que hay en el array son: ");
        for (int i = 0; i < valores.length; i++){
            Math.max(valores[i], valores[i+1]);
            Math.min(valores[i], valores[i+1]);
        }

    }
}
