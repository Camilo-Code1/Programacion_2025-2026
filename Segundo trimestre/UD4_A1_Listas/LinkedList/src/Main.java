import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LinkedList<Producto> productos = new LinkedList<>();

        Producto nuevo = new Producto("Zapato", 6);
        Producto nuevo2 = new Producto("Soplador", 8);
        Producto nuevo3 = new Producto("Verdad", 4);
        Producto nuevo4 = new Producto("Desajuste", 3);
        Producto nuevo5 = new Producto("Falacia", 9);

        productos.add(nuevo);
        productos.add(nuevo2);
        productos.add(nuevo3);
        productos.add(nuevo4);
        productos.add(nuevo5);

        Iterator<Producto> itera = productos.iterator();
        while(itera.hasNext()){
            System.out.println(itera.next());
        }

        productos.remove(nuevo3);
        productos.remove(nuevo4);

        int mitad = productos.size() / 2;
        Producto nuevoMedio = new Producto("Aversion", 5) ;
        productos.add(mitad, nuevoMedio);

        System.out.println("\n<--------------------------------------------------->");

        itera = productos.iterator();
        while(itera.hasNext()){
            System.out.println(itera.next());
        }

        productos.sort(null);

        System.out.println("\nLista de productos ordenada: ");
        Iterator<Producto> iterar = productos.iterator();
        while (iterar.hasNext()) {
            System.out.println(iterar.next());
        }
        productos.clear();

    }
}