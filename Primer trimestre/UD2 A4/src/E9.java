import java.util.Scanner;

public class E9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double [] numerosAleatorios = new double [100];

//        Random rand = new Random();


        for (int i = 0; i < numerosAleatorios.length; i++) {

//            numerosAleatorios[i] = rand.nextDouble(2);
            numerosAleatorios[i] = Math.random()*10;

        }



    }
}
