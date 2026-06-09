module org.example.espinosa_de_los_monteros {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens org.example.espinosa_de_los_monteros to javafx.fxml;
    exports org.example.espinosa_de_los_monteros;
}