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


        do {
            System.out.println(menu);
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("Ingresa el nombre del contacto: ");
                    String nombre = sc.nextLine();

                    System.out.println("Ingresa el telefono del contacto: ");
                    String telefono = sc.nextLine();

                    System.out.println("Ingresa el correo del contacto: ");
                    String correo = sc.nextLine();

                    Contacto contactoNuevo = new Contacto(nombre, telefono, correo);
                    nuevoContacto.agregarContacto(contactoNuevo);
                    break;
                case "2":

                    break;
                case "3":

                    break;

                case "4":
                    nuevoContacto.mostrarContactos();
                    break;
                case "5":

                    break;
                case "6":
                    break;
            }


        } while (!opcion.equals("6"));



    }
}