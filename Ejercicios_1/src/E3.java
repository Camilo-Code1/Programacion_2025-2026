import java.util.Scanner;

public class E3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Por favor ingrese el valor de un lado de un cuadrado para calcular su area: ");
        double lado = sc.nextDouble();

        System.out.println("El area del cuadrado es " + lado * lado);



    }
}
