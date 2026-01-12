import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistroUso {

    private static int contadorGlobal = 1;

    private int idRegistroUso;
    private String fechaRegistroUso;
    private int kilometrosRealizados;
    private int bateriaConsumida;

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public RegistroUso(int kilometrosRealizados, int bateriaConsumida) {
        this.idRegistroUso = contadorGlobal++;
        this.kilometrosRealizados = kilometrosRealizados;
        this.bateriaConsumida = bateriaConsumida;

        this.fechaRegistroUso = LocalDateTime.now().format(dtf);
    }

    public int getIdRegistroUso() {
        return idRegistroUso;
    }
    public int kilometrosRealizados() {
        return kilometrosRealizados;
    }
    public int bateriaConsumida() {
        return bateriaConsumida;
    }

    public void mostrarInfoRegistro() {
        System.out.println("-----------------------------");
        System.out.println("ID: " + idRegistroUso);
        System.out.println("Registro Uso: " + idRegistroUso);
        System.out.println("Kilometros realizados: " + kilometrosRealizados);
        System.out.println("Bateria consumida: " + bateriaConsumida +"%");
        System.out.println("Fecha de registro de uso: " + fechaRegistroUso);
        System.out.println("-----------------------------");
    }



}