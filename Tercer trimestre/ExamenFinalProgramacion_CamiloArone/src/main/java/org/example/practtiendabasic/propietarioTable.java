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
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.practtiendabasic.model.Propietario;
import org.example.practtiendabasic.model.SQLModelPropietario;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class propietarioTable implements Initializable {

    private Propietario propietarioSelecccionado = null;

    @FXML private TableView<Propietario> propietarioTable;

    @FXML private TableColumn<Propietario, String> dniPropietario, nombrePropietario, apellidoPropietario, telefonoPropietario, direccionPropietario, emailPropietario;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        dniPropietario.setCellValueFactory(new PropertyValueFactory<>("dni"));
        nombrePropietario.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        apellidoPropietario.setCellValueFactory(new PropertyValueFactory<>("Apellido"));
        telefonoPropietario.setCellValueFactory(new PropertyValueFactory<>("Telefono"));
        direccionPropietario.setCellValueFactory(new PropertyValueFactory<>("Direcion"));
        emailPropietario.setCellValueFactory(new PropertyValueFactory<>("Email"));

        cargarTabla();

        propietarioTable.getSelectionModel().selectedItemProperty().addListener(
                (obs, anterior, seleccionado) -> {
                    if (seleccionado != null) {
                        propietarioSelecccionado = seleccionado;
                    }
                }
        );

    }

    public void cargarTabla(){
        propietarioTable.setItems(FXCollections.observableArrayList(SQLModelPropietario.getAllPropietarios()));
    }

    public void editarTableOnAction(ActionEvent event) {

        if (propietarioSelecccionado == null){
            mostrarAlerta("Aviso", "Debe de seleccionar un propietario de la tabla primero");
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/org/example/practtiendabasic/registerPropietario.fxml"));
            Parent root = loader.load();

            propietarioController formController = loader.getController();
            formController.cargarDatoParaEditar(propietarioSelecccionado);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            mostrarAlerta("Error", "No se pudo abrir el formulario: " + e.getMessage());
            e.printStackTrace();
        }


    }

    public void salirOnAction(ActionEvent event) {
        cambiarPantalla(event, "mainview.fxml");
    }

    public void borrarTableOnAction(ActionEvent event) {

        if (propietarioSelecccionado == null){
            mostrarAlerta("Aviso", "Selecciona a un Propietario de la tabla primero.");
            return;
        }

        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Confirmar borrado");
        confirm.setHeaderText(null);
        confirm.setContentText("¿Seguro que quieres borrar a " + propietarioSelecccionado.getNombre() + "?");
        confirm.showAndWait().ifPresent(respuesta -> {
            if (respuesta == ButtonType.OK) {
                if (SQLModelPropietario.deletePropietario(propietarioSelecccionado.getDni())) {
                    mostrarAlerta("Éxito", "Propietario eliminado correctamente.");
                    cargarTabla();
                    propietarioSelecccionado = null;
                } else {
                    mostrarAlerta("Error", "No se pudo eliminar el paciente.");
                }
            }
        });

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
