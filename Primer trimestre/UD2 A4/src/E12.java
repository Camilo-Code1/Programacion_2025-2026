import java.util.Scanner;

public class E12 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String opcion = "";
        int contador = 0;

        int [] arraySencillo = new int[10];

        do {
            sc = new Scanner(System.in);

            System.out.println("\na. Mostrar valores\n" +
                    "b. Introducir valor\n" +
                    "c. Salir ");
            System.out.println("");
            opcion = sc.nextLine();

            switch(opcion) {
            case "a":
                sc = new Scanner(System.in);

                if (contador == 0) {
                    System.out.println("El array está vacío. No hay valores que mostrar.");
                } else {
                    System.out.println("Valores actuales: ");
                    for (int i = 0; i < contador; i++) {
                        System.out.print(arraySencillo[i] + " ");
                    }
                }
                break;

            case "b":
                sc = new Scanner(System.in);

                if  (contador >= arraySencillo.length) {
                    System.out.println("Se ha superado el tamaño del array.");
                } else {

                    System.out.println("Ingrese un valor: ");
                    arraySencillo[contador] = sc.nextInt();
                    sc.nextLine();
                    contador++;
                    System.out.println("Valor guardado en la posicion " + contador);
                }


                break;

            case "c":

                System.out.println("\nSaliendo del programa. Hasta pronto");
                break;
            default:

                System.out.print("\nOpcion invalida. Por favor, intentelo de nuevo");

                break;}}
        while (!opcion.equals ("c"));


    }
}
