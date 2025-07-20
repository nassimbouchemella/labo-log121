package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;

/**
 * Classe principale de l'application JavaFX.
 * <p>
 * Cette classe étend Application et sert de point d'entrée à l'application graphique.
 * Elle initialise la fenêtre principale (Stage) et la première scène affichée à l'utilisateur.
 * </p>
 *
 * @author Nassim Bouchemella
 */

public class App extends Application {
    private Stage stage;
    private Scene mainScene;
    private Scene secondScene;

/**
 * Point d'entrée de l'application JavaFX.
 * <p>
 * Cette méthode est appelée automatiquement au lancement de l'application.
 * Elle initialise la fenêtre principale, crée la scène principale et l'affiche.
 * </p>
 *
 * @param stage Le stage principal fourni par le système JavaFX.
 * @throws IOException Si une erreur survient lors du chargement des ressources.
 */
    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;

        MainView mainView = new MainView(20, stage);
        mainScene = new Scene(mainView, 400, 300);

        stage.setScene(mainScene);
        stage.setTitle("Fenêtre");
        stage.show();
    }

/**
 * Point d'entrée de l'application JavaFX.
 * <p>
 * Cette méthode est appelée automatiquement au lancement de l'application.
 * Elle initialise la fenêtre principale, crée la scène principale et l'affiche.
 * </p>
 *
 * @param ars argument de la ligne de code
 */
    public static void main(String[] args) {
        launch();
    }

}