import java.io.Serializable;
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

}
