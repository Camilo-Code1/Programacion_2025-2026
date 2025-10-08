import java.util.Scanner;

public class E14 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        double salarioBruto;
        double horasTrabajadas;

        double tarifaHoras;

        double impuestos;

        System.out.print("Ingrese su nombre por favor: ");
        String nombre = sc.nextLine();

        System.out.print("Inserte las horas trabajadas: ");
        horasTrabajadas = sc.nextDouble();

        System.out.print("Inserte la tarifa por hora por favor: ");
        tarifaHoras = sc.nextDouble();



        if (horasTrabajadas <= 35){
            salarioBruto = horasTrabajadas * tarifaHoras;
        } else {
            salarioBruto = (35 * tarifaHoras) + ((horasTrabajadas - 35) * 1.5 * tarifaHoras);
        }

        if (salarioBruto <= 500){
            impuestos = 0;
        } else if (salarioBruto <= 900){
            impuestos = (salarioBruto - 500) * 0.25;
        } else {
            impuestos = (400 * 0.25) + ((salarioBruto - 900) * 0.45);
        }

        double salarioNeto = salarioBruto - impuestos;

        System.out.println("Nombre: " + nombre);
        System.out.println("Horas trabajadas: " + horasTrabajadas);
        System.out.println("Tarifa por horas trabajadas: " + tarifaHoras);
        System.out.println("Salario Bruto: " + salarioBruto);
        System.out.println("Impuestos: " + impuestos);
        System.out.println("Salario Neto: " + salarioNeto);


    }

}
