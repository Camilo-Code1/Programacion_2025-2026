public class Agenda {

        private Contacto[] contactosControl;

    public Agenda() {
        this.contactosControl = new Contacto[100];
    }



    public Contacto[] getContactosControl() {
        return contactosControl;
    }

    public boolean verificarDuplicado (ContactoPersonas entrada) {
        boolean resultado = false;

        for (int i = 0; i < contactosControl.length; i++) {
            if (contactosControl[i] != null && contactosControl[i].getNombreCompleto().equals(entrada.getNombreCompleto())) {
                resultado = true;
                break;
            }
        }
        return resultado;
    }

    public boolean agregarContacto(Contacto entrada) {
        boolean resultado = false;

        for (int i = 0; i < contactosControl.length; i++) {
            if (contactosControl[i] == null) {
                contactosControl[i] = entrada;
                break;
            }
        }
        return resultado;
    }

    public boolean eliminarContacto(String nombreCompleto) {
        boolean resultado = false;

        for (int i = 0; i < contactosControl.length; i++) {
            if (contactosControl[i] != null && contactosControl[i].getNombreCompleto().equalsIgnoreCase(nombreCompleto)) {
                contactosControl[i] = null;
                resultado = true;
                break;
            }
        }
        return resultado;
    }

    public String mostrarContactos() {
        String datos = "";
        for (int i = 0; i < contactosControl.length; i++) {
            if (contactosControl[i] != null) {
                datos += contactosControl[i].toString() + "\n";
            }
        }
        return datos;
    }

    public int buscarContacto(String nombreCompleto) {
        int index = -1;
        for (int i = 0; i < contactosControl.length; i++) {
            if (contactosControl[i] != null && contactosControl[i].getNombreCompleto().equalsIgnoreCase(nombreCompleto)) {
                System.out.println(contactosControl[i]);
                i = index;
                break;
            }
        }
        return index;
    }


}




