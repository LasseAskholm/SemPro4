module com.example.controller {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.controller to javafx.fxml;
    exports com.example.controller;
}