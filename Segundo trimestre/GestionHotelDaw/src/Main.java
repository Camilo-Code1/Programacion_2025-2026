import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Gestion nuevos = new Gestion();

        nuevos.cargarDatos();

        String menu = "\n1. Registrar huésped.\n" +
                "2. Crear habitación\n" +
                "3. Ver huéspedes registrados.\n" +
                "4. Ver habitaciones.\n" +
                "5. Asignar habitación a huésped.\n" +
                "6. Liberar habitación (checkout).\n" +
                "7. Eliminar huésped.\n" +
                "8. Eliminar habitación.\n" +
                "9. Guardar y salir.";

        String opcion = "";
        String id;

        do {
            sc = new Scanner(System.in);
            System.out.println(menu);
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("Ingrese el ID del huesped:");
                    id = sc.nextLine();

                    System.out.println("Ingrese el nombre del huesped:");
                    String nombre = sc.nextLine();

                    System.out.println("Ingrese la edad del huesped: ");
                    int edad = sc.nextInt();

                    sc.nextLine();

                    System.out.println("Ingrese el numero telefonico del huesped: ");
                    String telefono = sc.nextLine();

                    System.out.println("Ingrse la nacionalidad del huesped: ");
                    String nacionalidad = sc.nextLine();

                    Huesped nuev = new Huesped(id, nombre, edad, telefono, nacionalidad);
                    nuevos.agregarPersona(nuev);

                    break;
                case "2":

                    System.out.println("Ingrese el numero de la habitación: ");
                    int numero = sc.nextInt();

                    sc.nextLine();

                    System.out.println("Ingrese el tipo de habitación: ");
                    String tipo = sc.nextLine();

                    Habitacion nuevawHabitacio = new Habitacion(numero, tipo, null);
                    nuevos.agregarHabitacion(nuevawHabitacio);

                    break;
                case "3":
                    nuevos.mostrarPersonas();
                    break;
                case "4":
                    nuevos.mostrarHabitaciones();

                    break;
                case "5":
                    sc = new Scanner(System.in);
                    nuevos.mostrarHuespedesFiltro();
                    System.out.println("Ingrese el ID del huesped para asignar la habitación: ");
                    id = sc.nextLine();

                    nuevos.mostrarHabitacionesFiltro();
                    System.out.println("Ingrese el numero de la habitación a asignar: ");
                    numero = sc.nextInt();
                    nuevos.asignarHabitacion(id, numero);
                    break;
                case "6":
                    sc = new Scanner(System.in);

                    System.out.println("Ingrese el ID del huesped para asignar la habitación: ");
                    id = sc.nextLine();

                    
                    System.out.println("Ingrese el numero de la habitación a asignar: ");
                    numero = sc.nextInt();
                    nuevos.desasignarHabitacion(id, numero);

                    break;
                case "7":
                    sc = new Scanner(System.in);
                    nuevos.mostrarHuespedesFiltro();
                    System.out.println("Ingrese el ID del huesped para asignar la habitación: ");
                    id = sc.nextLine();

                    boolean borrarHuesped = nuevos.eliminarPersona(id);

                    if (borrarHuesped) {
                        System.out.println("Huesped eliminado");
                    } else {
                        System.out.println("No se puede eliminar el huesped");
                    }

                    break;
                case "8":
                    sc = new Scanner(System.in);
                    nuevos.mostrarHabitacionesFiltro();
                    System.out.println("Ingrese el numero de la habitación a asignar: ");
                    numero = sc.nextInt();

                    boolean eliminarHab = nuevos.eliminarHabitacion(numero);
                    if (eliminarHab) {
                        System.out.println("Habitacion eliminado");
                    } else {
                        System.out.println("No se puede eliminar el habitacion");
                    }
                    break;
                case "9":
                    nuevos.guardarDatos();
                    System.out.println("Saliendo...");
                    break;
            }
        } while (!opcion.equals("9"));

    }
}