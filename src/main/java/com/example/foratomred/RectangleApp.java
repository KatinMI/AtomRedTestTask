package com.example.foratomred;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class RectangleApp extends Application {
    private Stage primaryStage;
    private AnchorPane rootLayout;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
            this.primaryStage = stage;
            stage.setTitle("Rectangle Application");
            primaryStage.setMinWidth(480);
            primaryStage.setMinHeight(320);
            showRectangleWindow();
    }
    public void showRectangleWindow(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(RectangleApp.class.getResource("rectangle-view.fxml"));
            rootLayout = loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
