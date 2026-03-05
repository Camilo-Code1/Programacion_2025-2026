import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Alumno extends Persona {

    private String expediente;
    private Map<String, Double> notas = new HashMap<>();

    public Alumno(String id, String nombre, int edad, String expediente) {
        super(id, nombre, edad);
        this.expediente = expediente;
    }

    public String getExpediente() {
        return expediente;
    }

    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }

    public void matricularEn(String codigo){
        notas.put(codigo, -1.0);
    }

    public double calcularMedia(){
        if(notas.isEmpty()) return 0.0;
        double msuma = 0;
        int cont = 0;
        for (double not : notas.values()) {
            if (not  >= 0){
                msuma += not;
                cont++;
            }
        }
        return cont == 0 ? 0 : msuma / cont;

    }


    public void ponerNota (String codigo, double nota){
        if(notas.containsKey(codigo)){
            notas.put(codigo, nota);
        }
    }

    public String getRol(){
        return "Alumno";
    }

    @Override
    public String toString() {
        return super.toString()  +
                " \n| Expediente: " + expediente +
                " | Notas: " + notas +
                ']';
    }
}
