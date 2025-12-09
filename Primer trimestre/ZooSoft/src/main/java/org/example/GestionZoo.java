package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class GestionZoo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String menu = "1. Registrar animal en el zoologico.\n" +
                "2. Registrar cuidador.\n" +
                "3. Asignar cuidador a animal.\n" +
                "4. Mostrar información general del zoo.\n" +
                "5. Mostrar listas.\n" +
                "6. Dar de baja animal.\n" +
                "7. Dar de baja cuidador. \n" +
                "8. Crear ticket de incidencia\n" +
                "9. Mostrar o modificar tickets.\n" +
                "10. Salir.\n";

        String opcion = "";

        do {
            sc = new Scanner(System.in);

            System.out.println("-----------------");
            System.out.println(menu);
            System.out.println("-----------------");

            opcion = sc.nextLine();

            switch (opcion) {
                case "1":

                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":

                    break;
                case "5":

                    break;
                case "6":

                    break;
                case "7":

                    break;
                case "8":

                    break;
                case "9":

                    break;
                case "10":

                    break;
            }

        } while (!opcion.equals("9"));

    }




}