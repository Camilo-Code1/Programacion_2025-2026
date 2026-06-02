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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.practtiendabasic.model.SQLModelProducto;
import org.example.practtiendabasic.model.productos;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TableProductController implements Initializable {

    @FXML private TableView<productos> producTablaView;

    @FXML private TableColumn<productos, String> nombreTable;
    @FXML private TableColumn<productos, Double> precioTable;
    @FXML private TableColumn<productos, Integer> stockTable;
    @FXML private TableColumn<productos, Integer> categoriaTable;
    @FXML private TableColumn<productos, Integer> proveedorTable;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        nombreTable.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        precioTable.setCellValueFactory(new PropertyValueFactory<>("precio"));
        stockTable.setCellValueFactory(new PropertyValueFactory<>("stock"));
        categoriaTable.setCellValueFactory(new PropertyValueFactory<>("categoriaSelec"));
        proveedorTable.setCellValueFactory(new PropertyValueFactory<>("proveedorSelec"));

        producTablaView.setItems(FXCollections.observableArrayList(SQLModelProducto.getAllProductos()));

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


    public void editarTableOnAction(ActionEvent event) {

        productos seleccionado = producTablaView.getSelectionModel().getSelectedItem();

        if (seleccionado == null) {
            System.out.println("Por favor, seleccione un gasto de la tabla para editar.");
            return;
        }

        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("registerProducto.fxml"));
            javafx.scene.Parent root = loader.load();

            HelloController formularioController = loader.getController();

            formularioController.cargarProductoParaEditar(seleccionado);

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
        productos seleccionado = producTablaView.getSelectionModel().getSelectedItem();

        if (seleccionado == null){
            System.out.println("Por favor, selecciona un producto de la tabla para eliminar.");
            return;
        }

        if (SQLModelProducto.deleteProducto(seleccionado.getId_producto())){
            producTablaView.getItems().remove(seleccionado);
            System.out.println("Producto eliminado exitosamente.");
        } else {
            System.out.println("Error al intentar eliminar el producto de la base de datos.");
        }
    }

    public void salirOnAction(ActionEvent event) {
        cambiarPantalla(event, "mainview.fxml");
    }
}
