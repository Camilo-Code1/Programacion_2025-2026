import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Habitacion implements Serializable {

    private static final long serialVersionUID = 5201374266536474663L;

    private static final DateTimeFormatter dtfFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter dtfCompleto = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    private int numero;
    private String tipo;
    private boolean ocupada;
    private LocalDate fechaCreacion;
    private String idHuespedAsignado;
    private LocalDateTime fechaIngreso;

    public Habitacion(int numero, String tipo, LocalDate fechaCreacion) {
        this.numero = numero;
        this.tipo = tipo;
        this.ocupada = false;
        this.fechaCreacion = LocalDate.now();
        this.idHuespedAsignado = null;
        this.fechaIngreso = null;
    }


    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public String getIdHuespedAsignado() {
        return idHuespedAsignado;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public void setIdHuespedAsignado(String idHuespedAsignado) {
        this.idHuespedAsignado = idHuespedAsignado;
    }

    public void registrarIngreso(String idHuesped) {
        this.idHuespedAsignado = idHuesped;
        this.ocupada = true;
        this.fechaIngreso = LocalDateTime.now();
    }

    public void registrarSalida() {
        this.idHuespedAsignado = null;
        this.ocupada = false;
        this.fechaIngreso = null;
    }


    @Override
    public String toString() {
        // 1. Formateamos las fechas antes de armar el String
        String fechaCreac = (fechaCreacion != null) ? fechaCreacion.format(dtfFecha) : "N/A";
        String fechaIngres = (fechaIngreso != null) ? fechaIngreso.format(dtfCompleto) : "Sin fecha";

        // 2. IMPORTANTE: Usar las variables "bonitas" aquí abajo
        return "[ HABITACION" +
                " | Numero: " + numero +
                " | Tipo: " + tipo  +
                " | Ocupada: " + (ocupada ? "SÍ" : "NO") +
                " | Creada: " + fechaCreac +
                " | Huésped: " + (idHuespedAsignado != null ? idHuespedAsignado : "Vacía") +
                " | Ingreso: " + fechaIngres +
                ']';
    }
}
