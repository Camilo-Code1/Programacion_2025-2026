package org.example;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        SQLAcessDelivery.cargarEstilos();
        SQLAcessDelivery.cargarEstados();
        SQLAcessDelivery.cargarPedidos();
        SQLAcessDelivery.cargarPlatillos();

        String nombreBuscar;

        String menu = """
                
                \n1. Lista de Pedido.
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

                    System.out.println("Inserte el nombre del Cliente:");
                    String cliente = sc.nextLine();

                    obtenerEstados();
                    System.out.println("Inserte el numero de Platillo que ha ordenado:");
                    int idPlatilloElegido = sc.nextInt();

                    Platillos id_platillo = SQLAcessDelivery.obtenerPlatilloPorID(idPlatilloElegido);

                    if (id_platillo == null) {
                        System.out.println("Error: ID de Platillo no existe");
                    } else {
                        System.out.println("ID aceptada");
                    }


                    obtenerPlatillos();
                    System.out.println("Inserte el numero del Estado:");
                    int estadoElegido = sc.nextInt();

                    estadosEntrega id_estado = SQLAcessDelivery.obtenerEstadoPorID(estadoElegido);
                    if (id_estado == null) {
                        System.out.println("Error: ID de Estado no existe");
                    } else {
                        System.out.println("ID aceptada");
                    }

                    SQLAcessDelivery.insertarPedido(new Pedidos(cliente, id_platillo, id_estado));

                    break;
                case "4":
                    do {
                        sc = new Scanner(System.in);
                        System.out.println(submenu1);
                        subopcion = sc.nextLine();

                        switch (subopcion){
                            case "a":

                                System.out.println(SQLAcessDelivery.cargarPedidos());

                                System.out.println("Inserte el numero de ID del Pedido a actualizar:");
                                int idPlatilloActualizar = sc.nextInt();

                                obtenerEstados();
                                System.out.println("Indique el nuevo estado del Pedido:");
                                int estadoActualizar = sc.nextInt();

                                SQLAcessDelivery.actualizarEstadoPedido(idPlatilloActualizar, estadoActualizar);


                                break;
                            case "b":

                                obtenerEstados();

                                System.out.println("Inserte el numero del Estado para listar los pedidos:");
                                int estadoListar = sc.nextInt();

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

                                System.out.println("Desea agregar un nuevo platillo o actualizar uno existente? (1 Para agregar o 2 Para actualizar)");
                                int accion = sc.nextInt();
                                if (accion == 1){
                                    sc = new Scanner(System.in);
                                    System.out.println("Ingrese el nombre del nuevo platillo:");
                                    String nombrePlatillo = sc.nextLine();

                                    System.out.println("Ingrese el precio del nuevo platillo:");
                                    double precioPlatillo = sc.nextDouble();

                                    obtenerEstilos();
                                    System.out.println("Ingrese el numero del estilo de cocina del nuevo platillo:");
                                    int estiloPlatillo = sc.nextInt();

                                    estilosCocina seleccionado = SQLAcessDelivery.obtenerEstiloPorID(estiloPlatillo);

                                     SQLAcessDelivery.insertarPlatillo(new Platillos(nombrePlatillo, precioPlatillo, seleccionado));

                                } else if (accion == 2) {



                                }


                                break;
                            case "b":

                                System.out.println("Introduzca el nombre del nuevo estilo de cocina:");
                                String nuevoEstilo = sc.nextLine();

                                SQLAcessDelivery.agregarEstiloCocina(new estilosCocina(nuevoEstilo));

                                break;
                            case "c":
                                System.out.println("Saliendo al menú principal...");
                                break;
                        }
                    } while (!subopcion.equals("c"));
                    break;
                case "6":
                    System.out.println("Introduzca el nombre del cliente a buscar:");
                    nombreBuscar = sc.nextLine();

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
                                System.out.println("Introduzca el nombre del cliente a buscar:");
                                nombreBuscar = sc.nextLine();

                                boolean exito = SQLAcessDelivery.eliminarPedido(nombreBuscar);

                                if (exito) {
                                    System.out.println("Pedido eliminado");
                                } else {
                                    System.out.println("Pedido no eliminado");
                                }
                                break;
                            case "b":

                                break;
                            case "c":
                                System.out.println("Saliendo al menú principal...");
                                break;
                        }
                    } while (!subopcion.equals("c"));
                    break;
                case "8":
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
                System.out.println(e);
            }
        }
    }
}