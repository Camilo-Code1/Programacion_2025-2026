package org.example;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);



        SQLAcessMercaDaw.cargarTiposDesdeBD();

//        SQLDataAccess accesoDatos = new SQLDataAccess();

        int idProducto;

//        System.out.println(SQLAcessMercaDaw.obtenerTodosLosProductos());

        String menu = """
                
                1. Mostrar todos los Productos en el Inventario.
                2. Buscar producto por referencia.
                3. Buscar productos por tipo.
                4. Buscar producto por cantidad.
                5. Insertar un nuevo producto (no permitir referencias repetidas).
                6. Eliminar Producto por referencia.
                7. Actualizar producto (descripción, cantidad, precio, descuento, AplicarDto).
                8. Insertar un nuevo tipo de producto.
                9. Salir.""";




        String opcion;

        do {
            sc = new Scanner(System.in);
            System.out.println(menu);
            System.out.println("Introduce una opción:");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println(SQLAcessMercaDaw.obtenerTodosLosProductos());
                    break;
                case "2":
                    System.out.println(SQLAcessMercaDaw.getNombresProductos());
                    System.out.println("Introduce el ID del producto a buscar:");
                    idProducto = sc.nextInt();

                    Productos p = SQLAcessMercaDaw.obtenerProductoPorID(idProducto);

                    if (p != null) {
                        System.out.println("Producto encontrado: ");
                        System.out.println(p);
                    } else {
                        System.out.println("Producto no encontrado con ID: " + idProducto);
                    }
                    break;
                case "3":
                    System.out.println(SQLAcessMercaDaw.getNombresTipos());

                    System.out.println("Introduce el ID del tipo de producto a buscar:");
                    int idTipo = sc.nextInt();

                    TipoProducto tipo = SQLAcessMercaDaw.obtenerTipoPorID(idTipo);
                    // Implementar búsqueda por tipo
                    break;
                case "4":
                    // Implementar búsqueda por cantidad
                    break;
                case "5":

                    System.out.println("Inserte el nombre del nuevo tipo de producto:");
                    String nombreTipo = sc.nextLine();

                    SQLAcessMercaDaw.insertarTipoProducto(new TipoProducto(nombreTipo));

                    break;
                case "6":


                    System.out.println("Introduce el ID del producto a buscar:");
                    idProducto = sc.nextInt();

                    SQLAcessMercaDaw.deleteProductoPorID(idProducto);
                    break;
                case "7":
                    // Implementar actualización de producto
                    break;
                case "8":

                    System.out.println("Inserte el tipo de referencia del nuevo producto:");
                    String referencia = sc.nextLine();

                    System.out.println("Inserte el nombre del nuevo producto:");
                    String nombre = sc.nextLine();

                    System.out.println("Inserte la descripción del nuevo producto:");
                    String descripcion = sc.nextLine();

                    obtenerTipos();
                    System.out.println("Inserte el ID del tipo del nuevo producto:");
                    int tipoid = sc.nextInt();

                    System.out.println("Inserte la cantidad del nuevo producto:");
                    int cantidad = sc.nextInt();

                    System.out.println("Inserte el precio del nuevo producto:");
                    double precio = sc.nextDouble();

                    System.out.println("Inserte el descuento del nuevo producto:");
                    int descuento = sc.nextInt();

                    System.out.println("Inserte el IVA del nuevo producto:");
                    int iva = sc.nextInt();

                    System.out.println("¿Aplicar descuento? (true/false):");
                    boolean aplicar_dto = sc.nextBoolean();

                    for (TipoProducto t : SQLAcessMercaDaw.getNombresTipos()) {
                        if (t.getId() == tipoid) {
                            tipoid = t.getId();
                            break;
                        }
                    }

                    TipoProducto tipo_id = SQLAcessMercaDaw.obtenerTipoPorID(tipoid);

                    SQLAcessMercaDaw.insertarProducto(new Productos(referencia, nombre, descripcion, tipo_id, cantidad, precio, descuento, iva, aplicar_dto));


                    break;
                case "9":
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, introduce una opción del 1 al 9.");
            }
        } while (!opcion.equals("9"));

    }

    private static void obtenerTipos(){
        List<TipoProducto> tipos = SQLAcessMercaDaw.getNombresTipos();

        if (tipos.isEmpty()){
            System.out.println("No se encontraron tipos de productos.");
        } else {
            System.out.println("Tipos de productos disponibles:");
            for (TipoProducto tipo : tipos) {
                System.out.println(tipo);
            }
        }

    }
}