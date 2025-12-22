import java.time.LocalDate;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ProgramaAgenda {
    public static void main(String[] args) {

        Scanner me = new Scanner(System.in);

        String menu = "1. Mostrar lista de contactos.\n" +
                "2. Añadir contacto.\n" +
                "3. Buscar contacto.\n" +
                "4. Eliminar contacto.\n" +
                "5. Salir. ";

        String submenu = "1. Crear contacto.\n" +
                "2. Crear contacto empresarial. ";
        String opcion = "";
        String opcionSubmenu = "";

        int contador = 0;

        Agenda nuevoAgenda = new Agenda();
        World world = new World();

        LocalDate cumpleanios;
        String nombreCompleto, numeroContacto;
        boolean copia;

        do {
            System.out.println("\n---------------");
            System.out.println(menu);
            System.out.println("---------------");
            opcion = me.nextLine();
            switch (opcion) {
                case "1":

                    if (contador == 0) {
                        System.out.println("\nNo hay contactos añadidos.");
                    } else {
                        System.out.println("\nMostrar lista de contactos:");
                        System.out.println(nuevoAgenda.mostrarContactos());
                    }
                    break;

                case "2":

                        me = new Scanner(System.in);

                        System.out.println(submenu);
                        opcionSubmenu = me.nextLine();

                        switch (opcionSubmenu) {
                            case "1":

                                nombreCompleto = World.execute("Inserte el nombre del contacto: ", me);

                                numeroContacto = World.execute("Inserte el numero telefono del nuevo contacto: ", me);

                                cumpleanios = obtenerFechaValida();

                                String nota = World.execute("Inserte una nota del contacto: ", me);

                                ContactoPersonas entrada = new ContactoPersonas(nombreCompleto, numeroContacto, cumpleanios, nota);

                                copia = nuevoAgenda.verificarDuplicado(entrada);

                                if (!copia) {

                                    nuevoAgenda.agregarContacto(entrada);
                                    System.out.println("\nContacto agregado correctamente.");
                                    contador++;

                                } else {
                                    System.out.println("Error: Ya existe un contacto con el mismo nombre.");
                                }
                                break;

                            case "2":
                                nombreCompleto = World.execute("Inserte el nombre del contacto: ", me);

                                numeroContacto = World.execute("Inserte el numero telefono del nuevo contacto: ", me);

                                String paginaWeb = World.execute("Inserte el pagina web de la empresa: ", me);

                                String correoElectronico =  World.execute("Inserte el correo de la empresa: ", me);

                                ContactoEmpresa contactoNuevo = new ContactoEmpresa(nombreCompleto, numeroContacto, paginaWeb, correoElectronico);

                                copia = nuevoAgenda.verificarDuplicado(contactoNuevo);

                                if (!copia) {
                                    nuevoAgenda.agregarContacto(contactoNuevo);
                                    System.out.println("\nContacto agregado correctamente.");
                                } else {
                                    System.err.println("El contacto ya existe");
                                }

                                break;
                        }

                    break;

                case "3":

                    if (contador == 0) {
                        System.out.println("\nNo hay contactos añadidos.");
                    } else {
                        System.out.println(nuevoAgenda.mostrarContactos());


                        nombreCompleto = World.execute("Inserte el nombre del contacto que quiere buscar: ", me);

                        System.out.println("\nEl contacto: " + nombreCompleto + " esta en la posición: " + nuevoAgenda.buscarContacto(nombreCompleto));

                    }

                    break;

                case "4":

                    if (contador == 0) {
                        System.out.println("\nNo hay contactos añadidos.");
                    }  else {

                        nombreCompleto = World.execute("Inserte el nombre del contacto que quiere eliminar: ", me);

                        boolean eliminado = nuevoAgenda.eliminarContacto(nombreCompleto);

                        if (eliminado) {
                            System.out.println("\nContacto eliminado correctamente.");
                        } else  {
                            System.out.println("No se ha podido eliminar al contacto o no existe.");
                        }
                    }

                    break;

                case "5":

                    System.out.println("Saliendo del programa...");
                    break;

                default:

                    System.out.println("Opción invalida. Vuelva a intentarlo.");
            }
        } while (!opcion.equals("5"));


    }

    private static LocalDate obtenerFechaValida() {
        Scanner sc = new Scanner(System.in);
        String fecha;

        while (true) {
            System.out.println("Ingrese la fecha del cumpleaños (dd/MM/yyyy):");
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