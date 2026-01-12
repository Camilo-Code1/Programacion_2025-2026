import java.util.ArrayList;
import java.util.Iterator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<Producto>();

        Producto nuevo = new Producto("Zuero de la verdad", 6);
        Producto nuevo2 = new Producto("Puero de la mentira", 8);
        Producto nuevo3 = new Producto("Auero de la pegamento", 4);
        Producto nuevo4 = new Producto("Tuero del desajuste", 3);
        Producto nuevo5 = new Producto("Auero del charlatan", 9);

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
        Producto nuevoMedio = new Producto("Suerto que no esta en el medio", 5) ;
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