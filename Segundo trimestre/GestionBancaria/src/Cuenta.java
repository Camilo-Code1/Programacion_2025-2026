import java.io.Serializable;

public abstract class Cuenta implements Serializable {

    private static final long serialVersionUID = -1293317624718273974L;

    private String numeraCuenta;
    private double saldo;
    private boolean activa;

    private static int incremental =  1;

    public Cuenta(double saldo, boolean activa) {
        this.numeraCuenta = String.format("C-%03d", incremental++);
        this.saldo = saldo;
        this.activa = true;
    }

    public String getNumeraCuenta() {
        return numeraCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }


    @Override
    public String toString() {
        return "[ Cuenta: " +
                "| NumeraCuenta: " + numeraCuenta +
                " | Saldo: " + saldo +
                " | Activa:" + activa;
    }
}
