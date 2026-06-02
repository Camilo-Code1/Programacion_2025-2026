package org.example.practtiendabasic;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.practtiendabasic.model.SQLModelGastos;
import org.example.practtiendabasic.model.SQLModelProducto;
import org.example.practtiendabasic.model.gastos;
import org.example.practtiendabasic.model.productos;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class TableGastoController implements Initializable {

    @FXML private TableView<gastos> gastoTablaView;

    @FXML private TableColumn<gastos, String> conceptoTable;
    @FXML private TableColumn<gastos, Double> montoTable;
    @FXML private TableColumn<gastos, Date> fechaTable;
    @FXML private TableColumn<gastos, Integer> proveedorGastoTable;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        conceptoTable.setCellValueFactory(new PropertyValueFactory<>("concepto"));
        montoTable.setCellValueFactory(new PropertyValueFactory<>("monto"));
        fechaTable.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        proveedorGastoTable.setCellValueFactory(new PropertyValueFactory<>("id_proveedor"));

        gastoTablaView.setItems(FXCollections.observableArrayList(SQLModelGastos.getAllGastos()));

    }

    public void editarTableOnAction(ActionEvent event) {

        gastos seleccionado = gastoTablaView.getSelectionModel().getSelectedItem();

        if (seleccionado == null){
            mostrarAlerta("Error", "Debe de seleccionar un gasto para poder editarlo");
            return;
        }

        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("registerGasto.fxml"));
            javafx.scene.Parent root = loader.load();

            gastoController formularioController = loader.getController();

            formularioController.cargarGastoParaEditar(seleccionado);

            javafx.scene.Scene scene = new javafx.scene.Scene(root);
            javafx.stage.Stage stage = (javafx.stage.Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.err.println("Error al cambiar a la pantalla de edición:");
            e.printStackTrace();
        }

    }

    public void borrarTableOnAction(ActionEvent event) {
        gastos seleccionado = gastoTablaView.getSelectionModel().getSelectedItem();

        if (seleccionado == null){
            System.out.println("Por favor, selecciona un producto de la tabla para eliminar.");
            return;
        }

        if (SQLModelGastos.deleteGasto(seleccionado.getId_gasto())){
            gastoTablaView.getItems().remove(seleccionado);
            System.out.println("Producto eliminado exitosamente.");
        } else {
            System.out.println("Error al intentar eliminar el producto de la base de datos.");
        }
    }

    public void salirOnAction(ActionEvent event) {
    }

    private void mostrarAlerta(String titulo, String msj) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(msj);
        alert.show();
    }
}
