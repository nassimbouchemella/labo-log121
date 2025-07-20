package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Implémentation du tri rapide (QuickSort) basée sur un template de tri abstrait.
 * Cette classe hérite de SortTemplate et fournit les méthodes nécessaires.
 * pour diviser, trier récursivement et fusionner les sous-tableaux selon l'algorithme QuickSort.
 */

public class QuickSort extends SortTemplate{
    
/**
     * Divise le tableau en deux sous-tableaux autour d'un pivot.
     * Tous les éléments inférieurs ou égaux au pivot sont placés dans le premier sous-tableau,
     * les éléments supérieurs dans le second.
     *
     * @param array Le tableau à diviser.
     * @return Un tableau de deux sous-tableaux : [gauche, droite].
*/

@Override
    protected int[][] divide(int[] array) {
    int pivot = array[0];
    int count = 0; 
    List<Integer> listGauche = new ArrayList<>();
    List<Integer> listDroite = new ArrayList<>();
    List<Integer> pivots = new ArrayList<>();
    pivots.add(pivot);

// Répartition des éléments autour du pivot
    for (int i = 1; i < array.length; i++) {
        if (array[i] < pivot) {
            listGauche.add(array[i]);
        } else if(array[i] == pivot){
            count++;
            pivots.add(array[i]);
        } else {
            listDroite.add(array[i]);
        }
    }

// Construction du sous-tableau gauche (éléments < pivot et pivots)
    int[] gauche = new int[listGauche.size() + count + 1];
    int[] droite = new int[listDroite.size()];
    int index = 0;

    for (int val : listGauche) {
        gauche[index++] = val;
    }
    for (int val : pivots) {
        gauche[index++] = val;
    }
    for (int k = 0; k < droite.length; k++) {
        droite[k] = listDroite.get(k);
    }

    return new int[][] { gauche, droite };
}

/**
     * Renvoie un boolean qui indique si le tableau doit encore être divisé.
     *
     * @param array Le tableau à diviser.
     * @return true or false.
*/

@Override
    protected boolean shouldRecurse(int[] array){
        if (array.length <= 1) return false;
        int first = array[0];
        for (int val : array) {
        if (val != first) return true;
        }
        return false;
    }

/**
     * Méthode récursive du tri
     *
     * @param array Le tableau à diviser.
*/

@Override
    protected void recursiveSort(int[] array){
        sort(array);
    }

/**
     * Fusionne les deux tableaux
     *
     * @param array1 @param array2 Les deux tableaux à fusionner.
     * @return le tableau fusionné
*/

@Override
   protected int[] merge(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        int i=0;

        for(int element : array1){
            result[i]=element;
            i++;
        }

        for(int element : array2){
            result[i]=element;
            i++;
        }

        
        return result;
    }
}
