import java.time.LocalDate;

public class Perro extends Mascotas{

    private String raza;
    private boolean pulgas;

    public Perro(String nombrel, int edad, boolean estado, LocalDate fechaNacimiento, String raza, boolean pulgas) {
        super(nombrel, edad, estado, fechaNacimiento);
        this.raza = raza;
        this.pulgas = pulgas;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public boolean isPulgas() {
        return pulgas;
    }

    public void setPulgas(boolean pulgas) {
        this.pulgas = pulgas;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n<---Perro--->" +
                "\nRaza: " + raza +
                "\nPulgas: " + pulgas +
                "\n<------------>";
    }

}
