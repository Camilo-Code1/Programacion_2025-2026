import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String menu = "\n1. Añadir coche.\n" +
                "2. Eliminar coche.\n" +
                "3. Mostrar coches.\n" +
                "4. Salir. ";

        String opcion = "";

        do {
            sc = new Scanner(System.in);

            System.out.println(menu);
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":

                    System.out.println("A");

                    break;
                case "2":

                    System.out.println("B");

                    break;
                case "3":

                    System.out.println("C");

                    break;
                case "4":
                    break;

            }

        } while (!opcion.equals("4"));


    }
}