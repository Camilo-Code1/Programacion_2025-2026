import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Enlace {

    static List <Producto> inventarioIn = new ArrayList<>();

    public void leerFicheroUnicode() {



        try (FileReader fr =  new FileReader("src/Recursos/Recursos/productos.csv");
        BufferedReader br = new BufferedReader(fr)){

            String linea;
            while((linea= br.readLine()) != null) {
                String[] datos = linea.split("/");

                if (datos.length == 4){
                    inventarioIn.add(new Producto(datos[0], datos [1], datos [2], datos [3]));
                }
            }


        } catch (FileNotFoundException e) {
            System.out.println("El archivo CSV no se encontro" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }

    }

    public void escribirFicherosUnicode(){

        try (FileWriter writer = new FileWriter("src/Recursos/Recursos/productos.csv");
        BufferedWriter bw = new BufferedWriter(writer)){

            for (Producto p : inventarioIn){
                bw.write((p.getReferencia()) + "/" + p.getNombre()  + "/" + p.getDescripcion()  + "/" + p.getTipo());

                bw.newLine();
            }

        } catch (IOException e){
            System.out.println("error al escribir datos: " + e.getMessage() );
        }


    }


    public void leerFicheroBinario() {
        try (FileInputStream fis = new FileInputStream("src/Recursos/Recursos/almacen.dat");
        DataInputStream dis = new DataInputStream(fis)){

            int i = 0;

            while (true){

                int cantidad = dis.readInt(); //leer cantidad
                double precio = dis.readDouble(); //leer precio
                int descuento = dis.readInt(); //leer descuento
                int iva = dis.readInt(); //leer iva
                boolean aplicardto = dis.readBoolean(); //leer aplicarDto

                if (i < inventarioIn.size()){
                    Producto p = inventarioIn.get(i);

                    p.setCantidad(cantidad);
                    p.setPrecio(precio);
                    p.setDescuento(descuento);
                    p.setIva(iva);
                    p.setAplicardto(aplicardto);
                }

                i++;
            }

        } catch (EOFException e) {
            System.out.println("Datos binarios cargados correctamente.");
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void escrituraFicheroBinario() {
        try (FileOutputStream fos = new FileOutputStream("src/Recursos/Recursos/almacen.dat");
        DataOutputStream dos = new DataOutputStream(fos)){

            for (Producto p : inventarioIn){
                dos.writeInt(p.getCantidad());
                dos.writeDouble(p.getPrecio());
                dos.writeInt(p.getDescuento());
                dos.writeInt(p.getIva());
                dos.writeBoolean(p.isAplicardto());
            }

        } catch (EOFException e){
            System.out.println(e.getMessage());
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public void mostrarProductos() {
        for (Producto p : inventarioIn){
            System.out.println(p);
        }
    }

    public void mostrarProductosPorFiltrado(){
        // Muestra de productos por referencia y descripcion
        for (Producto p : inventarioIn){
            System.out.println(p.getReferencia() + " / " + p.getDescripcion());
        }
    }

    public String eliminarProducto(String referencia){


        if (inventarioIn.isEmpty()){
            System.out.println("No hay productos");
        }

        // Eliminación

        int index = -1;

//        String referencia = "";

        for (int i = 0; i < inventarioIn.size(); i++){
            if (inventarioIn.get(i).getReferencia().equals(referencia)){
                index = i;
                break;
            }
        }

        if (index != -1){
            inventarioIn.remove(index);
        }



        return referencia;
    }

    public boolean comprobarReferencia(String referencia){

        for (Producto p : inventarioIn){
            if (p.getReferencia().equals(referencia)){
                System.out.println("REFERENCIA YA REGISTRADA. ¡No se aceptan duplicados!");
                return true;
            }
        }
        return false;
    }

    public void registrarProducto(String referencia,String nombre, String descripcion, String tipo, int cantidad,
                                  double precio, int descuento, int iva, boolean aplicardto){

        inventarioIn.add(new Producto(referencia, nombre, descripcion, tipo, cantidad,
                precio, descuento, iva, aplicardto));

        System.out.println("Producto registrado exitosamente");

    }

    public void cargatDatos(){
        inventarioIn.clear();
        leerFicheroUnicode();
        leerFicheroBinario();
    }

    public void guardarInventario() {
        escribirFicherosUnicode();
        escrituraFicheroBinario();
    }
}
