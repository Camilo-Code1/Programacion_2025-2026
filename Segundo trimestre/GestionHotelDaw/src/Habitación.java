public class Habitación {

    private int numero;
    private String tipo;
    private boolean ocupada;
    private String idHuespedAsignado;

    public Habitación(int numero, String tipo){
        this.numero = numero;
        this.tipo = tipo;
        this.ocupada = false;
        this.idHuespedAsignado = null;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public String getIdHuespedAsignado() {
        return idHuespedAsignado;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public void setIdHuespedAsignado(String idHuespedAsignado) {
        this.idHuespedAsignado = idHuespedAsignado;
    }

    @Override
    public String toString() {
        return "Habitación " +
                " | Numero:" + numero +
                " | Tipo: " + tipo +
                " | Ocupada: " + ocupada +
                " | ID Huesped de Asignado: " + idHuespedAsignado +
                ']';
    }
}
