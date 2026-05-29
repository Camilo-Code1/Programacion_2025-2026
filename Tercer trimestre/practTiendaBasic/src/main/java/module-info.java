module org.example.practtiendabasic {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.practtiendabasic to javafx.fxml;
    exports org.example.practtiendabasic;
}