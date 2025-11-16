import javax.swing.text.AbstractDocument;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//Oscar Lanza
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("************************************");
        System.out.println("Bienvenido al menu de la empresa 💻");
        System.out.println("************************************");

        System.out.println("Primero de todo inserte los numeros que desees / Importante !! Van a ser 5 numeros");


        int[] numeros = new int[5];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = scanner.nextInt();

        }


        int opcion = 0;

        while (opcion != 4) {
            System.out.println("--------------------------------");
            System.out.println("Pulse 1 para Modificar coleecion");
            System.out.println("-------------------------------------------------");
            System.out.println("Pulse 2 Para ver las estadisticas de la coleecion");
            System.out.println("-------------------------------------------------");
            System.out.println("Pulsa 3 Para Ampliar el valor del numero");
            System.out.println("------------------------------------");
            System.out.println("Pulsa 4 Para salir");
            System.out.println("------------------");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Pulsaste el 1, Modificar eleccion!!, Ahora inserte un numero");
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Pulsa 1 Para insertar numero");
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("Pulsa 2 para Borrar el numero");
                    System.out.println("-----------------------------------------------------------");
                    System.out.println("Pulsa 3 Para modificar el numero de una posicion especifica");
                    System.out.println("--------------------------------------------------------");
                    int eleccion = scanner.nextInt();

                    switch (eleccion) {
                        case 1:
                            System.out.println("////////////////////////////////////////////////////////");
                            System.out.println("Acabas del pulsar el 1, Insertar un numero cualquiera ");
                            System.out.println("/////////////////////////////////////////////////////////////////////////////////////");
                            System.out.println("Ahora pulsa 1 si quieres insertar un numero en la ultima posicion (Entre el 1 y el 5)");
                            System.out.println("/////////////////////////////////////////////////////////////////////////////////////");
                            System.out.println("Ahora 2 para insertar en una posicion especifica (Entre el 1 y el 5)");
                            System.out.println("/////////////////////////////////////////////////////////////////////////////////////");
                            int eleccion2 = scanner.nextInt();

                            switch (eleccion2) {
                                case 1:
                                    System.out.println("///////////////////////////");
                                    System.out.println("Inserte que numero desea insertar en la ultima posicion ");
                                    int eleccion3 = scanner.nextInt();
                                    System.out.println("El numero" + " " + eleccion3 + " " + "Fue insertado en la ultima posicion");
                                    break;
                                case 2:
                                    System.out.println("///////////////////////////");
                                    System.out.println("Primero inserte el numero que quiere");
                                    int eleccion15 = scanner.nextInt();
                                    System.out.println("Ahora Inserte que posicion quieres ");
                                    eleccion3 = scanner.nextInt();

                                    System.out.println("En la posicio" + " " + eleccion3 + " " + " Fue añadido el numero" + " " + eleccion15);

                                    if (eleccion3 > 5) {
                                        System.out.println("El numero" + " " + eleccion3 + " " + "es mayor que 5, vuelve a intentarlo");
                                    }
                                    else if (eleccion3 <= 0) {
                                        System.out.println("El numero" + " " + eleccion3 + " " + "es 0 o menor, vuelve a intentarlo");
                                    }

                                    break;
                            }
                            break;
                        case 2:
                            System.out.println("Pulsaste 2, asique desas borrar su numero");
                            System.out.println("////////////////////////////////////////////////////////");
                            System.out.println("////////////////////////////////////////////////////////");
                            System.out.println("Ahora pulsa 1 si el numero que quieres borrar es de la ultima posicion opcupada");
                            System.out.println("////////////////////////////////////////////////////////");
                            System.out.println("Ahora 2 para Borrar en una posicion especifica");
                            System.out.println("////////////////////////////////////////////////////////");
                            int eleccion4 = scanner.nextInt();

                            switch (eleccion4) {
                                case 1:
                                    System.out.println("Pulsa cual es la ultima posicion(Entre el 1 y el 5)");
                                    double eleccion5 = scanner.nextDouble();
                                    System.out.println("///////////////////////////");
                                    System.out.println("El numero de la posicion" + " " + (eleccion5) + " " + "Fue borrado");
                                    if (eleccion5 > 5) {
                                        System.out.println("El numero" + " " + eleccion5 + " " + "es mayor que 5, vuelve a intentarlo");
                                    }
                                    else if (eleccion5 <= 0) {
                                        System.out.println("El numero" + " " + eleccion5 + " " + "es 0 o menor, vuelve a intentarlo");
                                    }
                                    break;
                                case 2:
                                    System.out.println("/////////////////////////////////////////");
                                    System.out.println("Pulsaste borrar el numero de la posicion especifica");
                                    System.out.println("///////////////////////////////////////////////////////////////");
                                    System.out.println("Pulsa la posicion especifica donde esta el numero que desar borrar(Entre el 1 y el 5)");
                                    double eleccion6 = scanner.nextDouble();
                                    System.out.println("El numero de la posicion" + " " + (eleccion6) + " " + "Fue borrado");
                                    if (eleccion6 > 5) {
                                        System.out.println("El numero" + " " + eleccion6 + " " + "es mayor que 5, vuelve a intentarlo");
                                    }
                                    else if (eleccion6 <= 0) {
                                        System.out.println("El numero" + " " + eleccion6 + " " + "es 0 o menor, vuelve a intentarlo");
                                    }
                                    break;
                            }

                            break;

                        case 3:
                            System.out.println("Pulsaste 3 modificar un numero de una posicion especifica");
                            System.out.println("Primero, pulsa la posicion especifica que deseas cambiar entre el 1 al 5");
                            int eleccion7 = scanner.nextInt();
                            System.out.println("Ahora de la posicion" + " " + eleccion7 + " " + "porque numero que deaseas cambiar");
                            int eleccion8 = scanner.nextInt();
                            System.out.println("Todo correcto, el numero: " + " " + eleccion8 + " " + " Esta en la posicion" + " " + eleccion7);


                    }
                    break;
                case 2:
                    System.out.println("Acaba de pulsar el 2, asi que vamos a ver la estadisticas");
                    System.out.println("----------------------------------------------------");
                    System.out.println("Pulsa 1 para ver la media de todos los valore no nulos");
                    System.out.println("----------------------------------------------------");
                    System.out.println("Pulsa 2 para sumar todos los valores");
                    System.out.println("----------------------------------------------------");
                    System.out.println("Pulsa 3 para ver el maximo de la coleccion");
                    System.out.println("----------------------------------------------------");
                    System.out.println("Pulsa 4 para ver el minimo de la collecion");
                    System.out.println("--------------------------------------------------");

                    int eleccion9 = scanner.nextInt();

                    switch (eleccion9) {

                        case 1:
                            System.out.println("La media de los valores no nulos son:");
                            break;
                        case 2:
                            System.out.println("La suma de todos los valores son:");
                        case 3:
                            System.out.println("El maximo de la colleccion es :");
                            break;
                        case 4:
                            System.out.println("El minimo de la colleccion es :");
                    }
                    break;

                case 3:
                    System.out.println("Si desea ampliar un valor, ponga la posicion del valor que deseas cambiar");
                    System.out.println("************************************************************************");
                    int eleccion10 = scanner.nextInt();
                    System.out.println("La posicion que desea cambiar el valor la posicion" + " " + eleccion10);
                    System.out.println("De la posicion" + " " + eleccion10 + "" + "Cuanto le desearias sumar");
                    int eleccion11 = scanner.nextInt();
                    System.out.println("De la posicion" + " " + eleccion10 + "se sumaran" + " " + eleccion11);
                    break;
                case 4:
                    System.out.println("Adios.");


            }
        }
    }
}