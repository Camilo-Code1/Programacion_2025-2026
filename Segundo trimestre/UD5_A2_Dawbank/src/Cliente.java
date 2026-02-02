import java.time.LocalDate;

public class Cliente extends Persona {

    private String ntelefono;
    private String email;
    private String direccion;

    public Cliente (String nombre, String dni, LocalDate fechaNacimiento , String telefono, String email, String direccion) {
        super(nombre, dni, fechaNacimiento);
        this.ntelefono = telefono;
        this.email = email;
        this.direccion = direccion;
    }

    public String getNtelefono() {
        return ntelefono;
    }

    public void setNtelefono(String ntelefono) {
        this.ntelefono = ntelefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    @Override
    public String toString() {
        return super.toString() +
                "\n<>---Cliente---<>" +
                "\nNumero de telefono: " + ntelefono  +
                "\nEmail: " + email +
                "\nDireccion: " + direccion  +
                "\n<><><><><><><><><><><><><><><>" ;
    }
}
