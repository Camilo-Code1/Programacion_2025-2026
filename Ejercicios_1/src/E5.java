import java.util.Scanner;

public class E5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double diametroCir = 3.14;
        double volumenCir;

        System.out.print("Ingrese el volumen: ");
        volumenCir = sc.nextDouble();

        double operacion = diametroCir * 2 * volumenCir;

        System.out.println("El area del circulo es: " + operacion);



    }
}
