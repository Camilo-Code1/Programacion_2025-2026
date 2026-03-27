package org.example;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        supFormatos formas = new supFormatos();


        SQLAcessMercaDaw.cargarTiposDesdeBD();

        String refDir;

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

                    refDir = formas.obtenerTextoNoVacio("Introduce la referencia del producto a buscar:", sc);

                    Productos p = SQLAcessMercaDaw.obtenerProductoPorREF(refDir.toUpperCase());

                    if (p != null) {
                        System.out.println("Producto encontrado: ");
                        System.out.println(p);
                    } else {
                        System.out.println("Producto no encontrado con ID: " + refDir);
                    }
                    break;
                case "3":
                    System.out.println(SQLAcessMercaDaw.getNombresTipos());


                    int idTipoBusqueda = formas.obtenerEnteroValido("Introduce el ID del tipo de producto a buscar:", sc);

                    List<Productos> productosFiltrados = SQLAcessMercaDaw.obtenerProductosPorTipo(idTipoBusqueda);

                    if (productosFiltrados.isEmpty()) {
                        System.out.println("No hay productos en esta categoría.");
                    } else {
                        System.out.println("--- Productos encontrados ---");
                        for (Productos prod : productosFiltrados) {
                            System.out.println(prod);
                        }
                    }
                    break;
                case "4":

                    int cantBuscada = formas.obtenerEnteroValido("Introduce la cantidad exacta de stock a buscar:", sc);

                    List<Productos> prodsPorCant = SQLAcessMercaDaw.obtenerProductosPorCantidad(cantBuscada);

                    if (prodsPorCant.isEmpty()) {
                        System.out.println("No se encontraron productos con exactamente " + cantBuscada + " unidades.");
                    } else {
                        System.out.println("--- Productos con stock: " + cantBuscada + " ---");
                        for (Productos prod : prodsPorCant) {
                            System.out.println(prod);
                        }
                    }
                    break;
                case "5":
                    System.out.println(SQLAcessMercaDaw.getNombresProductos());

                    String nombreTipo = formas.obtenerTextoNoVacio("Inserte el nombre del nuevo tipo de producto:", sc);

                    SQLAcessMercaDaw.insertarTipoProducto(new TipoProducto(nombreTipo.toUpperCase()));

                    break;
                case "6":
                    System.out.println(SQLAcessMercaDaw.getNombresProductos());


                    refDir = formas.obtenerTextoNoVacio("Introduce la refencia del producto a buscar y eliminar:", sc);

                    SQLAcessMercaDaw.deleteProductoPorID(refDir.toUpperCase() );
                    break;
                case "7":

                    if (SQLAcessMercaDaw.obtenerTodosLosProductos().isEmpty()){
                        System.out.println("No hay productos en el inventario para actualizar.");
                        break;
                    } else {
                        SQLAcessMercaDaw.getNombresProductos();


                        refDir = formas.obtenerTextoNoVacio("Introduce la referencia del producto a actualizar:", sc);

                        System.out.println("Nueva descripción:");
                        String nuevaDescripcion = sc.nextLine();

                        int cantidad = formas.obtenerEnteroValido("Nueva cantidad:", sc);

                        double precio = formas.obtenerDoubleValido("Nuevo precio:", sc);

                        int descuento = formas.obtenerEnteroValido("Nuevo descuento:", sc);

                        System.out.println("¿Aplicar descuento? (s/n):");
                        String opcionDto = sc.nextLine();

                        boolean aplicar_dto = false;

                        if (opcionDto.equalsIgnoreCase("S") || opcionDto.isBlank()){
                            opcionDto = "true";
                        } else if (opcionDto.equalsIgnoreCase("N")){
                            opcionDto = "false";
                        } else {
                            System.out.println("Opción no válida. Se aplicará el descuento por defecto (false).");
                            opcionDto = "false";
                        }


                        SQLAcessMercaDaw.actualizarProducto(refDir, nuevaDescripcion, cantidad, precio, descuento, aplicar_dto);
                    }

                    break;
                case "8":


                    String referencia = formas.obtenerTextoNoVacio("Inserte el tipo de referencia del nuevo producto:", sc);

                    System.out.println("Inserte el nombre del nuevo producto:");
                    String nombre = sc.nextLine();

                    System.out.println("Inserte la descripción del nuevo producto:");
                    String descripcion = sc.nextLine();

                    obtenerTipos(); // Muestras la lista al usuario
                    int tipoidSeleccionado = formas.obtenerEnteroValido("Inserte el ID del tipo:", sc);

                    TipoProducto tipoEncontrado = SQLAcessMercaDaw.obtenerTipoPorID(tipoidSeleccionado);


                    if (tipoEncontrado == null) {
                        System.out.println("Error: El ID de tipo [" + tipoidSeleccionado + "] no existe.");
                        return; // O vuelve al menú, pero no intentes insertar
                    }

                    int cantidad = formas.obtenerEnteroValido("Inserte la cantidad del nuevo producto:", sc);


                    double precio = formas.obtenerDoubleValido("Inserte el precio del nuevo producto:", sc);


                    int descuento = formas.obtenerEnteroValido("Inserte el descuento del nuevo producto:", sc);

                    int iva = formas.obtenerEnteroValido("Inserte el IVA del nuevo producto:", sc);

                    System.out.println("¿Aplicar descuento? (true/false):");
                    boolean aplicar_dto = sc.nextBoolean();



                    SQLAcessMercaDaw.insertarProducto(new Productos(referencia, nombre, descripcion, tipoEncontrado, cantidad, precio, descuento, iva, aplicar_dto));


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