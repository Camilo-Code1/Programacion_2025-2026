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

        String opcion = "";

        int contador = 0;

        Agenda nuevoAgenda = new Agenda();

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

                        System.out.println("Inserte el nombre del contacto: ");
                        String nombreCompleto = me.nextLine();

                        System.out.println("Inserte el numero telefonico del contacto: ");
                        String numeroContacto = me.nextLine();

                        Contacto entrada = new Contacto(nombreCompleto, numeroContacto);

                        boolean copia = nuevoAgenda.verificarDuplicado(entrada);

                        if (!copia) {

                            nuevoAgenda.agregarContacto(entrada);
                            System.out.println("\nContacto agregado correctamente.");
                            contador++;

                        } else {
                            System.out.println("Error: Ya existe un contacto con el mismo nombre.");
                        }



                    break;

                case "3":

                    if (contador == 0) {
                        System.out.println("\nNo hay contactos añadidos.");
                    } else {
                        System.out.println(nuevoAgenda.mostrarContactos());

                        System.out.println("Inserte el nombre del contacto: ");
                        nombreCompleto = me.nextLine();

                        System.out.println("\nEl contacto: " + nombreCompleto + " esta en la posición: " + nuevoAgenda.buscarContacto(nombreCompleto));

                    }

                    break;

                case "4":

                    if (contador == 0) {
                        System.out.println("\nNo hay contactos añadidos.");
                    }  else {
                        System.out.println("Inserte el nombre del contacto que quiere eliminar: ");
                        nombreCompleto = me.nextLine();

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


}