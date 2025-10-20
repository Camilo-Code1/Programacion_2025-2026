import java.util.Scanner;

public class E3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el número de filas (N): ");
        int filas = sc.nextInt();
        System.out.print("Introduce el número de columnas (M): ");
        int columnas = sc.nextInt();

        int[][] matriz = new int[filas][columnas];


        System.out.println("\nIntroduce los valores de la matriz:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextInt();
            }
        }


        int mayores = 0;
        int menores = 0;
        int iguales = 0;


        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matriz[i][j] > 0) {
                    mayores++;
                } else if (matriz[i][j] < 0) {
                    menores++;
                } else {
                    iguales++;
                }
            }
        }


        System.out.println("\nResultados:");
        System.out.println("Mayores que 0: " + mayores);
        System.out.println("Menores que 0: " + menores);
        System.out.println("Iguales a 0: " + iguales);


    }
}
