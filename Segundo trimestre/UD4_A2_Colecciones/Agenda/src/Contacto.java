public class Contacto {

    private final String nombre;
    private final String numeroTelefono;
    private final String correo;

    public Contacto(String nombre, String numeroTelefono, String correo) {
        this.nombre = nombre;
        this.numeroTelefono = numeroTelefono;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public String getCorreo() {
        return correo;
    }


    @Override
    public String toString() {
        return "\n<---Contacto--->" +
                "\nNombre: " + nombre +
                "\nNumero telefonico: " + numeroTelefono +
                "\nCorreo: " + correo;
    }
}
