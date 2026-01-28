import java.util.ArrayList;

public class CuentaBancaria {

    private String iban;
    private String titular;
    private double saldo;

    ArrayList<Movimientos> nuevoMovimientos = new ArrayList<>();


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

    public void Ingreso (double cantidad) throws limiteHacienda {
        double limite = 3000;
        if (cantidad <= 0) {
            System.out.println("El cantidad debe ser mayor o igual a 0");
            return;
        }

        if (cantidad >= limite) {
            throw new limiteHacienda(
                    "Se ha ingresado una cantidad superior a la permitida. Avisando a Hacienda"
            );
        }

        System.out.println("Cantidad procesada correctamente: " + cantidad);
    }


    public void agregarMovimientos(Movimientos mov){
        nuevoMovimientos.add(mov);
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
