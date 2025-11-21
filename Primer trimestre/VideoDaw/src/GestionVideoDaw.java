import java.util.Scanner;

public class GestionVideoDaw {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String menu = "\n1. Crear y registrar VideoClub en la franquicia.\n" +
                "2. Registrar película en videoclub.\n" +
                "3. Crear y registrar cliente en videoclub.\n" +
                "4. Alquilar película.\n" +
                "5. Devolver película.\n" +
                "6. Dar de baja cliente.\n" +
                "7. Dar de baja película.\n" +
                "8. Salir.";

        String opcion = "";

        do {
            sc = new Scanner(System.in);

            System.out.print("");
            System.out.println(menu);
            System.out.print("");

            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println();
                    break;
                case "2":
                    System.out.println();
                    break;
                case "3":
                    System.out.println();
                    break;
                case "4":
                    System.out.println();
                    break;
                case "5":

                    break;
                case "6":

                    break;
                case "7":

                    break;
                case "8":
                    System.out.println("\nAviso: Saliendo del sistema.");
                    break;
                default:
                    System.out.print("\nOpción invalida. Por favor vuelva a intentarlo.");
                    break;
            }


        } while (!opcion.equals("8"));




    }


}
