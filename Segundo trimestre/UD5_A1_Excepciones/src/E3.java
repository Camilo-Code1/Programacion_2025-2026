import java.util.Scanner;

public class E3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String [] nombres = new String[5];

        String n = "2";
        int num = 0;

        try {
            num = Integer.parseInt(n);
            String nombre  = nombres[num];

            for (int i = 0; i < nombres.length; i++){
                System.out.println("Introduce el nombre " + (i + 1) + ": " );
                nombres[i] = sc.nextLine();
            }

        } catch (Exception e){
            System.out.println("\nError: " + e.getMessage());
        } finally{
            System.out.println("\nLista cerrada, espere unos segundos...");
        }


        try {

            System.out.println("\nMostrando contenido: ");
            for (int i = 0; i < nombres.length; i++) {
                System.out.println(nombres[i]);
            }
        } catch (Exception e){
            System.out.println("\nError: " + e.getMessage());
        }


        System.out.println("\nImprimiendo la longitud de cada nombre registrado:");
        for (int i = 0; i < nombres.length; i++) {
            try {
                System.out.println(nombres[i].length());
            } catch (Exception e){
                System.out.println("\nError: " + e.getMessage());
                System.out.println("El texto es null por ");
            }
        }



        System.out.println("\nSe ha finalizado el programa");
    }
}
