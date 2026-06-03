package org.example.practtiendabasic;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.practtiendabasic.model.SQLModelReserva;
import org.example.practtiendabasic.model.reservas;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class tablaReservasController implements Initializable {


    @FXML private TableView<reservas> reservasTableView;

    @FXML private TableColumn<reservas, Integer> idHuspedTable;
    @FXML private TableColumn<reservas, Integer> idHabitacionTable;
    @FXML private TableColumn<reservas, LocalDate> fechaEntradaTable;
    @FXML private TableColumn<reservas, LocalDate> fechaSalidaTable;
    @FXML private TableColumn<reservas, Double> montoTotalTable;
    @FXML private TableColumn<reservas, String> estadoReservaTable;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        idHuspedTable.setCellValueFactory(new PropertyValueFactory<>("id_huesped"));
        idHabitacionTable.setCellValueFactory(new PropertyValueFactory<>("id_habitacion"));
        fechaEntradaTable.setCellValueFactory(new PropertyValueFactory<>("fecha_entrada"));
        fechaSalidaTable.setCellValueFactory(new PropertyValueFactory<>("fecha_salida"));
        montoTotalTable.setCellValueFactory(new PropertyValueFactory<>("monto_total"));
        estadoReservaTable.setCellValueFactory(new PropertyValueFactory<>("estado_reserva"));

        reservasTableView.setItems(FXCollections.observableArrayList(SQLModelReserva.getAllReservas()));

    }

    public void editarTableOnAction(ActionEvent event) {
    }

    public void borrarTableOnAction(ActionEvent event) {
    }

    public void salirOnAction(ActionEvent event) {
    }
}
