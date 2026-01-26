import java.util.Scanner;

public class E5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Gato nuevoGato;

        try {
            System.out.print("Introduce el nombre del gato: ");
            String nombre  = sc.nextLine();
            System.out.print("Introduce la edad del gato: ");
            int edad = sc.nextInt();

            Gato nuevoGato1 = new Gato(nombre, edad);

        } catch (Exception e) {
            System.out.println("\nError: " + e.getMessage());
        }


    }

}
