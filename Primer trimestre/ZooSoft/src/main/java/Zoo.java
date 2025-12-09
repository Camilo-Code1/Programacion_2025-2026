import java.time.LocalDate;
import java.util.ArrayList;

public class Zoo {

    private String nombreZoo;
    private String direccionZoo;
    private LocalDate fechaApertura;
    private boolean abierto;

    private ArrayList <Animal> listaAnimales;
    private ArrayList <Cuidador> listaCuidadores;
    private ArrayList <TicketIncidencia> listaTicketIncidencias;

    public Zoo(String nombreZoo, String direccionZoo, LocalDate fechaApertura) {
        this.nombreZoo = nombreZoo;
        this.direccionZoo = direccionZoo;
        this.fechaApertura = fechaApertura;
        this.abierto = false;

        this.listaAnimales = new ArrayList<>();
        this.listaCuidadores = new ArrayList<>();
        this.listaTicketIncidencias = new ArrayList<>();
    }

    public String getNombreZoo() {
        return nombreZoo;
    }

    public void setNombreZoo(String nombreZoo) {
        this.nombreZoo = nombreZoo;
    }

    public String getDireccionZoo() {
        return direccionZoo;
    }

    public void setDireccionZoo(String direccionZoo) {
        this.direccionZoo = direccionZoo;
    }

    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(LocalDate fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public boolean getAbierto() {
        return abierto;
    }

    public boolean isAbierto() { return abierto; }


    ///  ABRIR Y CERRAR
    public void abrir(){ abierto = true;
    }
    public void cerrar(){ abierto = false;
    }

    public String mostrarInfoZoo() {
        StringBuilder sb = new StringBuilder("\nZooSoft Pro:\n");
        sb.append("Nombre: "+ nombreZoo + "\n");
        sb.append("Direccion: " + direccionZoo + "\n");
        sb.append("Fecha apertura: " + fechaApertura + "\n");
        sb.append("Estado: ").append(abierto ? "Abierto" : "Cerrado").append("\n");

        return sb.toString();
    }


}
