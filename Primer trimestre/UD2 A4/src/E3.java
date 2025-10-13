import java.util.Scanner;

public class E3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double valores [] = new double [10];

        for (int i = 0; i < valores.length; i++){
            System.out.println("Ingrese el valor de la lista "+(i+1)+":");
            valores[i] = sc.nextDouble();
        }


        double maximo = valores[0];
        double minimo = valores[0];


        for (int i = 1; i < valores.length; i++){
                if  (valores[i] > maximo){
                    maximo = valores[i];
                }
                if  (valores[i] < minimo){
                    minimo = valores[i];
                }
        }

        System.out.println("\nEl numero maximo es:  " + maximo);
        System.out.println("El numerEno minimo es:  " + minimo);

    }
}
