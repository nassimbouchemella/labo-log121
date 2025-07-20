/**
 * Cette classe représente la vue princiapale.
 * Elle utilise le framework JavaFX.
 */

package com.example;

import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainView extends VBox{
    public MainView(double spacing){
        super(spacing);

        ObservableList components = this.getChildren();


        Label paiementText = new Label("Mode de paiement:");
        ChoiceBox<String> modeDePaiementChoiceBox = new ChoiceBox<>();
        modeDePaiementChoiceBox.getItems().addAll("Carte de crédit","Carte cadeau","Paiement à la livraison");
        HBox modePaiement = new HBox(10);
        modePaiement.getChildren().addAll(paiementText,modeDePaiementChoiceBox);


        Label numCarteText = new Label("Numéro de carte de crédit:");
        TextField numCarteTF = new TextField();
        HBox numCarte = new HBox(20);
        numCarte.getChildren().addAll(numCarteText,numCarteTF);

        Label dateExpirationText = new Label("Date d'expiration de la carte:");
        TextField dateExpirationTF = new TextField();
        HBox expirationHBox = new HBox(20);
        expirationHBox.getChildren().addAll(dateExpirationText,dateExpirationTF);

        Label codeText = new Label("Code de sécurité de la carte:");
        TextField codeTF = new TextField();
        HBox codeHBox = new HBox(20);
        codeHBox.getChildren().addAll(codeText,codeTF);

        VBox creditVBox = new VBox();
        creditVBox.getChildren().addAll(numCarte,expirationHBox,codeHBox);

        Label numCarteCadeauLabel = new Label("Numéro de carte cadeau:");
        TextField numCarteCadeauTF = new TextField();
        HBox cadeauHBox = new HBox(20);
        cadeauHBox.getChildren().addAll(numCarteCadeauLabel, numCarteCadeauTF);



        Label adresseLivraisonText = new Label("Adresse de livraison:");
        TextField adresseLivraisonTF = new TextField();
        HBox livraisonHbox = new HBox(20);
        livraisonHbox.getChildren().addAll(adresseLivraisonText,adresseLivraisonTF);

        RadioButton adresseLivraisonRadio = new RadioButton();
        Label questionRadio = new Label("L'adresse de facturation est la même que l'adresse de livraison");
        HBox questionHbox = new HBox(20);
        questionHbox.getChildren().addAll(adresseLivraisonRadio,questionRadio);

        Label facturationText = new Label("Adresse de facturation:");
        TextField facturationTF = new TextField();
        HBox facturationHbox = new HBox(20);
        facturationHbox.getChildren().addAll(facturationText,facturationTF);

        Label optionLivraisonText = new Label("Option de livraison:");
        ChoiceBox<String> optionDeLivraisonChoiceBox = new ChoiceBox<>();
        optionDeLivraisonChoiceBox.getItems().addAll("Livraison en main propre","Se retrouver à l'extérieur","Laisser à la porte");
        components.addAll(
            modePaiement,
            creditVBox,
            cadeauHBox,           
            livraisonHbox,
            questionHbox,
            facturationHbox,
            optionDeLivraisonChoiceBox
        );
        

        new FormMediator(
    modeDePaiementChoiceBox,
    creditVBox,           
    cadeauHBox,          
    optionDeLivraisonChoiceBox,
    adresseLivraisonRadio,
    adresseLivraisonTF,
    facturationTF
);

    }
}
