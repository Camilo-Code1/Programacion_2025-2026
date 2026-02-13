import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Enlace {

    public LinkedList<Producto> productoEnvio = new LinkedList<>();


    public static void leerMostrarContenido() throws IOException{

        String direccion = "src/recursos/almacen.dat";

        try (DataInputStream dis = new DataInputStream(
                new FileInputStream(direccion))) {
            while (true){
                String codigo = dis.readUTF();
                String nombre = dis.readUTF();
                int cantidad = dis.readInt();
                double precio = dis.readDouble();

                System.out.println(
                        codigo + ", " +
                                nombre + ", " +
                                cantidad + ", " +
                                precio
                );
            }

        } catch (EOFException e) {

        }

    }

    public void agregarProducto (String codigo, String nombre, int cantidad, double precio){

        productoEnvio.add(new Producto(codigo, nombre, cantidad, precio));

    }

    public void mostrarProductosPorEnviar(){
        if (productoEnvio.isEmpty()){
            System.out.println("La lista de productos esta vacia");
        }

        for (int i = 0; i < productoEnvio.size(); i++){
            System.out.println(productoEnvio.get(i));
        }

    }

    public void guardarProductosNuevos() {
        try (DataOutputStream dos = new DataOutputStream(
                new FileOutputStream("src/recursos/almacen.dat", true))){

            for (Producto nuevo : productoEnvio){
                dos.writeUTF(nuevo.getCodigo());
                dos.writeUTF(nuevo.getNombre());
                dos.writeInt(nuevo.getCantidad());
                dos.writeDouble(nuevo.getPrecio());
            }

            productoEnvio.clear();
            System.out.println("Productos registrados correctamente.");

        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void borrarProductoPorCodigo(String codigoABorrar) {

        File archivo = new File("src/recursos/almacen.dat");
        List<Producto> productosRestantes = new ArrayList<>();

        // 1. Leer todo
        try (DataInputStream dis = new DataInputStream(
                new FileInputStream(archivo))) {

            while (true) {
                String codigo = dis.readUTF();
                String nombre = dis.readUTF();
                int cantidad = dis.readInt();
                double precio = dis.readDouble();

                if (!codigo.equals(codigoABorrar)) {
                    productosRestantes.add(
                            new Producto(codigo, nombre, cantidad, precio)
                    );
                }
            }

        } catch (EOFException e) {

        } catch (IOException e) {
            System.out.println("Error leyendo archivo: " + e.getMessage());
            return;
        }

        // 2. Reescribir archivo completo
        try (DataOutputStream dos = new DataOutputStream(
                new FileOutputStream(archivo))) {

            for (Producto p : productosRestantes) {
                dos.writeUTF(p.getCodigo());
                dos.writeUTF(p.getNombre());
                dos.writeInt(p.getCantidad());
                dos.writeDouble(p.getPrecio());
            }

            System.out.println("Producto eliminado correctamente");

        } catch (IOException e) {
            System.out.println("Error escribiendo archivo: " + e.getMessage());
        }
    }



}
