import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        GestionEcoDrive gestion = new GestionEcoDrive();
        supFormatos formas = new supFormatos();

        gestion.cargarDatos();

        String emnu = "\n1. Añadir vehiculo.\n" +
                "2. Lista de flota.\n" +
                "3. Realizar alquiler.\n" +
                "4. Devolver vehiculo.\n" +
                "5. Eliminar vehiculo.\n" +
                "6. Generar reporte de ganancias. \n" +
                "7. Guardar y salir. ";

        String opcion = "";

        do {
            scanner = new Scanner(System.in);
            System.out.println(emnu);
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    scanner = new Scanner(System.in);

                    String id = formas.obtenerTextoNoVacio ("Inserte el ID del vehiculo:", scanner);

                    System.out.println("Inserte el modelo del vehiculo:");
                    String modelo = scanner.nextLine();

                    System.out.println("Inserte el precio base por dia del vehiculo:");
                    double precioBaseDia = Double.parseDouble(scanner.nextLine());

                    System.out.println("Elija el tipo de vehiculo a añadir: (1) Coche electrico, (2) Dron de carga");
                    int tipoVehiculo = scanner.nextInt();

                    if (tipoVehiculo == 1) {
                        scanner = new Scanner(System.in);

                        System.out.println("Inserte la capacidad de bateria del coche electrico(KMH):");
                        double capacidadBateria = Double.parseDouble(scanner.nextLine());

                        System.out.println("Inserte la autonomia restante del coche electrico:");
                        double autonomiaRestante = Double.parseDouble(scanner.nextLine());

                        System.out.println("Inserte comentarios adicionales del coche electrico:");
                        String comentarios = scanner.nextLine();

                        CocheElectrico coche = new CocheElectrico(id, modelo, precioBaseDia, capacidadBateria, autonomiaRestante, comentarios);
                        gestion.registrarVehiculo(coche);

                    } else if (tipoVehiculo == 2) {
                        scanner = new Scanner(System.in);

                        System.out.println("Inserte el peso maximo del dron de carga(KG):");
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

                    gestion.mostrarVehiculosDisponibles();

                    System.out.println("\nInserte el ID del vehiculo que quiere alquilar:");
                    id = scanner.nextLine();

                    LocalDate fechaDevolucion = obtenerFechaValida();

                    boolean exitoAlquilar = gestion.alquilareVehiculo(id, fechaDevolucion);

                    if (exitoAlquilar) {
                        System.out.println("Se ha alquilado con exito.");
                    } else {
                        System.out.println("No se ha alquilado el vehiculo.");
                    }

                    break;
                case "4":
                    // Lógica para devolver

                    System.out.println("\nInserte el ID del vehiculo que quiere alquilar:");
                    id = scanner.nextLine();

                    boolean exitoDevolver = gestion.devolverVehiculo(id);
                    if (exitoDevolver) {
                        System.out.println("Se ha devolver con exito.");
                    } else {
                        System.out.println("No se ha devolver el vehiculo.");
                    }
                    break;
                case "5":
                    // Lógica para generar reporte de ganancias
                    break;
                case "6":
                    // Lógica para generar reporte de ganancias
                    break;
                case "7":
                    // Lógica para guardar y salir
                    gestion.guardarDatos();
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        } while (!opcion.equals("7"));




    }


    private static LocalDate obtenerFechaValida() {
        Scanner sc = new Scanner(System.in);
        String fecha;

        while (true) {
            System.out.println("Inserte la fecha en que sera devuelta (dd/MM/yyyy):");
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