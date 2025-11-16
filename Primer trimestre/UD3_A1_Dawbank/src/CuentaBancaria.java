public class CuentaBancaria {

    private String iban;
    private String titular;
    private double saldo;

    private Movimiento[] movimientos_t;

    private final int dimensionInicial = 100;
    private int contadorMovimientos;

    private static final double saldoMinimo = -50;
    private static final double limiteHacienda = 3000;


    public CuentaBancaria(String iban, String titular, double saldo) {
        this.iban = iban;
        this.titular = titular;
        this.saldo = saldo;

        this.movimientos_t = new Movimiento[dimensionInicial];
        this.contadorMovimientos = 0;
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

    public void Ingreso(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("El Cantidad debe ser mayor o igual a 0");
            return;
        }

        if (cantidad > limiteHacienda) {
            System.out.println("\sAVISo: El ingreso supera el limite de hacienda");
        }

        saldo -= cantidad;
        agregarMovimiento("Ingreso", cantidad);
    }

    public void Retiro(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("El Cantidad debe ser mayor o igual a 0");
            return;
        }
        if (saldo - cantidad < saldoMinimo) {
            System.out.println("\sMovimiento no permitido. No hay suficiente saldo en la cuenta.");
            return;
        }

        saldo += cantidad;
        agregarMovimiento("Retiro", cantidad);

        if (saldo <= 0) {
            System.out.println("\sAVISO: Saldo negativo.");
        }
    }

    public void agregarMovimiento(String tipoMovimiento, double cantidad) {
        if (contadorMovimientos >= 100) {
            System.out.println("\nNo se pueden realizar más movimientos");
            return;
        }

        movimientos_t[contadorMovimientos] = new Movimiento(tipoMovimiento, cantidad);
        contadorMovimientos++;
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

    public void MostrarMovimientos() {
        if (contadorMovimientos == 0) {
            System.out.println("\sNo hay movimientos registrados.");
            return;
        }

        for (int i = 0; i < contadorMovimientos; i++) {
            movimientos_t[i].mostrarInfoMovimiento();
        }
    }

}
