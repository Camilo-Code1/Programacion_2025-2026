package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);



        SQLAcessMercaDaw.cargarTiposDesdeBD();

//        SQLDataAccess accesoDatos = new SQLDataAccess();

        System.out.println(SQLAcessMercaDaw.getNombresProductos());


        int idProducto;




        System.out.println(SQLAcessMercaDaw.obtenerTodosLosProductos());

        String menu = "\n1. Mostrar todos los Productos en el Inventario.\n" +
                "2. Buscar producto por referencia.\n" +
                "3. Buscar productos por tipo.\n" +
                "4. Buscar producto por cantidad.\n" +
                "5. Insertar un nuevo producto (no permitir referencias repetidas).\n" +
                "6. Eliminar Producto por referencia.\n" +
                "7. Actualizar producto (descripción, cantidad, precio, descuento, AplicarDto).\n" +
                "8. Insertar un nuevo tipo de producto.\n" +
                "9. Salir.";


        System.out.println(menu);

        String opcion = "";

        do {
            System.out.println("Introduce una opción:");
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println(SQLAcessMercaDaw.obtenerTodosLosProductos());
                    break;
                case "2":
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
                    // Implementar búsqueda por tipo
                    break;
                case "4":
                    // Implementar búsqueda por cantidad
                    break;
                case "5":
                    // Implementar inserción de nuevo producto
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
                    // Implementar inserción de nuevo tipo de producto
                    break;
                case "9":
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, introduce una opción del 1 al 9.");
            }
        } while (!opcion.equals("9"));

    }
}