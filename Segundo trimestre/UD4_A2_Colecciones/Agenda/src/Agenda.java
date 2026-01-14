import java.util.ArrayList;
import java.util.LinkedList;

public class Agenda {

    private final ArrayList<Contacto> contactos = new ArrayList();

    public void agregarContacto(Contacto contacNuevo) {
        contactos.add(contacNuevo);
    }
    public void mostrarContactos() {
        if  (contactos.isEmpty()) {
            System.out.println("No hay contactos registrados");
            return;
        }
        System.out.println("Lista de cuidadores disponibles:");
        for (Contacto contacto : contactos) {
            System.out.println(contacto);
        }
    }

    public Contacto buscarContacto(String nombre) {

        if  (nombre == null || contactos.isEmpty()) {
            return null;
        }

        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombre)) {
                return contacto;
            }
        }

        return null;
    }
    public boolean eliminarContacto(String nombre) {
        Contacto contacto = buscarContacto(nombre);

        if (contacto != null) {
            contactos.remove(contacto);
            return true;
        }
        return false;
    }
    public int numContactos() {
        return contactos.size();
    }

}
