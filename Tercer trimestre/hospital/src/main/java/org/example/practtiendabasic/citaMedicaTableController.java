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
import org.example.practtiendabasic.model.SQLModelCitasMedicas;
import org.example.practtiendabasic.model.SQLModelMedicos;
import org.example.practtiendabasic.model.SQLModelPacientes;
import org.example.practtiendabasic.model.citas_medicas;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class citaMedicaTableController implements Initializable {

    private citas_medicas citaMedicaSeleccionada = null;

    @FXML TableView <citas_medicas> CitaMedicasTableView;

    @FXML
    TableColumn <citas_medicas, String> motivoCita, estadoCita;
// Cambia esto:
// @FXML TableColumn <citas_medicas, Integer> idPacienteCita, idMedicoCita;

    // Por esto:
    @FXML TableColumn <citas_medicas, String> idPacienteCita, idMedicoCita;
    @FXML TableColumn <citas_medicas, LocalDate> fechaCita;
    @FXML TableColumn <citas_medicas, LocalTime> horaCita;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // 🚀 LÓGICA PERSONALIZADA PARA MOSTRAR EL NOMBRE DEL PACIENTE
        idPacienteCita.setCellValueFactory(cellData -> {
            int idPaciente = cellData.getValue().getId_paciente();
            // Buscamos el paciente en la BD usando su ID y extraemos su nombre completo
            String nombrePaciente = SQLModelPacientes.getAllPacientes().stream()
                    .filter(p -> p.getId_paciente() == idPaciente)
                    .map(p -> p.getNombre_completo())
                    .findFirst()
                    .orElse("Paciente Desconocido (ID: " + idPaciente + ")");

            return new javafx.beans.property.SimpleStringProperty(nombrePaciente);
        });

        // 🚀 LÓGICA PERSONALIZADA PARA MOSTRAR EL NOMBRE DEL MÉDICO
        idMedicoCita.setCellValueFactory(cellData -> {
            int idMedico = cellData.getValue().getId_medico();
            // Buscamos el médico en la BD usando su ID y extraemos su nombre
            String nombreMedico = SQLModelMedicos.getAllMedicos().stream()
                    .filter(m -> m.getId_personal() == idMedico)
                    .map(m -> m.getNombre())
                    .findFirst()
                    .orElse("Médico Desconocido (ID: " + idMedico + ")");

            return new javafx.beans.property.SimpleStringProperty(nombreMedico);
        });

        // Las demás columnas se quedan exactamente igual con sus PropertyValueFactory
        fechaCita.setCellValueFactory(new PropertyValueFactory<>("fecha_cita"));
        horaCita.setCellValueFactory(new PropertyValueFactory<>("hora_cita"));
        motivoCita.setCellValueFactory(new PropertyValueFactory<>("motivo"));
        estadoCita.setCellValueFactory(new PropertyValueFactory<>("estado"));

        cargarTabla();

        CitaMedicasTableView.getSelectionModel().selectedItemProperty().addListener(
                (obs, anterior, seleccionado) -> {
                    if (seleccionado != null) {
                        citaMedicaSeleccionada = seleccionado;
                    }
                }
        );
    }

    public void editarTableOnAction(ActionEvent event) {
        if (citaMedicaSeleccionada == null) {
            mostrarAlerta("Aviso", "Selecciona una cita médica de la tabla primero.");
            return;
        }

        try {
            // 1. Cargamos el FXML del formulario (asumiendo que se llama citaMedicaView.fxml)
            FXMLLoader loader = new FXMLLoader(getClass().getResource("registerCitasMedicas.fxml"));
            Parent root = loader.load();

            // 2. Obtenemos el controlador del formulario y le pasamos la cita seleccionada
            citaMedicaController formularioCtrl = loader.getController();
            formularioCtrl.cargarCitaMedicaParaEditar(citaMedicaSeleccionada);

            // 3. Hacemos el cambio de pantalla físico
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            System.err.println("Error al abrir el formulario de edición: " + e.getMessage());
            mostrarAlerta("Error", "No se pudo abrir el formulario de edición.");
        }
    }

    public void borrarTableOnAction(ActionEvent event) {

        if (citaMedicaSeleccionada == null) {
            mostrarAlerta("Aviso", "Selecciona una cita médica de la tabla primero.");
            return;
        }

        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Confirmar borrado");
        confirm.setHeaderText(null);
        confirm.setContentText("¿Seguro que quieres borrar a " + citaMedicaSeleccionada.getMotivo() + "?");
        confirm.showAndWait().ifPresent(respuesta -> {
            if (respuesta == ButtonType.OK) {
                if (SQLModelCitasMedicas.deleteCitaMedica(citaMedicaSeleccionada.getId_cita())) {
                    mostrarAlerta("Éxito", "Cita médica eliminada correctamente.");
                    cargarTabla();
                    citaMedicaSeleccionada = null;
                } else {
                    mostrarAlerta("Error", "No se pudo eliminar la cita médica.");
                }
            }
        });


    }

    public void salirOnAction(ActionEvent event) {
        cambiarPantalla(event, "mainview.fxml");
    }

    public void cargarTabla(){
        CitaMedicasTableView.setItems(FXCollections.observableArrayList(SQLModelCitasMedicas.getAllCitasMedicas()));
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
