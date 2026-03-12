import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public abstract class Vehiculo implements Serializable {

    private static final long serialVersionUID = 5674327739926752840L;

    private static final DateTimeFormatter dtfFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter dtfCompleto = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    private String id;
    private String modelo;
    private double precioBaseDia;
    private boolean disponible;

    private LocalTime fechaDevolucion;
    private LocalDateTime fechaAlquiler;

    public Vehiculo(String id, String modelo, double precioBaseDia) {
        this.id = id;
        this.modelo = modelo;
        this.precioBaseDia = precioBaseDia;
        this.disponible = true;
        this.fechaDevolucion = null;
        this.fechaAlquiler = null;
    }

    public String getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public double getPrecioBaseDia() {
        return precioBaseDia;
    }

    public void setPrecioBaseDia(double precioBaseDia) {
        this.precioBaseDia = precioBaseDia;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public LocalTime getFechaDevolucion() {
        return fechaDevolucion;
    }

    public LocalDateTime getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void alquilar(boolean ocupado, LocalTime fechaDevolucion) {
        if (ocupado) {
            this.disponible = false;
            this.fechaDevolucion = fechaDevolucion;
            this.fechaAlquiler= LocalDateTime.now();
        }
    }
    public void devolver() {
        this.disponible = true;
        this.fechaDevolucion = null;
        this.fechaAlquiler = null;
    }

    @Override
    public String toString() {

        String fechaCreac = (fechaAlquiler != null) ? fechaDevolucion.format(dtfCompleto) : "Sin fecha";
        String fechaIngre = (fechaDevolucion != null) ? fechaAlquiler.format(dtfFecha) : "N/A";

        return "[ VEHICULO " +
                " | ID: " + id  +
                " | Modelo: " + modelo  +
                " | PrecioBaseDia: " + precioBaseDia +
                " | Disponible: " + (!disponible ? disponible : "Disponible") +
                " | Fecha de devolucion: " + fechaCreac +
                " | Fecha de alquiler: " + fechaIngre +
                ']';
    }
}
