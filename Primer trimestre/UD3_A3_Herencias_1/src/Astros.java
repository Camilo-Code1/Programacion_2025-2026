public abstract class Astros {

    private double radioEcuatorial;
    private double rotacionSobreEjeMasa;
    private double temperaturaMedia;
    private double gravedad;

    public Astros(double radioEcuatorial, double rotacionSobreEjeMasa, double temperaturaMedia, double gravedad) {
        this.radioEcuatorial = radioEcuatorial;
        this.rotacionSobreEjeMasa = rotacionSobreEjeMasa;
        this.temperaturaMedia = temperaturaMedia;
        this.gravedad = gravedad;

    }

    public double getRadioEcuatorial() {
        return radioEcuatorial;
    }

    public void setRadioEcuatorial(double radioEcuatorial) {
        this.radioEcuatorial = radioEcuatorial;
    }

    public double getRotacionSobreEjeMasa() {
        return rotacionSobreEjeMasa;
    }

    public void setRotacionSobreEjeMasa(double rotacionSobreEjeMasa) {
        this.rotacionSobreEjeMasa = rotacionSobreEjeMasa;
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
                "\nRotacion sobre su eje de masa: " + rotacionSobreEjeMasa +
                "\nTemperatura media: " + temperaturaMedia +
                "\nGravedad: " + gravedad +
                "<------>";
    }
}


