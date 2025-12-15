public abstract class Astros {

    private String designacion;
    private double radioEcuatorial;
    private double rotacionSobreEje;
    private double masa;
    private double temperaturaMedia;
    private double gravedad;

    public Astros(String designacion, double radioEcuatorial, double rotacionSobreEje, double masa, double temperaturaMedia, double gravedad) {
        this.designacion = designacion;
        this.radioEcuatorial = radioEcuatorial;
        this.rotacionSobreEje = rotacionSobreEje;
        this.masa = masa;
        this.temperaturaMedia = temperaturaMedia;
        this.gravedad = gravedad;

    }

    public String getDesignacion() {
        return designacion;
    }

    public void setDesignacion(String designacion) {
        this.designacion = designacion;
    }

    public double getRadioEcuatorial() {
        return radioEcuatorial;
    }

    public void setRadioEcuatorial(double radioEcuatorial) {
        this.radioEcuatorial = radioEcuatorial;
    }

    public double getRotacionSobreEje() {
        return rotacionSobreEje;
    }

    public void setRotacionSobreEje(double rotacionSobreEje) {
        this.rotacionSobreEje = rotacionSobreEje;
    }

    public double getMasa() {
        return masa;
    }

    public void setMasa(double masa) {
        this.masa = masa;
    }

    public double getTemperaturaMedia() {
        return temperaturaMedia;
    }

    public void setTemperaturaMedia(double temperaturaMedia) {
        this.temperaturaMedia = temperaturaMedia;
    }

    public double getGravedad() {
        return gravedad;
    }

    public void setGravedad(double gravedad) {
        this.gravedad = gravedad;
    }

    @Override
    public String toString() {
        return "Astros" +
                "\nRadio ecuatorial: " + radioEcuatorial +
                "\nRotacion sobre su eje de masa: " + rotacionSobreEje +
                "\nTemperatura media: " + temperaturaMedia +
                "\nGravedad: " + gravedad +
                "<------>";
    }
}


