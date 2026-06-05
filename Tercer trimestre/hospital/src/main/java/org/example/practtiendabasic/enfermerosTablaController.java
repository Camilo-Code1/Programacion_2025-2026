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
import org.example.practtiendabasic.model.SQLModelEnfermeros;
import org.example.practtiendabasic.model.enfermeros;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class enfermerosTablaController implements Initializable {

    private enfermeros enfermeroSeleccionado = null;

    @FXML TableView <enfermeros> EnfermerosTableView;

    @FXML TableColumn <enfermeros, String> nombreEnfermero, dniEnfermero, telefonoEnfermero,
            tipoPersonalEnfermero, turnoEnfermero, areaAsignadaEnfermero;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        nombreEnfermero.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        dniEnfermero.setCellValueFactory(new PropertyValueFactory<>("dni_empleado"));
        telefonoEnfermero.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        tipoPersonalEnfermero.setCellValueFactory(new PropertyValueFactory<>("tipo_personal"));
        turnoEnfermero.setCellValueFactory(new PropertyValueFactory<>("turno"));
        areaAsignadaEnfermero.setCellValueFactory(new PropertyValueFactory<>("area_asignada"));

        cargarTabla();

        EnfermerosTableView.getSelectionModel().selectedItemProperty().addListener(
                (obs, anterior, seleccionado) -> {
                    if (seleccionado != null) {
                        enfermeroSeleccionado = seleccionado;
                    }
                }
        );
    }
    
    public void editarTableOnAction(ActionEvent event) {
        if (enfermeroSeleccionado == null) {
            mostrarAlerta("Aviso", "Selecciona un enfermero de la tabla primero.");
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/org/example/practtiendabasic/registerEnfermeros.fxml"));
            Parent root = loader.load();

            enfermerosController formController = loader.getController();
            formController.cargarEnfermeroEdicion(enfermeroSeleccionado);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        }  catch (IOException e) {
            System.err.println("Error al cargar el formulario de edición: " + e.getMessage());
            mostrarAlerta("Error de Navegación", "No se pudo cargar el formulario de edición.");
        }
    }


    public void borrarTableOnAction(ActionEvent event) {
        if (enfermeroSeleccionado == null) {
            mostrarAlerta("Aviso", "Selecciona un enfermero de la tabla primero.");
            return;
        }

        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Confirmar borrado");
        confirm.setHeaderText(null);
        confirm.setContentText("¿Seguro que quieres borrar a " + enfermeroSeleccionado.getNombre() + "?");
        confirm.showAndWait().ifPresent(respuesta -> {
            if (respuesta == ButtonType.OK) {
                if (SQLModelEnfermeros.deleteEnfermero(enfermeroSeleccionado.getDni_empleado())) {
                    mostrarAlerta("Éxito", "Enfermero borrado correctamente.");
                    cargarTabla();
                    enfermeroSeleccionado = null;
                } else {
                    mostrarAlerta("Error", "No se pudo borrar el enfermero.");
                }
            }
        });

    }
    public void salirOnAction(ActionEvent event) {
        cambiarPantalla(event, "mainview.fxml");
    }

    public void cargarTabla(){
        EnfermerosTableView.setItems(FXCollections.observableArrayList(SQLModelEnfermeros.getAllEnfermeros()));
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
