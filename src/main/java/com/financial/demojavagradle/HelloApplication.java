package com.financial.demojavagradle;

import com.financial.demojavagradle.db.Database;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        if (!Database.isOK()) {
            System.exit(1);
        }
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Image icons = new Image(getClass().getResourceAsStream("icons/erwan.png"));

        Scene scene = new Scene(fxmlLoader.load(), 1200, 600);
        stage.setTitle("BONJOUR!");
        stage.getIcons().add(icons);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}