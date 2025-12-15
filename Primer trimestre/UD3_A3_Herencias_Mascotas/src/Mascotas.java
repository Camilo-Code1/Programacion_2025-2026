import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public abstract class Mascotas {

    private String nombrel;
    private int edad;
    private boolean estado;
    private LocalDate fechaNacimiento;

    public Mascotas(String nombrel, int edad, boolean estado, LocalDate fechaNacimiento) {
        this.nombrel = nombrel;
        this.edad = edad;
        this.estado = estado;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombrel() {
        return nombrel;
    }

    public void setNombrel(String nombrel) {
        this.nombrel = nombrel;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<---Mascotas--->");
        sb.append("Nombre: ").append(nombrel);
        sb.append("\nEdad: ").append(edad);
        sb.append("\nEstado: ").append(estado);
        sb.append("\nFecha de nacimiento: ").append(fechaNacimiento);
        sb.append("\n----------->");
        return sb.toString();
    }

    public void mostrarMascotas(){
        System.out.println(this);
    }

}