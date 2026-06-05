package org.example.practtiendabasic;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;



import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.System.exit;

public class menuController implements Initializable {
;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void inicioPaseOnAction(ActionEvent event) {
        cambiarPantalla(event, "mainview.fxml");
    }

    public void registerButtonOnAction(ActionEvent event) {
        cambiarPantalla(event, "registerMedicos.fxml");
    }

    public void salirButtonOnAction(ActionEvent event) {
        exit(0);
    }

    public void buscarButtonOnAction(ActionEvent event) {
        cambiarPantalla(event, "TableMedicos.fxml");
    }


    public void registerGastButtonOnAction(ActionEvent event) {
        cambiarPantalla(event, "registerEnfermeros.fxml");
    }

    public void buscarGastButtonOnAction(ActionEvent event) {
        cambiarPantalla(event, "TableEnfermeros.fxml");
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

    public void registerCitaButtonOnAction(ActionEvent event) {
        cambiarPantalla(event, "registerCitasMedicas.fxml");
    }

    public void buscarCitaButtonOnAction(ActionEvent event) {
        cambiarPantalla(event, "TableCitasMedicas.fxml");
    }

    public void buscarPaciButtonOnAction(ActionEvent event) {
        cambiarPantalla(event, "TablePacientes.fxml");
    }

    public void registerPaciButtonOnAction(ActionEvent event) {
        cambiarPantalla(event, "registerPacientes.fxml");
    }
}