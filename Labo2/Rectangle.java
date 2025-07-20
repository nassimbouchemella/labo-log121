/**
 * Cette classe représente un élément Dessin.
 * elle est utilisé pour instancier un Rectangle.
 * Elle implémente la classe ElementDessin.
 */

import java.util.Collections;
import java.util.Iterator;

public class Rectangle implements ElementDessin{
    private String nom;

    public Rectangle (String name){
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
