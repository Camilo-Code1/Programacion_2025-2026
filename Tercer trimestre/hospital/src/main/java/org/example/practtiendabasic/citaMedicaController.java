package org.example.practtiendabasic;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.practtiendabasic.model.*;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class citaMedicaController implements Initializable {

    private boolean isNewCitaMedica = true;
    private citas_medicas citaMedicaSeleccionada = null;

    @FXML ComboBox <EstadoEnum> estadoCita;
    @FXML ComboBox <medicos> medicoCita;
    @FXML ComboBox <pacientes> pacienteCita;
    @FXML TextField motivoCita;
    @FXML ComboBox <LocalTime> horaCita;
    @FXML DatePicker fechaCita;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        pacienteCita.setItems(FXCollections.observableArrayList(SQLModelPacientes.getAllPacientes()));
        medicoCita.setItems(FXCollections.observableArrayList(SQLModelMedicos.getAllMedicos()));

        // 2. Decirle al combo de Pacientes que muestre solo el NOMBRE_COMPLETO
        pacienteCita.setConverter(new javafx.util.StringConverter<pacientes>() {
            @Override
            public String toString(pacientes p) {
                return (p != null) ? p.getNombre_completo() : "";
            }
            @Override
            public pacientes fromString(String string) { return null; }
        });

        // 3. Decirle al combo de Médicos que muestre solo el NOMBRE (que viene de la tabla padre)
        medicoCita.setConverter(new javafx.util.StringConverter<medicos>() {
            @Override
            public String toString(medicos m) {
                return (m != null) ? m.getNombre() : ""; // getNombre() lo hereda de la clase personal
            }
            @Override
            public medicos fromString(String string) { return null; }
        });

        LocalTime horaInicio = LocalTime.of(8, 0);
        LocalTime horaFin = LocalTime.of(20, 0);

        while (horaInicio.isBefore(horaFin) || horaInicio.equals(horaFin)) {
            horaCita.getItems().add(horaInicio);
            horaInicio = horaInicio.plusMinutes(30); // Intervalos de 30 minutos
        }

        estadoCita.getItems().add(EstadoEnum.Pendiente);
        estadoCita.setValue(EstadoEnum.Pendiente);
        estadoCita.setDisable(true);

    }


    public void guardarOnAction(ActionEvent event) {
        pacientes pacienteSelect = pacienteCita.getValue();
        medicos medicoSelect = medicoCita.getValue();
        LocalDate fechaSelect = fechaCita.getValue();
        LocalTime horaSelect = horaCita.getValue();

        if (pacienteSelect == null || medicoSelect == null || horaSelect == null || fechaSelect == null) {
            System.err.println("Por favor, complete todos los campos antes de guardar la cita.");
            return;
        }

        if (motivoCita.getText().isEmpty() || estadoCita.getValue() == null) {
            System.err.println("Por favor, complete todos los campos antes de guardar.");
            return;
        }

        int idPaciente = pacienteSelect.getId_paciente();
        int idMedico = medicoSelect.getId_personal();

        if (isNewCitaMedica) {
            citas_medicas nuevaCita = new citas_medicas(
                    idPaciente,
                    idMedico,
                    fechaSelect,
                    horaSelect,
                    motivoCita.getText()
            );
            if (SQLModelCitasMedicas.createCitaMedica(nuevaCita)) {
                mostrarAlerta("Cita Médica Registrada", "La cita médica se ha registrado correctamente.");
                limpiarCampos();
            } else {
                mostrarAlerta("Error", "No se pudo registrar la cita médica.");
            }


        }
    }


    public void limpiarCampos(){
        pacienteCita.setValue(null);
        medicoCita.setValue(null);
        fechaCita.setValue(null);
        horaCita.setValue(null);
        motivoCita.clear();
        estadoCita.setValue(EstadoEnum.Pendiente);
    }

    private void mostrarAlerta(String titulo, String msj) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(msj);
        alert.show();
    }
    public void borrarOnAction(ActionEvent event) {
    }

    public void salirOnAction(ActionEvent event) {
        cambiarPantalla(event, "mainview.fxml");
    }
    private void cambiarPantalla(ActionEvent event, String archivoFXML) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(archivoFXML));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.err.println("Error al cargar " + archivoFXML + ": " + e.getMessage());
            mostrarAlerta("Error de Navegación", "No se encontró el archivo FXML: " + archivoFXML);
        }
    }

}
