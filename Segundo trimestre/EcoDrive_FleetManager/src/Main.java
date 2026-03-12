import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        supFormatos formas = new supFormatos();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el correo(juan.perez@gmail.com): ");
        String correoElectronico = scanner.nextLine();
        while (!formas.esEmailValido(correoElectronico)) {
            System.out.println("El correo introducido no es valido");
            correoElectronico = scanner.nextLine();
        }


        System.out.println("Ingrese el telefono(9-12 digitos): ");
        String numeroTelefono = scanner.nextLine();
        while (!formas.esTelefonoValido(numeroTelefono)) {
            System.out.println("El telefono introducido no es valido");
            numeroTelefono = scanner.nextLine();
        }

        System.out.println("Ingrese el codigo postal(5 digitos) ");
        String codigoPostal = scanner.nextLine();
        while (!formas.esCPValido(codigoPostal)) {
            System.out.println("El numero de telefono introducido no es valido");
            codigoPostal = scanner.nextLine();
        }


        GestionEcoDrive gestion = new GestionEcoDrive(correoElectronico, numeroTelefono, codigoPostal);

        System.out.println("Registro completo");

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

                    String id = formas.obtenerTextoNoVacio ("\nInserte el ID del vehiculo:", scanner);


                    String modelo = formas.obtenerTextoNoVacio("Inserte el modelo del vehiculo:", scanner);


                    double precioBaseDia = formas.obtenerDoubleValido("Inserte el precio base por dia del vehiculo:", scanner);


                    int tipoVehiculo = formas.obtenerEnteroValido("Elija el tipo de vehiculo a añadir: (1) Coche electrico, (2) Dron de carga", scanner);

                    if (tipoVehiculo == 1) {
                        scanner = new Scanner(System.in);


                        double capacidadBateria = formas.obtenerDoubleValido("Inserte la capacidad de bateria del coche electrico(KMH):", scanner);

                        System.out.println();
                        double autonomiaRestante = formas.obtenerDoubleValido("Inserte la autonomia restante del coche electrico:", scanner);

                        System.out.println("Inserte comentarios adicionales del coche electrico(Opcional):");
                        String comentarios = scanner.nextLine();

                        CocheElectrico coche = new CocheElectrico(id, modelo, precioBaseDia, capacidadBateria, autonomiaRestante, comentarios);
                        gestion.registrarVehiculo(coche);

                    } else if (tipoVehiculo == 2) {
                        scanner = new Scanner(System.in);

                        double pesoMaximo = formas.obtenerDoubleValido("Inserte el peso maximo del dron de carga(KG):", scanner);


                        int numHelices = formas.obtenerEnteroValido("Inserte el numero de helices del dron de carga:", scanner);

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

                    id = formas.obtenerTextoNoVacio ("Inserte el ID del vehiculo:", scanner);;

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

                    id = formas.obtenerTextoNoVacio ("Inserte el ID del vehiculo:", scanner);

                    boolean exitoDevolver = gestion.devolverVehiculo(id);
                    if (exitoDevolver) {
                        System.out.println("Se ha devolver con exito.");
                    } else {
                        System.out.println("No se ha devolver el vehiculo.");
                    }
                    break;
                case "5":

                    gestion.mostrarVehiculosDisponibles();

                    id = formas.obtenerTextoNoVacio ("Inserte el ID del vehiculo:", scanner);

                    boolean eliminadoExito = gestion.eliminarVehiculo(id);
                    if (eliminadoExito) {
                        System.out.println("Se ha eliminado el vehiculo.");
                    } else {
                        System.out.println("No se ha eliminado el vehiculo.");
                    }

                    break;
                case "6":
                    System.out.println(gestion.toString());
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