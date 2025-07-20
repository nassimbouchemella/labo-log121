/**
 * Cette classe représente un élément Dessin.
 * elle est utilisé pour instancier un Cercle.
 * Elle implémente la classe ElementDessin.
 */

import java.util.Collections;
import java.util.Iterator;

public class Cercle implements ElementDessin {
    private String nom;

    public Cercle (String name){
        this.nom = name;
    }

    public String getNom(){
        return this.nom;
    }

/**
 * renvoie un itérateur.
 *
 * @return Iterator
 */
    public Iterator<ElementDessin> getIterator(){
        return Collections.emptyIterator();
    }
}
