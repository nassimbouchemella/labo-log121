/**
 * Cette classe représente un élément Dessin.
 * elle est utilisé pour instancier un Triangle.
 * Elle implémente la classe ElementDessin.
 */

import java.util.Collections;
import java.util.Iterator;

public class Triangle implements ElementDessin {
private String nom;

    public Triangle (String name){
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
