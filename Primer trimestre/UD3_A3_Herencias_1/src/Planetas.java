public class Planetas extends Astros{

    private double distanciaSol;
    private double orbitaSol;
    private boolean tieneSatelites;

    public Planetas(String designacion,double radioEcuatorial, double rotacionSobreEje, double masa, double temperaturaMedia, double gravedad,
                    double distanciaSol, double orbitaSol, boolean tieneSatelites) {
        super(designacion, radioEcuatorial, rotacionSobreEje, masa, temperaturaMedia, gravedad);
        this.distanciaSol = distanciaSol;
        this.orbitaSol = orbitaSol;
        this.tieneSatelites = false;
    }

    public double getDistanciaSol() {
        return distanciaSol;
    }

    public void setDistanciaSol(double distanciaSol) {
        this.distanciaSol = distanciaSol;
    }

    public double getOrbitaSol() {
        return orbitaSol;
    }

    public void setOrbitaSol(double orbitaSol) {
        this.orbitaSol = orbitaSol;
    }

    public boolean isTieneSatelites() {
        return tieneSatelites;
    }

    public void setTieneSatelites(boolean tieneSatelites) {
        this.tieneSatelites = tieneSatelites;
    }

    @Override
    public String toString() {
        return super.toString() +
                "<---Satelites--->" +
                "\nDistancia del sol: " + distanciaSol +
                "\nOrbita del sol: " + orbitaSol +
                "\nTiene satelites: " + tieneSatelites +
                "-----";
    }



}
