package org.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Mañana será otro dia!");
    }

    @FXML
    protected void onNightHelloClick() {
        welcomeText.setText("Que tengas una buena noche!");
    }
}