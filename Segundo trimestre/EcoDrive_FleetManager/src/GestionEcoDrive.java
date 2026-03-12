import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class GestionEcoDrive implements Serializable {

    private static final long serialVersionUID = -2760323582789017406L;

    private Map<String, Vehiculo> nuevosVehiculos = new HashMap<>();

    public void registrarVehiculo(Vehiculo veh) {
        nuevosVehiculos.put(veh.getId(), veh);
    }

    public void mostrarVehiculos() {
        if (nuevosVehiculos.isEmpty()) {
            System.out.println("\nNo hay vehículos registrados.");
        } else {
            System.out.println("\nVehículos registrados:");
            for (Vehiculo veh : nuevosVehiculos.values()) {
                System.out.println(veh);
            }
        }
    }

    public void mostrarVehiculosDisponibles() {
        if (nuevosVehiculos.isEmpty()) {
            System.out.println("No hay vehiculos registrados.");
        } else {
            System.out.println("Vehiculos disponibles:");
            for (Vehiculo veh : nuevosVehiculos.values()) {
                if (veh.isDisponible()) {
                    System.out.println(veh);
                }
            }
        }
    }

    // BUSCAR Y ALQUILAR

    public Vehiculo buscarVehiculo(String id) {
        for (Vehiculo veh : nuevosVehiculos.values()) {
            if (veh.getId().equals(id)) {
                return veh;
            }
        }
        return null;
    }


    //  ELIMINAR

    public boolean eliminarVehiculo(String id) {
        Vehiculo veh = buscarVehiculo(id);
        if (veh != null) {
            nuevosVehiculos.remove(id);
            System.out.println("Persona eliminada");
            return true;
        }
        System.out.println("La persona con el " + id + "no existe");
        return false;
    }

    public boolean alquilareVehiculo(String id, LocalDate fechaDevolucion) {
        Vehiculo veh = buscarVehiculo(id);
        if (veh == null) {
            System.out.println("No existe el articulo con el " + id);
            return false;
        }

        if (!veh.isDisponible()){
            System.out.println("El articulo no esta disponible");
            return false;
        }

        veh.alquilar(fechaDevolucion);
        System.out.println("El articulo " + id + " ha sido alquilado");
        return true;

    }

    public boolean devolverVehiculo(String id) {
        Vehiculo veh = buscarVehiculo(id);
        if (veh == null) {
            System.out.println("No existe el articulo con el " + id);
            return false;
        }
        if (veh.isDisponible()){
            System.out.println("El articulo ya esta disponible");
            return false;
        }

        veh.devolver();
        System.out.println("El articulo " + id + " ha sido devuelto");
        return true;
    }





    //  FICHEROS

    public void cargarDatos() {
        File archivo = new File("src/datos.dat");

        if (!archivo.exists()) {
            System.out.println("No existe el archivo");
            return;
        }

        try(ObjectInputStream ois = new ObjectInputStream
                (new FileInputStream(archivo))){

            nuevosVehiculos = (Map<String, Vehiculo>) ois.readObject();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }


    public void guardarDatos(){

        File archivo = new File("src/datos.dat");

        try (ObjectOutputStream oos = new ObjectOutputStream
                (new FileOutputStream(archivo)) ){

            oos.writeObject(nuevosVehiculos);

            System.out.println("\nDatos guardados exitosamente");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

}
