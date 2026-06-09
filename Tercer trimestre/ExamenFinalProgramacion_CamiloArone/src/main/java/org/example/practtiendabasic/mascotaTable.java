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
import org.example.practtiendabasic.model.*;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class mascotaTable implements Initializable {

    private Mascota macotaSelect = null;

    @FXML TableView<Mascota> MascotaTableView;

    @FXML TableColumn<Mascota, String> pasaporteTable, nombreMasTable;
    @FXML TableColumn<Mascota, String> propietarioMasTable;
    @FXML TableColumn<Mascota, Double> pesoMasTable;
    @FXML TableColumn<Mascota, LocalDate> fechaMasTable;
    @FXML TableColumn<Mascota, Tipo> tipoMasTable;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        pasaporteTable.setCellValueFactory(new PropertyValueFactory<>("Pasaporte"));
        nombreMasTable.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        pesoMasTable.setCellValueFactory(new PropertyValueFactory<>("Peso"));
        fechaMasTable.setCellValueFactory(new PropertyValueFactory<>("FechaNacimiento"));
        propietarioMasTable.setCellValueFactory(new PropertyValueFactory<>("Propietario_dni"));
        tipoMasTable.setCellValueFactory(new PropertyValueFactory<>("Tipo_idTipo"));

        cargarTabla();

        MascotaTableView.getSelectionModel().selectedItemProperty().addListener(
                (obs, anterior, seleccionado) -> {
                    if (seleccionado != null) {
                        macotaSelect = seleccionado;
                    }
                }
        );
    }

    public void cargarTabla(){ MascotaTableView.setItems(FXCollections.observableArrayList(SQLModelMascotas.getAllMascotas()));
    }

    public void editarTableOnAction(ActionEvent event) {
    }

    public void salirOnAction(ActionEvent event) { cambiarPantalla(event, "mainview.fxml");
    }

    public void borrarTableOnAction(ActionEvent event) {

        if (macotaSelect == null){
            mostrarAlerta("Aviso", "Selecciona una Mascota de la tabla primero.");
            return;
        }

        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Confirmar borrado");
        confirm.setHeaderText(null);
        confirm.setContentText("¿Seguro que quieres borrar a " + macotaSelect.getNombre() + "?");
        confirm.showAndWait().ifPresent(respuesta -> {
            if (respuesta == ButtonType.OK) {
                if (SQLModelMascotas.deleteMascota(macotaSelect.getNombre())) {
                    mostrarAlerta("Éxito", "Paciente eliminado correctamente.");
                    cargarTabla();
                    macotaSelect = null;
                } else {
                    mostrarAlerta("Error", "No se pudo eliminar el paciente.");
                    mostrarAlerta("Aviso", "Recuerde eliminar primero la consulta a que este relacionada");
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
