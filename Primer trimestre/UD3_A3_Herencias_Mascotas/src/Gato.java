import java.time.LocalDate;

public class Gato extends Mascotas{

    private String color;
    private boolean peloLargo;

    public Gato(String nombrel, int edad, boolean estado, LocalDate fechaNacimiento, String color, boolean peloLargo) {
        super(nombrel, edad, estado, fechaNacimiento);

        this.color = color;
        this.peloLargo = peloLargo;

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isPeloLargo() {
        return peloLargo;
    }

    public void setPeloLargo(boolean peloLargo) {
        this.peloLargo = peloLargo;
    }


    @Override
    public String toString() {
        return super.toString() +
                "\n<---Gato--->" +
                "\nColor de pelaje: " + color +
                "\n¿Tiene el pelaje largo?" + peloLargo;
    }
}
