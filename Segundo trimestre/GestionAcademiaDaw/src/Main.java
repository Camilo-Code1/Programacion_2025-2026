import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        GestionAD nuevaGestion = new GestionAD();

        nuevaGestion.cargarDatos();

        String menu = """
                \n1. Registrar profesor.
                2. Registrar alumno.
                3. Crear asignatura.
                4. Asignar asignatura a profesor.
                5. Matricular alumno en asignatura.
                6. Poner nota a alumno.
                7. Mostrar todas las personas.
                8. Mostrar solo profesores.
                9. Mostrar solo alumnos.
                10. Mostrar media de un alumno.
                11. Mostrar salario final de un profesor.
                12. Eliminar persona.
                13. Salir.""";

        String opcion = "";

        String id, nombre;
        int edad;

        do {
            sc = new Scanner(System.in);

            System.out.println(menu);
            opcion = sc.nextLine();
            switch (opcion) {
                case "1":

                    System.out.println("Ingrese el ID del profesor: ");
                    id = sc.nextLine();

                    System.out.println("Ingrese el nombre: ");
                    nombre = sc.nextLine();

                    System.out.println("Ingrese la edad: ");
                    edad = sc.nextInt();

                    sc.nextLine();

                    System.out.println("Ingrese la especialidad: ");
                    String especialidad = sc.nextLine();

                    System.out.println("Ingrese el salario del profesor: ");
                    double salarioBase = sc.nextDouble();

                    Profesor prof = new Profesor(id, nombre, edad, especialidad, salarioBase);
                    nuevaGestion.registrarPersona(prof);
                    break;

                case "2":

                    System.out.println("Ingrese el ID del alumno: ");
                    id = sc.nextLine();

                    System.out.println("Ingrese el nombre: ");
                    nombre = sc.nextLine();

                    System.out.println("Ingrese la edad: ");
                    edad = sc.nextInt();

                    sc.nextLine();

                    System.out.println("Ingrese la expediente: ");
                    String expediente = sc.nextLine();

                    Alumno al = new Alumno(id, nombre, edad, expediente);
                    nuevaGestion.registrarPersona(al);

                    break;
                case "3":

                    System.out.println("Ingrese el codigo de  la asignatura: ");
                    String codigo = sc.nextLine();

                    System.out.println("Ingrese el nombre: ");
                    nombre = sc.nextLine();

                    System.out.println("Ingrese los creditos: ");
                    int creditos = sc.nextInt();

                    System.out.println("Ingrese la nota: ");
                    double nota = sc.nextDouble();

                    Asignatura as = new Asignatura(codigo, nombre, creditos, nota);
                    nuevaGestion.registrarAsignatura(as);
                    break;
                case "4":

                    break;
                case "5":
                    System.out.print("Introduce ID del Alumno: ");
                    id = sc.nextLine();
                    System.out.print("Introduce Código de la Asignatura: ");
                    codigo = sc.nextLine();
                    if (nuevaGestion.matricularAlummno(id, codigo)) {
                        System.out.println("¡Matriculación realizada!");
                    } else {
                        System.out.println("Error: No se encontró al alumno o la asignatura.");
                    }
                    break;
                case "6":
                    System.out.print("ID del Alumno: ");
                    id = sc.nextLine();
                    System.out.print("Código Asignatura: ");
                    codigo = sc.nextLine();
                    System.out.print("Nota final (0-10): ");
                    nota = sc.nextDouble();


                    if (nuevaGestion.asignarNota(id, codigo, nota)) {
                        System.out.println("Nota actualizada correctamente.");
                    } else {
                        System.out.println("Error al asignar la nota.");
                    }

                    break;
                case "7":

                    nuevaGestion.mostrarPersonas();
                    break;
                case "8":

                    nuevaGestion.mostrarProfesores();
                    break;
                case "9":

                    nuevaGestion.mostrarAlumnos();
                    break;
                case "10":

                    break;
                case "11":

                    break;
                case "12":

                    System.out.println("Ingrese el id de la persona: ");
                    id = sc.nextLine();

                    boolean borrarCliente = nuevaGestion.eliminarPersona(id);
                    if (borrarCliente) {
                        System.out.println("El persona eliminado correctamente.");
                    } else {
                        System.out.println("El persona no eliminado.");
                    }
                    break;
                case "13":
                    nuevaGestion.guardarDatos();
                    break;

            }
        } while (!opcion.equals("13") );

 }

}