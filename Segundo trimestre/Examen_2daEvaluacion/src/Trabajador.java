import java.time.LocalDate;

public class Trabajador extends Persona {



    private String numeroSS;
    private String emailEmp;
    private double salario;
    private Departamento depart;

    public Trabajador(String nombre, LocalDate fechaNacimiento, String dni, String dirección, String numeroSS, String emailEmp, double salario, Departamento depart) {
        super(nombre, fechaNacimiento, dni, dirección);
        this.numeroSS = numeroSS;
        this.emailEmp = emailEmp;
        this.salario = salario;
        this.depart = depart;
    }


    public String getNumeroSS() {
        return numeroSS;
    }

    public String getEmailEmp() {
        return emailEmp;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Departamento getDepart() {
        return depart;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n[ TRAJADOR " +
                "| Numero de seguridad social: " + numeroSS  +
                "| Email de Empresa: " + emailEmp  +
                "| Salario: " + salario +
                "| Departamento: " + depart +
                "] ";
    }
}
