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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.practtiendabasic.model.SQLModelCitasMedicas;
import org.example.practtiendabasic.model.citas_medicas;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class citaMedicaTableController implements Initializable {

    @FXML TableView <citas_medicas> CitaMedicasTableView;

    @FXML
    TableColumn <citas_medicas, String> motivoCita, estadoCita;
    @FXML TableColumn <citas_medicas, Integer> idPacienteCita, idMedicoCita;
    @FXML TableColumn <citas_medicas, LocalDate> fechaCita;
    @FXML TableColumn <citas_medicas, LocalTime> horaCita;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        idPacienteCita.setCellValueFactory(new PropertyValueFactory<>("id_paciente"));
        idMedicoCita.setCellValueFactory(new PropertyValueFactory<>("id_medico"));
        fechaCita.setCellValueFactory(new PropertyValueFactory<>("fecha_cita"));
        horaCita.setCellValueFactory(new PropertyValueFactory<>("hora_cita"));
        motivoCita.setCellValueFactory(new PropertyValueFactory<>("motivo"));
        estadoCita.setCellValueFactory(new PropertyValueFactory<>("estado"));

        cargarTabla();

    }

    public void editarTableOnAction(ActionEvent event) {
    }

    public void borrarTableOnAction(ActionEvent event) {

        citas_medicas seleccionado = CitaMedicasTableView.getSelectionModel().getSelectedItem();

        if (seleccionado == null){
            mostrarAlerta("Error", "Debe de seleccionar una cita médica para poder eliminarla");
            return;
        }

        if (SQLModelCitasMedicas.deleteCitaMedica(seleccionado.getId_cita())){
            CitaMedicasTableView.getItems().remove(seleccionado);
            mostrarAlerta("Éxito", "Cita médica eliminada correctamente");
        } else {
            mostrarAlerta("Error", "No se pudo eliminar la cita médica");
        }

    }

    public void salirOnAction(ActionEvent event) {
        cambiarPantalla(event, "mainview.fxml");
    }

    public void cargarTabla(){
        CitaMedicasTableView.setItems(FXCollections.observableArrayList(SQLModelCitasMedicas.getAllCitasMedicas()));
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
    private void mostrarAlerta(String titulo, String msj) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(msj);
        alert.show();
    }
}
