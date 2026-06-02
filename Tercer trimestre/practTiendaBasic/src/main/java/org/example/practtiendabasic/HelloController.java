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
import org.example.practtiendabasic.model.SQLModelProducto;
import org.example.practtiendabasic.model.categorias;
import org.example.practtiendabasic.model.productos;
import org.example.practtiendabasic.model.proveedores;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    private productos newProducto;
    private boolean isNewProducto = true;
    private ObservableList<productos> productosObservableList = FXCollections.observableArrayList();

    @FXML private TextField nombreProduct, precioProduct, stockProduct;

    @FXML private ComboBox<categorias> categoriaCombo;
    @FXML private ComboBox<proveedores> proveedorCombo;

    // Variable para actualizar Producto
    private int idProductoEnEdicion;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {

            if (categoriaCombo != null) {
                cargarCategortias();
            }

            if (proveedorCombo != null) {
                cargarProveedor();
            }

        } catch (Exception e) {
            System.err.println("¡ERROR crítico en el inicio del controlador!");
            e.printStackTrace();
        }
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

        if (nombreProduct.getText().isEmpty()){
            mostrarAlerta("Campo incompleto", "Por favor, complete el campo del nombre del producto.");
            return;
        }

        categorias catSeleccionada = categoriaCombo.getValue();
        proveedores provSeleccionada = proveedorCombo.getValue();

        if (catSeleccionada == null || provSeleccionada == null) {
            mostrarAlerta("Error", "Debes seleccionar una categoría y proveedor.");
            return;
        }

        int idCat = catSeleccionada.getId_categoria();
        int idPro = provSeleccionada.getId_proveedor();

        if (isNewProducto){
            this.newProducto = new productos(
                    nombreProduct.getText(),
                    Double.parseDouble(precioProduct.getText()),
                    Integer.parseInt(stockProduct.getText()),
                    idCat,
                    idPro
            );
            if (SQLModelProducto.createProducto(this.newProducto)){
                mostrarAlerta("Exito", "Producto creado correctamente");
                limpiarCampos();
            } else {
                mostrarAlerta("Error", "No se pudo crear el producto");
            }

        } else {
            productos productoEditado = new productos(
                    this.idProductoEnEdicion,
                    nombreProduct.getText(),
                    Double.parseDouble(precioProduct.getText()),
                    Integer.parseInt(stockProduct.getText()),
                    idCat,
                    idPro
            );

            if (SQLModelProducto.updateProducto(productoEditado)){
                mostrarAlerta("Exito", "Producto editado correctamente");
                isNewProducto = true;
                limpiarCampos();
            } else {
                mostrarAlerta("Error", "No se pudo actualizar el producto");
            }
        }

    }

    public void cargarProductoParaEditar(productos p){
        this.isNewProducto = false;
        this.idProductoEnEdicion = p.getId_producto();

        nombreProduct.setText(p.getNombre());
        precioProduct.setText(String.valueOf(p.getPrecio()));
        stockProduct.setText(String.valueOf(p.getStock()));

        for (categorias cat : categoriaCombo.getItems()){
            if (cat.getId_categoria() == p.getCategoriaSelec()) {
                categoriaCombo.setValue(cat);
                break;
            }
        }
        for (proveedores prov : proveedorCombo.getItems()){
            if (prov.getId_proveedor() == p.getProveedorSelec()) {
                proveedorCombo.setValue(prov);
                break;
            }
        }
    }

    public void borrarOnAction(ActionEvent event) {
        limpiarCampos();
    }

    public void salirOnAction(ActionEvent event) {
        cambiarPantalla(event, "mainview.fxml");
    }

    private void limpiarCampos(){
        nombreProduct.clear();
        precioProduct.clear();
        stockProduct.clear();
        categoriaCombo.getSelectionModel().clearSelection();
        proveedorCombo.getSelectionModel().clearSelection();
    }

    private void cargarCategortias(){
        List<categorias> lista = SQLModelProducto.getAllCategorias();
        ObservableList<categorias> observableList = FXCollections.observableArrayList(lista);
        categoriaCombo.setItems(observableList);

        categoriaCombo.setCellFactory(lv -> new ListCell<categorias>() {
            @Override
            protected void updateItem(categorias item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? "" : item.getNombre());
            }
        });
        categoriaCombo.setButtonCell(new ListCell<categorias>() {
            @Override
            protected void updateItem(categorias item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty || item == null ? "" : item.getNombre());
            }
        });
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