import java.util.Scanner;

public class E4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        final int ALUMNOS = 4;
        final int ASIGNATURAS = 5;

        double[][] notas = new double[ALUMNOS][ASIGNATURAS];


        for (int i = 0; i < ALUMNOS; i++) {
            System.out.println("\nIntroduce las notas del Alumno " + (i + 1) + ":");
            for (int j = 0; j < ASIGNATURAS; j++) {
                System.out.print("  Asignatura " + (j + 1) + ": ");
                notas[i][j] = sc.nextDouble();
            }
        }


        System.out.println("\n--- Resultados ---");

        for (int i = 0; i < ALUMNOS; i++) {
            double suma = 0;
            double max = notas[i][0];
            double min = notas[i][0];

            for (int j = 0; j < ASIGNATURAS; j++) {
                double nota = notas[i][j];
                suma += nota;

                if (nota > max) max = nota;
                if (nota < min) min = nota;
            }

            double media = suma / ASIGNATURAS;

            System.out.println("\nAlumno " + (i + 1) + ":");
            System.out.println("  Nota mínima: " + min);
            System.out.println("  Nota máxima: " + max);
            System.out.println("  Nota media : " + media);
        }

    }
}
