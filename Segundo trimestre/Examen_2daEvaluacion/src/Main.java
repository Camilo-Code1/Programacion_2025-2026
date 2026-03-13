import java.time.LocalDate;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        supFormatos formas = new supFormatos();


        String nombreEmp = formas.obtenerTextoNoVacio("Ingrese el nombre de la empresa: " ,scanner);

        System.out.println();
        String CIF = formas.obtenerCIFValido("Ingrese el CIF de la empresa", scanner);


        LocalDate fechaFundacion = obtenerFechaValida();



        Empresa gestion = new Empresa(nombreEmp, CIF, fechaFundacion);


        gestion.cargarDatos();

        String menu = "\n1. Registrar trabajador en empresa.\n" +
                "2. Mostrar información general de la empresa. \n" +
                "3. Mostrar el numero de trabajadores actuales y guardar. \n" +
                "4. Mostrar información de un departamento.  \n" +
                "5. Eliminar trabajador empresa.\n" +
                "6. Guardar toda la información de la empresa.\n" +
                "7. Guardar y salir. ";

        String submenu = "\na. Registrar director.\n"+
                "b. Registrar Gerente.\n"+
                "c. Registrar Trabajador.";

        String opcion = "";

        String nombre, dni, direccion, numeroSS, emailEmp;
        double salario;
        LocalDate fechaNacimiento;
        Departamento depart;


        do {
            scanner = new Scanner(System.in);
            System.out.println(menu);
            opcion = scanner.nextLine();
            switch (opcion){
                case "1":
                    scanner = new Scanner(System.in);

                    System.out.println(submenu);
                    String subopcion = scanner.nextLine().toLowerCase();

                    switch (subopcion){
                        case "a":

                            nombre = formas.obtenerTextoNoVacio("Ingrese el nombre del Trabajador: ", scanner);

                            fechaNacimiento = obtenerFechaValida();

                            dni = obtenerDNIValido().toUpperCase();


                            direccion = formas.obtenerTextoNoVacio("Ingrese la direccion del trabajador: ", scanner);


                            System.out.println("Ingrese el numero de la seguridad social (10 digitos): ");
                            numeroSS = scanner.nextLine();
                            while (!formas.esNumeroSS(numeroSS)){
                                System.out.println("El numero de seguridad social no es valido");
                                numeroSS = scanner.nextLine();
                            }



                            System.out.println("Ingrese el Email del trabajador (juan.perez@gmail.com): ");
                            emailEmp = scanner.nextLine();
                            while (!formas.esEmailValido(emailEmp)) {
                                System.out.println("El correo introducido no es valido");
                                emailEmp = scanner.nextLine();
                            }

                            scanner = new Scanner(System.in);


                            salario = formas.obtenerDoubleValido("Ingrese el salario del trabajador: ", scanner);


                            int gen = -1;

                            do {
                                System.out.println("Seleccione un departamento: ");
                                for (Departamento g : Departamento.values()){
                                    System.out.println((g.ordinal() + 1 ) + ". " + g);
                                }
                                System.out.println("Opcion: ");
                                String entrada = scanner.nextLine();

                                if (entrada.matches("\\d+")){
                                    gen = Integer.parseInt(entrada);
                                } else {
                                    System.out.println("Error: Debes de ingresar un numero.");
                                    continue;
                                }
                                if (gen < 1 || gen > Departamento.values().length){
                                    System.out.println("Opcion fuera de rango. Intentelo de nuevo");
                                }

                            } while (gen < 1 || gen > Departamento.values().length);

                            depart = Departamento.values()[gen - 1];

                            System.out.println("Ingrese el telefono del Director (9-12 digitos): ");
                            String telefono = scanner.nextLine();
                            while (!formas.esTelefonoValido(telefono)){
                                System.out.println("El telefono introducido no es valido");
                                telefono = scanner.nextLine();
                            }



                            String cocheEmpresa = formas.obtenerTextoNoVacio("Ingrese el coche que tiene por la empresa: ", scanner);

                            Director nuevoDirector = new Director(nombre, fechaNacimiento, dni, direccion,
                                    numeroSS, emailEmp, salario, depart, telefono, cocheEmpresa);

                            gestion.registrarTrabajador(nuevoDirector);

                            break;
                        case "b":

                            System.out.println("¡Sin datos!");

                            break;
                        case "c":
                            nombre = formas.obtenerTextoNoVacio("Ingrese el nombre del Trabajador: ", scanner);


                            fechaNacimiento = obtenerFechaValida();

                            dni = obtenerDNIValido().toUpperCase();


                            direccion = formas.obtenerTextoNoVacio("Ingrese la direccion del trabajador: ", scanner);


                            System.out.println("Ingrese el numero de la seguridad social (10 digitos): ");
                            numeroSS = scanner.nextLine();
                            while (!formas.esNumeroSS(numeroSS)){
                                System.out.println("El numero de seguridad social no es valido");
                                numeroSS = scanner.nextLine();
                            }



                            System.out.println("Ingrese el Email del trabajador (juan.perez@gmail.com): ");
                            emailEmp = scanner.nextLine();
                            while (!formas.esEmailValido(emailEmp)) {
                                System.out.println("El correo introducido no es valido");
                                emailEmp = scanner.nextLine();
                            }

                            scanner = new Scanner(System.in);


                            salario = formas.obtenerDoubleValido("Ingrese el salario del trabajador: ", scanner);


                            gen = -1;

                            do {
                                System.out.println("Seleccione un departamento: ");
                                for (Departamento g : Departamento.values()){
                                    System.out.println((g.ordinal() + 1 ) + ". " + g);
                                }
                                System.out.println("Opcion: ");
                                String entrada = scanner.nextLine();

                                if (entrada.matches("\\d+")){
                                    gen = Integer.parseInt(entrada);
                                } else {
                                    System.out.println("Error: Debes de ingresar un numero.");
                                    continue;
                                }
                                if (gen < 1 || gen > Departamento.values().length){
                                    System.out.println("Opcion fuera de rango. Intentelo de nuevo");
                                }

                            } while (gen < 1 || gen > Departamento.values().length);

                            depart = Departamento.values()[gen - 1];

                            Trabajador nuevoTrabajador = new Trabajador(nombre, fechaNacimiento, dni, direccion,
                                    numeroSS, emailEmp, salario, depart);

                            gestion.registrarTrabajador(nuevoTrabajador);

                            System.out.println("Datos guardados correctamente");

                            break;
                    }

                    break;
                case "2":
                    scanner = new Scanner(System.in);

                    gestion.mostrarTrabajadores();

                    break;
                case "3":
                    scanner = new Scanner(System.in);
                    gestion.mostrarNumeroTrabajadores();

                    break;
                case "4":
                    scanner = new Scanner(System.in);

                    System.out.println(gestion.toString());

                    gestion.mostrarTrabajadoresDepartamentosDireccion();
                    gestion.mostrarTrabajadoresDepartamentosInformatica();

                    gestion.mostrarTrabajadoresDepartamentosMarketing();
                    gestion.mostrarTrabajadoresDepartamentosGestion();

                    gestion.mostrarCosteSalarios();


                    break;
                case "5":
                    scanner = new Scanner(System.in);

                    gestion.mostrarTrabajadoresFiltrados();

                    dni = formas.obtenerTextoNoVacio("Inserta el numero del DNI para eliminar: ", scanner);
                    boolean exitoEliminar = gestion.eliminarTrabajador(dni);

                    if (exitoEliminar) {
                        System.out.println("Se ha eliminado con exito.");
                    } else {
                        System.out.println("No se ha eliminado al trabajador.");
                    }
                    break;
                case "6":
                    scanner = new Scanner(System.in);
                    gestion.guardarDatos();
                    break;
                case "7":
                    gestion.guardarDatos();
                    scanner = new Scanner(System.in);

                    break;
            }

        } while (!opcion.equals("7"));


    }



    private static LocalDate obtenerFechaValida() {
        Scanner sc = new Scanner(System.in);
        String fecha;

        while (true) {
            System.out.println("Inserte la fecha de nacimiento del trabajador (dd/MM/yyyy):");
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

    private static String obtenerDNIValido () {
        Scanner sc = new Scanner(System.in);
        String dni;
        while (true) {
            System.out.println("Ingrese el DNI del cliente (Ejemplo: 87654321M):");
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