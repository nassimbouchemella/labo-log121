package com.example;

import java.util.concurrent.atomic.AtomicBoolean;
import javafx.application.Platform;

/**
 * Classe abstraite servant de base pour les algorithmes de tri visuel.
 * <p>
 * Cette classe fournit le squelette général pour l'exécution d'un tri récursif
 * avec gestion de la visualisation et de la pause. Les algorithmes spécifiques
 * doivent implémenter les méthodes abstraites pour la division, la condition de récursion,
 * la récursion et la fusion.
 * </p>
 */
public abstract class SortTemplate {

    /** Listener pour mettre à jour la vue lors des modifications du tableau */
    protected VisualUpdateListener visualListener;

    /** Indique si le tri est en pause */
    protected AtomicBoolean paused;

    /** Objet de synchronisation pour la gestion de la pause */
    protected Object pauseLock = new Object();

    /** Délai (en millisecondes) entre chaque étape de visualisation */
    protected volatile long delay = 200L;

    /**
     * Définit le listener chargé de mettre à jour la visualisation.
     *
     * @param listener Instance de VisualUpdateListener à utiliser.
     */
    public void setVisualListener(VisualUpdateListener listener) {
        this.visualListener = listener;
    }

    /**
     * Lance le tri du tableau en utilisant la logique définie par les sous-classes.
     * <p>
     * Cette méthode divise le tableau, trie récursivement les sous-tableaux,
     * puis fusionne les résultats. À chaque modification, la vue est notifiée.
     * </p>
     *
     * @param array Tableau à trier.
     */
    public final void sort(int[] array) {
        if (shouldRecurse(array)) {
            int[][] divided = divide(array);
            int[] gauche = divided[0];
            int[] droite = divided[1];

            recursiveSort(gauche);
            recursiveSort(droite);

            int[] fusion = merge(gauche, droite);

            for (int i = 0; i < fusion.length; i++) {
                array[i] = fusion[i];
                notifyVisual(array);
                checkPause();
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException ignored) {}
            }
        }
    }

    /**
     * Configure les objets nécessaires pour la gestion de la pause et du délai.
     *
     * @param paused    Variable indiquant si la pause est active.
     * @param pauseLock Objet de synchronisation pour la pause.
     * @param delay     Délai entre chaque étape (en millisecondes).
     */
    public void setPauseObjects(AtomicBoolean paused, Object pauseLock, long delay) {
        this.paused = paused;
        this.pauseLock = pauseLock;
        this.delay = delay;
    }

    /**
     * Notifie le listener de visualisation d'une mise à jour du tableau.
     * L'appel est effectué sur le thread JavaFX via Platform.runLater.
     *
     * @param array Tableau à afficher.
     */
    protected void notifyVisual(int[] array) {
        if (visualListener != null) {
            Platform.runLater(() -> visualListener.onArrayUpdated(array.clone()));
        }
    }

    /**
     * Gère la pause de l'animation. Si la pause est activée, le thread attend jusqu'à la reprise.
     */
    protected void checkPause() {
        if (paused != null && paused.get()) {
            synchronized (pauseLock) {
                while (paused.get()) {
                    try {
                        pauseLock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    /**
     * Divise le tableau en sous-tableaux selon la logique de l'algorithme de tri.
     *
     * @param array Tableau à diviser.
     * @return Tableau de sous-tableaux.
     */
    protected abstract int[][] divide(int[] array);

    /**
     * Détermine si le tableau doit être traité récursivement.
     *
     * @param array Tableau à tester.
     * @return {@code true} si une récursion est nécessaire, {@code false} sinon.
     */
    protected abstract boolean shouldRecurse(int[] array);

    /**
     * Applique le tri récursif sur le tableau.
     *
     * @param array Tableau à trier.
     */
    protected abstract void recursiveSort(int[] array);

    /**
     * Fusionne deux sous-tableaux en un seul.
     *
     * @param array1 Premier sous-tableau.
     * @param array2 Second sous-tableau.
     * @return Tableau fusionné.
     */
    protected abstract int[] merge(int[] array1, int[] array2);
}