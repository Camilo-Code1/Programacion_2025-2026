package org.example.practtiendabasic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.practtiendabasic.model.SQLModelPacientes;
import org.example.practtiendabasic.model.pacientes;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class pacienteController implements Initializable {

    private boolean isNewPaciente = true;
    private pacientes pacienteSeleccionado = null;

    @FXML TextField nombreCompletoPaciente, historialClinicoText;
    @FXML DatePicker fechaNacimientoPicker;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


    public void guardarOnAction(ActionEvent event) {

        LocalDate fechaNacimiento = fechaNacimientoPicker.getValue();

        if(nombreCompletoPaciente == null || historialClinicoText == null || fechaNacimiento == null){
            mostrarAlerta("Campos Incompletos", "Complete todos los campos antes de guardar.");
            return;
        }

        if (isNewPaciente) {
            pacientes pacienteNuevo = new pacientes(
                    nombreCompletoPaciente.getText(),
                    fechaNacimiento,
                    historialClinicoText.getText()
            );
            if (SQLModelPacientes.createPacientes(pacienteNuevo)) {
                mostrarAlerta("Éxito", "Paciente registrado correctamente.");
                limpiarCmapos();
            } else {
                mostrarAlerta("Error", "No se pudo registrar el paciente.");
            }
        } else {
            pacientes pacienteEditado = new pacientes(
                    pacienteSeleccionado.getId_paciente(),
                    nombreCompletoPaciente.getText(),
                    fechaNacimiento,
                    historialClinicoText.getText()
            );
            if (SQLModelPacientes.updatePaciente(pacienteEditado)) {
                mostrarAlerta("Éxito", "Paciente actualizado correctamente.");
                limpiarCmapos();
            } else {
                mostrarAlerta("Error", "No se pudo actualizar el paciente.");
            }
        }


    }

    public void cargarPacienteParaEditar(pacientes pac) {
        this.isNewPaciente = false;
        pacienteSeleccionado = pac;

        nombreCompletoPaciente.setText(pac.getNombre_completo());
        fechaNacimientoPicker.setValue(pac.getFecha_nacimiento());
        historialClinicoText.setText(pac.getHistorial_clinico());
    }

    public void salirOnAction(ActionEvent event) {
        cambiarPantalla(event, "mainview.fxml");
    }

    public void limpiarCmapos(){
        nombreCompletoPaciente.clear();
        historialClinicoText.clear();
        fechaNacimientoPicker.setValue(null);
    }

    public void borrarOnAction(ActionEvent event) {
    }

    private void mostrarAlerta(String titulo, String msj) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(msj);
        alert.show();
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
