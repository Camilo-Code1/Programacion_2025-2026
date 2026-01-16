public class Coche {

    private String color;
    private String marca;

    public Coche(String color, String marca) {
        this.color = color;
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public String getMarca() {
        return marca;
    }

    @Override
    public String toString() {
        return "\n<---Coche--->" +
                "\nColor: " + color  +
                "\nMarca: " + marca +
                "\n-------------";
    }
}
