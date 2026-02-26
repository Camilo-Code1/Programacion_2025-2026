import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String menu = "1. Mostrar productos en el Inventario.\n" +
                "2. Eliminar Producto por referencia. \n" +
                "3. Guardar y salir.\n" +
                "4. Registrar producto en el inventario. \n";

        String opcion = "";

        do {
            System.out.println(menu);
            opcion = sc.nextLine();
        } while (!opcion.equals("3"));



    }
}