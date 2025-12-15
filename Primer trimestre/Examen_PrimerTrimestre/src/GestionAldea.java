import java.time.LocalDate;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class GestionAldea {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String menu = "1. Crear Equipo.\n" +
                "2. Registrar Ninja en el equipo.\n" +
                "3. Mostrar el número de ninjas totales en la Aldea.\n" +
                "4. Mostrar información de un equipo. \n" +
                "5. Mostrar información de todos los equipos.\n" +
                "6. Mostrar información de toda la Aldea.\n" +
                "7. Calcular estadísticas de toda la Aldea.\n" +
                "8. Cambiar ninja de un equipo.\n" +
                "9. Eliminar ninja de la Aldea.\n" +
                "10. Salir de la aplicación.";

        String submenurRegistros = "A. Registrar Ninja.\n" +
                "B. Registrar Sensei.";

        String submenuMostrar = "A. Mostrar Ninjas.\n" +
                "B. Mostrar Sensei.\n" +
                "c. Mostrar equipos";
        String opcion = "";

        String nombre, dni, direccion, numContrato, idNinja, tecnicaSecreta;
        LocalDate fechaNacimiento, fechaAlta;
        double ataque, defensa;
        Chakra chakra;
        Rango rango;


        Aldea nuevoUsuario;


        String nombreAldea = obtenerTextoNoVacio("Inserte el nombre de la aldea:", sc);


        String codAldea = obtenerTextoNoVacio("Inserte el codigo de la aldea:", sc);

        LocalDate fechaCreacion;

        System.out.println("Inserte la fecha de la creacion de la Aldea: ");
        fechaCreacion = obtenerFechaValida();

        String kage = obtenerTextoNoVacio("Inserte el nombre del Kage de la Aldea: ", sc);



        int maximoEquipos = obtenerEnteroValido(
                "Inserte el numero maximo de equipos para la Aldea: ", sc);

        nuevoUsuario = new Aldea(nombreAldea, codAldea, fechaCreacion, kage, maximoEquipos);

        do {
            System.out.println("");
            System.out.println(menu);
            System.out.println("");

            opcion = sc.nextLine();

            switch (opcion) {
                case "1":

                    nombre = obtenerTextoNoVacio( "Inserte el nombre de la aldea: ", sc);


                    String codEquipo = obtenerCodigoEquipo();

                    System.out.println("Inserte la fecha de la creación del equipo: ");
                    fechaCreacion = obtenerFechaValida();


                    int maximoNinjas = obtenerEnteroValido("Inserte el numero maximo de ninjas: ", sc);

                    Equipo e = new Equipo(nombre, codEquipo, fechaCreacion, maximoNinjas);
                    nuevoUsuario.agregarEquipo(e);

                    System.out.println("Equipo agregado exitosamente.");
                    break;
                case "2":

                    sc = new Scanner(System.in);

                    System.out.println("");
                    System.out.println(submenurRegistros);
                    System.out.println("");

                    String opcionRegistros = sc.nextLine().toUpperCase();

                    switch (opcionRegistros) {
                        case "A":

                            nombre  = obtenerTextoNoVacio("Ingresa el nombre del ninja", sc);

                            System.out.println("Ingresa su fecha de nacimiento");
                            fechaNacimiento = obtenerFechaValida();

                            System.out.println("Ingrese el DNI del ninja: ");
                            dni = obtenerDNIValido();


                            direccion = obtenerTextoNoVacio("Ingresa el direccion del ninja", sc);


                            numContrato = obtenerTextoNoVacio("Ingresa el numero de contrato del ninja", sc);

                            System.out.println("Ingrese el Chakra del ninja");
                            chakra = getChakra(sc);

                            System.out.println("Ingrese el rango del ninja");
                            rango = getRango(sc);

                            sc = new Scanner(System.in);

                            tecnicaSecreta = obtenerTextoNoVacio("Ingresa el tecnica del ninja", sc);

                            System.out.println("Inserte la fecha de alta del ninja");
                            fechaAlta = obtenerFechaValida();


                            ataque = obtenerDoubleValido( "Inserte el ataque del ninja", sc);


                            defensa = obtenerDoubleValido ("Inserte el defensa del ninja", sc);

                            Ninja nj = new Ninja(nombre,fechaNacimiento, dni, direccion, numContrato, TipoPersona.NINJA,
                                    chakra, rango, tecnicaSecreta, fechaAlta, ataque, defensa);
                            nuevoUsuario.agregarNinja(nj);

                            System.out.println("Ninja agregado exitosamente.");

                            break;
                        case "B":
                            nombre  = obtenerTextoNoVacio("Ingresa el nombre del ninja", sc);

                            System.out.println("Ingresa su fecha de nacimiento");
                            fechaNacimiento = obtenerFechaValida();

                            System.out.println("Ingrese el DNI del ninja: ");
                            dni = obtenerDNIValido();


                            direccion = obtenerTextoNoVacio("Ingresa el direccion del ninja", sc);


                            numContrato = obtenerTextoNoVacio("Ingresa el numero de contrato del ninja", sc);

                            System.out.println("Ingrese el Chakra del ninja");
                            chakra = getChakra(sc);

                            System.out.println("Ingrese el rango del ninja");
                            rango = getRango(sc);


                            tecnicaSecreta = obtenerTextoNoVacio("Ingresa el tecnica del ninja", sc);

                            System.out.println("Inserte la fecha de alta del ninja");
                            fechaAlta = obtenerFechaValida();


                            ataque = obtenerDoubleValido( "Inserte el ataque del ninja", sc);


                            defensa = obtenerDoubleValido ("Inserte el defensa del ninja", sc);


                            sc = new Scanner(System.in);


                            String codSensei = obtenerTextoNoVacio("Ingresa el codigo del sensei del ninja", sc);


                            double estrategia = obtenerDoubleValido("Inserte el estrategia del ninja", sc);


                            double liderazgo = obtenerDoubleValido("Inserte el liderazgo del ninja", sc);

                            Sensei s = new Sensei(nombre,fechaNacimiento, dni, direccion, numContrato, TipoPersona.SENSEI,
                                    chakra, rango, tecnicaSecreta, fechaAlta, ataque, defensa, codSensei, estrategia, liderazgo);

                            nuevoUsuario.agregarSensei(s);
                            System.out.println("Sensei agregado exitosamente.");
                            break;
                    }

                    break;

                case "3":
                    nuevoUsuario.numeroNinjas();
                    break;
                case "4":
                    nuevoUsuario.mostrarEquipos();
                    break;
                case "5":
                    sc = new Scanner(System.in);

                    System.out.println("");
                    System.out.println(submenuMostrar);
                    System.out.println("");

                    String opcionMostrar = sc.nextLine().toUpperCase();
                    switch (opcionMostrar) {
                        case "A":
                            System.out.println("A");
                            nuevoUsuario.mostrarNinjas();
                            break;
                        case "B":
                            System.out.println("B");
                            nuevoUsuario.mostrarSensei();
                            break;
                        case "C":
                            nuevoUsuario.mostrarEquipos();
                            break;

                    }

                    break;
                case "6":
                    nuevoUsuario.mostrarAldea();
                    break;
                case "7":
                    nuevoUsuario.mostrarNinjas();
                    break;
                case "8":
                    System.out.println("Ingresa el nombre del ninja");
                    TipoPersona tipo = TipoPersona.valueOf(sc.nextLine());
                    nuevoUsuario.mostrarNinjasAgrupadosPorGenero(tipo);
                    break;
                case "9":
                    System.out.println("Ingrese el ID del ninja que quiere eliminar: ");
                    idNinja = sc.nextLine();

                    nuevoUsuario.eliminarNinja(idNinja);
                    break;
                case "10":
                    break;
            }
        } while (!opcion.equals("10"));


    }



    private static LocalDate obtenerFechaValida() {
        Scanner sc = new Scanner(System.in);
        String fecha;

        while (true) {
            System.out.println("Ingrese la fecha (dd/MM/yyyy):");
            fecha = sc.nextLine();

            if (validarFecha(fecha)) {
                String[] p = fecha.split("/");
                int dia = Integer.parseInt(p[0]);
                int mes = Integer.parseInt(p[1]);
                int anio = Integer.parseInt(p[2]);

                if (dia >= 1 && dia <= 30 && mes >= 1 && mes <= 12) {
                    return LocalDate.of(anio, mes, dia);
                }
            }

            System.out.println("Fecha inválida. Intente de nuevo.");
        }
    }

    private static boolean validarFecha(String fecha) {
        return fecha.matches("^\\d{2}/\\d{2}/\\d{4}$");
    }



    // MOSTRAR ENUMS

    private static Chakra getChakra(Scanner sc) {
        Chakra tipo;
        int in = -1;

        do {
            System.out.println("Introduzca el tipo de Chakra: ");
            for (Chakra libro : Chakra.values()) {
                System.out.println((libro.ordinal() + 1) + ". " + libro);
            }
            System.out.print("Opcion: ");
            String entrada = sc.nextLine();

            if (entrada.matches("\\d+")) {
                in = Integer.parseInt(entrada);
            } else {
                System.out.println("\nOpcion no valida. Debe de ingresar un numero.");
                continue;
            }
            if (in < 1 || in > Chakra.values().length) {
                System.out.println("\nError: Numero fuera de rango. Intente de nuevo.");
            }
        } while (in < 1 || in > Chakra.values().length);

        return Chakra.values()[in - 1];
    }

    private static Rango getRango(Scanner sc) {
        Rango tipo;
        int in = -1;

        do {
            System.out.println("Introduzca el tipo de rango del ninja: ");
            for (Rango libro : Rango.values()) {
                System.out.println((libro.ordinal() + 1) + ". " + libro);
            }
            System.out.print("Opcion: ");
            String entrada = sc.nextLine();

            if (entrada.matches("\\d+")) {
                in = Integer.parseInt(entrada);
            } else {
                System.out.println("\nOpcion no valida. Debe de ingresar un numero.");
                continue;
            }
            if (in < 1 || in > Rango.values().length) {
                System.out.println("\nError: Numero fuera de rango. Intente de nuevo.");
            }
        } while (in < 1 || in > Rango.values().length);

        return Rango.values()[in - 1];
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
    private static int obtenerEnteroValido(String mensaje, Scanner sc) {
        while (true) {
            System.out.println(mensaje);
            String entrada = sc.nextLine();

            if (entrada.matches("\\d+")) {
                return Integer.parseInt(entrada);
            }
            System.out.println("\nError: Debe ingresar un número entero válido.");
        }
    }

    private static double obtenerDoubleValido(String mensaje, Scanner sc) {
        while (true) {
            System.out.println(mensaje);
            String entrada = sc.nextLine();

            if (entrada.matches("\\d+(\\.\\d+)?")) {
                return Double.parseDouble(entrada);
            }
            System.out.println("\nError: Debe ingresar un número válido (ej: 10.5).");
        }
    }

    private static String obtenerCodigoEquipo() {
        Scanner sc = new Scanner(System.in);
        String codigo;

        while (true) {
            System.out.println("Ingrese el código de la biblioteca (Ej: AB1234567):");
            codigo = sc.nextLine().toUpperCase();

            if (codigo.matches("^[A-Z]{2}\\d{7}$")) {
                return codigo;
            }
            System.out.println("Código inválido. Intente de nuevo.");
        }
    }

}


