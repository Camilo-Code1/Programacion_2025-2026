import java.util.Scanner;

public class E1 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int edad;


        System.out.println("Por favor ingrese su edad actual: ");
        edad = input.nextInt();

        if  (edad >= 18) {
            System.out.println("Eres mayor de edad");
        }


    }
}