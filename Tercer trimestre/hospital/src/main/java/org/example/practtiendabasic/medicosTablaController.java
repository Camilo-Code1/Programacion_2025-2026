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
import org.example.practtiendabasic.model.SQLModelMedicos;
import org.example.practtiendabasic.model.medicos;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class medicosTablaController implements Initializable {

    private medicos medicoSeleccionado = null;

    @FXML
    TableView<medicos> MedicosTableView;
    @FXML
    TableColumn<medicos, String> nombreMedic, dniMedico, telefonoMedic,
            tipoPersonalMedic, especialidadMedic, licenciaMedic;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nombreMedic.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        dniMedico.setCellValueFactory(new PropertyValueFactory<>("dni_empleado"));
        telefonoMedic.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        tipoPersonalMedic.setCellValueFactory(new PropertyValueFactory<>("tipo_personal"));
        especialidadMedic.setCellValueFactory(new PropertyValueFactory<>("especialidad"));
        licenciaMedic.setCellValueFactory(new PropertyValueFactory<>("licencia_medica"));

        cargarTabla();

        MedicosTableView.getSelectionModel().selectedItemProperty().addListener(
                (obs, anterior, seleccionado) -> {
                    if (seleccionado != null) {
                        medicoSeleccionado = seleccionado;
                    }
                }
        );
    }

    private void cargarTabla() {
        MedicosTableView.setItems(FXCollections.observableArrayList(SQLModelMedicos.getAllMedicos()));
    }

    public void editarTableOnAction(ActionEvent event) {
        if (medicoSeleccionado == null) {
            mostrarAlerta("Aviso", "Selecciona un médico de la tabla primero.");
            return;
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/org/example/practtiendabasic/registerMedicos.fxml"));
            Parent root = loader.load();

            medicosController formController = loader.getController();
            formController.cargarMedicoParaEdicion(medicoSeleccionado);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            mostrarAlerta("Error", "No se pudo abrir el formulario: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void borrarTableOnAction(ActionEvent event) {
        if (medicoSeleccionado == null) {
            mostrarAlerta("Aviso", "Selecciona un médico de la tabla primero.");
            return;
        }

        // Comprobar si tiene citas antes de intentar borrar
        if (SQLModelMedicos.tieneCitas(medicoSeleccionado)) {
            mostrarAlerta("No se puede borrar",
                    "El médico tiene citas médicas asignadas. Elimínalas primero.");
            return;
        }

        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Confirmar borrado");
        confirm.setHeaderText(null);
        confirm.setContentText("¿Seguro que quieres borrar a " + medicoSeleccionado.getNombre() + "?");
        confirm.showAndWait().ifPresent(respuesta -> {
            if (respuesta == ButtonType.OK) {
                if (SQLModelMedicos.deleteMedico(medicoSeleccionado.getDni_empleado())) {
                    mostrarAlerta("Éxito", "Médico eliminado correctamente.");
                    cargarTabla();
                    medicoSeleccionado = null;
                } else {
                    mostrarAlerta("Error", "No se pudo eliminar el médico.");
                }
            }
        });
    }

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