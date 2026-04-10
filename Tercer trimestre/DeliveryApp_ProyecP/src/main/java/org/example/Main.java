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

                    System.out.println("Inserte el numero de Platillo que ha ordenado:");
                    int idPlatilloElegido = sc.nextInt();

                    Platillos id_platillo = SQLAcessDelivery.obtenerPedidosPorID(idPlatilloElegido);

                    if (id_platillo == null) {
                        System.out.println("Error: ID de Platillo no existe");
                    } else {
                        System.out.println("ID aceptada");
                    }

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
                    break;
                case "5":
                    break;
                case "6":
                    System.out.println("Introduzca el nombre del cliente a buscar:");
                    String nombreBuscar = sc.nextLine();

                    List<Pedidos> encontrados = SQLAcessDelivery.obtenerPedidosPorNombre(nombreBuscar);

                    if (encontrados.isEmpty()) {
                        System.out.println("No se encontraron pedidos para: " + nombreBuscar);
                    } else {
                        System.out.println("--- PEDIDOS ENCONTRADOS ---");
                        for (Pedidos p : encontrados) {
                            System.out.println(p); // Usará tu toString() formateado
                        }
                    }
                    break;
                case "7":
                    sc = new Scanner(System.in);
                    System.out.println("Introduzca el nombre del cliente a buscar:");
                    nombreBuscar = sc.nextLine();

                    boolean exito = SQLAcessDelivery.eliminarPedido(nombreBuscar);

                    if (exito) {
                        System.out.println("Pedido eliminado");
                    } else {
                        System.out.println("Pedido no eliminado");
                    }
                    break;
                case "8":
                    break;
            }
        } while (!opcion.equals("8"));

    }

}