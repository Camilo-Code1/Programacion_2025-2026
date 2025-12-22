public class ContactoEmpresa extends Contacto {

    private String paginaWeb;
    private String correoElectronico;

    public ContactoEmpresa(String nombreCompleto, String numeroContacto, String paginaWeb, String correoElectronico) {
        super(nombreCompleto, numeroContacto);
        this.paginaWeb = paginaWeb;
        this.correoElectronico = correoElectronico;

    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n<---ContactoEmpresa--->" +
                "\nPaginaWeb: " + paginaWeb +
                "\nCorreo electronico:" + correoElectronico  +
                "\n<--------------------->";
    }
}
