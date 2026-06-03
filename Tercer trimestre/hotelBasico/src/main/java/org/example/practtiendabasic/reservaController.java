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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.practtiendabasic.model.*;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;

public class reservaController implements Initializable {

    private reservas newReserva;
    private boolean isNewReserva = true;

    private int idReservaEnEdicion;

    @FXML
    private TextField idHuespedText, idHabitacionText, montoTotalText;
    @FXML
    private DatePicker fechaEntradaPicker, fechaSalidaPicker;
    @FXML
    private ComboBox<EstadoDeReserva> estadorReservaCombo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if (estadorReservaCombo != null){
            estadorReservaCombo.setItems(FXCollections.observableArrayList(EstadoDeReserva.values()));
        }

    }


    public void guardarOnAction(ActionEvent event) {

        if (idHabitacionText == null || idHuespedText == null || montoTotalText == null) {
            mostrarAlerta("Error", "Por favor, complete todos los campos.");
            return;
        }
        EstadoDeReserva estadoSeleccionado = estadorReservaCombo.getValue();

        if (estadorReservaCombo == null) {
            mostrarAlerta("Error", "Por favor, seleccione un estado de reserva.");
            return;
        }

        double precio;
        try {
            precio = Double.parseDouble(montoTotalText.getText());
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Monto total debe ser un número válido.");
            return;
        }
        LocalDate fechaEntrada = fechaEntradaPicker.getValue();
        LocalDate fechaSalida = fechaSalidaPicker.getValue();

        if (fechaEntrada == null || fechaSalida == null) {
            mostrarAlerta("Error", "Por favor, seleccione fechas válidas.");
            return;
        }

        if (isNewReserva){
            newReserva = new reservas(
                    Integer.parseInt(idHuespedText.getText()),
                    Integer.parseInt(idHabitacionText.getText()),
                    fechaEntrada,
                    fechaSalida,
                    precio,
                    estadoSeleccionado
            );

            if (SQLModelReserva.createReserva(newReserva)){
                mostrarAlerta("Éxito", "Reserva creada exitosamente.");
                limpiarCampos();
            } else {
                mostrarAlerta("Error", "No se pudo crear la reserva.");
            }
        } else {
            // Lógica para actualizar una reserva existente (si se implementa)
        }

    }

    public void borrarOnAction(ActionEvent event) {
        limpiarCampos();
    }

    public void salirOnAction(ActionEvent event) {
        cambiarPantalla(event, "mainview.fxml");
    }
    private LocalDate validarFecha(String fechaTexto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            return LocalDate.parse(fechaTexto, formatter);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    private void limpiarCampos(){
        idHuespedText.clear();
        idHabitacionText.clear();
        montoTotalText.clear();
        fechaEntradaPicker.setValue(null);
        fechaSalidaPicker.setValue(null);
        estadorReservaCombo.getSelectionModel().clearSelection();
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
