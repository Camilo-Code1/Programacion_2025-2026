module org.example.practtiendabasic {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.practtiendabasic to javafx.fxml;
    opens org.example.practtiendabasic.model to javafx.base;

    exports org.example.practtiendabasic;
    exports org.example.practtiendabasic.model;
}