package org.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private Button onNightHelloClick;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Mañana será otro dia!");
    }

    @FXML
    protected void onNightHelloClick (ActionEvent event) {

        try {

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("org/example/demo/segundaPan.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1920, 1080);
            Stage stage = (Stage) onNightHelloClick.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();

        }
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