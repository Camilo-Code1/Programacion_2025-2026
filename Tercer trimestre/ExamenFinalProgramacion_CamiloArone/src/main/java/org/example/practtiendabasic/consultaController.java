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
import org.example.practtiendabasic.model.*;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class consultaController implements Initializable {

    private boolean isNewConsulta = true;
    private Consulta consultaSelect = null;

    @FXML
    TextField duracionConsul, observacionConsul;
    @FXML
    DatePicker fechaConsulPicker;
    @FXML
    ComboBox <Propietario> dniProMascota;
    @FXML
    ComboBox <Mascota> mascotaPasCon;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {

            if (mascotaPasCon != null) {
                cargarCombMascotas();
            }

        } catch (Exception e) {
            System.err.println("¡ERROR crítico en el inicio del controlador!");
            e.printStackTrace();
        }

        try {

            if (dniProMascota != null) {
                cargarComboDNI();
            }

        } catch (Exception e) {
            System.err.println("¡ERROR crítico en el inicio del controlador!");
            e.printStackTrace();
        }

    }

    public void cargarComboDNI(){

        List<Propietario> lista = SQLModelPropietario.getAllPropietarios();
        ObservableList<Propietario> observableList = FXCollections.observableArrayList(lista);
        dniProMascota.setItems(observableList);

        dniProMascota.setCellFactory(lv -> new ListCell<Propietario>() {
            @Override
            protected void updateItem(Propietario item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? "" : item.getDni());
            }
        });
        dniProMascota.setButtonCell(new ListCell<Propietario>() {
            @Override
            protected void updateItem(Propietario item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? "" : item.getDni());
            }
        });
    }

    public void cargarCombMascotas(){

        List<Mascota> lista = SQLModelMascotas.getAllMascotas();
        ObservableList<Mascota> observableList = FXCollections.observableArrayList(lista);
        mascotaPasCon.setItems(observableList);

        mascotaPasCon.setCellFactory(lv -> new ListCell<Mascota>() {
            @Override
            protected void updateItem(Mascota item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? "" : item.getPasaporte());
            }
        });
        mascotaPasCon.setButtonCell(new ListCell<Mascota>() {
            @Override
            protected void updateItem(Mascota item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? "" : item.getPasaporte());
            }
        });
    }

    public void guardarOnAction(ActionEvent event) {

        if (fechaConsulPicker == null){
            mostrarAlerta("Campos incompletos", "Por favor, complete los campos faltantes");
            return;
        }

        LocalDate fechaSelect = fechaConsulPicker.getValue();

        if (duracionConsul == null||observacionConsul == null||fechaSelect == null ){
            mostrarAlerta("Campos incompletos", "Por favor, complete los campos faltantes");
            return;
        }

        int duraci;
        try {
            duraci = Integer.parseInt(duracionConsul.getText());
        } catch (NumberFormatException e){
            mostrarAlerta("Error", "Por favor, ingrese un numeor valido");
            return;
        }



        Mascota masccoPas = mascotaPasCon.getValue();
        if (masccoPas == null){
            mostrarAlerta("Error", "Debe de seleccionar un Pasaporte de Mascota");
        }
        String pasport = masccoPas.getPasaporte();




        Propietario propietearioSelec = dniProMascota.getValue();

        if (propietearioSelec == null){
            mostrarAlerta("Error", "Debe de seleccionar un propietario");
        }

        String dniProp = propietearioSelec.getDni();




        if (isNewConsulta){
            Consulta consulNueva = new Consulta(
                    fechaSelect, duraci, observacionConsul.getText(),
                    pasport, dniProp
            );
            if (SQLModelConsultas.createConsultas(consulNueva)){
                mostrarAlerta("Exito", "Mascota registrada con exito");
                limpiarCampos();
            } else {
                mostrarAlerta("Error", "No se pudo registrar la mascota");
            }
        }


    }

    public void limpiarCampos(){
        fechaConsulPicker.setValue(null);
        duracionConsul.clear();
        observacionConsul.clear();
        dniProMascota.getSelectionModel().clearSelection();
        mascotaPasCon.getSelectionModel().clearSelection();
    }

    public void salirOnAction(ActionEvent event) {
        cambiarPantalla(event, "mainview.fxml");
    }

    public void borrarOnAction(ActionEvent event) {
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
