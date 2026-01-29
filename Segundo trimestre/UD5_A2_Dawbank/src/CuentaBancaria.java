import java.util.ArrayList;
import java.util.Iterator;

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

    public void Ingreso (double cantidad) {
        double limite = 3000;
        if (cantidad <= 0) {
            System.out.println("\nEl cantidad debe ser mayor o igual a 0");
            return;
        }

        if (cantidad >= limite) {
            System.out.println("\nAVISO: Se ha ingresado una cantidad superior a la permitida. Avisando a Hacienda");
        }

        System.out.println("\nCantidad procesada correctamente: " + cantidad + "\nEspere por favor...");


        saldo += cantidad;
        agregarMovimientos(new Movimientos(TipoMovimiento.Ingreso, cantidad));


        System.out.println(
                "\nMovimiento confirmado" +
                        "\nUsted ha retirado: " + cantidad + "$" +
                        "\nDe la cuenta: " + iban
        );

    }

    public void Retiro (double cantidad){
        double minimo = -50;
        if (cantidad <= 0){
            System.out.println("\nLa cantidad de dinero debe ser mayor o igual a 0");
            return;
        }
        if (saldo - cantidad < minimo) {
            throw new MinimoCuenta(
                    "Movimiento no permitido. No puede rebasarse la cantidad minima de la cuenta"
            );
        }


        saldo -= cantidad;
        agregarMovimientos(new Movimientos(TipoMovimiento.Retirada, cantidad));


        System.out.println(
                "\nMovimiento confirmado" +
                        "\nUsted ha retirado: " + cantidad + "$" +
                        "\nDe la cuenta: " + iban
        );
     }


    public void agregarMovimientos(Movimientos mov){
        nuevoMovimientos.add(mov);
    }

    public void mostrarMovimientos() {
        if (nuevoMovimientos.isEmpty()) {
            System.out.println("\nNo hay movimientos registrados");
            return;
        }
        System.out.println("\nMostrando movimientos: ");
        Iterator<Movimientos> itera = nuevoMovimientos.iterator();
        while (itera.hasNext()) {
            System.out.println(itera.next());
        }
    }



    @Override
    public String toString() {
        return "\n<---CuentaBancaria--->" +
                "\nIBAN: " + iban +
                "\nTitular: " + titular +
                "\nSaldo: " + saldo +
                "\n<><><><><><><><><><><><><><><>";
    }


}
