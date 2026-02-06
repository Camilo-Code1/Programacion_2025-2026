import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Producto {
    private String codigo;
    private String nombre;
    private int cantidad;
    private double precio;

    private static int incremental = 1;


    public Producto (String nombre, int cantidad, double precio){
        this.codigo = String.format("PR-%03d", incremental);
        incremental++;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }


    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Producto:" +
                "codigo: " + codigo + '\'' +
                ", nombre:" + nombre + '\'' +
                ", cantidad: " + cantidad +
                ", precio:" + precio;
    }
}






