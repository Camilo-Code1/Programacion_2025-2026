package org.example;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        supFormatos Formas  = new supFormatos();

        SQLAcessDelivery.cargarEstilos();
        SQLAcessDelivery.cargarEstados();
        SQLAcessDelivery.cargarPedidos();
        SQLAcessDelivery.cargarPlatillos();

        String nombreBuscar;

        String menu = """
                
                1. Lista de Pedido.
                2. Lista de Platillos.\s
                3. Realizar Nuevo Pedido.\s
                4. Gestión de Estados.
                5. Mantenimiento de Catálogo.\s
                6. Búsqueda Avanzada.\s
                7. Administración.
                8. Salir.
                
                """;

        String opcion = "";

        String submenu1 = """
                
                a. Cambiar Estado de un pedido.
                b. Lista de pedidos por Estado.
                c. Salir al menú principal.""";

        String submenu2 = """
                
                a. Agregar/Actualizar Platillo.
                b. Agregar Estilo de Cocina.
                c. Salir al menú principal.""";

        String submenu3 = """
                
                a. Eliminar Pedido.\s
                b. Reporte de Ventas.
                c. Salir al menú principal.""";

        String subopcion = "";

        do {
            sc = new Scanner(System.in);
            System.out.println(menu);
            opcion = sc.nextLine();
            switch (opcion) {
                case "1":
                    System.out.println(SQLAcessDelivery.cargarPedidos());

                    break;
                case "2":
                    System.out.println(SQLAcessDelivery.cargarPlatillos());

                    break;
                case "3":

                    String cliente = Formas.obtenerTextoNoVacio("Inserte el nombre del Cliente:", sc);

                    System.out.println(SQLAcessDelivery.cargarPlatillos());
                    int idPlatilloElegido = Formas.obtenerEnteroValido("\nInserte el número del Platillo que se ordena:", sc);

                    estadosEntrega id_estado = SQLAcessDelivery.obtenerEstadoPorID(1); // Automático: Pendiente
                    Platillos platillo = SQLAcessDelivery.obtenerPlatilloPorID(idPlatilloElegido);

                    if (platillo == null) {
                        System.out.println("Error: ID de Platillo no existe.");
                    } else {
                        SQLAcessDelivery.insertarPedido(new Pedidos(cliente, platillo, id_estado));
                    }
                    break;
                case "4":
                    do {
                        sc = new Scanner(System.in);
                        System.out.println(submenu1);
                        subopcion = sc.nextLine();

                        switch (subopcion){
                            case "a":

                                System.out.println(SQLAcessDelivery.cargarPedidos());


                                int idPlatilloActualizar = Formas.obtenerEnteroValido("Inserte el numero de ID del Pedido a actualizar:", sc);

                                obtenerEstados();

                                int estadoActualizar = Formas.obtenerEnteroValido("Indique el nuevo estado del Pedido:", sc);

                                SQLAcessDelivery.actualizarEstadoPedido(idPlatilloActualizar, estadoActualizar);


                                break;
                            case "b":

                                obtenerEstados();


                                int estadoListar = Formas.obtenerEnteroValido("Inserte el numero del Estado para listar los pedidos:", sc);

                                List<Pedidos> pedidosPorEstado = SQLAcessDelivery.mostrarPedidosPorEstado(estadoListar);

                                if (pedidosPorEstado.isEmpty()){
                                    System.out.println("No se encontraron pedidos con ese estado.");
                                } else {
                                    System.out.println("--- PEDIDOS CON ESTADO SELECCIONADO ---");
                                    for (Pedidos p : pedidosPorEstado) {
                                        System.out.println(p);
                                    }
                                }

                                break;
                            case "c":
                                System.out.println("Saliendo al menú principal...");
                                break;
                        }
                    } while (!subopcion.equals("c"));
                    break;
                case "5":
                    do {
                        sc = new Scanner(System.in);
                        System.out.println(submenu2);
                        subopcion = sc.nextLine();

                        switch (subopcion){
                            case "a":

                                int action = Formas.obtenerEnteroValido("Desea agregar un nuevo platillo o actualizar uno existente? (1 Para agregar o 2 Para actualizar)", sc);
                                if (action == 1){
                                    sc = new Scanner(System.in);
                                    String nombrePlatillo = Formas.obtenerTextoNoVacio("Ingrese el nombre del nuevo platillo:", sc);

                                    double precioPlatillo = Formas.obtenerDoubleValido("Ingrese el precio del nuevo platillo:", sc);

                                    obtenerEstilos();

                                    int estiloPlatillo = Formas.obtenerEnteroValido("Ingrese el numero del estilo de cocina del nuevo platillo:", sc);

                                    estilosCocina seleccionado = SQLAcessDelivery.obtenerEstiloPorID(estiloPlatillo);

                                     SQLAcessDelivery.insertarPlatillo(new Platillos(nombrePlatillo, precioPlatillo, seleccionado));

                                } else if (action == 2) {
                                    sc = new Scanner(System.in);

                                    obtenerPlatillos();

                                    int idAEditar = Formas.obtenerEnteroValido("Ingrese el ID del platillo que desea ACTUALIZAR:", sc);

                                    Platillos platilloExistente = SQLAcessDelivery.obtenerPlatilloPorID(idAEditar);

                                    if (platilloExistente == null) {
                                        System.out.println("Error: No existe un platillo con ese ID.");
                                    } else {
                                        System.out.println("--- Editando: " + platilloExistente.getNombre() + " ---");

                                        sc = new Scanner(System.in);

                                        String nuevoNombre = Formas.obtenerTextoNoVacio("Nuevo nombre (Actual: " + platilloExistente.getNombre() + "):", sc);

                                        double nuevoPrecio = Formas.obtenerDoubleValido("Nuevo precio (Actual: " + platilloExistente.getPrecio() + "):", sc);

                                        obtenerEstilos();

                                        int nuevoEstiloId = Formas.obtenerEnteroValido("Nuevo ID de estilo de cocina:", sc);

                                        estilosCocina nuevoEstilo = SQLAcessDelivery.obtenerEstiloPorID(nuevoEstiloId);

                                        if (nuevoEstilo == null) {
                                            System.out.println("Error: El estilo de cocina no existe. Actualización abortada.");
                                        } else {
                                            Platillos platilloActualizado = new Platillos(idAEditar, nuevoNombre, nuevoPrecio, nuevoEstilo);

                                            SQLAcessDelivery.actualizarPlatillo(platilloActualizado, idAEditar);
                                        }
                                    }
                                }


                                break;
                            case "b":

                                String nuevoEstilo = Formas.obtenerTextoNoVacio("Introduzca el nombre del nuevo estilo de cocina:", sc);

                                SQLAcessDelivery.agregarEstiloCocina(new estilosCocina(nuevoEstilo));

                                break;
                            case "c":
                                System.out.println("Saliendo al menú principal...");
                                break;
                        }
                    } while (!subopcion.equals("c"));
                    break;
                case "6":
                    mostrarNombresClientes();
                    nombreBuscar = Formas.obtenerTextoNoVacio("\nIntroduzca el nombre del cliente a buscar:", sc);

                    List<Pedidos> encontrados = SQLAcessDelivery.obtenerPedidosPorNombre(nombreBuscar);

                    if (encontrados.isEmpty()) {
                        System.out.println("No se encontraron pedidos para: " + nombreBuscar);
                    } else {
                        System.out.println("--- PEDIDOS ENCONTRADOS ---");
                        for (Pedidos p : encontrados) {
                            System.out.println(p);
                        }
                    }
                    break;
                case "7":
                    do {
                        sc = new Scanner(System.in);
                        System.out.println(submenu3);
                        subopcion = sc.nextLine();

                        switch (subopcion){
                            case "a":

                                mostrarNombresClientes();
                                nombreBuscar = Formas.obtenerTextoNoVacio("Introduzca el nombre del cliente a buscar:", sc);

                                boolean exito = SQLAcessDelivery.eliminarPedido(nombreBuscar);


                                break;
                            case "b":
                                System.out.println("A");
                                SQLAcessDelivery.generarReporteVentas();
                                break;
                            case "c":
                                System.out.println("Saliendo al menú principal...");
                                break;
                        }
                    } while (!subopcion.equals("c"));
                    break;
                case "8":
                    System.out.println("Saliendo del sistema...");
                    break;
            }
        } while (!opcion.equals("8"));

    }

    private static void obtenerEstados(){
        SQLAcessDelivery.cargarEstados();

        List<estadosEntrega> estados = SQLAcessDelivery.getNombresEstados();

        if (estados.isEmpty()){
            System.out.println("No se encontraron estados de entrega.");
        } else {
            System.out.println("--- ESTADOS DE ENTREGA ---");
            for (estadosEntrega e : estados) {
                System.out.println(e);

            }
        }
    }

    public static void obtenerPlatillos(){
        SQLAcessDelivery.cargarEstilos();

        List<Platillos> platillos = SQLAcessDelivery.getNombresPlatillos();

        if (platillos.isEmpty()){
            System.out.println("No se encontraron platillos.");
        } else {
            System.out.println("--- PLATILLOS ---");
            for (Platillos p : platillos) {
                System.out.println(p);
            }
        }
    }

    public static void obtenerEstilos(){
        SQLAcessDelivery.cargarEstilos();

        List<estilosCocina> estilos = SQLAcessDelivery.getNombresEstilos();

        if (estilos.isEmpty()){
            System.out.println("No se encontraron estilos de cocina.");
        } else {
            System.out.println("--- ESTILOS DE COCINA ---");
            for (estilosCocina e : estilos) {
                System.out.println(e.getId() + ". " + e.getNombre());
            }
        }
    }
    public static void mostrarNombresClientes() {
        List<String> clientes = SQLAcessDelivery.obtenerClientesConPedidos();
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados actualmente.");
        } else {
            System.out.println("--- CLIENTES ACTUALES CON PEDIDOS ---");
            clientes.forEach(System.out::println);
        }
    }
}