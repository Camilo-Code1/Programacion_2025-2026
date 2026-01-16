import java.util.HashMap;

public class Taller {

    final HashMap <String, Coche> coches =  new HashMap<>();

    public void agregarCoche(String color, String marca){
        Coche coche = new Coche(color,marca);
        coches.put(color,coche);
    }

    public void mostrarCoches(){
        for (Coche contenido : coches.values()){
            System.out.println(contenido);
        }
    }

    public void eliminarcoche(String marca){
        coches.remove(marca);
    }
}
