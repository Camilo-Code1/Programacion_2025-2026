import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Gestion nuevoMovimiento = new Gestion();

        nuevoMovimiento.cargarDatos();

        String menu = """
                \n1. Crear y registrar plataforma en franquincia.\s
                2. Registar articulo (Pelicula o Videojuego).
                3. Registrar cliente.
                4. Alquilar articulo.\s
                5. Devolver articulo.\s
                6. Dar de baja cliente.
                7. Dar de baja articulo.\s
                8. Mostrar todos los artículos.
                9. Mostrar todos los clientes.\s
                10. Salir.\s
                """;

        String opcion = "";

        do {
            sc = new Scanner(System.in);
            System.out.println(menu);
            opcion = sc.nextLine();
            switch (opcion) {
                case "1":
                    break;
                case "2":
                    System.out.println("¿Que deseas registrar? (1) Pelicula (2) Videjuego");
                    int seleccion = sc.nextInt();

                    sc = new Scanner(System.in);

                    System.out.println("Ingrese el titulo del articulo: ");
                    String titulo = sc.nextLine();

                    if (seleccion == 1) {
                        System.out.println("Duracion de la pelicula (Minutos): ");
                        int duracionH = sc.nextInt();

                        sc = new Scanner(System.in);

                        Genero genero;
                        int gen = -1;

                        do {
                            System.out.println("Seleccione un género:");
                            for (Genero g : Genero.values()) {
                                System.out.println((g.ordinal() + 1) + ". " + g);
                            }
                            System.out.println("Opción: ");

                            String entrada = sc.nextLine();


                            if (entrada.matches("\\d+")) {
                                gen = Integer.parseInt(entrada);
                            } else {
                                System.out.println("Error: Debe ingresar un número.");
                                continue;
                            }

                            if (gen < 1 || gen > Genero.values().length) {
                                System.out.println("Opción fuera de rango. Intente nuevamente.");
                            }

                        } while (gen < 1 || gen > Genero.values().length);

                        genero = Genero.values()[gen - 1];

                        System.out.println("Ingrese el precio de la entrada: ");
                        double precioEntrada = sc.nextDouble();

                        Pelicula peli = new Pelicula(titulo, duracionH, genero, precioEntrada);
                        nuevoMovimiento.agregarArticulo(peli);


                    }
                    if (seleccion == 2) {
                        sc = new Scanner(System.in);
                        System.out.println("De que plataforma es el videojuego?");
                        String plataforma = sc.nextLine();

                        Pegi pegiAsignado;
                        int peg = -1;

                        do {
                            System.out.println("Cual es el PEGI que tiene asignado?");
                            for (Pegi p : Pegi.values()) {
                                System.out.println((p.ordinal() + 1) + ". " + p);
                            }

                            System.out.println("Opcion: ");
                            String entrada = sc.nextLine();

                            if (entrada.matches("\\d+")){
                                peg = Integer.parseInt(entrada);
                            } else {
                                System.out.println("Error: Debe ingresar un número.");
                                continue;
                            }
                            if (peg < 1 || peg > Pegi.values().length) {
                                System.out.println("Opción fuera de rango. Intente nuevamente.");
                            }
                        } while (peg < 1 || peg > Pegi.values().length);

                        pegiAsignado = Pegi.values()[peg - 1];

                        System.out.println("Indique el precio del articulo por dia: ");
                        double precioXdia = sc.nextDouble();

                        Videojuego juego = new Videojuego(titulo, plataforma, pegiAsignado, precioXdia);

                        nuevoMovimiento.agregarArticulo(juego);
                    }

                    System.out.println("Registro completo.");

                    break;
                case "3":
                    System.out.println("Ingrese el DNI del cliente: ");
                    String dni = sc.nextLine();

                    System.out.println("Ingrese el nombre del cliente: ");
                    String nombre = sc.nextLine();

                    Cliente nuevo = new Cliente(dni, nombre);
                    nuevoMovimiento.agregarCliente(nuevo);

                    break;
                case "4":
                    sc = new Scanner(System.in);

                    nuevoMovimiento.mostrarClienteFiltro();

                    System.out.println("Ingrese el DNI del cliente: ");
                    dni = sc.nextLine();

                    nuevoMovimiento.mostrarArticulosFiltro();

                    System.out.println("Ingrese el ID del articulo: ");
                    String id = sc.nextLine();

                    boolean alquilado = nuevoMovimiento.alquilarArticulo(id, dni);

                    break;
                case "5":
                    sc = new Scanner(System.in);

                    nuevoMovimiento.mostrarClienteFiltro();

                    System.out.println("Ingrese el DNI del cliente: ");
                    dni = sc.nextLine();

                    nuevoMovimiento.mostrarArticulosNO_Disponibles();

                    System.out.println("Ingrese el ID del articulo: ");
                    id = sc.nextLine();

                    boolean devolver = nuevoMovimiento.devolverArticulo(id, dni);
                    break;
                case "6":
                    sc = new Scanner(System.in);

                    nuevoMovimiento.mostrarClienteFiltro();

                    System.out.println("Ingrese el DNI del cliente: ");
                    dni = sc.nextLine();

                    boolean borrarCliente = nuevoMovimiento.eliminarCliente(dni);

                    if (borrarCliente) {
                        System.out.println("Cliente dado de baja con éxito.");
                    } else {
                        System.out.println("No se pudo dar de baja al cliente. Verifique que el DNI sea correcto y que el cliente no tenga artículos alquilados.");
                    }

                    break;
                case "7":
                    sc = new Scanner(System.in);

                    nuevoMovimiento.mostrarArticulosNO_Disponibles();

                    System.out.println("Ingrese el ID del articulo: ");
                    id = sc.nextLine();

                    boolean borrrarArticulo = nuevoMovimiento.eliminarArticulo(id);

                    if (borrrarArticulo) {
                        System.out.println("Artículo dado de baja con éxito.");
                    } else {
                        System.out.println("No se pudo dar de baja al artículo. Verifique que el ID sea correcto y que el artículo no esté alquilado.");
                    }

                    break;
                case "8":
                    nuevoMovimiento.mostrarInventario();
                    break;
                case "9":
                    nuevoMovimiento.mostrarCliente();
                    break;
                case "10":
                    nuevoMovimiento.escribirDatosFichero();
                    System.out.println("Salir del programa.");
                    break;

            }
        } while (!opcion.equals("10"));

    }
}