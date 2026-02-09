import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

            System.out.println("¡Productos guardados correctamente!");
            productosEnvio.clear();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void borrarProductoPorCodigo(String codigoABorrar) {

        File archivo = new File("src/recursos/almacen.dat");
        List<String> lineasRestantes = new ArrayList<>();

        // 1. Leer archivo
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(archivo), StandardCharsets.UTF_8))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.startsWith(codigoABorrar + ",")) {
                    lineasRestantes.add(linea);
                }
            }

        } catch (IOException e) {
            System.out.println("Error leyendo archivo: " + e.getMessage());
            return;
        }

        // 2. Reescribir archivo
        try (BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(archivo), StandardCharsets.UTF_8))) {

            for (String linea : lineasRestantes) {
                bw.write(linea);
                bw.newLine();
            }

            System.out.println("Producto eliminado correctamente");

        } catch (IOException e) {
            System.out.println("Error escribiendo archivo: " + e.getMessage());
        }
    }

}
