import java.time.LocalDate;

public class GerenteDep extends Trabajador {

    private int numTrabajadores;
    private Departamento gerencia;
    private Trabajador listaTrabajadores;

    public GerenteDep(String nombre, LocalDate fechaNacimiento, String dni, String direccion, String numeroSS, String emailEmp,
                      double salario, Departamento depart, int numTrabajadores, Departamento gerencia, Trabajador listaTrabajadores){
        super(nombre, fechaNacimiento, dni, direccion, numeroSS, emailEmp, salario, depart);
        this.numTrabajadores = 0;
        this.gerencia = gerencia;
        this.listaTrabajadores = listaTrabajadores;
    }

    public int getNumTrabajadores() {
        return numTrabajadores;
    }

    public Departamento getGerencia() {
        return gerencia;
    }

    public Trabajador getListaTrabajadores() {
        return listaTrabajadores;
    }

    @Override
    public String toString() {
        return super.toString() + "\n[ GerenteDep" +
                "| Numero de trabajadores: " + numTrabajadores +
                "| Gerencia:" + gerencia +
                "| Lista de trabajadores: " + listaTrabajadores +
                "] ";
    }
}
