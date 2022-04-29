package com.example.controller;

import com.example.demo.WarehouseFacade;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void initialize(){
        WarehouseFacade warehouse = WarehouseFacade.getInstance();
        welcomeText.setText(warehouse.getInventory());
    }
}