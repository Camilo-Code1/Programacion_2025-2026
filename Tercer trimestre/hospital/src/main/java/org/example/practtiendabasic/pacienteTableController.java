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
import org.example.practtiendabasic.model.SQLModelPacientes;
import org.example.practtiendabasic.model.pacientes;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class pacienteTableController implements Initializable {

    private pacientes pacienteSeleccionado = null;

    @FXML private TableView<pacientes> pacientesTableView;

    @FXML private TableColumn<pacientes, String> nombreCompletoPaciente, historialCinicoColum ;
    @FXML private TableColumn<pacientes, LocalDate> fechaNacimientoColum;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        nombreCompletoPaciente.setCellValueFactory(new PropertyValueFactory<>("nombre_completo"));
        historialCinicoColum.setCellValueFactory(new PropertyValueFactory<>("historial_clinico"));
        fechaNacimientoColum.setCellValueFactory(new PropertyValueFactory<>("fecha_nacimiento"));
        
        cargarTabla();

        pacientesTableView.getSelectionModel().selectedItemProperty().addListener(
                (obs, anterior, seleccionado) -> {
                    if (seleccionado != null) {
                        pacienteSeleccionado = seleccionado;
                    }
                }
        );
    }
    
    public void cargarTabla(){
        pacientesTableView.setItems(FXCollections.observableArrayList(SQLModelPacientes.getAllPacientes()));
    }

    public void editarTableOnAction(ActionEvent event) {

        if (pacienteSeleccionado == null) {
            mostrarAlerta("Aviso", "Selecciona un paciente de la tabla primero.");
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/org/example/practtiendabasic/registerPacientes.fxml"));
            Parent root = loader.load();

            pacienteController formController = loader.getController();
            formController.cargarPacienteParaEditar(pacienteSeleccionado);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            mostrarAlerta("Error", "No se pudo abrir el formulario: " + e.getMessage());
            e.printStackTrace();
        }

    }

    public void borrarTableOnAction(ActionEvent event) {

        if (pacienteSeleccionado == null) {
            mostrarAlerta("Aviso", "Selecciona un paciente de la tabla primero.");
            return;
        }

        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Confirmar borrado");
        confirm.setHeaderText(null);
        confirm.setContentText("¿Seguro que quieres borrar a " + pacienteSeleccionado.getNombre_completo() + "?");
        confirm.showAndWait().ifPresent(respuesta -> {
            if (respuesta == ButtonType.OK) {
                if (SQLModelPacientes.deletePaciente(pacienteSeleccionado.getId_paciente())) {
                    mostrarAlerta("Éxito", "Paciente eliminado correctamente.");
                    cargarTabla();
                    pacienteSeleccionado = null;
                } else {
                    mostrarAlerta("Error", "No se pudo eliminar el paciente.");
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
