package org.example.practtiendabasic;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.practtiendabasic.model.SQLModelEnfermeros;
import org.example.practtiendabasic.model.enfermeros;

import java.net.URL;
import java.util.ResourceBundle;

public class enfermerosTablaController implements Initializable {

    @FXML TableView <enfermeros> EnfermerosTableView;

    @FXML TableColumn <enfermeros, String> nombreEnfermero, dniEnfermero, telefonoEnfermero,
            tipoPersonalEnfermero, turnoEnfermero, areaAsignadaEnfermero;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        nombreEnfermero.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        dniEnfermero.setCellValueFactory(new PropertyValueFactory<>("dni_empleado"));
        telefonoEnfermero.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        tipoPersonalEnfermero.setCellValueFactory(new PropertyValueFactory<>("tipo_personal"));
        turnoEnfermero.setCellValueFactory(new PropertyValueFactory<>("turno"));
        areaAsignadaEnfermero.setCellValueFactory(new PropertyValueFactory<>("area_asignada"));

        cargarTabla();
    }
    
    public void editarTableOnAction(ActionEvent event) {
    }


    public void borrarTableOnAction(ActionEvent event) {
    }

    public void salirOnAction(ActionEvent event) {
    }

    public void cargarTabla(){
        EnfermerosTableView.setItems(FXCollections.observableArrayList(SQLModelEnfermeros.getAllEnfermeros()));
    }

}
