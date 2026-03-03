import java.util.ArrayList;
import java.util.List;

public class Gestion {

    private List<Persona> nuevosPersonas = new ArrayList<Persona>();

    public void agregarMedico(Medico m) {
        nuevosPersonas.add(m);
    }

    public void mostrarMedicos() {
        for (Persona p : nuevosPersonas) {
            if (p.getTipo().equals("Medico")){
                System.out.println(p);
            }
        }
    }

    public void agregarPaciente(Paciente p) {
        nuevosPersonas.add(p);
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

}
