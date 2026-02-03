import java.time.LocalDate;

public class Loro extends Aves{
    protected String origen;
    protected boolean habla;

    public Loro(String nombre, int edad, Estado estado, LocalDate fechaNacimiento, Tipo tipo, boolean pico, boolean vuela, String origen, boolean habla) {
        super(nombre, edad, estado, fechaNacimiento, tipo, pico, vuela);
        this.origen = origen;
        this.habla = habla;
        Mascotas.contadorAnimales++;
    }

    public String getOrigen() {
        return origen;
    }

    public boolean isHabla() {
        return habla;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\n<---Canario--->" +
                "\nOrigen: " + origen +
                "\n¿Habla? " + habla +
                "\n<-------->";
    }

    @Override
    protected String habla() {
        return this.nombre + "¡Esta hablando!";
    }

    @Override
    protected String volar() {
        return this.nombre + " ¡Esta volando!";
    }
}
