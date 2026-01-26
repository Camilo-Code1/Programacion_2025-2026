public class Gato {

    private String nombre;
    private int edad;

    public Gato(String nombre, int edad) throws Exception {
        if (nombre == null || nombre.length() < 3) {
            throw new Exception("El nombre debe tener al menos 3 caracteres");
        }
        if (edad < 0) {
            throw new Exception("¡Edad negativa! ¡Degenado!");
        }
        this.nombre = nombre;
        this.edad = edad;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "\n<---Gato--->" +
                "\nNombre: " + nombre +
                "\nEdad:" + edad +
                "\n<----------->";
    }

//    public void verificarNombre (String nombre) throws Exception {
//        if (nombre == null || nombre.length() < 3) {
//            throw new Exception("El nombre debe tener al menos 3 DASDAS");
//        }
//        this.nombre = nombre;
//    }


}
