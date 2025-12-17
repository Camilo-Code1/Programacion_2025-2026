public class Contacto {

    private String nombreCompleto;
    private String numeroContacto;

    private String codContacto;

    private int contadorNumCont = 1;

    public Contacto(String nombreCompleto, String numeroContacto) {
        this.nombreCompleto = nombreCompleto;
        this.numeroContacto = numeroContacto;

        this.codContacto = String.format("C-%03d", contadorNumCont);
        contadorNumCont ++;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContacto(String numeroContacto) {
        this.numeroContacto = numeroContacto;
    }
    public String getCodContacto() {
        return codContacto;
    }

    @Override
    public String toString() {
        return "\n<---Contacto--->" +
                "\nNombre completo: " + nombreCompleto +
                "\nNumero de contacto: " + numeroContacto +
                "\nCodigo de contacto: " + codContacto  +
                "\n<-------------->";
    }
}
