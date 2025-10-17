import java.util.Scanner;

public class E1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Por favor inserte la frase que quiere componer: ");
        String texto = sc.nextLine();

        String[] palabras = texto.split(" ");


        for (String palabra : palabras) {
            System.out.println(" ");
            System.out.println(palabra);
        }



    }
}