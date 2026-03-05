import java.util.ArrayList;
import java.util.List;

public class Profesor extends Persona{

    private String especialidad;
    private double salarioBase;

    private List<Asignatura> asignaturasImpartidas = new ArrayList<>();

    public Profesor(String id, String nombre, int edad, String especialidad, double salarioBase) {
        super(id, nombre, edad);
        this.especialidad = especialidad;
        this.salarioBase = salarioBase;

    }

    public String getEspecialidad() {
        return especialidad;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public String getRol(){
        return "Profesor";
    }

    public void agregarAsignatura(Asignatura asig){
        this.asignaturasImpartidas.add(asig);
    }

    @Override
    public String toString() {
        return super.toString() +
                " \n| Especialidad: " + especialidad +
                " | SalarioBase: " + salarioBase +
                " | Asignaturas: " + asignaturasImpartidas +
                " ]";
    }
}
