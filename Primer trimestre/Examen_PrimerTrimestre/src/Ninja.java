import java.time.LocalDate;

public class Ninja extends Persona {

    private Chakra chakra;
    private Rango rango;
    private String idNinja;
    private String tecnicaSecreta;
    private LocalDate fechaAlta;
    private double ataque;
    private double defensa;
    private Equipo equipoAsignado;

    private static int contadorIdNinja = 1;

    public Ninja(String nombre,LocalDate fechaNacimiento,String dni,String direccion,String numContrato,
                 TipoPersona tipoPersona, Chakra chakra, Rango rango,
                 String tecnicaSecreta, LocalDate fechaAlta, double ataque, double defensa) {
        super(nombre,fechaNacimiento,dni,direccion,numContrato, tipoPersona);

        this.chakra = chakra;
        this.rango = rango;

        this.idNinja = String.format("N-%03d", contadorIdNinja);
        contadorIdNinja++;

        this.tecnicaSecreta = tecnicaSecreta;
        this.fechaAlta = fechaAlta;
        this.ataque = ataque;
        this.defensa = defensa;

    }

    public Chakra getChakra() {
        return chakra;
    }

    public void setChakra(Chakra chakra) {
        this.chakra = chakra;
    }

    public Rango getRango() {
        return rango;
    }

    public void setRango(Rango rango) {
        this.rango = rango;
    }

    public String getIdNinja() {
        return idNinja;
    }



    public String getTecnicaSecreta() {
        return tecnicaSecreta;
    }

    public void setTecnicaSecreta(String tecnicaSecreta) {
        this.tecnicaSecreta = tecnicaSecreta;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public double getAtaque() {
        return ataque;
    }

    public void setAtaque(double ataque) {
        this.ataque = ataque;
    }

    public double getDefensa() {
        return defensa;
    }

    public void setDefensa(double defensa) {
        this.defensa = defensa;
    }


    @Override
    public String toString() {
        return super.toString() +

                "\n<---Ninja--->" +
                "\nChakra: " + chakra +
                "\nRango: " + rango +
                "\nIDNinja: " + idNinja +
                "\nTecnica secreta: " + tecnicaSecreta +
                "\nFecha alta: " + fechaAlta +
                "\nAtaque: " + ataque +
                "\nDefensa: " + defensa +
                "\n<---------->";

    }



}


