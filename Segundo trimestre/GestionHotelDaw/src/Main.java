import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Gestion nuevos = new Gestion();

        String menu = "\n1. Registrar huésped.\n" +
                "2. Crear habitación\n" +
                "3. Ver huéspedes registrados.\n" +
                "4. Ver habitaciones.\n" +
                "5. Asignar habitación a huésped.\n" +
                "6. Liberar habitación (checkout).\n" +
                "7. Eliminar huésped.\n" +
                "8. Eliminar habitación.\n" +
                "9. Guardar y salir.";

        String opcion = "";
        String id;

        do {
            System.out.println(menu);
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("Ingres el ID del huesped:");
                    id = sc.nextLine();

                    System.out.println("Ingrese el nombre del huesped:");
                    String nombre = sc.nextLine();

                    System.out.println("Ingrese la edad del huesped: ");
                    int edad = sc.nextInt();

                    System.out.println("Ingrese el numero telefonico del huesped: ");
                    String telefono = sc.nextLine();

                    System.out.println("Ingrse la nacionalidad del huesped: ");
                    String nacionalidad = sc.nextLine();

                    Huesped nuev = new Huesped(id, nombre, edad, telefono, nacionalidad);

                    break;
                case "2":
                    break;
                case "3":
                    nuevos.mostrarPersonas();
                    break;
                case "4":
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "7":
                    break;
                case "8":
                    break;
                case "9":
                    break;
            }
        } while (!opcion.equals("9"));

    }
}