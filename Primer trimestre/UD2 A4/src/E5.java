import java.util.Scanner;

public class E5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double valores []  = new double [20];

        for (int i = 0; i < valores.length; i++){
            System.out.println("Introduce el valor: "+ (i+1)+": ");
            valores[i] = sc.nextDouble();
        }

        double suma = 0;
        double media = 0;

        for (int i = 0; i < valores.length; i++){
            suma += valores[i];
            media =  suma / valores.length;
        }

        System.out.println("La suma de los numeros es: " + suma);
        System.out.println("La media de los numeros es: " + media);
    }
}
