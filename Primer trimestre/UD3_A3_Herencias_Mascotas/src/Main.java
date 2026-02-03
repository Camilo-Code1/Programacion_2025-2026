import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Inventario inventario = new Inventario();

        String menu =
                "\n1. Mostrar lista de animales (solo tipo y nombre).\n" +
                        "2. Mostrar todos los datos de un animal concreto.\n" +
                        "3. Mostrar todos los datos de todos los animales.\n" +
                        "4. Insertar animales en el inventario.\n" +
                        "5. Eliminar animales del inventario.\n" +
                        "6. Vaciar inventario.\n" +
                        "7. Salir";

        String opcion = "";

        do {
            System.out.println(menu);
            opcion = scanner.nextLine();

            switch (opcion) {

                case "1":
                    inventario.mostrarAnimalTipoNombre();
                    break;

                case "2":

                    inventario.mostrarAnimalTipoNombre();

                    break;

                case "3":
                    inventario.mostrarTodoAnimal();
                    break;

                case "4":
                    System.out.println("Nombre:");
                    String nombreNuevo = scanner.nextLine();

                    System.out.println("Edad:");
                    int edad = scanner.nextInt();
                    scanner.nextLine();

                    int estadoSeleccionado;
                    do {
                        inventario.estados();
                        System.out.println("Elija un estado de la mascota (id):");
                        estadoSeleccionado = scanner.nextInt();
                        scanner.nextLine();

                        if (estadoSeleccionado <= 0 || estadoSeleccionado > Estado.values().length) {
                            System.err.println("Debe elegir un estado válido.");
                        }
                    } while (estadoSeleccionado <= 0 || estadoSeleccionado > Estado.values().length);

                    Estado estadoMascota = Estado.values()[estadoSeleccionado - 1];

                    String fechaNacimientoStr;
                    do {
                        System.out.println("Ingrese fecha de nacimiento (dd/MM/yyyy):");
                        fechaNacimientoStr = scanner.nextLine().trim();
                    } while (!validarFecha(fechaNacimientoStr));

                    LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr, dateFormatter);

                    int tipoNuevo;
                    do {
                        inventario.tipos();
                        System.out.println("Elija un tipo de mascota (id):");
                        tipoNuevo = scanner.nextInt();
                        scanner.nextLine();

                        if (tipoNuevo <= 0 || tipoNuevo > Tipo.values().length) {
                            System.err.println("Debe elegir un tipo válido.");
                        }
                    } while (tipoNuevo <= 0 || tipoNuevo > Tipo.values().length);

                    Tipo tipoMascota = Tipo.values()[tipoNuevo - 1];

                    if (tipoMascota.equals(Tipo.PERRO)) {

                        System.out.println("Raza:");
                        String raza = scanner.nextLine();

                        System.out.println("¿Tiene pulgas? (Y/N)");
                        boolean tienePulgas = scanner.nextLine().equalsIgnoreCase("Y");

                        Perro perro = new Perro(
                                nombreNuevo, edad, estadoMascota,
                                fechaNacimiento, tipoMascota, raza, tienePulgas
                        );

                        if (!inventario.exists(perro.getNombre(), perro.getTipo())) {
                            if (inventario.insertarAnimal(perro)) {
                                System.out.println("Se ha insertado la mascota.");
                            } else {
                                System.err.println("No hay espacio disponible.");
                            }
                        }

                    } else if (tipoMascota.equals(Tipo.GATO)) {

                        System.out.println("Color:");
                        String color = scanner.nextLine();

                        System.out.println("¿Tiene pelo largo? (Y/N)");
                        boolean peloLargo = scanner.nextLine().equalsIgnoreCase("Y");

                        Gato gato = new Gato(
                                nombreNuevo, edad, estadoMascota,
                                fechaNacimiento, tipoMascota, color, peloLargo
                        );

                        if (!inventario.exists(gato.getNombre(), gato.getTipo())) {
                            if (inventario.insertarAnimal(gato)) {
                                System.out.println("Se ha insertado la mascota.");
                            } else {
                                System.err.println("No hay espacio.");
                            }
                        }

                    } else if (tipoMascota.equals(Tipo.LORO)) {

                        System.out.println("¿Tiene pico? (Y/N)");
                        boolean tienePico = scanner.nextLine().equalsIgnoreCase("Y");

                        System.out.println("¿Vuela? (Y/N)");
                        boolean vuela = scanner.nextLine().equalsIgnoreCase("Y");

                        System.out.println("Origen:");
                        String origen = scanner.nextLine();

                        System.out.println("¿Habla? (Y/N)");
                        boolean habla = scanner.nextLine().equalsIgnoreCase("Y");

                        Loro loro = new Loro(
                                nombreNuevo, edad, estadoMascota,
                                fechaNacimiento, tipoMascota, tienePico, vuela, origen, habla
                        );

                        if (!inventario.exists(loro.getNombre(), loro.getTipo())) {
                            if (inventario.insertarAnimal(loro)) {
                                System.out.println("Se ha insertado la mascota.");
                            } else {
                                System.err.println("No hay espacio disponible.");
                            }
                        }

                    } else if (tipoMascota.equals(Tipo.CANARIO)) {

                        System.out.println("¿Tiene pico? (Y/N)");
                        boolean tienePico = scanner.nextLine().equalsIgnoreCase("Y");

                        System.out.println("¿Vuela? (Y/N)");
                        boolean vuela = scanner.nextLine().equalsIgnoreCase("Y");

                        System.out.println("Color:");
                        String color = scanner.nextLine();

                        System.out.println("¿Canta? (Y/N)");
                        boolean canta = scanner.nextLine().equalsIgnoreCase("Y");

                        Canario canario = new Canario(
                                nombreNuevo, edad, estadoMascota,
                                fechaNacimiento, tipoMascota, tienePico, vuela, color, canta
                        );

                        if (!inventario.exists(canario.getNombre(), canario.getTipo())) {
                            if (!inventario.insertarAnimal(canario)) {
                                System.err.println("No hay espacio. Ampliando inventario...");
                                inventario.aumentarTamanio();
                                inventario.reorganizar();
                                inventario.insertarAnimal(canario);
                            }
                            System.out.println("Se ha insertado la mascota.");
                        }
                    }
                    break;

                case "5":
                    inventario.mostrarAnimalTipoNombre();

                    System.out.println("Nombre:");
                    String nombreEliminar = scanner.nextLine();

                    int tipoEliminar;
                    do {
                        inventario.tipos();
                        System.out.println("Elija el tipo de mascota (id):");
                        tipoEliminar = scanner.nextInt();
                        scanner.nextLine();
                    } while (tipoEliminar <= 0 || tipoEliminar > Tipo.values().length);

                    Tipo tipoBorrar = Tipo.values()[tipoEliminar - 1];
                    inventario.eliminarAnimal(nombreEliminar, tipoBorrar);
                    inventario.reorganizar();
                    
                    System.out.println("Se ha finalizado correctamente a la mascota");
                    break;

                case "6":
                    inventario.eliminarTodosAnimales();
                    break;

                case "7":
                    System.out.println("Gracias por usar nuestros servicios.");
                    break;

                default:
                    System.err.println("Seleccione una opción válida.");
            }

        } while (!opcion.equals("7"));
    }

    public static boolean validarFecha(String fecha) {
        String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/((19|20)\\d\\d)$";
        return Pattern.matches(regex, fecha);
    }
}
