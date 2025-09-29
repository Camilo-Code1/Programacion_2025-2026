import java.util.Scanner;

public class E13 {
    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        double valor;

        System.out.println("Ingresa un valor para el numero: ");
        valor = leer.nextDouble();

        if (valor <= -1) {
            System.out.println("El valor introducido no es positivo");
        }  else if (valor >= 0) {
            System.out.println("El valor introducido es positivo");
        }


    }
}
