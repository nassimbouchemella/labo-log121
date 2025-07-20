/**
 * Cette classe représente le médiateur du patron médiateur.
 * Elle utilise gère tous les évènements et changement de bouton.
 */

package com.example;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FormMediator implements Mediator {
    // Composants à gérer
    private ChoiceBox<String> modePaiementCB;
    private VBox creditFields;
    private HBox cadeauFields;
    private ChoiceBox<String> livraisonCB;
    private RadioButton sameAdresseRB;
    private TextField adresseLivraisonTF;
    private TextField adresseFacturationTF;

    
    private final String LAISSER_A_LA_PORTE = "Laisser à la porte";

/**
 * Associe tous les champs et composants au mediateur.
 */
    public FormMediator(
            ChoiceBox<String> modePaiementCB,
            VBox creditFields,
            HBox cadeauFields,
            ChoiceBox<String> livraisonCB,
            RadioButton sameAdresseRB,
            TextField adresseLivraisonTF,
            TextField adresseFacturationTF
    ) {
        this.modePaiementCB = modePaiementCB;
        this.creditFields = creditFields;
        this.cadeauFields = cadeauFields;
        this.livraisonCB = livraisonCB;
        this.sameAdresseRB = sameAdresseRB;
        this.adresseLivraisonTF = adresseLivraisonTF;
        this.adresseFacturationTF = adresseFacturationTF;

        setupListeners();
    }

    /**
 * ajoute des écouteurs sur chaque props.
 */
    private void setupListeners() {
        
        modePaiementCB.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            modePaiementChanged(newVal);
        });

        
        sameAdresseRB.selectedProperty().addListener((obs, oldVal, newVal) -> {
            adresseLivraisonChecked(newVal);
        });

        
        adresseLivraisonTF.textProperty().addListener((obs, oldVal, newVal) -> {
            adresseLivraisonChanged(newVal);
        });
    }
/**
 * supprime les champs qui ne sont pas en lien avec le mode de paiement
 *
 * @param mode le mode de paiement choisi
 * @return void
 */
    @Override
    public void modePaiementChanged(String mode) {
        if (mode.equals("Carte de crédit")) {
            creditFields.setVisible(true);
            cadeauFields.setVisible(false);
            
            if (!livraisonCB.getItems().contains(LAISSER_A_LA_PORTE)) {
                livraisonCB.getItems().add(LAISSER_A_LA_PORTE);
            } 
        } else if (mode.equals("Carte cadeau")) {
            creditFields.setVisible(false);
            cadeauFields.setVisible(true);
            if (!livraisonCB.getItems().contains(LAISSER_A_LA_PORTE)) {
                livraisonCB.getItems().add(LAISSER_A_LA_PORTE);
            }
        } else if (mode.equals("Paiement à la livraison")) {
            creditFields.setVisible(false);
            cadeauFields.setVisible(false);
            livraisonCB.getItems().remove(LAISSER_A_LA_PORTE);
        }
    }

    @Override
    public void adresseLivraisonChecked(boolean checked) {
        adresseFacturationTF.setDisable(checked);
        if (checked) {
            adresseFacturationTF.setText(adresseLivraisonTF.getText());
        }
    }

    @Override
    public void adresseLivraisonChanged(String newVal) {
        if (sameAdresseRB.isSelected()) {
            adresseFacturationTF.setText(newVal);
        }
    }
}
