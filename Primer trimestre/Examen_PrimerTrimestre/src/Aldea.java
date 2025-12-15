import java.time.LocalDate;

public class Aldea {

    private String nombreAldea;
    private String codAldea; // 1 Mayus y 5 dig
    private LocalDate fechaCreacion;
    private String kage;
    private int maximoEquipos;

    private Equipo [] listaEquipos;
    private Ninja [] listaNinjas;
    private Sensei [] listaSensei;

    private static int numEquipos;
    private static int numNinjas;
    private static int numSenseis;

    private int limitePersonas = 100;

    public Aldea(String nombreAldea, String codAldea, LocalDate fechaCreacion, String kage, int maximoEquipos) {
        this.nombreAldea = nombreAldea;
        this.codAldea = codAldea;
        this.fechaCreacion = fechaCreacion;
        this.kage = kage;
        this.maximoEquipos = maximoEquipos;

        this.numNinjas = 0;
        this.numSenseis = 0;
        this.numEquipos = 0;
        this.listaEquipos = new Equipo[maximoEquipos];
        this.listaNinjas = new Ninja[limitePersonas];
        this.listaSensei = new Sensei[limitePersonas];
    }

    public String getNombreAldea() {
        return nombreAldea;
    }

    public void setNombreAldea(String nombreAldea) {
        this.nombreAldea = nombreAldea;
    }

    public String getCodAldea() {
        return codAldea;
    }

    public void setCodAldea(String codAldea) {
        this.codAldea = codAldea;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getKage() {
        return kage;
    }

    public void setKage(String kage) {
        this.kage = kage;
    }

    public int getMaximoEquipos() {
        return maximoEquipos;
    }

    public void setMaximoEquipos(int maximoEquipos) {
        this.maximoEquipos = maximoEquipos;
    }

    public Equipo[] getListaEquipos() {
        return listaEquipos;
    }

    public void setListaEquipos(Equipo[] listaEquipos) {
        this.listaEquipos = listaEquipos;
    }

    public Ninja[] getListaNinjas() {
        return listaNinjas;
    }
    public void setListaNinjas(Ninja[] listaNinjas) {
        this.listaNinjas = listaNinjas;
    }

    public void mostrarNinjas() {
        boolean encontrado = false;

        if (this.numNinjas == 0) {
            System.out.println("No hay ninjas registrados");
        } else {
            for (int i = 0; i < numNinjas; i++) {
                if (listaNinjas[i].getTipoPersona() == TipoPersona.NINJA) {
                    System.out.println(this.listaNinjas[i]);
                    encontrado = true;
                }
            }
            if (!encontrado) {
                System.out.println("No se encontraron ninjas");
            }
        }
    }
    public void agregarNinja(Ninja nj) {
        if (numNinjas < limitePersonas) {
            listaNinjas[numNinjas] = nj;
            numNinjas++;
        } else {
            System.out.println("No hay espacio para más ninjas");
        }
    }

    public void agregarSensei(Sensei s) {
        if (numNinjas < limitePersonas) {
            listaNinjas[numNinjas] = s;
            numNinjas++;
            numSenseis++;
        }  else {
            System.out.println("No hay espacio para más senseis en este mundo");
        }
    }
    public void mostrarEquipos() {
        if (this.numNinjas == 0) {
            System.out.println("No hay equipos registrados");
        }  else {
            for (int i = 0; i < numEquipos; i++) {
                System.out.println(this.listaEquipos[i]);
            }
        }
    }
    public void mostrarSensei() {
        if (this.numNinjas == 0) {
            System.out.println("No hay senseis registrados");
        } else {
            for (int i = 0; i < numNinjas;i++) {
                System.out.println(this.listaNinjas[i]);
            }
        }
    }

    public void agregarEquipo (Equipo e) {
        if (numEquipos < limitePersonas) {
            listaEquipos[numEquipos] = e;
            numEquipos++;
        }  else {
            System.out.println("No hay más espacio para equipos");
        }
    }

    public void mostrarNinjasAgrupadosPorGenero(TipoPersona tipoPersona) {
        if (numNinjas == 0) {
            System.out.println("No hay ninjas registrados");
            return;
        }
        for (TipoPersona tipo : TipoPersona.values()) {
            boolean hayNinjas = false;
            System.out.println("\nPersonas" + tipo);

            for (int i = 0; i < numNinjas; i++) {
                if (listaNinjas[i].getTipoPersona() == tipoPersona) {
                    System.out.println(" - " +  listaNinjas[i].getNombre() +
                            " - " +  listaNinjas[i].getNombre() +" |" +
                            " - " + listaNinjas[i].getChakra());
                    hayNinjas = true;
                }
            }
            if (!hayNinjas) {
                System.out.println("Datos no encontrados");
            }
        }
    }

    public void getmostrarEquiposEnumerados () {
        if (numNinjas == 0) {
            System.out.println("No hay ninjas registrados");
            return;
        }

        System.out.println("\nLista de equipos disponibles: " );
        for (int i = 0; i < listaNinjas.length; i++) {
            System.out.println((i + 1) + ". " + listaNinjas[i].getNombre());
        }
    }

    public void numeroNinjas () {
        System.out.println("\nNumero de ninjas registrados: " + numNinjas);
    }

    public boolean eliminarNinja(String idNinja) {
        if (numNinjas == 0) {
            System.out.println("No hay ninjas registrados");
            return false;
        }

        for (int i = 0; i < numNinjas; i++) {
            if (listaNinjas[i].getIdNinja().equals(idNinja)) {
                for (int j = i; j < numNinjas - 1; j++) {
                    listaNinjas[j] = listaNinjas[j + 1];
                }
                listaNinjas[numNinjas - 1] = null;
                numNinjas--;

                System.out.println("Eliminando el ninja " + idNinja);
                return true;
            }
        }
        System.out.println("No existe el ninja " + idNinja);
        return false;
    }



    @Override
    public String toString() {
        return "<---Aldea--->" +
                "\nNombre de aldea: " + nombreAldea +
                "\nCodigo de Aldea: " + codAldea +
                "\nFecha de creacion: " + fechaCreacion +
                "\nKage: " + kage  +
                "\nMaximo de equipos: " + maximoEquipos +
                "\n<---------->";
    }

    public void mostrarAldea() {
        System.out.println(this);
    }
}
