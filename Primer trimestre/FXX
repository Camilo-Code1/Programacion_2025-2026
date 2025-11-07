import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String opcion = "";

        int contador = 0;
        int suma = 0;
        int media = 0;
        double maximo = Double.MIN_VALUE;
        double minimo = Double.MAX_VALUE;


        String menu = "\nCrear un colección de edades (Por ahora no: y peso en kilogramo) de una serie de personas.\n" +
                "\n" +
                "Recuerda preguntar al comienzo del programa cuantas personas serán censadas\n" +
                "\n" +
                "1. Agregar una edad\n" +
                "2. Mostrar colección\n" +
                "3. Estadísticas: Cantidad de edades registradas, media, el mayor de todos y menor de todos\n" +
                "4. Eliminar una edad de la colección\n" +
                "5. Modificar el tamaño de la colección\n" +
                "6. Salir \n";

        int cantidad;
        String bienvenida = "\nBienvenido a este sofisticado sistema creado para registrar edades.\n" +
                "Por favor ingrese la cantidad de personas que serán registradas: ";

        System.out.println(bienvenida);
        cantidad = sc.nextInt();



        int coleccion [] = new int [cantidad];

        do {
            sc = new Scanner(System.in);

            System.out.println("");
            System.out.println(menu);
            System.out.println("");

            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    if (contador >= coleccion.length) {
                        System.out.println("Se ha superado el tamaño del array");
                    } else {

                        System.out.println("Ingrese la edad por favor: ");
                        coleccion[contador] = sc.nextInt();
                        contador++;
                        System.out.println("Valor guardado en la posición: " + contador);

//                    for (int i = 0; i < coleccion.length; i++) {
//                        System.out.println("\nPor favor, ingrese la edad" + (i + 1) + "");
//                        coleccion[i] = sc.nextInt();
//                    }
                    }

                    break;

                case "2":
                    if (contador == 0) {
                        System.out.println("\nLa colección esta vacia. No hay valores que mostrar.");
                    } else {
                        for (int i = 0; i < coleccion.length; i++) {
                            System.out.print(coleccion[i] + " ");
                        }
                    }

                    break;
                case "3":
                    if (contador == 0) {
                        System.out.println("No hay edades registradas todavía.");
                    } else {
                        suma = 0;
                        maximo = coleccion[0];
                        minimo = coleccion[0];

                        for (int i = 0; i < contador; i++) {
                            suma += coleccion[i];
                            if (coleccion[i] > maximo) maximo = coleccion[i];
                            if (coleccion[i] < minimo) minimo = coleccion[i];
                        }

                        media = suma / contador;

                        System.out.println("Número de edades registradas: " + contador);
                        System.out.println("La media es: " + media);
                        System.out.println("La edad máxima es: " + maximo);
                        System.out.println("La edad mínima es: " + minimo);
                    }

                    break;

                case "4":
                    if (contador == 0) {
                        System.out.println("No hay edades para eliminar.");
                    } else {
                        System.out.print("Ingrese el índice (posición) que desea eliminar (1 - " + contador + "): ");
                        // le pedimos índice 1-based para coincidir con la forma de mostrar
                        int indice = sc.nextInt();
                        sc.nextLine(); // consumir newline

                        if (indice < 1 || indice > contador) {
                            System.out.println("Índice inválido. Debe estar entre 1 y " + contador);
                        } else {
                            int pos = indice - 1; // convertir a 0-based
                            // desplazamos a la izquierda desde pos
                            for (int j = pos; j < contador - 1; j++) {
                                coleccion[j] = coleccion[j + 1];
                            }
                            // opcional: limpiar la última posición (no necesaria, pero más "limpio")
                            coleccion[contador - 1] = 0;
                            contador--;
                            System.out.println("Elemento en la posición " + indice + " eliminado correctamente.");
                        }
                    }
                    break;

                case "5":

                    break;

                case "6":
                    System.out.println("\n¡Gracias por todo! Hasta la proxima");
                    break;

                default:
                    System.out.println("Opcion invalida. Por favor, vuelva a intentarlo.");
            }

        } while (!opcion.equals("6"));


    }
}
