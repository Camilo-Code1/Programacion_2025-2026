import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Enlace nuevodDatos = new Enlace();

        nuevodDatos.cargatDatos();

        String menu = "\n1. Mostrar productos en el Inventario.\n" +
                "2. Eliminar Producto por referencia. \n" +
                "3. Guardar y salir.\n" +
                "4. Registrar producto en el inventario. \n";

        String opcion = "";

        do {
            sc = new Scanner(System.in);
            System.out.println(menu);
            opcion = sc.nextLine();

            switch (opcion){
                case "1":
                    nuevodDatos.mostrarProductos();
                    break;
                case "2":
                    nuevodDatos.mostrarProductosPorFiltrado();

                    System.out.println("Ingrese la referencia del producto a eliminar: ");
                    String referencia = sc.nextLine()
;
                    nuevodDatos.eliminarProducto(referencia);
                    break;
                case "3":
                    nuevodDatos.guardarInventario();
                    break;
                case "4":

                    sc = new Scanner(System.in);

                    System.out.println("Ingrese la referencia del producto: ");
                    referencia = sc.nextLine();

                    if (nuevodDatos.comprobarReferencia(referencia)){
                        break;
                }

                    System.out.println("Ingrese el nombre del producto: ");
                    String nombre = sc.nextLine();

                    System.out.println("Ingrese la descripción del producto: ");
                    String descripcion = sc.nextLine();

                    System.out.println("Ingrese el tipo de producto: ");
                    String tipo = sc.nextLine();

                    System.out.println("Ingrese la cantidad del producto: ");
                    int cantidad = sc.nextInt();

                    System.out.println("Ingrese el precio del producto: ");
                    double precio = sc.nextDouble();

                    System.out.println("Ingrese el descuento del producto: ");
                    int descuento = sc.nextInt();

                    System.out.println("Ingrese el IVA del producto: ");
                    int iva = sc.nextInt();

                    System.out.println("¿Esta el descuento aplicado?");
                    boolean aplicardto = sc.nextBoolean();

                    nuevodDatos.registrarProducto(referencia, nombre, descripcion, tipo, cantidad, precio, descuento, iva, aplicardto);

                    break;
            }


        } while (!opcion.equals("3"));



    }
}