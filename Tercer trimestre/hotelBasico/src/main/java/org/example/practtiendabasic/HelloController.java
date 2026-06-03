package org.example.practtiendabasic;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.example.practtiendabasic.model.SQLModelHabitacion;
import org.example.practtiendabasic.model.estadoHab;
import org.example.practtiendabasic.model.habitaciones;
import org.example.practtiendabasic.model.tipoHabitacion;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
;
    private habitaciones newHabitacion;
    private boolean isNewHabitacion = true;

    private int idHabitacionEnEdicion;

    @FXML private TextField numeroHab, precioNoche;

    @FXML private ComboBox<tipoHabitacion> tipoHabCombo;
    @FXML private ComboBox<estadoHab> estadoHabCombo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if (tipoHabCombo != null){
//            tipoHabCombo.getItems().addAll("Individual", "Doble", "Suite");
                tipoHabCombo.setItems(FXCollections.observableArrayList(tipoHabitacion.values()));
        }

        if (estadoHabCombo != null){
//            estadoHabCombo.getItems().addAll("Disponible", "Ocupada", "Mantenimiento");
                estadoHabCombo.setItems(FXCollections.observableArrayList(estadoHab.values()));
        }

    }

    public void inicioPaseOnAction(ActionEvent event) {
        cambiarPantalla(event, "mainview.fxml");
    }

    public void registerButtonOnAction(ActionEvent event) {
        cambiarPantalla(event, "registerHabitacion.fxml");
    }

    public void salirButtonOnAction(ActionEvent event) {

    }

    public void buscarButtonOnAction(ActionEvent event) {
        cambiarPantalla(event, "habitacionTable.fxml");
    }

    public void guardarOnAction(ActionEvent event) {

        if (numeroHab.getText().isEmpty() || precioNoche.getText().isEmpty()) {
            mostrarAlerta("Error", "Por favor, complete todos los campos.");
            return;
        }

        tipoHabitacion tipoSeleccionado = tipoHabCombo.getValue();
        estadoHab estadoSeleccionado = estadoHabCombo.getValue();

        if (tipoSeleccionado == null || estadoSeleccionado == null) {
            mostrarAlerta("Error", "Por favor, seleccione un tipo y un estado.");
            return;
        }


        double precio;
        try {
            precio = Double.parseDouble(precioNoche.getText());
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Por favor, ingrese un precio válido.");
            return;
        }

        if (isNewHabitacion){
            this.newHabitacion = new habitaciones(
                    numeroHab.getText(),
                    tipoSeleccionado,
                    precio,
                    estadoSeleccionado
            );

            if (SQLModelHabitacion.createHabitacioon(newHabitacion)){
                mostrarAlerta("Exito", "Habitacion creada con exito");
                limpiarCampos();
            } else {
                mostrarAlerta("Error", "No se pudo crear la habitacion.");
            }
        } else {
            habitaciones habitacionEnEdicion = new habitaciones(
                    idHabitacionEnEdicion,
                    numeroHab.getText(),
                    tipoSeleccionado,
                    precio,
                    estadoSeleccionado
            );

            if (SQLModelHabitacion.updateHabitacion(habitacionEnEdicion)){
                mostrarAlerta("Exito", "Habitacion actualizada con exito");
                limpiarCampos();
                isNewHabitacion = true;
            } else {
                mostrarAlerta("Error", "No se pudo actualizar la habitacion.");
            }
        }
    }

    public void cargarHabitacionParaEditar(habitaciones hab){
        this.isNewHabitacion = false;
        this.idHabitacionEnEdicion = hab.getId_habitacion();

        numeroHab.setText(hab.getNumero_habitacion());
        precioNoche.setText(String.valueOf(hab.getPrecio_noche()));
        tipoHabCombo.setValue(hab.getTipo());
        estadoHabCombo.setValue(hab.getEstado());
    }

    public void borrarOnAction(ActionEvent event) {
        limpiarCampos();
    }

    public void salirOnAction(ActionEvent event) {
        cambiarPantalla(event, "mainview.fxml");
    }

    private void limpiarCampos(){
        numeroHab.clear();
        precioNoche.clear();
        tipoHabCombo.getSelectionModel().clearSelection();
        estadoHabCombo.getSelectionModel().clearSelection();
    }


    public void registerGastButtonOnAction(ActionEvent event) {
        cambiarPantalla(event, "registerReserva.fxml");
    }

    public void buscarGastButtonOnAction(ActionEvent event) {
        cambiarPantalla(event, "reservasTable.fxml");
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