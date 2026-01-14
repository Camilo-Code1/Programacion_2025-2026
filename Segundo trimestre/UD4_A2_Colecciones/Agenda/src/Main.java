import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String menu = "\n1. Añadir contacto.\n" +
                "2. Buscar contacto.\n" +
                "3. Eliminar contacto.\n" +
                "4. Visualizar agenda.\n" +
                "5. Número de contactos de mi agenda. \n" +
                "6. Salir. ";

        String opcion = "";
        Agenda nuevoContacto = new Agenda();

        String nombre;

        do {
            System.out.println(menu);
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    sc = new Scanner(System.in);


                    nombre = obtenerTextoNoVacio("Ingresa el nombre del contacto: ", sc);

                    String telefono = obtenerTelefonoValido ("Ingresa el numero del contacto: ", sc);

                    String correo = obtenerCorreoValido("Ingresa el correo del contacto (Ej: usuario@correo.com): ", sc);

                    Contacto contactoNuevo = new Contacto(nombre, telefono, correo);
                    nuevoContacto.agregarContacto(contactoNuevo);
                    break;
                case "2":
                    sc = new Scanner(System.in);

                    nombre = obtenerTextoNoVacio("Ingresa el nombre del contacto que quieras buscar: ", sc);


                    Contacto contactoEncontrado = nuevoContacto.buscarContacto(nombre);

                    if (contactoEncontrado != null) {
                        System.out.println(contactoEncontrado);
                    } else {
                        System.out.println("Contacto no encontrado");
                    }
                    break;
                case "3":
                    sc = new Scanner(System.in);

                    nombre = obtenerTextoNoVacio("Inserte el nombre del contacto que quieras eliminar: ", sc);

                    if (nuevoContacto.eliminarContacto(nombre)) {
                        System.out.println("Contacto eliminado");
                    } else {
                        System.out.println("Contacto no encontrado");
                    }

                    break;
                case "4":
                    nuevoContacto.mostrarContactos();
                    break;
                case "5":
                    int cantidad = nuevoContacto.numContactos();
                    if (cantidad == 0) {
                        System.out.println("\nNo hay contactos registrados");
                    }  else {
                        System.out.println("\nCantidad de contactos registrados: " + cantidad);
                    }
                    break;
                case "6":
                    break;
            }


        } while (!opcion.equals("6"));



    }

    private static String obtenerTextoNoVacio(String mensaje, Scanner sc) {
        String entrada;
        do {
            System.out.println(mensaje);
            entrada = sc.nextLine().trim();

            if (entrada.isEmpty()) {
                System.out.println("Error: El campo no puede quedar vacío.");
            }
        } while (entrada.isEmpty());
        return entrada;
    }
    private static String obtenerTelefonoValido(String mensaje, Scanner sc) {
        String telefono;
        do {
            System.out.println(mensaje);
            telefono = sc.nextLine().trim();

            if (!telefono.matches("\\d{9}")) {
                System.out.println("Error: El teléfono debe contener exactamente 9 dígitos.");
                telefono = "";
            }
        } while (telefono.isEmpty());

        return telefono;
    }
    private static String obtenerCorreoValido(String mensaje, Scanner sc) {
        String correo;
        do {
            System.out.println(mensaje);
            correo = sc.nextLine().trim();

            if (!correo.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
                System.out.println("Error: Correo electrónico no válido.");
                correo = "";
            }
        } while (correo.isEmpty());

        return correo;
    }

}