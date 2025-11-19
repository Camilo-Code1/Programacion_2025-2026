public class BicicletaElectrica {

    private String idBici; // A23F9K
    private String modelo;
    private int bateria;
    private int kilometrosTotales;
//    private int bateriaInicial = 100;

    private final int dimensionInicial = 100;
    private RegistroUso [] movimientos;

    private int contadorMovimientos;

    public BicicletaElectrica(String idBici, String modelo) {
        this.idBici = idBici;
        this.modelo = modelo;
        this.bateria = 100;
        this.kilometrosTotales = 0;
        this.contadorMovimientos = 0;
        this.movimientos = new RegistroUso[dimensionInicial];
    }

    public String getIdBici() {
        return idBici;
    }
    public void setIdBici(String idBici) {
        this.idBici = idBici;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getBateria() {
        return bateria;
    }
    public int getKilometrosTotales() {
        return kilometrosTotales;
    }







    public String infoBicicleta() {
        return String.format(
                "<---------Bicicleta:--------->\n" +
                        "ID: %s\n" +
                        "Modelo: %s\n" +
                        "Bateria: %s%%\n" +
                        "Kilometros totales: %s\n",
                this.idBici, this.modelo, this.bateria, this.kilometrosTotales
        );
    }


}
