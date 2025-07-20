/**
 * Cette classe représente l'app.
 * Elle utilise le framework JavaFX.
 */

package com.example;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class App extends Application {

    private static Scene scene;

    
    private double startX = 10.5;
    private double startY = 20.7;
    private double shownX = 30.9;
    private double shownY = 40.1;

    @Override
    public void start(Stage stage) {
        
        Scene scene = new Scene(new MainView(20.0));
        stage.setScene(scene);
        stage.setTitle("Fenêtre");
        stage.setWidth(400);
        stage.setHeight(500);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
