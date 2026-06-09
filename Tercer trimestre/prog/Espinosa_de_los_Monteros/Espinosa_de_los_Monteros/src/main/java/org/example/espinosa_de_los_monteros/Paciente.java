package org.example.espinosa_de_los_monteros;

import java.io.Serializable;
import java.time.LocalDate;

public class Paciente extends Persona implements Serializable {

    private static final long serialVersionUID = -4401788530462482798L;

        private String dni;

        public Paciente(String dni, String nombre, String apellidos,
                        String telefono, String direccion, String email) {
            super(nombre, apellidos, telefono, direccion, email); // llama al constructor de Persona
            this.dni = dni;
        }

        public String getDni() { return dni; }

        @Override
        public String toString() {
            return nombre + " " + apellidos + " (" + dni + ")";
        }


}
