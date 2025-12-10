import java.time.LocalDate;
import java.util.ArrayList;

public class ZooSoft {

    private String nombreZoo;
    private String direccionZoo;
    private LocalDate fechaApertura;
    private boolean abierto;

    private ArrayList <Animal> listaAnimales;
    private ArrayList <Cuidador> listaCuidadores;
    private ArrayList <TicketIncidencia> listaTicketIncidencias;


    public ZooSoft(String nombreZoo, String direccionZoo, LocalDate fechaApertura) {
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

    public ArrayList <Animal> getListaAnimales() {
        return listaAnimales;
    }
    public ArrayList <Cuidador> getListaCuidadores() {
        return listaCuidadores;
    }


    public void mostrarAnimales() {
        if (listaAnimales.isEmpty()) {
            System.out.println("No hay animales registrados");
        } else {
            System.out.println("Numero de animales: " + listaAnimales.size());
            for (Animal a : listaAnimales) {
                a.mostrarAnimal();
            }
        }
    }

    public void mostrarCuidadores() {
        if (listaCuidadores.isEmpty()) {
            System.out.println("No hay cuidadores registrados");
        } else {
            System.out.println("Numero de cuidades: " + listaCuidadores.size());
            for (Cuidador a : listaCuidadores) {
                a.mostrarCuidador();
            }
        }
    }

    public void agregarCuidador (Cuidador c) {
        listaCuidadores.add(c);
    }
    public int getNumeroCuidadores() {
        return listaCuidadores.size();
    }

    public void mostrarCuidadoresEnumerados() {
        if (listaCuidadores.isEmpty()) {
            System.out.println("No hay cuidadores registrados");
            return;
        }

        System.out.println("Lista de cuidadores disponibles: ");
        for (int i = 0; i < listaCuidadores.size(); i++) {
            System.out.println((i + 1) + ". " + listaCuidadores.get(i).getNombre());
        }
    }

    public Cuidador getCuidadorPorIndice(int index) {
        if (index < 0 || index >= listaCuidadores.size()) {
            return null;
        }
        return listaCuidadores.get(index);
    }



    public void agregarAnimal(Animal a) {
        listaAnimales.add(a);
    }
    public void mostrarTicketIncidencias() {
        if (listaTicketIncidencias.isEmpty()) {
            System.out.println("No hay ticket incidencias");
        } else {
            System.out.println("Numero de tickets incidencias: " + listaTicketIncidencias.size());
            for (TicketIncidencia a : listaTicketIncidencias) {
                a.mostrarIncidencia();
            }
        }
    }

    public void agregarTicketIncidencia(TicketIncidencia t) {
        listaTicketIncidencias.add(t);
    }


    public boolean darDeBajaCuidador(String cuidadorEntrada) {
        Cuidador c = buscarCuidador(cuidadorEntrada);

        if (c == null) {   // no existe
            return false;
        }
        if (!c.getActivo()) {   // ya está inactivo
            return false;
        }

        c.setActivo(false);
        c.setFechaBaja(LocalDate.now());

        return true;
    }


    public Cuidador buscarCuidador(String cuidadorEntrada) {
        for (int i = 0; i < listaCuidadores.size(); i++) {
            if (listaCuidadores.get(i).getNombre().equals(cuidadorEntrada)) {
                return listaCuidadores.get(i);
            }
        }
        return null;
    }

    public boolean darBajaAnimal(String animalEntrada) {
        Animal a = buscarAnimal(animalEntrada);
        if (a == null) {
            return false;
        }
        if (!a.getActivo()) {
            return false;
        }
        a.setActivo(false);
        a.setFechaBaja(LocalDate.now());

        return true;
    }

    public Animal buscarAnimal(String animalEntrada) {
        for (int i = 0; i < listaAnimales.size(); i++) {
            if (listaAnimales.get(i).getIdAnimal().equals(animalEntrada)) {
                return listaAnimales.get(i);
            }
        }
        return null;
    }




    ///  ABRIR Y CERRAR
    public void abrir(){ abierto = true;
    }
    public void cerrar(){ abierto = false;
    }

    public String mostrarInfoZoo() {
        StringBuilder sb = new StringBuilder("\n<---ZooSoft Pro--->\n");
        sb.append("Nombre: "+ nombreZoo + "\n");
        sb.append("Direccion: " + direccionZoo + "\n");
        sb.append("Fecha apertura: " + fechaApertura + "\n");
        sb.append("Estado: ").append(abierto ? "Abierto" : "Cerrado").append("\n");

        return sb.toString();
    }


}
