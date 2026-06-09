package org.example.practtiendabasic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.practtiendabasic.model.Propietario;
import org.example.practtiendabasic.model.SQLModelPropietario;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class propietarioController implements Initializable {

    private boolean isNewPropietario = true;
    private Propietario propietarioSeleccionado = null;

    @FXML TextField dniPropietario, nombrePropietario, apellidoPropietario, telefonoPropietario, direciconPropietario, emailPropietario;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }


    public void guardarOnAction(ActionEvent event) {

        if (dniPropietario == null || nombrePropietario == null|| apellidoPropietario == null || telefonoPropietario == null || direciconPropietario == null || emailPropietario == null){
            mostrarAlerta("Campos Incompletos", "Complete todos los campos antes de guardar.");
            return;
        }

        if (isNewPropietario){
            Propietario propietarioNuevo = new Propietario(
                    dniPropietario.getText(), nombrePropietario.getText(), apellidoPropietario.getText(),
                    telefonoPropietario.getText(), direciconPropietario.getText(), emailPropietario.getText()
            );
            if (SQLModelPropietario.createPropietario(propietarioNuevo)) {
                mostrarAlerta("Exito", "Propietario registrado con exito");
                limpiarCampos();
                isNewPropietario = true;
                propietarioSeleccionado = null;
                dniPropietario.setEditable(true);
            } else {
                mostrarAlerta("Error", "No se pudo registrar el paciente");
            }
        } else {
            Propietario propietarioEditado = new Propietario(
                    propietarioSeleccionado.getDni(),
                    nombrePropietario.getText(),
                    apellidoPropietario.getText(),
                    telefonoPropietario.getText(),
                    direciconPropietario.getText(),
                    emailPropietario.getText()


            );
            if (SQLModelPropietario.updatePropietario(propietarioEditado)){
                mostrarAlerta("Exito", "Propietario actualizado correctamente");
                limpiarCampos();
            } else {
                mostrarAlerta("Error", "No se pudo actualizar al Propietario");
            }


        }

    }


    public void salirOnAction(ActionEvent event) {
        cambiarPantalla(event, "mainview.fxml");
    }

    private void limpiarCampos(){
        dniPropietario.clear();
        nombrePropietario.clear();
        apellidoPropietario.clear();
        telefonoPropietario.clear();
        direciconPropietario.clear();
        emailPropietario.clear();
    }
    public void borrarOnAction(ActionEvent event) {
        limpiarCampos();
    }

    public void borrarTableOnAction(ActionEvent event) {
    }

    public void cargarDatoParaEditar(Propietario pro){
        this.isNewPropietario = false;
        propietarioSeleccionado = pro;

        dniPropietario.setText(pro.getDni());
        nombrePropietario.setText(pro.getNombre());
        apellidoPropietario.setText(pro.getApellido());
        telefonoPropietario.setText(pro.getTelefono());
        direciconPropietario.setText(pro.getDirecion());
        emailPropietario.setText(pro.getEmail());

        dniPropietario.setEditable(false);
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
