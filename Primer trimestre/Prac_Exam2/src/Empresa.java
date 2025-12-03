import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Empresa {

    private String nombre;
    private String cif;
    private String fechaFundacion;

    private final int dimensionMaxima = 100;

    private Trabajador [] trabajadores;

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    private int numTrabajadores;

    public Empresa(String nombre, String cif) {
        this.nombre = nombre;
        this.cif = cif;
        this.fechaFundacion = LocalDateTime.now().format(dtf);

        this.trabajadores = new Trabajador[dimensionMaxima];
        this.numTrabajadores = 0;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCif() {
        return cif;
    }
    public void setCif(String cif) {
        this.cif = cif;
    }
    public String getFechaFundacion() {
        return fechaFundacion;
    }

    public String mostrarinfoEmpresa() {
        StringBuilder sb = new StringBuilder("GestoresEmpresas:\n");
        sb.append("Nombre: " + nombre + "\n");
        sb.append("CIF: " + cif + "\n");
        sb.append("Fecha fundacion: " + fechaFundacion + "\n");
        return sb.toString();
    }



}
