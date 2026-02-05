import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String menu = "1. Crear producto.\n" +
                "2. Mostrar productos existentes.\n" +
                "3. Eliminar productos por codigo.\n" +
                "4. Guardar productos en el fichero.\n" +
                "5. Salir";

        String opcion = "";

        do {
            System.out.println(menu);
            opcion = sc.next();

            switch (opcion){
                case "1":
                    System.out.println("1");
                    break;
                case "2":
                    System.out.println("2");
                    break;
                case "3":
                    System.out.println("3");
                    break;
                case "4":
                    System.out.println("4");
                    break;
                case "5":
                    System.out.println("5");
                    break;


            }
        } while (!opcion.equals("5"));






    }
}