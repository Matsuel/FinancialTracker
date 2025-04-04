package com.financial.demojavagradle;

import com.financial.demojavagradle.db.Database;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private static Stage primaryStage;

    public static void setPrimaryStage(Stage stage) {
        primaryStage = stage;
    }

    public static void changeScene(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(fxml));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 600);
        primaryStage.setScene(scene);
    }

    @Override
    public void start(Stage stage) throws IOException {
        if (!Database.isOK()) {
            System.exit(1);
        }
        HelloApplication.setPrimaryStage(stage);
        HelloApplication.changeScene("dashboard.fxml");
        stage.setTitle("BONJOUR!");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("icons/erwan.png")));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}