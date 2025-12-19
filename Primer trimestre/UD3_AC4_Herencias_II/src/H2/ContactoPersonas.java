import java.time.LocalDate;

public class ContactoPersonas extends Contacto {

    private LocalDate cumpleanios;
    private String nota;

    public ContactoPersonas(String nombreCompleto, String numeroContacto, LocalDate cumpleanios, String nota) {
        super(nombreCompleto, numeroContacto);
        this.cumpleanios = cumpleanios;
        this.nota = nota;
    }

    public LocalDate getCumpleanios() {
        return cumpleanios;
    }

    public void setCumpleanios(LocalDate cumpleanios) {
        this.cumpleanios = cumpleanios;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n<---Personas--->" +
                "\nCumpleaños: " + cumpleanios +
                "\nNota: " + nota +
                "\n<---------------->";
    }
}
