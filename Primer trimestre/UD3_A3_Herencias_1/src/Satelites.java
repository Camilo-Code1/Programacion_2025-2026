public class Satelites extends Astros {

   private double distanciaPlaneta;
   private String orbitaPlanetaria;
   private Planetas planetaPertenece;

    public Satelites(double radioEcuatorial, double rotacionSobreEjeMasa, double temperaturaMedia, double gravedad,
                     double distanciaPlaneta, String orbitaPlanetaria, Planetas planetaPertenece) {
        super(radioEcuatorial, rotacionSobreEjeMasa, temperaturaMedia, gravedad);
        this.distanciaPlaneta = distanciaPlaneta;
        this.orbitaPlanetaria = orbitaPlanetaria;
        this.planetaPertenece = planetaPertenece;
    }

    public double getDistanciaPlaneta() {
        return distanciaPlaneta;
    }

    public void setDistanciaPlaneta(double distanciaPlaneta) {
        this.distanciaPlaneta = distanciaPlaneta;
    }

    public String getOrbitaPlanetaria() {
        return orbitaPlanetaria;
    }

    public void setOrbitaPlanetaria(String orbitaPlanetaria) {
        this.orbitaPlanetaria = orbitaPlanetaria;
    }

    public Planetas getPlanetaPertenece() {
        return planetaPertenece;
    }

    public void setPlanetaPertenece(Planetas planetaPertenece) {
        this.planetaPertenece = planetaPertenece;
    }

    @Override
    public String toString() {
        return super.toString() +
                "<---Satelites--->" +
                "\nDistancia del Planeta: " + distanciaPlaneta +
                "\nOrbita planetaria: " + orbitaPlanetaria +
                "\nPlaneta al que pertenece: " + planetaPertenece +
                "<------------->";
    }
}
