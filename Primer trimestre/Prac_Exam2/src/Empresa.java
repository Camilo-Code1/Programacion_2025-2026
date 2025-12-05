import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Empresa {

    private String nombreEmp;
    private String cif;
    private String fechaFundacion;

    private ArrayList<Trabajador> trabajadores;

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    private int numTrabajadores;

    public Empresa(String nombre, String cif) {
        this.nombreEmp = nombre;
        this.cif = cif;
        this.fechaFundacion = LocalDateTime.now().format(dtf);

        this.trabajadores = new ArrayList<>();
        this.numTrabajadores = 0;
    }

    public String getNombreEmp() {
        return nombreEmp;
    }
    public void setNombreEmp(String nombreEmp) {
        this.nombreEmp = nombreEmp;
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

    public void agregarTrabajador(Trabajador t) {
        for(Trabajador tr : trabajadores) {
            if (tr.getDni().equals(t.getDni())) {
                System.out.println("\nError: Ya existe un trabajador con ese DNI");
                return;
            }
        }
        trabajadores.add(t);
        numTrabajadores++;

        System.out.println("\nTrabajor añadido correctamente");
    }

    public void mostrarTrabajadores() {
        if (trabajadores.isEmpty()) {
            System.out.println("No existe ningun trabajador registrado");
            return;
        }
        System.out.println("\nMostrando trabajadores:");
        for (Trabajador t : trabajadores) {
            t.mostrarInfoTrabajadores();
        }

    }


    public String mostrarinfoEmpresa() {
        StringBuilder sb = new StringBuilder("GestoresEmpresas:\n");
        sb.append("Nombre de empresa: " + nombreEmp + "\n");
        sb.append("CIF: " + cif + "\n");
        sb.append("Fecha fundacion: " + fechaFundacion + "\n");
        sb.append("Numero de trabajadores: " + trabajadores.size() + "\n");
        return sb.toString();
    }



}
