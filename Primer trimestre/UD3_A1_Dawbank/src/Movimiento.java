import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Movimiento {

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    private int contadorMovimientos;
    private int id;
    private String fecha;
    private String tipoMovimiento;
    private double cantidad;

    public Movimiento(String tipoMovimiento, double cantidad) {
        this.contadorMovimientos = 0;
        this.id = id;
        this.tipoMovimiento = tipoMovimiento;
        this.cantidad = cantidad;

        this.fecha = LocalDateTime.now().format(dtf);
    }

//    public int getContadorMovimientos() {
//        return contadorMovimientos;
//    }
//
//    public int getId() {
//        return id;
//    }
//    public String getFecha() {
//        return fecha;
//    }
//    public String getTipoMovimiento() {
//        return tipoMovimiento;
//    }
//    public double getCantidad() {
//        return cantidad;
//    }


    public String mostrarInfoMovimiento() {
        String infoLibro = "";
        infoLibro += "ID: " + this.id + "\n";
        infoLibro += "Fecha: " + this.fecha + "\n";
        infoLibro += "Tipo Movimiento: " + this.tipoMovimiento + "\n";
        infoLibro += "Cantidad: " + this.cantidad + "\n";

        String info = String.format("Movimiento - ID: %s, Fecha: %s, Tipo de movimiento: %s, Cantidad: %.2f\n", id, fecha, tipoMovimiento, cantidad);

        return infoLibro;
    }

}
