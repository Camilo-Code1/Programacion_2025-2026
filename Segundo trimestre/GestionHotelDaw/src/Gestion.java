import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Gestion {

    List<Persona> nuevosIntegrantes = new ArrayList<Persona>();
    List<Habitacion> datosEmpresa = new ArrayList<>();

    // AGREGAR Y MOSTRAR

    public void agregarPersona(Persona per) {
        nuevosIntegrantes.add(per);
    }

    public void mostrarPersonas() {
        for (Persona persona : nuevosIntegrantes) {
            System.out.println(persona);
        }
    }

    public void agregarHabitacion(Habitacion hab) {
        datosEmpresa.add(hab);
    }

    public void mostrarHabitaciones() {
            for (Habitacion hab : datosEmpresa) {
                System.out.println(hab);
            }
        }

    public void mostrarHuespedesFiltro(){
        for (Persona persona : nuevosIntegrantes) {
                System.out.println(persona.getId() + " | " + persona.getNombre());
            }
        }

    public void mostrarHabitacionesFiltro(){
        for (Habitacion hab : datosEmpresa) {
            if (!hab.isOcupada()){
                System.out.println(hab);
            }
        }
    }


    // ELIMINAR

    public boolean eliminarPersona(String id) {
        Persona per = buscarHuesped(id);

        if (per == null) {
            System.out.println("No se ha podido eliminar la persona " + id);
        }
        nuevosIntegrantes.remove(per);
        System.out.println("Persona eliminada con exito");
        return true;
    }

    public boolean eliminarHabitacion(int numero) {
        Habitacion hab = buscarHabitacion(numero);

        if (hab == null) {
            System.out.println("No se ha podido eliminar la persona " + numero);
        }

        datosEmpresa.remove(hab);
        System.out.println("Persona eliminada con exito");
        return true;
    }



    // BUSCAR Y ASIGNAR

    public Persona buscarHuesped (String id) {
        for (Persona persona : nuevosIntegrantes) {
            if (persona.getId().equals(id)) {
                System.out.println("Huesped encontrado: " + persona);
                return persona;
            }
        }
        System.out.println("Huesped no encontrado con ID: " + id);
        return null;
    }

    public Habitacion buscarHabitacion (int numero) {
        for (Habitacion hab : datosEmpresa) {
            if (hab.getNumero() == numero) {
                System.out.println("Habitación encontrada: " + hab);
                return hab;
            }
        }
        System.out.println("Habitación no encontrada con número: " + numero);
        return null;
    }

    public void asignarHabitacion(String id, int numero) {
        Persona p = buscarHuesped(id);
        Habitacion h = buscarHabitacion(numero);


        if (p == null | h == null) {
            System.out.println("No se puede asignar habitación, huesped no encontrado.");
            return;
        }

        if (h.isOcupada()){
            System.out.println("La habitacion " + h.getNumero() + " ya esta ocupada");

        }

        if (p instanceof Huesped){
            Huesped hue = (Huesped) p;

            if (hue.isHospedado()){
                System.out.println("Error: El huesped " + hue.getNombre() + " ya esta hospedado en la habitacion " + hue.getNumeroHabitacion());
                return;
            }

            h.registrarIngreso(id);
            hue.setHospedado(true);
            hue.setNumeroHabitacion(numero);

            System.out.println("Check-in exitoso: " + hue.getNombre() + " en habitación " + numero);
        } else {
            System.out.println("Error: La persona con ID " + id + " no es un Huésped.");
        }

    }

        public void desasignarHabitacion(String id, int numero) {
        Persona p = buscarHuesped(id);
        Habitacion h = buscarHabitacion(numero);

        if (p == null | h == null) {
            System.out.println("No se puede asignar habitación, huesped no encontrado.");
            return;
        }
        if (!h.isOcupada()){
            System.out.println("La habitacion " + h.getNumero() + " no esta ocupada");
        }

        if (p instanceof Huesped){
            Huesped hue = (Huesped) p;

            if (!hue.isHospedado()){
                System.out.println("Error: El huesped " + hue.getNombre() + "no se encuentra en la habitacion " + hue.getNumeroHabitacion());
                return;
            }

            h.registrarSalida();
            hue.setHospedado(false);
            hue.setNumeroHabitacion(0);

            System.out.println("Desasignación exitosa: " + hue.getNombre() + ", la habitación " + numero + "ha quedado libre");
        } else {
            System.out.println("Error: La persona con ID" + id + " no es un Huesped." );
        }

        }





    // Ficheros

    public void cargarDatos(){

        File archivo = new File("src/resources/datos.dat");

        if (!archivo.exists()){
            return;
        }

        try(ObjectInputStream ois = new ObjectInputStream
                (new FileInputStream(archivo))) {

            nuevosIntegrantes = (List<Persona>) ois.readObject();
            datosEmpresa = (List<Habitacion>) ois.readObject();

            System.out.println("Datos cargados con exitoso");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los datos: " + e.getMessage());
        }
    }


    public void guardarDatos(){

        File archivo = new File("src/resources/datos.dat");

        try(FileOutputStream fos = new FileOutputStream(archivo);
        ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(nuevosIntegrantes);
            oos.writeObject(datosEmpresa);

            System.out.println("Datos guardados exitoso");
        } catch (IOException e){
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }






    } ///






