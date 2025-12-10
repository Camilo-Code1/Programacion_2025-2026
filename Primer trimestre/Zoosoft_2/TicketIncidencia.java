import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TicketIncidencia {

    private String idTicket;
    private String fechaIncidencia;
    private String nombreIncidencia;
    private String descripcion;
    private TipoIncidencia tipoIncidencia;

    private Animal animalRelacionado;
    private Cuidador cuidadorRelacionado;
    private boolean resuelto;

    private static int contadorIdTicket = 1;
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    private List<TicketIncidencia> incidencias;


    public TicketIncidencia(String nombreIncidencia, String descripcion, TipoIncidencia tipoIncidencia, Cuidador cuidadorRelacionado) {
        this.idTicket = String.format("TI-%03d", contadorIdTicket);
        contadorIdTicket++;

        this.fechaIncidencia = LocalDateTime.now().format(dtf);

        this.nombreIncidencia = nombreIncidencia;
        this.descripcion = descripcion;
        this.tipoIncidencia = tipoIncidencia;
        this.cuidadorRelacionado = cuidadorRelacionado;
        this.animalRelacionado = null;
        this.resuelto = false;
    }
    public String getIdTicket() {
        return idTicket;
    }

    public String getNombreIncidencia() {
        return nombreIncidencia;
    }

    public void setNombreIncidencia(String nombreIncidencia) {
        this.nombreIncidencia = nombreIncidencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoIncidencia getTipoIncidencia() {
        return tipoIncidencia;
    }

    public void setTipoIncidencia(TipoIncidencia tipoIncidencia) {
        this.tipoIncidencia = tipoIncidencia;
    }

    public Animal getAnimalRelacionado() {
        return animalRelacionado;
    }

    public void setAnimalRelacionado(Animal animalRelacionado) {
        this.animalRelacionado = animalRelacionado;
    }

    public Cuidador getCuidadorRelacionado() {
        return cuidadorRelacionado;
    }

    public void setCuidadorRelacionado(Cuidador cuidadorRelacionado) {
        this.cuidadorRelacionado = cuidadorRelacionado;
    }

    public void agregarIncidencia(TicketIncidencia t) {
        incidencias.add(t);
    }
    public void eliminarIncidencia(TicketIncidencia t) {
        incidencias.remove(t);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n<---TicketIncidencia--->")
                .append("\nIDTicket: ").append(idTicket)
                .append("\nFechaIncidencia: ").append(fechaIncidencia)
                .append("\nNombre de incidencia: ").append(nombreIncidencia)
                .append("\nDescripcion: ").append(descripcion)
                .append("\nTipo de incidencia: ").append(tipoIncidencia)
                .append("\nAnimal relacionado: ").append(animalRelacionado != null ? animalRelacionado.getNombreAnimal() : "Ninguno")
                .append("\nCuidador relacionado: ").append(cuidadorRelacionado != null ? cuidadorRelacionado.getNombre() : "Ninguno")
                .append("\nResuelto: ").append(resuelto ? "Sí" : "No")
                .append("\n--------------");

        return sb.toString();
    }

    public void mostrarIncidencia() {
        System.out.println(this);
    }

}
