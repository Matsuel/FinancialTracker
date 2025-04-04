package com.financial.demojavagradle.controller;

import com.financial.demojavagradle.HelloApplication;
import javafx.fxml.FXML;

import java.io.IOException;

public class HeaderController {

    @FXML
    private void handleItem1() throws IOException {
        HelloApplication.changeScene("hello-view.fxml");
    }

    @FXML
    private void handleItem2() throws IOException {
        HelloApplication.changeScene("dashboard.fxml");
    }
}
