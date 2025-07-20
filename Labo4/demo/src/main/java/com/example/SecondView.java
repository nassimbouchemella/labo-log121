package com.example;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;          
import javafx.scene.layout.HBox;     
import javafx.scene.layout.VBox;     
import javafx.scene.paint.Color;     
import javafx.scene.shape.Rectangle; 
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.concurrent.atomic.AtomicBoolean;

import java.io.IOException;
import java.util.Arrays;

/**
 * Vue JavaFX permettant de visualiser un tableau sous forme de barres et de contrôler le déroulement d'un tri.
 * <p>
 * Cette classe gère l'affichage graphique du tableau, ainsi que les boutons de contrôle pour démarrer ou mettre en pause l'animation du tri.
 * Elle implémente VisualUpdateListener pour mettre à jour l'affichage lors des changements du tableau.
 * </p>
 */

public class SecondView extends VBox implements VisualUpdateListener {
    private Stage stage;
    private int[] array;
    /** Conteneur horizontal pour les barres représentant les valeurs du tableau */
    private HBox barsBox = new HBox(20);
    private String choix;
    private double speed;

    /** Indique si l'animation est en pause */
    private AtomicBoolean paused = new AtomicBoolean(false);
    private final Object pauseLock = new Object();

    /**
     * Constructeur de la vue.
     *
     * @param spacing Espacement vertical entre les éléments de la VBox.
     * @param stage   Fenêtre principale de l'application.
     * @param array   Tableau à trier et à afficher.
     * @param choix   Algorithme de tri sélectionné.
     * @param speed   Vitesse de l'animation (en millisecondes).
     */

    public SecondView(double spacing, Stage stage,int[] array, String choix,long speed) {
        super(spacing);
        this.array = array;
        this.choix = choix;

        barsBox.setMinHeight(200);
        barsBox.setMinWidth(400);
        barsBox.setAlignment(Pos.BOTTOM_CENTER);
        this.getChildren().add(barsBox);

        initBars(array);

        Button stop = new Button("Arrêter");
        Button start = new Button("Démarrer");
        HBox menu = new HBox(10, stop, start);
        menu.setAlignment(Pos.BOTTOM_RIGHT);
        this.getChildren().add(menu);

        drawArray(array);

        // Action du bouton "Démarrer" : lance le tri dans un nouveau thread
        start.setOnAction(e -> {
                new Thread(() -> {
                switch (choix) {
                    case "null":
                        System.err.println("Veuillez choisir un algorithme");
                        break;
                    case "QuickSort":
                        QuickSort quick = new QuickSort();
                        quick.setVisualListener(this);
                        quick.setPauseObjects(paused, pauseLock,speed);
                        quick.sort(array);
                        System.out.println(Arrays.toString(array));
                        break;
                    case "MergeSort":
                        MergeSort merge = new MergeSort();
                        merge.setVisualListener(this);
                        merge.setPauseObjects(paused, pauseLock, speed);
                        merge.sort(array);
                        System.out.println(Arrays.toString(array));
                        break;
                }
            }).start();
        });
        
        // Action du bouton "Stop" : met en pause ou relance l'animation
        stop.setOnAction(e -> {
            boolean currentlyPaused = paused.get();
            paused.set(!currentlyPaused);
            if (!paused.get()) {
                synchronized (pauseLock) {
                    pauseLock.notifyAll();
                }
            }
        });
    }

    /**
     * Initialise les rectangles représentant chaque valeur du tableau.
     *
     * @param arrayToDraw Tableau à représenter sous forme de barres.
     */

    private void initBars(int[] arrayToDraw) {
    barsBox.getChildren().clear();
    for (int val : arrayToDraw) {
        Rectangle rect = new Rectangle(40, val * 20);
        rect.setFill(Color.RED);
        barsBox.getChildren().add(rect);
    }
}

    /**
     * Met à jour la hauteur des barres pour refléter l'état actuel du tableau.
     * L'appel est fait sur le thread JavaFX via Platform.runLater.
     *
     * @param arrayToDraw Tableau à afficher.
     */
    private void drawArray(int[] arrayToDraw) {
        Platform.runLater(() -> {
            ObservableList children = barsBox.getChildren();
            for (int i = 0; i < arrayToDraw.length; i++) {
                Rectangle rect = (Rectangle) children.get(i);
                rect.setHeight(arrayToDraw[i] * 20);
            }
        });
    }

    /**
     * Méthode appelée lors d'une mise à jour du tableau pendant le tri.
     * Met à jour l'affichage et attend brièvement pour visualiser la transition.
     *
     * @param updatedArray Nouveau tableau à afficher.
     */
    private void onArrayUpdate(int[] updatedArray) {
        drawArray(updatedArray);
        try {
            Thread.sleep(200); 
        } catch (InterruptedException ignored) {}
    }

     /**
     * Implémentation de l'interface VisualUpdateListener.
     * Cette méthode est appelée par l'algorithme de tri à chaque modification du tableau.
     *
     * @param updatedArray Tableau mis à jour.
     */
@Override
    public void onArrayUpdated(int[] updatedArray) {
        drawArray(updatedArray);
    }
}