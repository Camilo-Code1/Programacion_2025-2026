import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        GestionEcoDrive gestion = new GestionEcoDrive();

        String emnu = "\n1. Añadir vehiculo.\n" +
                "2. Lista de flota.\n" +
                "3. Realizar alquiler. \n" +
                "4. Generar reporte de ganancias.\n" +
                "5. Guardar y salir.";

        String opcion = "";

        do {
            scanner = new Scanner(System.in);
            System.out.println(emnu);
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    scanner = new Scanner(System.in);
                    System.out.println("\nInserte el ID del vehiculo:");
                    String id = scanner.nextLine();

                    System.out.println("Inserte el modelo del vehiculo:");
                    String modelo = scanner.nextLine();

                    System.out.println("Inserte el precio base por dia del vehiculo:");
                    double precioBaseDia = Double.parseDouble(scanner.nextLine());

                    System.out.println("Elija el tipo de vehiculo a añadir: (1) Coche electrico, (2) Dron de carga");
                    int tipoVehiculo = scanner.nextInt();

                    if (tipoVehiculo == 1) {
                        scanner = new Scanner(System.in);

                        System.out.println("Inserte la capacidad de bateria del coche electrico:");
                        double capacidadBateria = Double.parseDouble(scanner.nextLine());

                        System.out.println("Inserte la autonomia restante del coche electrico:");
                        double autonomiaRestante = Double.parseDouble(scanner.nextLine());

                        System.out.println("Inserte comentarios adicionales del coche electrico:");
                        String comentarios = scanner.nextLine();

                        CocheElectrico coche = new CocheElectrico(id, modelo, precioBaseDia, capacidadBateria, autonomiaRestante, comentarios);
                        gestion.registrarVehiculo(coche);

                    } else if (tipoVehiculo == 2) {
                        scanner = new Scanner(System.in);

                        System.out.println("Inserte el peso maximo del dron de carga:");
                        double pesoMaximo = Double.parseDouble(scanner.nextLine());

                        System.out.println("Inserte el numero de helices del dron de carga:");
                        int numHelices = Integer.parseInt(scanner.nextLine());

                        DronCarga dron = new DronCarga(id, modelo, precioBaseDia, pesoMaximo, numHelices);
                        gestion.registrarVehiculo(dron);
                    } else {
                        System.out.println("Tipo de vehiculo no valido. Por favor, intente de nuevo.");
                    }


                    break;
                case "2":
                    gestion.mostrarVehiculos();
                    break;
                case "3":
                    // Lógica para realizar un alquiler
                    break;
                case "4":
                    // Lógica para generar reporte de ganancias
                    break;
                case "5":
                    // Lógica para guardar y salir
                    System.out.println("Guardando datos y saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        } while (!opcion.equals("5"));




    }
}