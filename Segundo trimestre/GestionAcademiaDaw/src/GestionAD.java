import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GestionAD implements Serializable {

    private static final long serialVersionUID = -8530018169449509648L;

    private Map<String, Persona > nuevasPersonas = new HashMap<>();
    private Map<String, Asignatura> nuevasAsignaturas = new HashMap<>();

    public void registrarPersona (Persona per) {
        nuevasPersonas.put(per.getId(), per);
    }

    public void registrarAsignatura (Asignatura as) {
        nuevasAsignaturas.put(as.getCodigo(), as);
    }

    public void mostrarAsignaturas () {
        for (Asignatura as : nuevasAsignaturas.values()) {
            System.out.println(as);
        }
    }
    public void mostrarPersonas () {
        for (Persona per : nuevasPersonas.values()) {
            System.out.println(per);
        }
    }

    public void mostrarProfesores() {
        for (Persona per : nuevasPersonas.values()) {
            if (per instanceof Profesor) {
                System.out.println(per);
            }
        }
    }
    public void mostrarAlumnos() {
        for (Persona per : nuevasPersonas.values()) {
            if (per instanceof Alumno) {
                System.out.println(per);
            }
        }
    }

    public void mostrarSoloAlumnos() {
        for (Persona per : nuevasPersonas.values()) {
            if (per.getRol().equalsIgnoreCase("Alumno")) {
                System.out.println(per);
            }
        }
    }

    //  Buscar

    public Persona buscarPersona (String id) {
        for (Persona per : nuevasPersonas.values()) {
            if (per.getId().equals(id)) {
                return per;
            }
        }
        return null;
    }

    // Borrar

    public boolean eliminarPersona (String id) {
        Persona per = buscarPersona(id);

        if (per == null) {
            nuevasPersonas.remove(id);
            return true;
        }
        nuevasPersonas.remove(id);

        System.out.println("El persona" + " " + "eliminado exitosamente");
        return true;
    }

    public boolean matricularAlummno (String id, String codigo) {
        Persona per = nuevasPersonas.get(id);

        boolean existeAsignatura = nuevasAsignaturas.containsKey(codigo);

        if (per instanceof Alumno && existeAsignatura) {
            ((Alumno) per).matricularEn((codigo));
            return true;
        }
        return false;
    }

    public boolean asignarNota (String id, String codigo, double nota) {
        Persona per = nuevasPersonas.get(id);

        if (per instanceof Alumno){
            ((Alumno) per).ponerNota(codigo, nota);
            return true;
        }
        return false;
    }


    // Ficheros

   public void cargarDatos(){
        File enlace = new File("src/resources/datos.dat");

        if (!enlace.exists()) {
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream
                (new FileInputStream(enlace)) ) {

            nuevasAsignaturas = (Map<String, Asignatura>) ois.readObject();
            nuevasPersonas = (Map<String, Persona>) ois.readObject();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void guardarDatos(){
        File enlace = new File("src/resources/datos.dat");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(enlace)) ) {
            oos.writeObject(nuevasAsignaturas);
            oos.writeObject(nuevasPersonas);

            System.out.println("Datos guardados exitosamente");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
