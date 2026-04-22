package org.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javafx.scene.Node;
import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private Button onPasarPantalla;

    @FXML
    private Button onBackButtonClick;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Mañana será otro dia!");
    }

    @FXML
    protected void onPasarPantalla (ActionEvent event) {

        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/demo/segundaPan.fxml"));

            Parent root = fxmlLoader.load();

            Scene scene = new Scene(root, 1620, 880);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println("Error al cargar la segunda pantalla");
            e.printStackTrace();
        }
    }

    @FXML
    protected void onBackButtonClick (ActionEvent event) {

        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/demo/hello-view.fxml"));

            Parent root = fxmlLoader.load();

            Scene scene = new Scene(root, 1620, 880);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println("Error al cargar la segunda pantalla");
            e.printStackTrace();
        }
    }
    @FXML
    protected void onNightHelloClick() {
        welcomeText.setText("Tal vez mañana sea otro dia mejor");
    }
    @FXML
    protected void onBackButtonClick() {
        welcomeText.setText("Que tengas una buena noche!");
    }
    @FXML
    protected void onSegundoImpaClick() {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
    }
}