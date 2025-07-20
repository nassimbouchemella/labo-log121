package com.example;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Vue principale de l'application JavaFX.
 * <p>
 * Cette classe étend VBox et permet de définir les composants de la vue.
 * Elle récupère le Stage afin de changer de vue ainsi qu'une valeure pour son spacing.
 */

public class MainView extends VBox{
    private Stage stage;
    private Scene otherScene;
    private boolean appliqué = false;
    
    public MainView(double spacing, Stage stage){
        super(spacing);

        this.stage = stage;

        ObservableList components = this.getChildren();


        Label algoText = new Label("Algorithme de tri:");
        ChoiceBox<String> triChoiceBox = new ChoiceBox<>();
        triChoiceBox.getItems().addAll("QuickSort","MergeSort");
        HBox algoHbox = new HBox(10);
        algoHbox.getChildren().addAll(algoText,triChoiceBox);


        Label arrayText = new Label("Collectiond d'entier à trier:");
        TextField arrayTF = new TextField();
        HBox arrayHbox = new HBox(20);
        arrayHbox.getChildren().addAll(arrayText,arrayTF);

        Label vitesseText = new Label("vitesse de la simulation:");
        ChoiceBox<String> vitesseChoiceBox = new ChoiceBox<>();
        vitesseChoiceBox.getItems().addAll("Lent","Rapide");
        HBox vitesseHbox = new HBox(20);
        vitesseHbox.getChildren().addAll(vitesseText,vitesseChoiceBox);

        Button btn1 = new Button();
        btn1.setText("OK");
        Button btn2 = new Button();
        btn2.setText("Annuler");
        Button btn3 = new Button();
        btn3.setText("Appliquer");
        btn1.setPrefWidth(80);
        btn2.setPrefWidth(80);
        btn3.setPrefWidth(80);
        HBox btnHbox = new HBox(20);
        btnHbox.getChildren().addAll(btn1,btn2,btn3);
        btnHbox.setAlignment(Pos.CENTER_RIGHT);
        btnHbox.setPadding(new javafx.geometry.Insets(0, 10, 0, 0));

        this.getChildren().addAll(algoHbox,arrayHbox,vitesseHbox,btnHbox);
        this.setAlignment(Pos.CENTER);
        this.setPadding(new javafx.geometry.Insets(10, 10, 10, 10));


        btn2.setOnAction(e -> {
            arrayTF.clear();
            triChoiceBox.getSelectionModel().clearSelection();
            vitesseChoiceBox.getSelectionModel().clearSelection();
        });

        btn3.setOnAction(e -> {
            try {
                String text = arrayTF.getText();
                if (text == null || text.trim().isEmpty()) {
                    throw new IllegalArgumentException("Le champ est vide.");
                }

                String[] textArray = text.split(",");
                int[] array = new int[textArray.length];

                int i = 0;
                for (String nombre : textArray) {
                    array[i++] = Integer.parseInt(nombre.trim());
                }

                String choix = triChoiceBox.getValue();
                if (choix == null) {
                    throw new IllegalArgumentException("Veuillez choisir un algorithme de tri.");
                }

                long delay;
                if (vitesseChoiceBox.getValue() == null) {
                    throw new IllegalArgumentException("Le champ vitesse de lecture est vide.");
                }else if ("rapide".equals(vitesseChoiceBox.getValue())) {
                    delay = 200L;
                } else{
                    delay = 500L;
                }
                
                appliqué = true;
                otherScene = new Scene(new SecondView(20.0, stage, array, choix, delay), 400, 300);

            } catch (NumberFormatException ex) {
                System.out.println("❌ Veuillez entrer uniquement des nombres séparés par des virgules (ex: 3,5,1)");
            } catch (IllegalArgumentException ex) {
                System.out.println("❌ " + ex.getMessage());
            }
        });

        btn1.setOnAction(e -> {
            if(appliqué){
                stage.setScene(otherScene);
                    stage.show();
            }else{
                System.out.println("Veuillez appliqué les paramètres d'abord.");
            }
            
        });
    }

/**
     * Méthode permettant de changer de scène.
     * Elle est appelé lorsque l'on souhaite afficher le graphique.
     * @param otherScene représente la seconde vue avec le graphique.
     * 
*/
    public void setOtherScene(Scene otherScene)
    {
        this.otherScene = otherScene;
    }

}
