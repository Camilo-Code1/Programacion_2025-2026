import java.io.*;
import java.util.LinkedList;

public class Enlace {

    public LinkedList<Producto> productosEnvio = new LinkedList<>();

    public static void leerContenido() throws IOException {

        String direccion = "src/recursos/almacen.dat";

        try (

                FileInputStream ficher = new FileInputStream(direccion);
                InputStreamReader lector = new InputStreamReader(ficher);
                BufferedReader leer = new BufferedReader(lector);){

            String lin;
            while ((lin = leer.readLine())!= null) {
                System.out.println(lin);
            }

        }
    }

    public void agregarProducto(String nombre, int cantidad, double precio){

        productosEnvio.add(new Producto(nombre, cantidad, precio));

    }

    public void mostrarProductosPorEnviar(){
        if(productosEnvio.isEmpty()){
            System.out.println("La lista de productos esta vacia");
        }

        for (int i = 0; i < productosEnvio.size(); i++){
            System.out.println(productosEnvio.get(i));
        }

    }

    public void guardarProductosNuevos(){
        try(
             BufferedWriter bf = new BufferedWriter(new FileWriter("src/recursos/almacen.dat"))

                ) {
            for (Producto nuevo : productosEnvio){
                bf.write(nuevo.getCodigo() + ", " + nuevo.getNombre() + ", " + nuevo.getCantidad() + ", " + nuevo.getPrecio());
                bf.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }



}
