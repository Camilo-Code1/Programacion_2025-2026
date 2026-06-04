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
import org.example.practtiendabasic.model.SQLModelPersonal;
import org.example.practtiendabasic.model.personal;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class personalController implements Initializable {

    @FXML private TableView<personal> personalTableView;

    @FXML private TableColumn<personal, String> nombrePersonal;
    @FXML private TableColumn<personal, String> dniPersonal;
    @FXML private TableColumn<personal, String> telefonoPersonal;
    @FXML private TableColumn<personal, String> tipoPersonal;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        nombrePersonal.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        dniPersonal.setCellValueFactory(new PropertyValueFactory<>("dni_empleado"));
        telefonoPersonal.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        tipoPersonal.setCellValueFactory(new PropertyValueFactory<>("tipo_personal"));

        personalTableView.setItems(FXCollections.observableArrayList(SQLModelPersonal.getAllPersonal()));
    }


    public void guardarOnAction(ActionEvent event) {


    }

    public void salirOnAction(ActionEvent event) {
        cambiarPantalla(event, "mainview.fxml");
    }

    private void limpiarCampos(){

    }
    public void borrarOnAction(ActionEvent event) {
        limpiarCampos();
    }

    public void borrarTableOnAction(ActionEvent event) {
    }

    public void cargarDatoParaEditar(){

    }

    public void editarTableOnAction(ActionEvent event) {
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
