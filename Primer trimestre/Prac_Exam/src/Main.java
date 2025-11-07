import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String opcion = "";

        String opcion2 = "";

        String menu = "1. Modifica la colección\n" +
                "2. Estadísticas de la colección\n" +
                "3. Ampliar el valor de la colección\n" +
                "4. Salir";

        String submenu1 = "A. Insertar número.\n" +
                "B. Borrar número.\n" +
                "C. Modificar número de una posición especifica";

        String submenu2 = "A. En la última posición\n" +
                "B. En una posición específica";

        String submenu3 = "A. De la última posición ocupada.\n" +
                "B. De una posición específica.";

        String bienvenida = "Por favor, ingrese el tamaño que tendrá la colección: ";

        System.out.print(bienvenida);
        int cantidad = sc.nextInt();

        int coleccion [] = new int [cantidad];

        int contador = 0;
        int suma = 0;
        int media = 0;
        double maximo = Double.MIN_VALUE;
        double minimo = Double.MAX_VALUE;


        do {
            sc = new Scanner(System.in);

            System.out.println("");
            System.out.println(menu);
            System.out.println("");

            opcion = sc.nextLine();

            switch (opcion) {
                case "1":

                    sc = new Scanner(System.in);
                    System.out.println("");
                    System.out.println(submenu1);
                    System.out.println("");


                    opcion2 = sc.nextLine();

                    switch (opcion2.toUpperCase()) {
                        case "A":
                            sc = new Scanner(System.in);
                            System.out.println(submenu2);

                            opcion2 = sc.nextLine();

                            switch (opcion2.toUpperCase()) {
                                case "A":

                                    if (contador >= coleccion.length) {
                                        System.out.println("Se ha superado el tamaño del array");
                                    } else {

                                        System.out.println("Ingrese el valor: ");
                                        coleccion[cantidad - 1] = sc.nextInt();
                                        contador++;

//                                        coleccion[contador] = sc.nextInt();
//                                        contador++;
//                                        System.out.println("Valor guardado en la posición: " + contador);
                                    }

                                    break;
                                case "B":
                                    int posicion;
                                    System.out.println("Por favor, inserte la posicion especifica: ");
                                    posicion = sc.nextInt();
                                    if (posicion < 1 || posicion > cantidad) {
                                        System.out.println("Índice inválido. Debe estar entre 1 y " + cantidad);

                                    } else {
                                    System.out.println("Por favor, ahora inserte el valor: ");
                                    coleccion[posicion - 1] = sc.nextInt();
                                    contador++;
                                    }
                                    break;
                                default:
                                    System.out.println("Opcion invalida. Por favor, vuelva a intentarlo.");
                            }
                            break;


                        case "B":

                            // APARTADO BORRAR

                            sc = new Scanner(System.in);
                            System.out.println(submenu3);

                            opcion2 = sc.nextLine();

                            switch (opcion2.toUpperCase()) {
                                case "A":

                                    System.out.println("Borrando numero de la ultima posicion... ");
                                    int valornuevo = 0;
                                    coleccion[cantidad - 1] = valornuevo;
                                    contador--;
                                    break;

                                case "B":
                                    sc = new Scanner(System.in);
                                    if (contador == 0){
                                        System.out.println("No hay valores para eliminar.");
                                    } else {
                                        System.out.println("Ingrese el índice (posición) que desea eliminar (1 - " + contador + "): ");
                                        int indice = sc.nextInt();
                                        if (indice < 1 || indice > contador) {
                                            System.out.println("Índice inválido. Debe estar entre 1 y " + contador);
                                        } else  {
                                            int pos = indice - 1;

                                            for (int j = pos; j < contador; j++) {
                                                coleccion[j] = coleccion[j + 1];
                                            }
                                            coleccion[contador - 1] = 0;
                                            contador--;
                                            System.out.println("Elemento en la posición " + indice + " eliminado correctamente.");
                                        }
                                    }

                                    break;
                                default:
                                    System.out.println("Opcion invalida. Por favor, vuelva a intentarlo.");
                            }
                            break;


                        case "C":
                            sc = new Scanner(System.in);
                            int posicion2;
                            System.out.println("Por favor, inserte la posicion especifica: ");
                            posicion2 = sc.nextInt();
                            System.out.println("Por favor, ahora inserte el valor: ");
                            coleccion[posicion2 - 1] = sc.nextInt();

                            break;

                        default:
                            System.out.println("Opcion invalida. Por favor, vuelva a intentarlo.");
                    }

                    break;

                case "2":
                    sc = new Scanner(System.in);
                    if (contador == 0) {
                        System.out.println("\nLa colección esta vacia. No hay valores , ni estadisticas que mostrar.");
                    } else {
                        System.out.println("Valores guardados: ");
                        for (int i = 0; i < coleccion.length; i++) {
                            System.out.print(coleccion[i] + " ");
                        }

                        suma = 0;
                        maximo = coleccion[0];
                        minimo = coleccion[0];

                        for (int i = 0; i < contador; i++) {
                            suma += coleccion[i];
                            if (coleccion[i] > maximo) maximo = coleccion[i];
                            if (coleccion[i] < minimo) minimo = coleccion[i];
                        }

                        media = suma / contador;

                        System.out.println("\n====================================");
                        System.out.println("\nNúmero de valores registrados: " + contador);
                        System.out.println("La media es: " + media);
                        System.out.println("La suma es: " + suma);
                        System.out.println("La valor máximo es: " + maximo);
                        System.out.println("La valor mínimo es: " + minimo);
                    }

                    break;
                case "3":
                    System.out.println("Inserte el nuevo tamaño, por favor: ");
                    int nuevaCollecion = sc.nextInt();

                    int [] collecion2 = Arrays.copyOf(coleccion, nuevaCollecion);

                    for (int a : collecion2) {
                        System.out.print(a + " ");
                    }

                    System.out.println("Se crea el nuevo tamaño manteniendo los valores, pero se mantiene el otro al mostrar datos"+
                            "Habría que incorporar una alternativa con un if (Duplicar lo existente? Solución no real si se vuelve a cambiar el tamaño)");
                    break;
                case "4":
                    System.out.println("\n¡Gracias por todo! Hasta la proxima");
                    break;
                default:
                    System.out.println("Opcion invalida. Por favor, vuelva a intentarlo.");
            }
        } while (!opcion.equals("4"));




    }
}