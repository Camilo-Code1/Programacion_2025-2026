import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class DawBank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String menu = "\n1. Datos de la cuenta.\n" +
                "2. IBAN.\n" +
                "3. Titular.\n" +
                "4. Saldo.\n" +
                "5. Ingreso.\n" +
                "6. Retirada. \n" +
                "7. Movimientos. \n" +
                "8. Salir.  ";

        String opcion = "";

        do {
            sc = new Scanner(System.in);
            System.out.print("");
            System.out.println(menu);
            System.out.print("");
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
            }
        } while (!opcion.equals("8"));






    }
}