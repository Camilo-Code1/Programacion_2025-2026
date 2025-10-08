import java.util.Scanner;

public class E6 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double precioArt;
        double precioReal;

        double obtenerValor;
        double porcentajeDes;

        System.out.print("Ingresa el precio del articulo: ");
        precioArt = sc.nextDouble();

        System.out.print("Ingresa el precio real del articulo: ");
        precioReal = sc.nextDouble()
;
        double diferencia = precioReal - precioArt;

        obtenerValor = diferencia/precioReal;
        porcentajeDes = obtenerValor * 100;

        System.out.println("El valor del articulo es: " + porcentajeDes + "%");




    }
}
