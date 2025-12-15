import java.time.LocalDate;

public abstract class Persona {

    private String nombre;
    private LocalDate fechaNacimiento;
    private String dni;
    private String direccion;
    private String numContrato;

    private TipoPersona tipoPersona;

    public Persona(String nombre,LocalDate fechaNacimiento,String dni,String direccion,String numContrato, TipoPersona tipoPersona) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
        this.direccion = direccion;
        this.numContrato = numContrato;
        this.tipoPersona = tipoPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumContrato() {
        return numContrato;
    }

    public void setNumContrato(String numContrato) {
        this.numContrato = numContrato;
    }

    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n<---Persona--->")
                .append("\nNombre: " + this.nombre)
                .append("\nFecha nacimiento: " + this.fechaNacimiento)
                .append("\nDni: " + this.dni)
                .append("\nDireccion: " + this.direccion)
                .append("\nNum Contrato: " + this.numContrato)
                .append("\nTipo Persona: " + this.tipoPersona);
        return sb.toString();
    }

    public void mostrarPersona() {
        System.out.println(this);
    }
}
