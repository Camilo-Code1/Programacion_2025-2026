import java.io.IOException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Enlace nuevoProducto = new Enlace();

        String menu = "\n1. Crear producto.\n" +
                "2. Mostrar productos existentes.\n" +
                "3. Mostrar productos por enviar.\n" +
                "4. Eliminar productos por código.\n" +
                "5. Guardar productos en el fichero. \n" +
                "6. Salir. ";

        String opcion = "";

        do {
            System.out.println(menu);
            opcion = sc.next();

            switch (opcion){
                case "1":
                    sc = new Scanner(System.in);

                    System.out.println("Inserte el codigo del producto (Ejemplo: PR-001): ");
                    String codigo = sc.nextLine();

                    System.out.println("Inserte el nombre del producto: ");
                    String nombre = sc.nextLine();

                    System.out.println("Introduzca la cantidad del producto: ");
                    int cantidad = sc.nextInt();

                    System.out.println("Inserte el precio del producto: ");
                    double precio = sc.nextDouble();

                    nuevoProducto.agregarProducto(codigo, nombre, cantidad, precio);


                    break;
                case "2":
                    try {
                        Enlace.leerMostrarContenido();
                    } catch (IOException e) {
                        System.out.println("Error: ");
                        e.printStackTrace();
                    }

                    break;
                case "3":
                    nuevoProducto.mostrarProductosPorEnviar();
                    break;
                case "4":

                    sc = new Scanner(System.in);

                    System.out.println("Introduce el código del producto a eliminar (ej: PR-003): ");
                    codigo = sc.nextLine();

                    nuevoProducto.borrarProductoPorCodigo(codigo);
                    break;
                case "5":
                    nuevoProducto.guardarProductosNuevos();
                    break;

                case "6":
                    System.out.println("5");
                    break;
            }
        } while (!opcion.equals("6"));






    }


}