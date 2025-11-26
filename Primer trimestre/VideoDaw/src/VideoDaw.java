import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class VideoDaw {

    private String cif;
    private String direccionEm;
    private String fechaAlta;
    private Pelicula [] peliculasRegistradas;
    private Cliente [] clientesRegistrados  ;

    private int contadorPeliculas = 0;
    private int contadorClientes = 0;

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public VideoDaw(String cif, String direccionEm) {
        this.cif = cif;
        this.direccionEm = direccionEm;
        this.fechaAlta = LocalDateTime.now().format(dtf);
        this.peliculasRegistradas = new Pelicula[100];
        this.clientesRegistrados = new Cliente[100];
    }

    public String getCif() {
        return cif;
    }
    public void setCif(String cif) {
        this.cif = cif;
    }
    public String getDireccionEm() {
        return direccionEm;
    }
    public void setDireccionEm(String direccionEm) {
        this.direccionEm = direccionEm;
    }
    public String getFechaAlta() {
        return fechaAlta;
    }

    public void agregarPelicula(Pelicula p) {
        if (contadorPeliculas < peliculasRegistradas.length) {
            peliculasRegistradas[contadorPeliculas] = p;
            contadorPeliculas++;
        }  else {
            System.out.println("No se pueden registrar más películas (límite alcanzado).");
        }
    }
    public void mostrarPeliculas() {
        if (contadorPeliculas == 0) {
            System.out.println("No hay películas registradas.");
        } else {
            for (int i = 0; i < contadorPeliculas; i++) {
                peliculasRegistradas[i].mostrarInfoPelicula();
            }
        }
    }

    public void agregarCliente(Cliente c) {
        if (contadorClientes < clientesRegistrados.length) {
            clientesRegistrados[contadorClientes] = c;
            contadorClientes++;
        }  else {
            System.out.println("No se pueden registrar más clientes (límite alcanzado).");
        }
    }

    public void mostrarClientes() {
        if (contadorClientes == 0) {
            System.out.println("No hay clientes registradas.");
        } else {
            for (int i = 0; i < contadorClientes; i++) {
                clientesRegistrados[i].mostrarInfoCliente();
            }
        }
    }

    public String mostrarInfoVideoDaw() {
        StringBuilder sb = new StringBuilder("VideoDaw:\n");
        sb.append("CIF: " + this.cif + "\n");
        sb.append("Direccion: " + this.direccionEm + "\n");
        sb.append("Fecha de alta: " + this.fechaAlta + "\n");

        return sb.toString();
    }


}