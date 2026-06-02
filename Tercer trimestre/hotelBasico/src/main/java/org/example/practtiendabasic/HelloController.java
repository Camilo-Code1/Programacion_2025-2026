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


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
//
//    private productos newProducto;
//    private boolean isNewProducto = true;


    // Variable para actualizar Producto
    private int idProductoEnEdicion;


    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

    public void inicioPaseOnAction(ActionEvent event) {
        cambiarPantalla(event, "mainview.fxml");
    }

    public void registerButtonOnAction(ActionEvent event) {
        cambiarPantalla(event, "registerProducto.fxml");
    }

    public void salirButtonOnAction(ActionEvent event) {

    }

    public void buscarButtonOnAction(ActionEvent event) {
        cambiarPantalla(event, "productTable.fxml");
    }

    public void guardarOnAction(ActionEvent event) {


    }


    public void borrarOnAction(ActionEvent event) {
        limpiarCampos();
    }

    public void salirOnAction(ActionEvent event) {
        cambiarPantalla(event, "mainview.fxml");
    }

    private void limpiarCampos(){
//        nombreProduct.clear();
//        precioProduct.clear();
//        stockProduct.clear();
//        categoriaCombo.getSelectionModel().clearSelection();
//        proveedorCombo.getSelectionModel().clearSelection();
    }


    public void registerGastButtonOnAction(ActionEvent event) {
        cambiarPantalla(event, "registerGasto.fxml");
    }

    public void buscarGastButtonOnAction(ActionEvent event) {
        cambiarPantalla(event, "gastoTable.fxml");
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