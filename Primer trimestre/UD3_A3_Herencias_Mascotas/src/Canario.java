import java.time.LocalDate;

public class Canario extends Aves{
    protected String color;
    protected boolean canta;

    public Canario(String nombre, int edad, Estado estado, LocalDate fechaNacimiento, Tipo tipo, boolean pico, boolean vuela, String color, boolean canta) {
        super(nombre, edad, estado, fechaNacimiento, tipo, pico, vuela);
        this.color = color;
        this.canta = canta;
        Mascotas.contadorAnimales++;
    }

    public String getColor() {
        return color;
    }

    public boolean isCanta() {
        return canta;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\n<---Canario--->" +
                "\nColor: " + color +
                "\nCanta:" + canta +
                "\n<------>";
    }

    @Override
    protected String habla() {
        return this.nombre + " esta cantando!";
    }

    @Override
    protected String volar() {
        return this.nombre + " esta volando!!!";
    }
}
