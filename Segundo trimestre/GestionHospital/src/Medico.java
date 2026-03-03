public class Medico extends Persona{

    private String especialidad;
    private double salario;

    public Medico(String nombre, int edad, String especialidad, double salario) {
        super(nombre, edad);
        this.especialidad = especialidad;
        this.salario = salario;

    }

    public String getEspecialidad() {
        return especialidad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String getTipo(){
        return "Medico";
    }

    @Override
    public String toString() {
        return super.toString() +
                "| Especialidad: " + especialidad +
                " | Salario: " + salario;
    }
}
