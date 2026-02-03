import java.time.LocalDate;

public abstract class Aves extends Mascotas{
    protected boolean pico;
    protected boolean vuela;

    public Aves(String nombre, int edad, Estado estado, LocalDate fechaNacimiento, Tipo tipo, boolean pico, boolean vuela) {
        super(nombre, edad, estado, fechaNacimiento, tipo);
        this.pico = pico;
        this.vuela = vuela;
    }

    public boolean isPico() {
        return pico;
    }

    public boolean isVuela() {
        return vuela;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\n<---Ave--->" +
                "Pico: " + pico +
                "Vuela: " + vuela +
                "\n<--------->" ;
    }

    protected abstract String volar();
}
