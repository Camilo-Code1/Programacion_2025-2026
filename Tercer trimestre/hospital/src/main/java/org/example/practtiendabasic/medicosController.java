package org.example.practtiendabasic;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.practtiendabasic.model.SQLModelMedicos;
import org.example.practtiendabasic.model.TipoPersonal;
import org.example.practtiendabasic.model.medicos;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class medicosController implements Initializable {

    private boolean isNewMedico = true;
    private medicos medicoSeleccionado = null;

    @FXML TextField nombrePersonal, dniEmpleado, telefonoPersonal, especialidadMedico, licenciaMedica;
    @FXML ComboBox<TipoPersonal> tipoPersonal;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tipoPersonal.getItems().add(TipoPersonal.Medico);
        tipoPersonal.setValue(TipoPersonal.Medico);
        tipoPersonal.setDisable(true);
    }

    // Llamado desde medicosTablaController al pulsar Editar
    public void cargarMedicoParaEdicion(medicos m) {
        isNewMedico = false;
        medicoSeleccionado = m;
        nombrePersonal.setText(m.getNombre());
        dniEmpleado.setText(m.getDni_empleado());
        telefonoPersonal.setText(m.getTelefono());
        especialidadMedico.setText(m.getEspecialidad());
        licenciaMedica.setText(m.getLicencia_medica());
        dniEmpleado.setEditable(false);
    }

    public void guardarOnAction(ActionEvent event) {
        if (nombrePersonal.getText().isEmpty() || dniEmpleado.getText().isEmpty() ||
                telefonoPersonal.getText().isEmpty() || especialidadMedico.getText().isEmpty() ||
                licenciaMedica.getText().isEmpty()) {
            mostrarAlerta("Campos Incompletos", "Complete todos los campos antes de guardar.");
            return;
        }

        if (isNewMedico) {
            medicos nuevoMedico = new medicos(
                    nombrePersonal.getText(), dniEmpleado.getText(),
                    telefonoPersonal.getText(), TipoPersonal.Medico,
                    especialidadMedico.getText(), licenciaMedica.getText()
            );
            if (SQLModelMedicos.createMedico(nuevoMedico)) {
                mostrarAlerta("Éxito", "Médico registrado correctamente.");
                limpiarCampos();
            } else {
                mostrarAlerta("Error", "No se pudo registrar el médico.");
            }

        }

        // EDITANDO

        else {
            medicos medicoEditado = new medicos(
                    nombrePersonal.getText(), dniEmpleado.getText(),
                    telefonoPersonal.getText(), TipoPersonal.Medico,
                    especialidadMedico.getText(), licenciaMedica.getText()
            );
            if (SQLModelMedicos.updateMedico(medicoEditado)) {
                mostrarAlerta("Éxito", "Médico actualizado correctamente.");
                limpiarCampos();
                isNewMedico = true;
                medicoSeleccionado = null;
                dniEmpleado.setEditable(true);
            } else {
                mostrarAlerta("Error", "No se pudo actualizar el médico.");
            }
        }
    }

    public void limpiarCampos() {
        nombrePersonal.clear();
        dniEmpleado.clear();
        telefonoPersonal.clear();
        tipoPersonal.getSelectionModel().clearSelection();
        especialidadMedico.clear();
        licenciaMedica.clear();
    }

    public void borrarOnAction(ActionEvent event) { }
    public void salirOnAction(ActionEvent event) {
        cambiarPantalla(event, "mainview.fxml");
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