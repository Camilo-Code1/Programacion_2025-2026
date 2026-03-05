import java.io.Serializable;

public class Asignatura implements Serializable {

    private static final long serialVersionUID = -4383981628189534860L;

    private String codigo;
    private String nombre;
    private int creditos;
    private double nota;

    public Asignatura(String codigo, String nombre, int creditos, double nota) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.nota = nota;

    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public double getNota() {
        return nota;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "[ Asignatura: " +
                " | Codigo:" + codigo +
                " | Nombre:'" + nombre+
                " | Creditos: " + creditos +
                " | Nota:" + nota +
                ']';
    }
}
