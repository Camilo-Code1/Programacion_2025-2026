import java.time.LocalDate;
import java.util.Scanner;

public class World {

    static String execute(String mensaje, Scanner me) {
        String entrada;
        do {
            System.out.println(mensaje);
            entrada = me.nextLine().trim();

            if (entrada.isEmpty()) {
                System.out.println("Error: El campo no puede quedar vacío.");
            }
        } while (entrada.isEmpty());
        return entrada;
    }

    private int obtenerEnteroValido(String mensaje, Scanner me) {
        while (true) {
            System.out.println(mensaje);
            String entrada = me.nextLine();

            if (entrada.matches("\\d+")) {
                return Integer.parseInt(entrada);
            }
            System.out.println("Error: Debe ingresar un número entero válido.");
        }
    }

    private double obtenerDoubleValido(String mensaje, Scanner me) {
        while (true) {
            System.out.println(mensaje);
            String entrada = me.nextLine();

            if (entrada.matches("\\d+(\\.\\d+)?")) {
                return Double.parseDouble(entrada);
            }
            System.out.println("Error: Debe ingresar un número válido (ej: 10.5).");
        }
    }


}
