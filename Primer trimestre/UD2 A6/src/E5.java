import java.util.Scanner;

public class E5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("¿Cuántas personas hay en la empresa? ");
        int n = sc.nextInt();

        double[][] datos = new double[n][2];

        for (int i = 0; i < n; i++) {
            System.out.println("\nPersona " + (i + 1) + ":");

            int genero;
            do {
                System.out.print("  Género (0 = varón, 1 = mujer): ");
                genero = sc.nextInt();
                if (genero != 0 && genero != 1)
                    System.out.println("  Valor no válido. Debe ser 0 o 1.");
            } while (genero != 0 && genero != 1);

            System.out.print("  Sueldo: ");
            double sueldo = sc.nextDouble();

            datos[i][0] = genero;
            datos[i][1] = sueldo;
        }


        double sumaHombres = 0, sumaMujeres = 0;
        int contHombres = 0, contMujeres = 0;

        for (int i = 0; i < n; i++) {
            if (datos[i][0] == 0) { // varón
                sumaHombres += datos[i][1];
                contHombres++;
            } else { // mujer
                sumaMujeres += datos[i][1];
                contMujeres++;
            }
        }

        double mediaHombres = (contHombres > 0) ? sumaHombres / contHombres : 0;
        double mediaMujeres = (contMujeres > 0) ? sumaMujeres / contMujeres : 0;


        System.out.println("\n--- Resultados ---");
        System.out.println("Sueldo medio de hombres: " + mediaHombres);
        System.out.println("Sueldo medio de mujeres: " + mediaMujeres);


        if (contHombres == 0 || contMujeres == 0) {
            System.out.println("\nNo hay suficientes datos para comparar ambos géneros.");
        } else if (mediaHombres > mediaMujeres) {
            System.out.println("\nExiste brecha salarial: los hombres ganan más en promedio.");
        } else if (mediaMujeres > mediaHombres) {
            System.out.println("\nExiste brecha salarial: las mujeres ganan más en promedio.");
        } else {
            System.out.println("\nNo existe brecha salarial: ambos promedios son iguales.");
        }

    }
}
