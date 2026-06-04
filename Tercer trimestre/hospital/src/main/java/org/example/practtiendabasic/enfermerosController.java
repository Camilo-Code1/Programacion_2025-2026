package org.example.practtiendabasic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.practtiendabasic.model.SQLModelEnfermeros;
import org.example.practtiendabasic.model.TipoPersonal;
import org.example.practtiendabasic.model.enfermeros;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class enfermerosController implements Initializable {

    private boolean isNewEnfermero = true;
    private enfermeros enfermeroSeleccionado = null;

    @FXML
    TextField nombrePersonal, dniEmpleado, telefonoPersonal, turnoEnfermero, areaAsignadaEnfermero;
    @FXML
    ComboBox<TipoPersonal> tipoPersonal;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tipoPersonal.getItems().add(TipoPersonal.Enfermero);
        tipoPersonal.setValue(TipoPersonal.Enfermero);
        tipoPersonal.setDisable(true);
    }


    public void guardarOnAction(ActionEvent event) {
        if (nombrePersonal.getText().isEmpty() || dniEmpleado.getText().isEmpty() ||
                telefonoPersonal.getText().isEmpty() || turnoEnfermero.getText().isEmpty() ||
                areaAsignadaEnfermero.getText().isEmpty()) {
            mostrarAlerta("Campos Incompletos", "Complete todos los campos antes de guardar.");
            return;
        }

        if (isNewEnfermero){
            enfermeros nuevoEnfermero = new enfermeros(
                    nombrePersonal.getText(), dniEmpleado.getText(),
                    telefonoPersonal.getText(), TipoPersonal.Enfermero,
                    turnoEnfermero.getText(), areaAsignadaEnfermero.getText()
            );
            if (SQLModelEnfermeros.createEnfermero(nuevoEnfermero)) {
                mostrarAlerta("Éxito", "Enfermero registrado correctamente.");
                limpiarCampos();
            } else {
                mostrarAlerta("Error", "No se pudo registrar el enfermero.");
            }
        }


    }

    public void borrarOnAction(ActionEvent event) {
    }

    public void salirOnAction(ActionEvent event) {
            cambiarPantalla(event, "mainview.fxml");
    }

    public void limpiarCampos() {
        nombrePersonal.clear();
        dniEmpleado.clear();
        telefonoPersonal.clear();
        tipoPersonal.getSelectionModel().clearSelection();
        turnoEnfermero.clear();
        areaAsignadaEnfermero.clear();
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
