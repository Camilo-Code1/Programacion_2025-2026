public class DronCarga extends Vehiculo{

    private double pesoMaximo;
    private int numHelices;

    public DronCarga(String id, String modelo, double precioBaseDia, double pesoMaximo, int numHelices) {
        super(id, modelo, precioBaseDia);
        this.pesoMaximo = pesoMaximo;
        this.numHelices = numHelices;
    }

    public double getPesoMaximo() {
        return pesoMaximo;
    }

    public int getNumHelices() {
        return numHelices;
    }


    @Override
    public String toString() {
        return super.toString() +
                "[ DRON CARGA" +
                " | Peso maximo: " + pesoMaximo +
                " | Numero de helices:" + numHelices +
                ']';
    }
}
