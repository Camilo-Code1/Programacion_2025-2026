import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String opcion = "";

        int victorias = 0;
        int derrotas = 0;
        int empates = 0;

        ///  Apartado de computadora

        String Papel;
        String Piedra;
        String Tijeras;
        String opcionJugador = "";


        String menu = "a. Explicar reglas\n" +
                "b. Jugar\n" +
                "c. Victorias y derrotas\n" +
                "d. Salir";

        do {
            sc =  new Scanner(System.in);

            System.out.print("");
            System.out.println(menu);
            System.out.print("");

            opcion = sc.nextLine();

            switch (opcion.toLowerCase()) {
                case "a":

//                    System.out.println("Valor random: " + decisionIA);

                    break;
                case "b":

                    System.out.println("Eliga que jugara:  ");
//                    do {
                        sc =  new Scanner(System.in);
                        System.out.print("");
                        System.out.println("\nP - Piedra\n" +
                                "L - Papel\n" +
                                "T - Tijeras\n" +
                                "S - Salir");
                        opcionJugador = sc.nextLine();

                        switch (opcionJugador.toUpperCase()) {
                            case "P":
                                opcionJugador = "Piedra";
                                break;
                            case "L":
                                opcionJugador = "Papel";
                                break;
                            case "T":
                                opcionJugador = "Tijeras";
                                break;
                            case "S":
                                System.out.println("Saliendo al menu principal");
                                break;
                        }

                        // Ordenador
                    int [] numeros = {1, 2 , 3};
                    int randomNum = numeros[(int) (Math.random() * numeros.length)];
                    String decisionIA;

                    switch (randomNum) {
                        case 1: decisionIA = "Piedra";
                            break;
                        case 2: decisionIA = "Papel";
                            break;
                        case 3: decisionIA = "Tijeras";
                            break;
                        default: decisionIA = "";
                    }

                        System.out.print("");
                        System.out.println("Usted ha elegido: " + opcionJugador);
                        System.out.println("El ordenador ha escogido: " + decisionIA);

                        // JUGADAS ENFRENTADAS

                        if (opcionJugador.equals("Piedra") && decisionIA.equals("Piedra")) {
                            System.out.println("¡Empate!");
                            empates ++;
                        } else if (opcionJugador.equals("Piedra") && decisionIA.equals("Tijeras")) {
                            System.out.println("¡Victoria!");
                            victorias ++;
                        } else if (opcionJugador.equals("Piedra") && decisionIA.equals("Papel")) {
                            System.out.println("¡Derrota!");
                            derrotas++;
                        } else if (opcionJugador.equals("Papel") && decisionIA.equals("Papel")) {
                            System.out.println("¡Empate!");
                            empates ++;
                        } else if (opcionJugador.equals("Papel") && decisionIA.equals("Piedra")) {
                            System.out.println("¡Victoria!");
                            victorias ++;
                        } else if (opcionJugador.equals("Papel") && decisionIA.equals("Tijeras")) {
                            System.out.println("¡Derrota!");
                            derrotas ++;
                        } else if (opcionJugador.equals("Tijeras") && decisionIA.equals("Tijeras")) {
                            System.out.println("¡Empate!");
                            empates ++;
                        } else if (opcionJugador.equals("Tijeras") && decisionIA.equals("Papel")) {
                            System.out.println("¡Victoria!");
                            victorias ++;
                        } else if (opcionJugador.equals("Tijeras") && decisionIA.equals("Piedra")) {
                            System.out.println("¡Derrota!");
                            derrotas ++;
                        }

//                    } while (!opcionJugador.equals("S"));

                    break;
                case "c":
                    System.out.println("");
                    System.out.println("Victorias: " + victorias);
                    System.out.println("Derrotas: " + derrotas);
                    System.out.println("Empates: " + empates);

                    break;
                case "d":
                    System.out.println("\nGracias por jugar con nosotros. Hasta la proxima");
                    break;
                default:
                    System.out.println("\nOpcion invalida. Por favor, vuelva a intentarlo.");
            }


        } while(!opcion.equals("d"));{}




    }
}