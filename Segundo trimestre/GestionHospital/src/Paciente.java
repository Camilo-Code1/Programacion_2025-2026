public class Paciente extends Persona{

    private String numeroHistorial;
    private String diagnostico;
    private boolean atendido;

    public Paciente(String nombre, int edad, String numeroHistorial, String diagnostico) {
        super(nombre, edad);
        this.numeroHistorial = numeroHistorial;
        this.diagnostico = diagnostico;
        this.atendido = false;
    }
    

    public String getNumeroHistorial() {
        return numeroHistorial;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public boolean isAtendido() {
        return atendido;
    }

    public void setAtendido(boolean atendido) {
        this.atendido = atendido;
    }

    @Override
    public String getTipo(){
        return "Paciente";
    }

    @Override
    public String toString() {
        return super.toString() +
                " | Numero de Historial:" + numeroHistorial +
                " | Diagnostico:" + diagnostico +
                " | Atendido:" + atendido;
    }
}
