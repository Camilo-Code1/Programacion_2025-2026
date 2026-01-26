import java.util.ArrayList;
import java.util.Scanner;

public class E6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList <Gato> nuevoGato = new ArrayList<Gato>();

        try {



            for (int i = 1; i <= 5; i++) {
                sc = new Scanner(System.in);
                System.out.println("Introduce el nombre del gato: ");
                String nombre  = sc.nextLine();
                System.out.println("Introduce la edad del gato: ");
                int edad = sc.nextInt();

                nuevoGato.add(new Gato(nombre, edad));

            }


        } catch (Exception e) {
            System.out.println("\nError: " + e.getMessage());
        }

        for (Gato gato : nuevoGato) {
            System.out.println(gato);
        }



    }
}
