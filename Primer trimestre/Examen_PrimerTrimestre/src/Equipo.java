import java.time.LocalDate;

public class Equipo {

    private String nombre;
    private String codEquipo;
    private LocalDate fechaCreacion;
    private Sensei senseiAsignado;
    private int maximoNinjas;

    private Ninja listaNinjas;
    private Equipo [] listaEquipos;



    public Equipo(String nombre, String codEquipo, LocalDate fechaCreacion, int maximoNinjas) {
        this.nombre = nombre;
        this.codEquipo = codEquipo;
        this.fechaCreacion = fechaCreacion;
        this.senseiAsignado = senseiAsignado;
        this.maximoNinjas = maximoNinjas;

        this.listaNinjas = listaNinjas;
        this.listaEquipos = new Equipo[maximoNinjas];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodEquipo() {
        return codEquipo;
    }

    public void setCodEquipo(String codEquipo) {
        this.codEquipo = codEquipo;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Sensei getSenseiAsignado() {
        return senseiAsignado;
    }

    public void setSenseiAsignado(Sensei senseiAsignado) {
        this.senseiAsignado = senseiAsignado;
    }

    public int getMaximoNinjas() {
        return maximoNinjas;
    }

    public void setMaximoNinjas(int maximoNinjas) {
        this.maximoNinjas = maximoNinjas;
    }

    public Ninja getNinja() {
        return listaNinjas;
    }

    public void setNinja(Ninja listaNinjas) {
        this.listaNinjas = listaNinjas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<--- Equipo: --->");
        sb.append("\nNombre: ").append(nombre);
        sb.append("\nCodigo equipo: ").append(codEquipo);
        sb.append("\nFecha de creacion: ").append(fechaCreacion);
        sb.append("\nSensei asignado: ").append(senseiAsignado);
        sb.append("\nMaximo de ninjas: ").append(maximoNinjas);
        sb.append("\nNinjas: ").append(listaNinjas);
        sb.append("\n<------------------>");
        return sb.toString();
    }

    public void mostrarEquipo() {
        System.out.print(this);
    }
}
