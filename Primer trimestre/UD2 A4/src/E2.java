import java.util.Scanner;

public class E2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double valores [] = new double [10];

        double suma = 0;

        for (int i = 0; i < valores.length; i++){
            System.out.println("Ingrese el valor de la lista "+(i+1)+":");
            valores[i] = sc.nextDouble();
            suma = suma + valores[i];
        }

        System.out.println("La suma es: ");

            System.out.print(suma +" ");




    }
}
