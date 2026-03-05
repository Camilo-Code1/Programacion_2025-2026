import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Gestion {

    private List<Persona> nuevosPersonas = new ArrayList<Persona>();

    // AGREGAR Y MOSTRAR

    public void registro(Persona m) {
        nuevosPersonas.add(m);
    }

    public void mostrarMedicos() {
        for (Persona p : nuevosPersonas) {
            if (p.getTipo().equals("Medico")){
                System.out.println(p);
            }
        }
    }


    public void mostrarPacientes() {
        for (Persona p : nuevosPersonas) {
            if (p.getTipo().equals("Paciente")) {
                System.out.println(p);
            }
        }
    }

    public void mostrarTodosPersonas() {
        for (Persona p : nuevosPersonas) {
            System.out.println(p);
        }
    }

    public void mostrarPacientesNoAtendidos(){
        for (Persona p : nuevosPersonas) {
            if (p instanceof Paciente) {
                Paciente pac = (Paciente) p;
                if (!pac.isAtendido()) {
                    System.out.println(pac);
                }
            }
        }
    }

    public void mostrarPacientesFiltro(){
        for (Persona p : nuevosPersonas) {
            System.out.println(p.getId() + " / " + p.getNombre());
        }
    }

    // Eliminar

    public boolean eliminarPersona(String id) {
        Persona p = buscarPersona(id);

        if (p == null) {
            System.out.println("No existe el persona con el ID " + id);
            return false;
        }

        // Posible agregar funcionar de mantener aun si no se a atendido

        nuevosPersonas.remove(p);

        System.out.println("Persona eliminado con el ID " + id);
        return true;
    }


    // BUSCAR Y ATENDER

    public Persona buscarPersona(String id) {
        for (Persona p : nuevosPersonas) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }


    public boolean atenderPaciente (String id) {
        Persona p = buscarPersona(id);

        if (p == null) {
            System.out.println("No se encontro el persona con el ID " + id);
            return false;
        }

       if (p instanceof Paciente) {
           Paciente pac = (Paciente) p;

           if (pac.isAtendido()){
               System.out.println("El persona se encuentra atendido");
               return false;
           }

           pac.setAtendido(true);
           System.out.println("Paciente " + pac.getNombre() + " atendido con éxito.");
           return true;
       } else {
           System.out.println("ERROR: El ID " + id + " pertenece a un Médico, no se puede 'atender'.");
           return false;
       }

    }

    public boolean asignarDiagnostico(String id, String nuevoDiagnostico) {
        Persona p = buscarPersona(id);

        if (p instanceof Paciente) {
            Paciente pac = (Paciente) p;
            pac.setDiagnostico(nuevoDiagnostico);
            System.out.println("Diagnóstico actualizado para: " + pac.getNombre());
            return true;
        }

        System.out.println("No se puede asignar diagnóstico: El ID no corresponde a un paciente.");
        return false;
    }



    // FICHEROS

    public void cargarDatos(){
        File archivo = new File("src/resources/datos.dat");

        if (!archivo.exists()){
            return;
        }

        try(ObjectInputStream ois = new ObjectInputStream
                (new FileInputStream(archivo))) {

            nuevosPersonas = (List<Persona>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los datos: " + e.getMessage());

        }

    }

    public void guardarDatos(){

        File archivo = new File("src/resources/datos.dat");

        try ( FileOutputStream fos = new FileOutputStream(archivo);
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(nuevosPersonas);

            System.out.println("Datos guardados exitosamente");

            } catch (IOException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }

}
