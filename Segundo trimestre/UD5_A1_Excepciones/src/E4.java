public class E4 {
    public static void main(String[] args) {

        int valor;

        try {

        } catch (Exception e) {
            System.out.println("\nError: " + e.getMessage());
        }



    }

    public static void verificarValorNegativo (int valor) {
        if (valor <= 0) {
            System.out.println("\nEl valor es negativo");
        }
    }

    public static void verificarValorPositivo (int valor) {
        if (valor > 0) {
            System.out.println("\nEl valor no es negativo");
        }

    }
}
