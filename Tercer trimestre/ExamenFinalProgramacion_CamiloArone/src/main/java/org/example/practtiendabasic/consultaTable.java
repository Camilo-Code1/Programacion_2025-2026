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
import org.example.practtiendabasic.model.Consulta;
import org.example.practtiendabasic.model.Propietario;
import org.example.practtiendabasic.model.SQLModelConsultas;
import org.example.practtiendabasic.model.SQLModelPropietario;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class consultaTable implements Initializable {

    private Consulta consultaSeleccionada = null;

    @FXML private TableView <Consulta> ConsultaTableView;

    @FXML private TableColumn <Consulta, LocalDate> fechaConsulta;
    @FXML private TableColumn <Consulta, Integer> duracionConsulta;
    @FXML private TableColumn <Consulta, String> observacionesConsul, mascotPasConsul, propietarioPassConsul;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        fechaConsulta.setCellValueFactory(new PropertyValueFactory<>("Fecha"));
        duracionConsulta.setCellValueFactory(new PropertyValueFactory<>("Duracion"));
        observacionesConsul.setCellValueFactory(new PropertyValueFactory<>("Observaciones"));
        mascotPasConsul.setCellValueFactory(new PropertyValueFactory<>("Mascota_Pasaporte"));
        propietarioPassConsul.setCellValueFactory(new PropertyValueFactory<>("Mascota_Propietario_dni"));

        cargarTabla();

        ConsultaTableView.getSelectionModel().selectedItemProperty().addListener(
                (obs, anterior, seleccionado) -> {
                    if (seleccionado != null) {
                        consultaSeleccionada = seleccionado;
                    }
                }
        );

    }

    public void cargarTabla(){
        ConsultaTableView.setItems(FXCollections.observableArrayList(SQLModelConsultas.getAllConsultas()));
    }

    public void editarTableOnAction(ActionEvent event) {
    }

    public void salirOnAction(ActionEvent event) {
        cambiarPantalla(event, "mainview.fxml");
    }

    public void borrarTableOnAction(ActionEvent event) {

        if (consultaSeleccionada == null){
            mostrarAlerta("Aviso", "Seleccione una Consulta de la tabla primero");
            return;
        }

        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Confirmar borrado");
        confirm.setHeaderText(null);
        confirm.setContentText("¿Seguro que quieres borrar a " + consultaSeleccionada.getIdConsulta() + "?");
        confirm.showAndWait().ifPresent(respuesta -> {
            if (respuesta == ButtonType.OK) {
                if (SQLModelConsultas.deleteConsulta(consultaSeleccionada.getMascota_Propietario_dni())) {
                    mostrarAlerta("Éxito", "Paciente eliminado correctamente.");
                    cargarTabla();
                    consultaSeleccionada = null;
                } else {
                    mostrarAlerta("Error", "No se pudo eliminar la Consulta.");

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
