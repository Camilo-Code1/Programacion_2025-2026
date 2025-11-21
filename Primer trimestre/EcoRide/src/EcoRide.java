import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class EcoRide {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        String menu = "1. Datos de la bicicleta\n" +
                "2. Mostrar ID\n" +
                "3. Mostrar modelo\n" +
                "4. Mostrar batería\n" +
                "5. Usar bicicleta\n" +
                "6. Cargar batería\n" +
                "7. Historial de uso\n" +
                "8. Salir\n";

        String opcion = "";
        BicicletaElectrica nuevoUsuario;
        RegistroUso movimientos;

        String idBici = "";
        String modelo = "";

        System.out.print("Bienvenido a Dawbank" +
                " (Presione intro para continuar)");

        sc.nextLine();

        idBici = obtenerFormatoValido();

        System.out.println("Ingrese el modelo de la bicicleta: ");
        modelo = sc.nextLine();

        nuevoUsuario = new BicicletaElectrica(idBici, modelo);


        do {
            sc = new Scanner(System.in);

            System.out.println("\n-----------------------------");
            System.out.print(menu);
            System.out.println("-----------------------------");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println(nuevoUsuario.infoBicicleta());
                    break;
                case "2":
                    System.out.println("ID: " + nuevoUsuario.getIdBici());
                    break;
                case "3":
                    System.out.println("Modelo: " + nuevoUsuario.getModelo());
                    break;
                case "4":
                    System.out.println("Bateria: " + nuevoUsuario.getBateria() + "%") ;
                    break;
                case "5":
                    System.out.println("¿Cuantos kilometros desea recorrer?");
                    int km = sc.nextInt();
                    nuevoUsuario.usarBicicleta(km);
                    break;
                case "6":
                    nuevoUsuario.reiniciarBateria();
                    break;
                case "7":
                    nuevoUsuario.mostrarHistorial();
                    break;
                case "8":
                    System.out.println("\nAviso: Saliendo del sistema.");
                    break;
                default:
                    System.out.print("\nOpción invalida. Por favor vuelva a intentarlo.");
                    break;


            }

        } while (!opcion.equals("8"));





    }

    private static String obtenerFormatoValido() {
        Scanner sc = new Scanner(System.in);
        String idBici;
        while (true) {
            System.out.println("\nIngrese el formato (Formato: ECO-A00): ");
            idBici = sc.nextLine().toUpperCase(); // Convertir a mayúsculas
            if (validarFormato(idBici)) {
                return idBici;
            }
            System.out.println("Formato inválido. Por favor, inténtelo de nuevo.");
        }
    }

    private static boolean validarFormato(String idBici) {
        // Expresión regular para el formato "ECO-A00"
        return idBici.matches("[A-Z]{3}-[A-Z]{1}\\d{2}");
    }
}