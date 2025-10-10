import java.util.Scanner;

public class E1 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int cantidadInsertada;

        do {
            System.out.print("Por favor, ingrese el dinero (Solo se admiten billetes multiplos de 5): ");
            cantidadInsertada = input.nextInt();

            if (cantidadInsertada % 5 != 0) {
                System.out.println("Solo se admiten multiplos de 5");
            }
        } while (cantidadInsertada % 5 != 0);


        int billete500 = cantidadInsertada / 500;
        cantidadInsertada %= 500;

        int billete200 = cantidadInsertada / 200;
        cantidadInsertada %= 200;

        int billete100 = cantidadInsertada / 100;
        cantidadInsertada %= 100;

        int billete50 = cantidadInsertada / 50;
        cantidadInsertada %= 50;

        int billete20 = cantidadInsertada / 20;
        cantidadInsertada %= 20;

        int billete10 = cantidadInsertada / 10;
        cantidadInsertada %= 10;

        int billete5 = cantidadInsertada / 5;
        cantidadInsertada %= 5;

        if (billete500 > 0) {
            System.out.println("Billetes de 500: " + billete500);
        }

        if (billete200 > 0) {
            System.out.println("Billetes de 200: " + billete200);
        }

        if (billete100 > 0) {
            System.out.println("Billetes de 100: " + billete100);
        }
        if (billete50 > 0) {
            System.out.println("Billetes de 50: " + billete50);
        }
        if (billete20 > 0) {
            System.out.println("Billetes de 20: " + billete20);
        }
        if (billete10 > 0) {
            System.out.println("Billetes de 10: " + billete10);
        }
        if (billete5 > 0) {
            System.out.println("Billetes de  5: " + billete5);

        }
    }
}