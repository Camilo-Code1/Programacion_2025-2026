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

    public int obtenerEnteroValido(String mensaje, Scanner scanner) {
        while (true) {
            System.out.println(mensaje);
            String entrada = scanner.nextLine();

            if (entrada.matches("\\d+")) {
                return Integer.parseInt(entrada);
            }
            System.out.println("Error: Debe ingresar un número entero válido.");
        }
    }

    public double obtenerDoubleValido(String mensaje, Scanner scanner) {
        while (true) {
            System.out.println(mensaje);
            String entrada = scanner.nextLine();

            if (entrada.matches("\\d+(\\.\\d+)?")) {
                return Double.parseDouble(entrada);
            }
            System.out.println("Error: Debe ingresar un número válido (ej: 10.5).");
        }
    }


    public String obtenerCodBibliotecaValido() {
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

    public String obtenerISBNValido(String isbn) throws FormatoInvalidoException {
        if (isbn.matches("^\\d{13}$")) {
            return isbn;
        }
        throw new FormatoInvalidoException("El ISBN debe contener exactamente 13 dígitos numéricos.");
    }

    public String obtenerCIFValido (String mensaje, Scanner scanner) {
        Scanner sc = new Scanner(System.in);
        String cif;
        while (true) {
            System.out.println("Ingrese un CIF valido para la empresa (Ejemplo: A1234567891):");
            cif = sc.nextLine().toUpperCase();
            if (validarCIF(cif)) {
                System.out.println("\nCIF admitido correctamente.");
                return cif;

            }
            System.out.println("CIF invalido. Por favor vuelva a intentarlo.");
        }
    }
    private static boolean validarCIF(String cif) {
        return cif.matches("^[A-Z]\\d{10}$");
    }


        public  boolean esEmailValido(String email) {
            return email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,7}$");
        }

        public boolean esTelefonoValido(String tel) {
            return tel.matches("^(\\+\\d{1,3})?\\d{9,12}$");
        }

        public  boolean esNumeroSS(String SS) {
            return SS.matches("^\\d{10}$");
        }




    }




