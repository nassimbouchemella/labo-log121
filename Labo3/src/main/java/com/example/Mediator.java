/**
 * Cette interface représente le patron médiateur.
 * Elle permet de diminuer le couplage et les responsabilités.
 */

package com.example;

public interface Mediator {
    void modePaiementChanged(String mode);
    void adresseLivraisonChecked(boolean checked);
    void adresseLivraisonChanged(String newVal);
}
