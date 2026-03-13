import java.time.LocalDate;

public class Director extends Trabajador {

    private String telefono;
    private String cocheEmpresa;

    public Director(String nombre, LocalDate fechaNacimiento, String dni, String direccion, String numeroSS, String emailEmp,
                    double salario, Departamento depart, String telefono, String cocheEmpresa){
        super(nombre, fechaNacimiento, dni, direccion, numeroSS, emailEmp, salario, depart);
        this.telefono = telefono;
        this.cocheEmpresa = cocheEmpresa;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCocheEmpresa() {
        return cocheEmpresa;
    }

    @Override
    public String toString() {
        return super.toString() + "\nDIRECTOR" +
                "| Telefono: " + telefono  +
                "| Coche de empresa: " + cocheEmpresa  +
                "]";
    }
}
