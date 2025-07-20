package com.example;

import java.util.Arrays;

/**
 * Implémentation du tri (MergeSort) basée sur un template de tri abstrait.
 * Cette classe hérite de SortTemplate et fournit les méthodes nécessaires.
 * pour diviser, trier récursivement et fusionner les sous-tableaux selon l'algorithme MergeSort.
 */

public class MergeSort extends SortTemplate{

/**
     * Divise le tableau en deux sous-tableaux égaux.
     * Tous les éléments inférieurs ou égaux au milieu sont placés dans le premier sous-tableau,
     * les éléments supérieurs dans le second.
     *
     * @param array Le tableau à diviser.
     * @return Un tableau de deux sous-tableaux : [gauche, droite].
*/


@Override
    protected  int[][] divide(int[] array){
        int milieu = array.length/2;
        int[] sousCol1 = new int[milieu];
        int[] sousCol2 = new int[array.length - milieu];
        for(int i = 0; i<milieu ; i++){
            sousCol1[i] = array[i];
        }
        for(int i = 0; i<sousCol2.length ; i++){
            sousCol2[i] = array[milieu + i];
        }
        return new int[][] {sousCol1,sousCol2};
    }

/**
     * Renvoie un boolean qui indique si le tableau doit encore être divisé.
     *
     * @param array Le tableau à diviser.
     * @return true or false.
*/

@Override
    protected boolean shouldRecurse(int[] array){
        return array.length>1 ;
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
    protected int[] merge(int[] array1, int[] array2){
        int[] result = new int[array1.length + array2.length];
        int i = 0, j = 0, k = 0;

        while (i < array1.length && j < array2.length) {
            if (array1[i] <= array2[j]) {
                result[k++] = array1[i++];
            } else {
                result[k++] = array2[j++];
            }
        }

        while (i < array1.length) result[k++] = array1[i++];
        while (j < array2.length) result[k++] = array2[j++];

        return result;
    }

}
