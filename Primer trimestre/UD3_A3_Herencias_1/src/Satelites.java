public class Satelites extends Astros {

   private double distanciaPlaneta;
   private String orbitaPlanetaria;
   private Planetas planetaPertenece;

   private int contadorSatelites = 0;

   private int tamanioMaximo = 100;
   Satelites[] nuevoSatelite = new Satelites[tamanioMaximo];


    public Satelites(String designacion, double radioEcuatorial, double rotacionSobreEje, double masa, double temperaturaMedia, double gravedad,
                     double distanciaPlaneta, String orbitaPlanetaria, Planetas planetaPertenece) {
        super(designacion, radioEcuatorial, rotacionSobreEje, masa, temperaturaMedia, gravedad);
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

    public void mostrarSatelites(){
        for (int i = 0; i < contadorSatelites; i++) {
            if (nuevoSatelite[i] != null){
                System.out.println(nuevoSatelite[i]);
            }
        }
    }

    public void insertarSatelite(Satelites insertarSatelite){
        if (contadorSatelites < tamanioMaximo) {
            nuevoSatelite[contadorSatelites] = insertarSatelite;
            contadorSatelites++;

        } else {

            System.out.println("No hay más espacio para Satelites o ha ocurrido un error inesperado");
        }
    }

    public boolean reorganizarSatelite() {
        boolean orden = false;

        for (int i = 0; i < contadorSatelites; i++) {
            if (nuevoSatelite[i] != null && nuevoSatelite[i - 1] == null) {
                nuevoSatelite[i -1] = nuevoSatelite[i];
                nuevoSatelite[i] = null;
                orden = true;
            }
        }

        return orden;
    }

    public void mostrarSatelitePorDesignacion(String designacion){
        boolean encontrado = false;

        for (int i = 0; i < contadorSatelites; i++) {
            if (nuevoSatelite[i] != null &&
                    nuevoSatelite[i].getDesignacion().equalsIgnoreCase(designacion)) {
                    System.out.println(nuevoSatelite[i]);
                    encontrado = true;
                    break;
            }
        }
        if (!encontrado) {
            System.out.println("\nNo se encontro ningún salite con esa designación");
        }
    }

    public void mostrarDesignacionSatelite(){
        for (int i = 0; i < contadorSatelites; i++) {
            if (nuevoSatelite[i] != null){
                System.out.println(nuevoSatelite[i].getDesignacion());
            }
        }
    }

    public boolean verificarSatelite (String designacion){

        for (int i = 0; i < contadorSatelites; i++) {
            if (nuevoSatelite[i].getDesignacion().equalsIgnoreCase(designacion)) {
                return true;
            }

        }
        System.out.println("\nParece que no es posible encontrar el satelite o no esta creado.");
        return false;
    }

}
