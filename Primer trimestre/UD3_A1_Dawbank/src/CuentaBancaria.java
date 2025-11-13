public class CuentaBancaria {

    private String iban;
    private String titular;
    private double saldo;

    private Movimiento[] movimientos_t;
    private final int dimensionInicial = 100;
    private int nMovimientosActuales;

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

    public String infoCuentaBancaria() {
        String info = String.format("Cuenta bancaria - Iban:  %s, Titular: %s, Saldo: %d\n ", this.iban, this.titular, this.saldo);

        StringBuilder sb = new StringBuilder("Cuenta Bancaria: \n");
        sb.append("IBAN: " + this.iban + "\n");
        sb.append("Titular: " + this.titular + "\n");
        sb.append("Saldo: " + this.saldo + "\n");


//        infoCuentaBancaria += "IBAN: " + this.iban + "\n";
//        infoCuentaBancaria += "Titular: " + this.titular + "\n";
//        infoCuentaBancaria += "Saldo: " + this.saldo + "\n";

        return sb.toString();
    }

}
