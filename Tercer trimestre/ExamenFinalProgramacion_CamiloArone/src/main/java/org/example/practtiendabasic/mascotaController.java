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

public class mascotaController implements Initializable {

    private boolean isNewMascota = true;
    private Mascota mascotaSeleccionada = null;

    @FXML TextField  pasaporteMascota, nombreMascota, pesoMascota;
    @FXML ComboBox <Tipo> tipoMascota;
    @FXML DatePicker fechaNacPicker;
    @FXML ComboBox <Propietario> dniProMascota;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


            if (tipoMascota != null) {
                cargar();
            }
            if (dniProMascota != null) {
                cargarComboDNI();
            }



    }

    public void cargar(){
        List<Tipo> lista = SQLModelTipo.getAllTipos();
        ObservableList<Tipo> observableList = FXCollections.observableArrayList(lista);
        tipoMascota.setItems(observableList);

        tipoMascota.setCellFactory(lv -> new ListCell<Tipo>() {
            @Override
            protected void updateItem(Tipo item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? "" : item.getTipo());
            }
        });
        tipoMascota.setButtonCell(new ListCell<Tipo>() {
            @Override
            protected void updateItem(Tipo item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? "" : item.getTipo());
            }
        });
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

    public void guardarOnAction(ActionEvent event) {

        LocalDate fechaSelect = fechaNacPicker.getValue();

        if (pasaporteMascota == null|| nombreMascota == null|| fechaSelect == null|| pesoMascota == null) {
            mostrarAlerta("Campos incompletos", "Por favor, complete los campos faltantes");
            return;
        }



        Tipo tipoSelec = tipoMascota.getValue();

        if (tipoSelec == null){
            mostrarAlerta("Error", "Debe de seleccionar un tipo de animal");
            return;
        }



        Propietario propietearioSelec = dniProMascota.getValue();

        if (propietearioSelec == null){
            mostrarAlerta("Error", "Debe de seleccionar un propietario");
        }

        String dniProp = propietearioSelec.getDni();




        double peso;
        try {
            peso = Double.parseDouble(pesoMascota.getText());
        } catch (NumberFormatException e){
            mostrarAlerta("Error", "Por favor, ingrese un peso valido.");
            return;
        }

        int idTipo = tipoSelec.getIdTipo();

        if (isNewMascota) {
            Mascota mascotaNueva = new Mascota(
                    pasaporteMascota.getText(), nombreMascota.getText(), peso,
                    fechaSelect, dniProp, idTipo
            );
            if (SQLModelMascotas.createMascota(mascotaNueva)){
                mostrarAlerta("Exito", "Mascota registrada con exito");
                limpiarCampos();
            } else {
                mostrarAlerta("Error", "No se pudo registrar la mascota");
            }
        }



    }

    public void salirOnAction(ActionEvent event) {
        cambiarPantalla(event, "mainview.fxml");
    }

    public void limpiarCampos(){
        pasaporteMascota.clear();
        nombreMascota.clear();
        pesoMascota.clear();
        tipoMascota.getSelectionModel().clearSelection();
        fechaNacPicker.setValue(null);
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
