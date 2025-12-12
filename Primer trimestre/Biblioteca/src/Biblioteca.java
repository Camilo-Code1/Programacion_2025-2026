import java.time.LocalDate;

public class Biblioteca {

    private String nombreBiblioteca;
    private String codBilioteca; // 3 letras Mayus y 3 digitos
    private LocalDate fechaApertura;
    private int capacidadMaximaLibros;

    private Libro [] librosRegistrados;
    private int numLibrosRegistrados;

    public Biblioteca(String nombreBiblioteca, String codBilioteca, LocalDate fechaApertura, int capacidadMaximaLibros) {
        this.nombreBiblioteca = nombreBiblioteca;
        this.codBilioteca = codBilioteca;
        this.fechaApertura = fechaApertura;
        this.capacidadMaximaLibros = capacidadMaximaLibros;

        this.librosRegistrados = new Libro[capacidadMaximaLibros];
        this.numLibrosRegistrados = 0;
    }

    public String getNombreBiblioteca() {
        return nombreBiblioteca;
    }

    public void setNombreBiblioteca(String nombreBiblioteca) {
        this.nombreBiblioteca = nombreBiblioteca;
    }

    public String getCodBilioteca() {
        return codBilioteca;
    }

    public void setCodBilioteca(String codBilioteca) {
        this.codBilioteca = codBilioteca;
    }

    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(LocalDate fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public int getCapacidadMaximaLibros() {
        return capacidadMaximaLibros;
    }

    public void setCapacidadMaximaLibros(int capacidadMaximaLibros) {
        this.capacidadMaximaLibros = capacidadMaximaLibros;
    }


    public void agregarLibroFisico(LibroFisico lf) {
        if (numLibrosRegistrados < capacidadMaximaLibros) {
            librosRegistrados[numLibrosRegistrados] = lf;
            numLibrosRegistrados++;
        } else {
            System.out.println("No hay espacio para más libros");
        }
    }

    public void agregarLibroDigital(LibroDigital ld) {
        if (numLibrosRegistrados < capacidadMaximaLibros) {
            librosRegistrados[numLibrosRegistrados] = ld;
            numLibrosRegistrados++;
        } else {
            System.out.println("No hay espacio para más libros");
        }
    }


    public void mostrarLibros() {
        if (this.numLibrosRegistrados == 0) {
            System.out.println("No hay libros registrados");
        } else {
            for (int i = 0; i < numLibrosRegistrados; i++) {
                System.out.println(this.librosRegistrados[i]);
            }
        }
    }

    public void mostrarNumeroLibros() {
        System.out.println("Numero de libros registrados: " + numLibrosRegistrados);
    }

    public void mostrarLibrosFisicos() {
        boolean encontrado = false;
        if (this.numLibrosRegistrados == 0) {
            System.out.println("No hay libros registrados");
        } else {
            for (int i = 0; i < numLibrosRegistrados; i++) {
                if (librosRegistrados[i].getTipo() == TipoLibro.FISICO) {
                    System.out.println(this.librosRegistrados[i]);
                    encontrado = true;
                }
            }
            if (!encontrado) {
                System.out.println("No hay libros registrados");
            }
        }
    }

    public void mostrarLibrosDigitales() {
        boolean encontrado = false;
        if (this.numLibrosRegistrados == 0) {
            System.out.println("No hay libros registrados");
        } else {
            for (int i = 0; i < numLibrosRegistrados; i++) {
                if (librosRegistrados[i].getTipo() == TipoLibro.DIGITAL) {
                    System.out.println(this.librosRegistrados[i]);
                    encontrado = true;
                }
            }
            if (!encontrado) {
                System.out.println("No hay libros registrados");
            }
        }
    }

    public void buscarLibroMostrar(String isbn) {

        if (numLibrosRegistrados == 0) {
            System.out.println("No hay libros registrados.");
            return;
        }

        for (int i = 0; i < numLibrosRegistrados; i++) {
            if (librosRegistrados[i].getIsbn().equals(isbn)) {
                System.out.println("\nLibro encontrado:");
                System.out.println(librosRegistrados[i]);
                return;
            }
        }

        System.out.println("No se encontró ningún libro con el ISBN ingresado.");
    }
    public Libro buscarLibroNeutral(String isbn) {
        for (int i = 0; i < numLibrosRegistrados; i++) {
            if (librosRegistrados[i].getIsbn().equals(isbn)) {
                return librosRegistrados[i];
            }
        }
        return null;
    }


    public boolean eliminarLibro(String isbn) {

        if (numLibrosRegistrados == 0) {
            System.out.println("No hay libros registrados.");
            return false;
        }

        for (int i = 0; i < numLibrosRegistrados; i++) {
            if (librosRegistrados[i].getIsbn().equals(isbn)) {

                for (int j = i; j < numLibrosRegistrados - 1; j++) {
                    librosRegistrados[j] = librosRegistrados[j + 1];
                }

                librosRegistrados[numLibrosRegistrados - 1] = null;
                numLibrosRegistrados--;

                System.out.println("Libro eliminado correctamente.");
                return true;
            }
        }

        System.out.println("No existe ningún libro con ese ISBN.");
        return false;
    }

    public void mostrarLibrosAgrupadosPorGenero(Genero gen) {

        if (numLibrosRegistrados == 0) {
            System.out.println("No hay libros registrados.");
            return;
        }

        for (Genero genero : Genero.values()) {

            boolean hayDelGenero = false;
            System.out.println("\nGenero: " + genero);

            for (int i = 0; i < numLibrosRegistrados; i++) {
                if (librosRegistrados[i].getGenero() == genero) {
                    System.out.println(" - " + librosRegistrados[i].getTituloLibro() +
                            " | ISBN: " + librosRegistrados[i].getIsbn());
                    hayDelGenero = true;
                }
            }

            if (!hayDelGenero) {
                System.out.println("(Sin libros en este género)");
            }
        }
    }



    public String msotrarInfoBiblioteca() {
        StringBuilder sb = new StringBuilder("\nBiblioteca:\n");
            sb.append("Nombre Biblioteca: " + nombreBiblioteca + "\n");
            sb.append("Codigo Biblioteca: " + codBilioteca + "\n");
            sb.append("Fecha Apertura: " + fechaApertura + "\n");

            return sb.toString();
    }

}


