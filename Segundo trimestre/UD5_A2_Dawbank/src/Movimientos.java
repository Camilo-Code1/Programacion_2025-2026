import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Movimientos {

    private int ID;
    private String fecha;
    private TipoMovimiento tipoMovi;
    private double Cantidad;


    private static int incremental = 1;

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public Movimientos(TipoMovimiento tipoMovi, double saldo) {
        this.ID = incremental++;
        this.tipoMovi = tipoMovi;
        this.Cantidad = saldo;

        this.fecha = LocalDateTime.now().format(dtf);
    }

    public int getID() {
        return ID;
    }

    public String getFecha() {
        return fecha;
    }

    public TipoMovimiento getTipoMovi() {
        return tipoMovi;
    }

    public double getCantidad() {
        return Cantidad;
    }

    @Override
    public String toString() {
        return "\n<>---Movimientos---<>" +
                "\nID: " + ID  +
                "\nFecha: " + fecha  +
                "\nTipo de movimiento: " + tipoMovi +
                "\nCantidad: " + Cantidad +
                "\n<><><><><><><><><><><><><><><>";
    }
}
