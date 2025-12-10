
import java.time.LocalDate;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class GestionZoo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String menu = "\n1. Registrar animal en el zoologico.\n" +
                "2. Registrar cuidador.\n" +
                "3. Actualizacion y configuracion de cuidadores.\n" +
                "4. Mostrar información general del zoo.\n" +
                "5. Mostrar listas.\n" +
                "6. Dar de baja animal.\n" +
                "7. Dar de baja cuidador. \n" +
                "8. Crear ticket de incidencia\n" +
                "9. Mostrar o modificar tickets.\n" +
                "10. Salir.";

        String submenu = "A. Mostrar lista de animales. \n" +
                "B. Mostrar lista de cuidadores";

        String submenu2 = "A. Actualizar cambios.  \n" +
                "B. Asignar cuidador a un animal.\n" +
                "c. Retirar cuidador de un animal. ";
        String opcion = "";
        String opcion2 = "";
        
        ZooSoft nuevoUsuario;
        Animal criatura;
        Cuidador persona;
        TicketIncidencia ticket;

        System.out.println("Bienvenido a ZooSoft");
        System.out.println("Inserte el nombre del zoologico: ");
        String nombreZoo = sc.nextLine();
        System.out.println("Inserte la direccion del zoologico: ");
        String direccionZoo = sc.nextLine();
        LocalDate fechaApertura;
        System.out.println("Ingrese la fecha en la que se fundo el zoologico: ");
        fechaApertura = obtenerFechaValida();

        nuevoUsuario = new ZooSoft(nombreZoo, direccionZoo, fechaApertura);



        do {
            sc = new Scanner(System.in);

            System.out.println("-----------------");
            System.out.println(menu);
            System.out.println("-----------------");

            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    if (nuevoUsuario.getNumeroCuidadores() == 0) {
                        System.out.println("Error: Debe registrar al menos un cuidador antes de registrar un animal.");
                        break;
                    }
                    System.out.println("Ingrese el nombre del animal: ");
                    String nombreAnimal = sc.nextLine();

                    System.out.println("Ingrese la especie del animal: ");
                    String especie = sc.nextLine();

                    TipoAnimal tipoAnimalAnim = getTipoAnimal(sc);

                    System.out.println("Ingrese la fecha de nacimiento: ");
                    LocalDate fechaNacimiento = obtenerFechaValida();

                    System.out.println("Ingrese la fecha en la que ingreso al zoologico el animal: ");
                    LocalDate fechaIngreso = obtenerFechaValida();

                    System.out.println("Seleccione un cuidador");

                   Cuidador cuidadorAsignado = null;
                   int opcionCuid = -1;

                   nuevoUsuario.mostrarCuidadoresEnumerados();
                   do {
                       System.out.print("Opcion: ");
                       String entradaOp = sc.nextLine();

                       if (entradaOp.matches("\\d+")) {
                           opcionCuid = Integer.parseInt(entradaOp);
                       } else {
                           System.out.println("Error: Debe ingresar un numero.");
                           continue;
                       }

                       if (opcionCuid < 1 || opcionCuid > nuevoUsuario.getNumeroCuidadores()) {
                           System.out.println("Error: Opcion fuera de rango. Intente de nuevo.");
                       }
                   } while (opcionCuid < 1 || opcionCuid > nuevoUsuario.getNumeroCuidadores());

                   cuidadorAsignado = nuevoUsuario.getCuidadorPorIndice(opcionCuid - 1);

                    Animal a = new Animal(nombreAnimal, especie, tipoAnimalAnim, fechaNacimiento, fechaIngreso, cuidadorAsignado);
                    nuevoUsuario.agregarAnimal(a);
                    System.out.println("Animal agregado correctamente.");
                    break;
                case "2":

                    String dni;
                    dni = obtenerDNIValido().toUpperCase();
                    System.out.println("Ingrese el nombre completo del cuidador: ");
                    String nombre = sc.nextLine();

                    LocalDate fechaContratacion;

                    System.out.println("Ingrese la fecha de Contratacion: ");
                    fechaContratacion = obtenerFechaValida();

                    TipoAnimal tipoAnimal = getTipoAnimal(sc);

                    Cuidador c = new Cuidador(dni, nombre, fechaContratacion, tipoAnimal);
                    nuevoUsuario.agregarCuidador(c);
                    System.out.println("Cuidador agregado correctamente. El numero de cuidadores actuales es de " + nuevoUsuario.getNumeroCuidadores());
                    break;
                case "3":

                    sc = new Scanner(System.in);
                    System.out.println("");
                    System.out.println(submenu2);
                    System.out.println("");

                    String opcion3 = sc.nextLine();

                    switch (opcion3.toUpperCase()) {
                        case "A":
                            for (Cuidador cui : nuevoUsuario.getListaCuidadores()) {
                                cui.actualizarAnimalesACargo(nuevoUsuario.getListaAnimales());
                            }
                            System.out.println("\nActualización completada: los cuidadores ahora tienen sus animales a cargo sincronizados.");
                            break;

                        case "B":

                            break;
                        case "C":
                    }
                    break;
                case "4":
                    System.out.println(nuevoUsuario.mostrarInfoZoo());
                    break;
                case "5":

                    sc = new Scanner(System.in);
                    System.out.println("");
                    System.out.println(submenu);
                    System.out.println("");

                    opcion2 = sc.nextLine();

                    switch (opcion2.toUpperCase()) {
                        case "A":
                            nuevoUsuario.mostrarAnimales();
                            break;
                        case "B":
                            nuevoUsuario.mostrarCuidadores();
                            break;
                        case "C":
                            nuevoUsuario.mostrarTicketIncidencias();
                    }

                    break;
                case "6":

                    break;
                case "7":

                    break;
                case "8":
                    System.out.println("Ingrese el nombre de la Incidencia");
                    String nombreIncidencia = sc.nextLine();

                    System.out.println("Ingrese una descripción de la Incidencia");
                    String descripcion = sc.nextLine();

                    TipoIncidencia tipoIncidencia = getTipoIncidencia(sc);

                    Cuidador cuidadorRelacionado = null;
                    int opcionRel = -1;

                    nuevoUsuario.mostrarCuidadoresEnumerados();
                    do {
                        System.out.print("Opcion: ");
                        String entradaOp = sc.nextLine();

                        if (entradaOp.matches("\\d+")) {
                            opcionRel = Integer.parseInt(entradaOp);
                        } else {
                            System.out.println("Error: Debe ingresar un numero.");
                            continue;
                        }

                        if (opcionRel < 1 || opcionRel > nuevoUsuario.getNumeroCuidadores()) {
                            System.out.println("Error: Opcion fuera de rango. Intente de nuevo.");
                        }
                    } while (opcionRel < 1 || opcionRel > nuevoUsuario.getNumeroCuidadores());

                    cuidadorRelacionado = nuevoUsuario.getCuidadorPorIndice(opcionRel - 1);
                    TicketIncidencia t = new TicketIncidencia(nombreIncidencia, descripcion, tipoIncidencia, cuidadorRelacionado);
                    nuevoUsuario.agregarTicketIncidencia(t);

                    System.out.println("Ticket de incidencia agregado correctamente.");
                    break;

                case "9":

                    break;
                case "10":

                    break;
            }

        } while (!opcion.equals("9"));

    }

    private static TipoAnimal getTipoAnimal(Scanner sc) {
        TipoAnimal tipoAnimal;
        int anim = -1;
        do {
            System.out.println("Seleccione el tipo de animal: ");
            for (TipoAnimal tipo : TipoAnimal.values()) {
                System.out.println((tipo.ordinal() + 1) + ". " + tipo);
            }
            System.out.print("Opcion: ");
            String entrada = sc.nextLine();

            if (entrada.matches("\\d+")) {
                anim = Integer.parseInt(entrada);
            } else {
                System.out.println("Error: Debe ingresar un numero");
                continue;
            }
            if (anim < 1 || anim > TipoAnimal.values().length) {
                System.out.println("Error: Numero fuera de rango. Intente nuevamente");
            }
        } while (anim < 1 || anim > TipoAnimal.values().length);

        tipoAnimal = TipoAnimal.values()[anim - 1];
        return tipoAnimal;
    }
    private static TipoIncidencia getTipoIncidencia(Scanner sc) {
        TipoIncidencia tipoIncidencia;
        int anim = -1;
        do {
            System.out.println("Seleccione el tipo de animal: ");
            for (TipoIncidencia tipo : TipoIncidencia.values()) {
                System.out.println((tipo.ordinal() + 1) + ". " + tipo);
            }
            System.out.print("Opcion: ");
            String entrada = sc.nextLine();

            if (entrada.matches("\\d+")) {
                anim = Integer.parseInt(entrada);
            } else {
                System.out.println("Error: Debe ingresar un numero");
                continue;
            }
            if (anim < 1 || anim > TipoIncidencia.values().length) {
                System.out.println("Error: Numero fuera de rango. Intente nuevamente");
            }
        } while (anim < 1 || anim > TipoIncidencia.values().length);

        tipoIncidencia = TipoIncidencia.values()[anim - 1];
        return tipoIncidencia;
    }

    private static LocalDate obtenerFechaValida() {
        Scanner sc = new Scanner(System.in);
        String fecha;

        while (true) {
            System.out.println("Ingrese la fecha: (dd-MM-yyyy):");
            fecha = sc.nextLine();

            if (validarFecha(fecha)) {

                String[] partes = fecha.split("-");
                int dia = Integer.parseInt(partes[0]);
                int mes = Integer.parseInt(partes[1]);
                int año = Integer.parseInt(partes[2]);

                return LocalDate.of(año, mes, dia);
            }

            System.out.println("Fecha inválida. Por favor vuelva a intentarlo.");
        }
    }


    private static boolean validarFecha(String fecha) {
        return fecha.matches("^\\d{2}-\\d{2}-\\d{4}$");
    }
    private static String obtenerDNIValido () {
        Scanner sc = new Scanner(System.in);
        String dni;
        while (true) {
            System.out.println("Ingrese el DNI del cuidador (Ejemplo: 87654321M):");
            dni = sc.nextLine().toUpperCase();
            if (validarDNI(dni)) {
                System.out.println("\nDNI admitido correctamente.");
                return dni;
            }
            System.out.println("DNI invalido. Por favor vuelva a intentarlo.");
        }
    }
    private static boolean validarDNI(String dni) {
        return dni.matches("^\\d{8}[A-Za-z]$");
    }
}