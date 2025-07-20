package com.example;

/**
 * Interface permettant de notifier la vue lors d'une mise à jour du tableau.
 * <p>
 * Les classes qui implémentent cette interface peuvent recevoir des notifications
 * à chaque fois que le tableau subit une modification pendant le tri ou toute autre opération.
 * </p>
 */
public interface VisualUpdateListener {
    /**
     * Méthode appelée lorsqu'une mise à jour du tableau doit être reflétée visuellement.
     *
     * @param array Le tableau mis à jour.
     */
    void onArrayUpdated(int[] array);
}