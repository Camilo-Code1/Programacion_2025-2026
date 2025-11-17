import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Movimiento {

    private static int contadorMovimientosGlobal = 1;

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    private int id;
    private String fecha;
    private String tipoMovimiento;
    private double cantidad;

    public Movimiento(String tipoMovimiento, double cantidad) {
        this.id = contadorMovimientosGlobal++;
        this.tipoMovimiento = tipoMovimiento;
        this.cantidad = cantidad;

        this.fecha = LocalDateTime.now().format(dtf);
    }



    public int getId() {
        return id;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }
    public double getCantidad() {
        return cantidad;
    }


    public void mostrarInfoMovimiento() {
        System.out.println("-----------------------------");
        System.out.println("ID: " + id);
        System.out.println("Fecha: " + fecha);
        System.out.println("Tipo: " + tipoMovimiento);
        System.out.println("Cantidad: " + cantidad + "€");
        System.out.println("-----------------------------");
    }


}
