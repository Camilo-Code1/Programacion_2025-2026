import java.util.ArrayList;
import java.util.List;

public class Gestion {

    List<Persona> nuevosIntegrantes = new ArrayList<Persona>();
    List<Habitación> datosEmpresa = new ArrayList<>();

    public void agregarPersona(Persona per) {
        nuevosIntegrantes.add(per);
    }

    public void mostrarPersonas() {
        for (Persona persona : nuevosIntegrantes) {
            System.out.println(persona);
        }
    }

}
