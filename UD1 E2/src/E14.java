import java.util.Scanner;

public class E14 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tarifaNormal = 35;
        double aumentoPorTarifa = 1.5;
        int libreImpuestos = 500;
        double impuestosMenor = 0.25;
        double impuestosMayor = 0.45;

        double salarioBruto;
        double horasTrabajadas;
        double salarioNeto;

        System.out.print("Inserte las horas trabajadas: ");
        horasTrabajadas = sc.nextDouble();

        System.out.print("Inserte su salario bruto por favor: ");
        salarioBruto = sc.nextDouble();

        salarioBruto = horasTrabajadas * salarioBruto;
        System.out.print(salarioBruto);

        if (horasTrabajadas >= tarifaNormal) {
            salarioNeto = (horasTrabajadas * salarioBruto) * aumentoPorTarifa;
            System.out.print(salarioNeto);
        }


    }

}
