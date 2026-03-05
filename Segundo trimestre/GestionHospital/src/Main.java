import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Gestion nuevosDatos = new Gestion();

        nuevosDatos.cargarDatos();

        String menu = """
                \n1. Registrar médico
                2. Registrar paciente
                3. Mostrar todas las personas
                4. Mostrar solo médicos
                5. Mostrar solo pacientes
                6. Asignar diagnóstico a paciente
                7. Dar de alta paciente (marcar como atendido)
                8. Eliminar persona
                9. Salir. \s""";

        String opcion = "";

        String nombre, id, diagnostico;
        int edad;

        do {
            sc = new Scanner(System.in);

            System.out.println(menu);


            opcion = sc.nextLine();

            switch (opcion) {
                case "1":

                    System.out.println("Ingresa el nombre del medico: ");
                    nombre = sc.nextLine();

                    System.out.println("Ingrese la edad del medico: ");
                    edad = sc.nextInt();

                    sc.nextLine();

                    System.out.println("Por favor, ingrese la especialidad del medico: ");
                    String especialidad = sc.nextLine();

                    System.out.println("Por favor, ingrese el salario del medico: ");
                    double salario = sc.nextDouble();

                    Medico m = new Medico(nombre, edad, especialidad, salario);
                    nuevosDatos.registro(m);

                    break;
                case "2":
                    System.out.println("Ingresa el nombre del paciente: ");
                    nombre = sc.nextLine();

                    System.out.println("Ingrese la edad del paciente: ");
                    edad = sc.nextInt();

                    sc.nextLine();

                    System.out.println("Por favor, ingrese el numero del historial del paciente: ");
                    String numeroHistorial = sc.nextLine();

                    System.out.println("Ingrese el diagnostico del paciente: ");
                    diagnostico = sc.nextLine();

                    Paciente p = new Paciente(nombre, edad, numeroHistorial, diagnostico);
                    nuevosDatos.registro(p);
                    break;
                case "3":
                    nuevosDatos.mostrarTodosPersonas();
                    break;
                case "4":
                    nuevosDatos.mostrarMedicos();
                    break;
                case "5":
                    nuevosDatos.mostrarPacientes();
                    break;
                case "6":

                    nuevosDatos.mostrarPacientesFiltro();

                    System.out.println("Ingrese el ID del Paciente: ");
                    id = sc.nextLine();

                    System.out.println("Ingrese el nuevo diagnostico del Paciente: ");
                    diagnostico = sc.nextLine();

                    boolean nuevoDiagnostico = nuevosDatos.asignarDiagnostico(id, diagnostico);
                    if (nuevoDiagnostico) {
                        System.out.println("Nuevo diagnostico asignado correctamente");
                    } else {
                        System.out.println("Diagnostico no asignado");
                    }

                    break;
                case "7":

                    nuevosDatos.mostrarPacientesNoAtendidos();

                    System.out.println("Ingrese el ID del Paciente que se dara de alta: ");
                    id = sc.nextLine();

                    boolean darAlta = nuevosDatos.atenderPaciente(id);

                    if (darAlta) {
                        System.out.println("Paciente dado de alta correctamente");
                    } else {
                        System.out.println("No se ha podido dar de alta");
                    }
                    break;
                case "8":
                    sc.nextLine();

                    nuevosDatos.mostrarPacientesFiltro();

                    System.out.println("Ingrese el ID del Paciente que se dara de alta: ");
                    id = sc.nextLine();

                    boolean eliminado = nuevosDatos.eliminarPersona(id);
                    if (eliminado) {
                        System.out.println("Persona eliminado correctamente");
                    } else {
                        System.out.println("No se ha podido eliminar el Persona");
                    }
                    break;
                case "9":
                    nuevosDatos.guardarDatos();
                    System.out.println("Saliendo del programa!");
                    break;
            }
        } while (!opcion.equals("9"));

    }
}