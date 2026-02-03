import java.util.Arrays;

public class Inventario {
    Mascotas[] m;

    public Inventario() {
        this.m = new Mascotas[100];
    }

    public Mascotas[] getM() {
        return m;
    }

    public void setM(Mascotas[] m) {
        this.m = m;
    }

    public void mostrarAnimalTipoNombre(){
        for(int i = 0; i < Mascotas.contadorAnimales;i++){
            if(m[i] != null){
                System.out.println(i +": "+ m[i].getTipo() + "\t" + m[i].getNombre());
            }
        }
    }

    public void mostrarTodoAnimal(){
        for(int i = 0; i < Mascotas.contadorAnimales;i++) {
            if (m[i] != null) {
                System.out.println(m[i].toString());
            }
        }
    }

    public void mostrarDatosAnimalConcreto(String nombre, Tipo tipo){
        for(int i = 0; i < Mascotas.contadorAnimales;i++){
            if(m[i] != null && nombre.equalsIgnoreCase(m[i].getNombre()) && tipo.equals(m[i].getTipo())){
                System.out.println(m[i].toString());
            }
        }
    }

    public boolean insertarAnimal(Mascotas m1) {
        for (int i = 0; i < m.length; i++) {
            if (m[i] == null) {
                m[i] = m1;
                return true;
            }
        }
        aumentarTamanio();


        m[m.length - 100] = m1;
        return true;
    }


    public boolean eliminarAnimal(String nombre, Tipo tipo){
        boolean eliminado = false;

        for(int i = 0; i < Mascotas.contadorAnimales; i++){
            if(m[i] != null && nombre.equalsIgnoreCase(m[i].getNombre()) && tipo.equals(m[i].getTipo())){
               m[i] = null;
               eliminado = true;
            }
        }
        return eliminado;
    }

    public void eliminarTodosAnimales(){
        Arrays.fill(m, null);
    }

    public boolean reorganizar(){
        boolean reorganizado = false;

        for(int i = 1; i < Mascotas.contadorAnimales; i++){
            if(m[i - 1] == null && m[i] != null){
                m[i - 1] = m[i];
                m[i] = null;
                reorganizado = true;
            }
        }
        return reorganizado;
    }

    public void tipos(){
        for(Tipo t : Tipo.values()){
            System.out.println((t.ordinal() + 1) + " " + t);
        }
    }

    public void estados(){
        for(Estado e : Estado.values()){
            System.out.println((e.ordinal() + 1) + " " + e);
        }
    }
    
    public boolean exists(String nombre, Tipo tipo){
        
        for(int i = 0; i < Mascotas.contadorAnimales; i++){
            if(m[i] != null && m[i].getNombre().equalsIgnoreCase(nombre) && m[i].getTipo().equals(tipo)){
                System.err.println("No se ha podido insertar la mascota, esta ya existe");
                return true;
            }
        }
        return false;
    }
    
    public void aumentarTamanio(){
        m = Arrays.copyOf(m, m.length + 100);
    }
}
