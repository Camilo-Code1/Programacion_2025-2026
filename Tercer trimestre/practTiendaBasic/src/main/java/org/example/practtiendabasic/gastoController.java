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
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.practtiendabasic.model.SQLModelGastos;
import org.example.practtiendabasic.model.SQLModelProducto;
import org.example.practtiendabasic.model.gastos;
import org.example.practtiendabasic.model.proveedores;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class gastoController implements Initializable {

    private gastos newGasto;
    private boolean isNewGasto = true;

    private int idGastoEnEdicion;

    @FXML private TextField conceptoGasto, montoGasto;
    @FXML private ComboBox<proveedores> proveedorCombo;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {

            if (proveedorCombo != null) {
                cargarProveedor();
            }

        } catch (Exception e) {
            System.err.println("¡ERROR crítico en el inicio del controlador!");
            e.printStackTrace();
        }
    }

    public void guardarOnAction(ActionEvent event) {

        if (conceptoGasto.getText().isEmpty()){
            mostrarAlerta("Campo incompleto", "Por favor, complete el campo del nombre del producto.");
            return;
        }
        if (montoGasto.getText().isEmpty()){
            mostrarAlerta("Campo incompleto", "Por favor, complete el campo del nombre del producto.");
            return;
        }

        proveedores provSelec = proveedorCombo.getValue();

        if (provSelec == null){
            mostrarAlerta("Error", "Debe seleccionar un proveedor.");
            return;
        }

        int idProv = provSelec.getId_proveedor();

        if (isNewGasto){
            this.newGasto = new gastos(
                    conceptoGasto.getText(),
                    Double.parseDouble(montoGasto.getText()),
                    idProv
            );

            if (SQLModelGastos.createGasto(this.newGasto)){
                mostrarAlerta("Exito", "Gasto creado correctamente");
                limpiarCampos();
            } else {
                mostrarAlerta("Error", "No se pudo crear el gasto");
            }
        } else {
            gastos gastoEditado = new gastos(
                    this.idGastoEnEdicion,
                    conceptoGasto.getText(),
                    Double.parseDouble(montoGasto.getText()),
                    idProv
            );

            if (SQLModelGastos.updateGasto(gastoEditado)){
                mostrarAlerta("Exito", "Gasto editado correctamente");
                isNewGasto = true;
                limpiarCampos();
            } else {
                mostrarAlerta("Error", "No se pudo editar el gasto");
            }
        }
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
    private void limpiarCampos(){
        conceptoGasto.clear();
        montoGasto.clear();
        proveedorCombo.getSelectionModel().clearSelection();
    }


    public void borrarOnAction(ActionEvent event) {
    }

    public void salirOnAction(ActionEvent event) {
        cambiarPantalla(event, "mainview.fxml");
    }

    private void cargarProveedor(){
        List<proveedores> lista = SQLModelProducto.getAllProveedorews();
        ObservableList<proveedores> observableList = FXCollections.observableArrayList(lista);
        proveedorCombo.setItems(observableList);

        proveedorCombo.setCellFactory(lv -> new ListCell<proveedores>() {
            @Override
            protected void updateItem(proveedores item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? "" : item.getNombre_empresa());
            }
        });
        proveedorCombo.setButtonCell(new ListCell<proveedores>() {
            @Override
            protected void updateItem(proveedores item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? "" : item.getNombre_empresa());
            }
        });
    }

    public void cargarGastoParaEditar(gastos g) {

        this.isNewGasto = false;
        this.idGastoEnEdicion = g.getId_gasto();

        conceptoGasto.setText(g.getConcepto());
        montoGasto.setText(String.valueOf(g.getMonto()));

        for (proveedores prov : proveedorCombo.getItems()){
            if (prov.getId_proveedor() == g.getId_proveedor()) {
                proveedorCombo.setValue(prov);
                break;
            }
        }


    }
}
