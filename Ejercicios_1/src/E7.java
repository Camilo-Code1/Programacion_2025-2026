import java.util.Scanner;

public class E7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double millaMarina = 1852;

        double metrosAsig;

        System.out.print("Ingrese la distancia que ha recorrido en millas maritimas: ");
        metrosAsig = sc.nextDouble();

        double transforMillas = metrosAsig/ millaMarina;

        System.out.println("La transformacion a metros es: " + transforMillas);


    }
}
