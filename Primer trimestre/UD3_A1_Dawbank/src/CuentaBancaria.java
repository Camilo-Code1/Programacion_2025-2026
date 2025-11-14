import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CuentaBancaria {

    private String iban;
    private String titular;
    private double saldo;

    private Movimiento[] movimientos_t;
    private final int dimensionInicial = 100;
    private int nMovimientosActuales;

    private static final double saldoMinimo = -50;
    private static final double saldoMaximo = 3000;


    public CuentaBancaria(String iban, String titular, double saldo) {
        this.iban = iban;
        this.titular = titular;
        this.saldo = saldo;

        this.movimientos_t = new Movimiento[dimensionInicial];
        this.nMovimientosActuales = 0;
    }

    public String getIban() {
        return this.iban;
    }
    public void setIban(String iban) {
        this.iban = iban;
    }
    public String getTitular() {
        return this.titular;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }
    public double getSaldo() {
        return this.saldo;
    }


    private boolean ibanCorrec(String IBAN) {
        return IBAN != null && IBAN.matches("[A-Z]{2}\\d{22}");
    }

    private void Ingreso (double Cantidad) {
        if (Cantidad <= 0) {
            System.out.println("El Cantidad debe ser mayor o igual a 0");
            return;
        }

    }




    public String infoCuentaBancaria() {
        return String.format(
                "Cuenta bancaria:\n" +
                        "IBAN: %s\n" +
                        "Titular: %s\n" +
                        "Saldo: %.2f€\n",
                this.iban,
                this.titular,
                this.saldo
        );
    }


}
