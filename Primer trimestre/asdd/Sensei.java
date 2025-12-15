import java.time.LocalDate;

public class Sensei extends Ninja {

    private String codSensei;
    private double estrategia;
    private double liderazgo;

    public Sensei(String nombre,LocalDate fechaNacimiento,String dni,String direccion,String numContrato, TipoPersona tipoPersona,
                  Chakra chakra, Rango rango, String tecnicaSecreta, LocalDate fechaAlta, double ataque, double defensa,
                  String codSensei, double estrategia, double liderazgo) {
        super(nombre,fechaNacimiento,dni,direccion,numContrato, tipoPersona, chakra, rango, tecnicaSecreta, fechaAlta, ataque, defensa);

        this.codSensei = codSensei;
        this.estrategia = estrategia;
        this.liderazgo = liderazgo;

    }

    public String getCodSensei() {
        return codSensei;
    }

    public void setCodSensei(String codSensei) {
        this.codSensei = codSensei;
    }

    public double getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(double estrategia) {
        this.estrategia = estrategia;
    }

    public double getLiderazgo() {
        return liderazgo;
    }

    public void setLiderazgo(double liderazgo) {
        this.liderazgo = liderazgo;
    }

    @Override
    public String toString() {
        return super.toString() +
        "\n<--Sensei--->" +
        "\nCodigo sensei: " +  this.codSensei +
        "\nEstrategia: " +   this.estrategia
        + "\nLiderazgo: " +   this.liderazgo +
        "\n<------------------->";
    }

}
