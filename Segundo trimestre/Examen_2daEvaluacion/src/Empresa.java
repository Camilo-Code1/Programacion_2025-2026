import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Empresa implements Serializable{

    private Map<String, Persona> nuevosTrab = new HashMap<>();
    private List<String> Departamentos = new ArrayList<>();

    private static int numeroTrabajadores = 0;


    private static final long serialVersionUID = -2760323582789017406L;

    private String nombreEmp;
    private String CIF;
    private LocalDate fechaFundacion;


    public Empresa(String nombreEmp, String CIF, LocalDate fechaFundacion){
        this.nombreEmp = nombreEmp;
        this.CIF = CIF;
        this.fechaFundacion = fechaFundacion;

    }

    public Map<String, Persona> getNuevosTrab() {
        return nuevosTrab;
    }

    public String getNombreEmp() {
        return nombreEmp;
    }

    public String getCIF() {
        return CIF;
    }

    public LocalDate getFechaFundacion() {
        return fechaFundacion;
    }

    @Override
    public String toString() {
//        String mostrarTrabajadoresFiltrados = for (Persona per : nuevosTrab.values()){
//            System.out.println(per.getDni() + " | " + per.getNombre());};
        return "[ Empresa" +
                " | Nombre Empresa: " + nombreEmp  +
                " | CIF: " + CIF  +
                " | Fecha de fundacion: " + fechaFundacion +
                " | NuevosTrab: " + "¡Datos, datos, datos!" +
                ']';
    }

    // REGISTRAR Y MOSTRAR

    public void registrarTrabajador(Persona per){
        nuevosTrab.put(per.getDni(), per);
    }

    public void registrarDatosEmpresa () {

    }

    public void mostrarTrabajadores(){
        if (nuevosTrab.isEmpty()){
            System.out.println("No hay trabajadores registrados");
        } else {
            System.out.println("\nLista de trabajadores: ");
            for (Persona per : nuevosTrab.values()){
                System.out.println(per);
            }
        }
    }

    public void mostrarTrabajadoresFiltrados(){
        if (nuevosTrab.isEmpty()){
            System.out.println("No hay trabajadores registrados");
        } else {
            for (Persona per : nuevosTrab.values()){
                System.out.println(per.getDni() + " | " + per.getNombre());
            }
        }
    }



    public void mostrarNumeroTrabajadores(){
        if (nuevosTrab.isEmpty()){
            System.out.println("No hay trabajadores registrados");
        } else {
            for (Persona per : nuevosTrab.values()){
                numeroTrabajadores++;
            }
            System.out.println("\nEl numero de trabajadores que hay registrados son: " + numeroTrabajadores);
            numeroTrabajadores = 0;
        }

    }

    public void mostrarTrabajadoresDepartamentosDireccion(){
        if (nuevosTrab.isEmpty()){
            System.out.println("No hay trabajadores registrados");
        } else {
            System.out.println("\nTrabajadores del departamento de DIRECCION: ");
            for (Persona persona : nuevosTrab.values()){
                if (persona instanceof Trabajador){
                    Trabajador trab = (Trabajador) persona;
                        if (trab.getDepart() == Departamento.Direccion ) {
                            System.out.println(trab.getDni() + " | " + trab.getNombre());                        }
                }
            }
        }
    }

    public void mostrarTrabajadoresDepartamentosInformatica(){
        if (nuevosTrab.isEmpty()){
            System.out.println("No hay trabajadores registrados");
        } else {
            System.out.println("\nTrabajadores del departamento de INFORMATICA: ");
            for (Persona persona : nuevosTrab.values()){
                if (persona instanceof Trabajador){
                    Trabajador trab = (Trabajador) persona;
                    if (trab.getDepart() == Departamento.Informatica ) {
                        System.out.println(trab.getDni() + " | " + trab.getNombre());
                    }
                }
            }
        }
    }

    public void mostrarTrabajadoresDepartamentosMarketing(){
        if (nuevosTrab.isEmpty()){
            System.out.println("No hay trabajadores registrados");
        } else {
            System.out.println("\nTrabajadores del departamento de MARKETING: ");
            for (Persona persona : nuevosTrab.values()){
                if (persona instanceof Trabajador){
                    Trabajador trab = (Trabajador) persona;
                    if (trab.getDepart() == Departamento.Marketing ) {
                        System.out.println(trab.getDni() + " | " + trab.getNombre());
                    }
                }
            }
        }
    }

    public void mostrarTrabajadoresDepartamentosGestion(){
        if (nuevosTrab.isEmpty()){
            System.out.println("No hay trabajadores registrados");
        } else {
            System.out.println("\nTrabajadores del departamento de GESTION: ");
            for (Persona persona : nuevosTrab.values()){
                if (persona instanceof Trabajador){
                    Trabajador trab = (Trabajador) persona;
                    if (trab.getDepart() == Departamento.Gestion ) {
                        System.out.println(trab.getDni() + " | " + trab.getNombre());
                    }
                }
            }
        }
    }

    public void mostrarCosteSalarios(){

        double costeSalarios = 0;

        if (nuevosTrab.isEmpty()){
            System.out.println("No hay trabajadores registrados");
        } else {
            System.out.println("\nCOSTE: ");
            for (Persona persona : nuevosTrab.values()){
                if (persona instanceof Trabajador){
                    Trabajador trab = (Trabajador) persona;
                    if (trab.getSalario() == costeSalarios) {
                        costeSalarios++;
                    }
                }
            }
            System.out.println("El coste de los salarios en conjunto es: " + costeSalarios);
            costeSalarios = 0;
        }
    }

    // BUSCAR Y ELIMINAR

    public Persona buscarTrabajador(String dni){
        for (Persona veh : nuevosTrab.values()) {
            if (veh.getDni().equals(dni)){
                return veh;
            }
        }
        return null;
    }

    public boolean eliminarTrabajador(String dni){
        Persona veh = buscarTrabajador(dni);
        if (veh != null){
            nuevosTrab.remove(dni);
            System.out.println("Trabajador eliminado");
            return true;
        }
        System.out.println("La persona con el DNI de " + dni + "no existe.");
        return false;
    }



    // FICHEROS



    public void cargarDatos(){
        File archivo = new File("src/resources/empresa.bat");

        if (!archivo.exists()){
            System.out.println("No existe el archivo");
            return;
        }


        try (ObjectInputStream ois = new ObjectInputStream
                (new FileInputStream(archivo))){

            nuevosTrab = (Map<String, Persona>) ois.readObject();

        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }


    public void guardarDatos(){

        File archivo = new File("src/resources/empresa.bat");

        try (ObjectOutputStream oos = new ObjectOutputStream
                (new FileOutputStream(archivo)) ){

            oos.writeObject(nuevosTrab);

            System.out.println("\nDatos guardados exitosamente");
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }

    }
}
