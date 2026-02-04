import java.time.LocalDate;
import java.util.Scanner;

public class E13 {
    public static void main(String[] args) {

    }

    // -------------------------
    // MÉTODOS DE VALIDACIÓN
    // -------------------------

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

    private static int obtenerEnteroValido(String mensaje, Scanner sc) {
        while (true) {
            System.out.println(mensaje);
            String entrada = sc.nextLine();

            if (entrada.matches("\\d+")) {
                return Integer.parseInt(entrada);
            }
            System.out.println("Error: Debe ingresar un número entero válido.");
        }
    }

    private static double obtenerDoubleValido(String mensaje, Scanner sc) {
        while (true) {
            System.out.println(mensaje);
            String entrada = sc.nextLine();

            if (entrada.matches("\\d+(\\.\\d+)?")) {
                return Double.parseDouble(entrada);
            }
            System.out.println("Error: Debe ingresar un número válido (ej: 10.5).");
        }
    }

    private static LocalDate obtenerFechaValida() {
        Scanner sc = new Scanner(System.in);
        String fecha;

        while (true) {
            System.out.println("Ingrese la fecha (dd/MM/yyyy):");
            fecha = sc.nextLine();

            if (validarFecha(fecha)) {
                String[] p = fecha.split("/");
                int dia = Integer.parseInt(p[0]);
                int mes = Integer.parseInt(p[1]);
                int anio = Integer.parseInt(p[2]);

                // Validación adicional de rango
                if (dia >= 1 && dia <= 30 && mes >= 1 && mes <= 12) {
                    return LocalDate.of(anio, mes, dia);
                }
            }

            System.out.println("Fecha inválida. Intente de nuevo.");
        }
    }

    private static boolean validarFecha(String fecha) {
        // dd/MM/yyyy
        return fecha.matches("^\\d{2}/\\d{2}/\\d{4}$");
    }

}
