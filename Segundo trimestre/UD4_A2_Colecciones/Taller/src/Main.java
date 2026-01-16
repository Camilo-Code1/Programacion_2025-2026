import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    String opcion = "";

    String color, marca;

    Taller nuevoTaller = new Taller();

    String menu = "\n1. Añadir coche.\n" +
            "2. Eliminar coche.\n" +
            "3. Mostrar coches.\n" +
            "4. Salir. \n";


    do {

        System.out.print(menu);
        opcion = sc.nextLine();

        switch (opcion) {
            case "1":

                color = obtenerTextoNoVacio("\nIngresa el color del coche: ", sc);


                marca = obtenerTextoNoVacio("\nIngresa la marca del coche: ", sc);

                nuevoTaller.agregarCoche(color, marca);
                break;

            case "2":
                if (nuevoTaller.coches.isEmpty()){
                    System.out.println("El taller esta vacio. ");
                } else {


                    marca = obtenerTextoNoVacio("\nIngresa la marca del coche: ", sc);

                    nuevoTaller.eliminarcoche(marca);

                    System.out.println("El coche ha sido eliminado exitosamente.");

                }

                break;

            case "3":

                if (nuevoTaller.coches.isEmpty()){
                    System.out.println("El taller esta vacio. ");
                } else {

                    nuevoTaller.mostrarCoches();

                }

                break;

            case "4":

                break;
        }
    } while(!opcion.equals("4"));


    }

    private static String obtenerTextoNoVacio(String mensaje, Scanner sc) {
        String entrada;
        do {
            System.out.println(mensaje);
            entrada = sc.nextLine().trim();

            if (entrada.isEmpty()) {
                System.out.println("Error: El campo no puede quedar vacío.");
            }
        } while (entrada.isEmpty());
        return entrada;
    }
}