import java.time.LocalDate;
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

    public Cliente buscarCliente(String numSocio) {
        for (int i = 0; i < contadorClientes; i++) {
            if (clientesRegistrados[i].getNumSocio().equals(numSocio)) {
                return clientesRegistrados[i];
            }
        }
        return null;
    }
    public boolean darBajaCliente(String numSocio) {
        Cliente c = buscarCliente(numSocio);

        if (c == null) {
            return false;
        }

        if (c.getFechaBaja() != null) {
            return false;
        }

        c.setFechaBaja(LocalDate.now().toString());
        return true;
    }

    public Pelicula buscarPelicula(String cod) {
        for (int i = 0; i < contadorPeliculas; i++) {
            if (peliculasRegistradas[i].getCod().equals(cod)) {
                return peliculasRegistradas[i];
            }
        }
        return null;
    }
    public boolean darBajaPelicula(String cod) {
        Pelicula p = buscarPelicula(cod);
        if (p == null) {
            return false;
        }
        if (p.getFechaBaja() != null) {
            return false;
        }

        p.setFechaBaja(LocalDate.now().toString());
        return true;
    }

    public boolean alquilarPeicula (String numSocio, String cod) {
        Cliente c = buscarCliente(numSocio);
        Pelicula p = buscarPelicula(cod);

        // Verificar existencia
        if (c == null) {
            System.out.println("Error: Cliente no encontrado");
            return false;
        }
        if (p == null) {
            System.out.println("Error: Pelicula no encontrada");
            return false;
        }

        // Verificar si esta dado de baja
        if (c.getFechaBaja() != null) {
            System.out.println("Error: El cliente esta dado de baja y no puede alquilar");
            return false;
        }
        if (p.getFechaBaja() != null) {
            System.out.println("Error: La pelicula esta dada de baja");
            return false;
        }



        if (p.isAlquilada()) {
            System.out.println("Error: La pelicula ya esta alquilada");
            return false;
        }


        p.setAlquilada(true);
        c.setPeliculasAlquiladas(c.getPeliculasAlquiladas() + 1);

        System.out.println("Alquiler realizado correctamente");
        return true;

    }

    public boolean devolverPelicula(String nunSocio, String cod) {
        Cliente c = buscarCliente(nunSocio);
        Pelicula p = buscarPelicula(cod);

        if (c == null) {
            System.out.println("Error: Cliente no encontrado");
            return false;
        }
        if (p == null) {
            System.out.println("Error: Pelicula no encontrada");
            return false;
        }

        if (c.getFechaBaja() != null) {
            System.out.println("Error: El cliente esta dado de baja y no puede devolver");
            return false;
        }
        if (p.getFechaBaja() != null) {
            System.out.println("Error: La pelicula esta dada de baja");
            return false;
        }

        if (!p.isAlquilada()) {
            System.out.println("Error: La pelicula no esta alquilada");
            return false;
        }

        if (c.getPeliculasAlquiladas() <= 0) {
            System.out.println("Error: El cliente no tiene peliculas para devolver");
            return false;
        }

        p.setAlquilada(false);
        c.setPeliculasAlquiladas(c.getPeliculasAlquiladas() - 1);

        System.out.println("La pelicula fue devuelta correctamente");
        return true;
    }


    public String mostrarInfoVideoDaw() {
        StringBuilder sb = new StringBuilder("\nVideoDaw:\n");
        sb.append("CIF: " + this.cif + "\n");
        sb.append("Direccion: " + this.direccionEm + "\n");
        sb.append("Fecha de alta: " + this.fechaAlta + "\n");

        return sb.toString();
    }


}