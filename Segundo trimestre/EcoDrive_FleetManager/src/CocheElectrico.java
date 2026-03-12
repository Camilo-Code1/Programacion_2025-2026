public class CocheElectrico extends Vehiculo {

    private double capacidadBateria;
    private double autonomiaRestante;
    private String comentarios;

    public CocheElectrico(String id, String modelo, double precioBaseDia, double capacidadBateria, double autonomiaRestante, String comentarios) {
        super(id, modelo, precioBaseDia);
        this.capacidadBateria = capacidadBateria;
        this.autonomiaRestante = autonomiaRestante;
        this.comentarios = comentarios;
    }

    public double getCapacidadBateria() {
        return capacidadBateria;
    }

    public double getAutonomiaRestante() {
        return autonomiaRestante;
    }

    public void setAutonomiaRestante(double autonomiaRestante) {
        this.autonomiaRestante = autonomiaRestante;
    }

    public String getComentarios() {
        return comentarios;
    }


    @Override
    public String toString() {

        String vacio = (comentarios == null)
                ? "Vacio" : String.valueOf(comentarios);

        return super.toString() +
                "[ COCHE ELECTRICO" +
                " | Capacidad de bateria: " + capacidadBateria +
                " | Autonomia restante: " + autonomiaRestante +
                " | Comentarios: " + vacio  +
                ']';
    }
}
