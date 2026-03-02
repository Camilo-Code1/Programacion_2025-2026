import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class GestionMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String menu = "1. Crear y registrar plataforma en franquincia. \n" +
                "2. Registar articulo (Pelicula o Videojuego).\n" +
                "3. Registrar cliente.\n" +
                "4. Alquilar articulo. \n" +
                "5. Devolver articulo. \n" +
                "6. Dar de baja cliente.\n" +
                "7. Dar de baja articulo. \n" +
                "8. Mostrar todos los artículos.\n" +
                "9. Mostrar todos los clientes. \n" +
                "10. Salir. \n";

        String opcion = "";

        do {
            System.out.println(menu);
            opcion = sc.nextLine();
            switch (opcion) {

            }
        } while (!opcion.equals("10"));





    }
}