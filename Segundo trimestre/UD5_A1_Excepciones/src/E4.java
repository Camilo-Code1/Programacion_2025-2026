import java.util.Scanner;

public class E4 {
    public static void main(String[] args) {

        int valor;


        System.out.print("Introduce el valor: ");
        try {
            valor = new Scanner(System.in).nextInt();
            verificarValorNegativo(valor);
            verificarValorPositivo(valor);

        } catch (Exception e) {
            System.out.println("\nError: " + e.getMessage());
        }



    }

    public static void verificarValorNegativo (int valor) throws Exception{
        if (valor <= 0) {
            System.out.println("\nEl valor es negativo");
        }
    }

    public static void verificarValorPositivo (int valor) throws Exception {
        if (valor > 0) {
            System.out.println("\nEl valor no es negativo");
        }

    }
}
