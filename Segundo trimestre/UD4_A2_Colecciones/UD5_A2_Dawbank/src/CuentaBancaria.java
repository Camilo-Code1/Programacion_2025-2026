public class CuentaBancaria {

    private String iban;
    private String titular;
    private double saldo;



    public CuentaBancaria(String iban, String titular, double saldo) {
        this.iban = iban;
        this.titular = titular;
        this.saldo = saldo;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }




    @Override
    public String toString() {
        return "<---CuentaBancaria--->" +
                "\nIBAN:" + iban +
                "\nTitular: " + titular +
                "\nSaldo: " + saldo +
                "\n<---->";
    }
}
