import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class supFormatos {

    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public String obtenerTextoNoVacio(String mensaje, Scanner scanner) {
        String entrada;
        do {
            System.out.println(mensaje);
            entrada = scanner.nextLine().trim();

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

    public static LocalDate obtenerFechaValida(String fechaTexto) throws formatoInvalido {
        try {
            // LocalDate.parse ya valida bisiestos, días 31, etc.
            return LocalDate.parse(fechaTexto, FORMATO_FECHA);
        } catch (DateTimeParseException e) {
            throw new formatoInvalido("La fecha '" + fechaTexto + "' no tiene un formato real o válido (dd/MM/yyyy).");
        }
    }


    private static String obtenerCodBibliotecaValido() {
        Scanner sc = new Scanner(System.in);
        String codigo;

        while (true) {
            System.out.println("Ingrese el código de la biblioteca (Ej: ABC123):");
            codigo = sc.nextLine().toUpperCase();

            if (codigo.matches("^[A-Z]{3}\\d{3}$")) {
                return codigo;
            }
            System.out.println("Código inválido. Intente de nuevo.");
        }
    }

    public static String obtenerISBNValido(String isbn) throws formatoInvalido {
        if (isbn.matches("^\\d{13}$")) {
            return isbn;
        }
        throw new formatoInvalido("El ISBN debe contener exactamente 13 dígitos numéricos.");
    }





}
