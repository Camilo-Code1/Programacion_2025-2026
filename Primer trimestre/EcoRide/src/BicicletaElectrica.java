public class BicicletaElectrica {

    private String idBici; // A23F9K
    private String modelo;
    private int bateria;
    private int kilometrosTotales;
//    private int bateriaInicial = 100;

    private final int dimensionInicial = 100;
    private RegistroUso [] movimientos;

    private int contadorMovimientos;

    private static final int bateriaBaja = 15;

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

    public void usarBicicleta(int kilometrosRealizados){

        if (kilometrosRealizados <= 0) {
            System.out.println("\nError: La distancia que recorrera siempre debe ser mayor a 0.");
            return;
        }
        int bateriaConsumida = kilometrosRealizados * 2;

        if (bateriaConsumida > bateria) {
            System.out.println("ERROR: No hay batería suficiente para el trayecto");
            return;
        }

        bateria -= bateriaConsumida;

        kilometrosTotales += kilometrosRealizados;

        agregarRegistro(kilometrosRealizados, bateriaConsumida);

        if (bateria <= bateriaBaja) {
            System.out.println("AVISO: Bateria baja, cargue el dispositivo.");

        }

    }

    public void agregarRegistro(int km, int consumo) {
        if (contadorMovimientos < movimientos.length) {
            movimientos[contadorMovimientos] = new RegistroUso(km, consumo);
            contadorMovimientos++;
        }
        else {
            System.out.println("\nERROR: No se pueden registrar más elementos");
        }
    }

    public void mostrarHistorial(){
        if (contadorMovimientos == 0) {
            System.out.println("AVISO: No hay registros todavía");
            return;
        }

        for (int i = 0; i < contadorMovimientos; i++) {
            movimientos[i].mostrarInfoRegistro();
        }
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
