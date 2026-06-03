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
import org.example.practtiendabasic.model.SQLModelHabitacion;
import org.example.practtiendabasic.model.habitaciones;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class tablaHabController implements Initializable {

    @FXML private TableView<habitaciones> habitacionTablaView;

    @FXML private TableColumn<habitaciones, String> nHabitaTable;
    @FXML private TableColumn<habitaciones, String> tipoHabTable;
    @FXML private TableColumn<habitaciones, Double> precioHabTable;
    @FXML private TableColumn<habitaciones, String> estadoHabTable;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        nHabitaTable.setCellValueFactory(new PropertyValueFactory<>("numero_habitacion"));
        tipoHabTable.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        precioHabTable.setCellValueFactory(new PropertyValueFactory<>("precio_noche"));
        estadoHabTable.setCellValueFactory(new PropertyValueFactory<>("estado"));

        habitacionTablaView.setItems(FXCollections.observableArrayList(SQLModelHabitacion.getAllHabitaciones()));

    }
    public void editarTableOnAction(ActionEvent event) {
        habitaciones seleccionado = habitacionTablaView.getSelectionModel().getSelectedItem();

        if (seleccionado == null) {
            mostrarAlerta("Error", "Por favor, seleccione un producto para editar.");
            return;
        }

        cambiarPantallaConDatos(event, "registerHabitacion.fxml", seleccionado);
    }

    public void borrarTableOnAction(ActionEvent event) {
        habitaciones seleccionado = habitacionTablaView.getSelectionModel().getSelectedItem();

        if (seleccionado == null) {
            mostrarAlerta("Error", "Por favor, seleccione un producto para eliminar.");
            return;
        }
        if (SQLModelHabitacion.deleteHabitacion(seleccionado.getId_habitacion())){
            habitacionTablaView.getItems().remove(seleccionado);
            mostrarAlerta("Exito", "Habitacion eliminada con exito");
        } else {
            mostrarAlerta("Error", "No se pudo eliminar la habitacion.");
        }
    }

    public void salirOnAction(ActionEvent event) {
        cambiarPantalla(event, "mainview.fxml");
    }

    private void cambiarPantallaConDatos(ActionEvent event, String archivoFXML, habitaciones hab) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(archivoFXML));
            Parent root = loader.load();

            if (hab != null) {
                HelloController formularioController = loader.getController();
                formularioController.cargarHabitacionParaEditar(hab);
            }

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            System.err.println("Error al cargar " + archivoFXML + ": " + e.getMessage());
            mostrarAlerta("Error de Navegación", "No se pudo abrir el formulario de edición.");
        }
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
