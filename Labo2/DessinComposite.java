/**
 * Cette classe représente un élément Dessin.
 * elle est utilisé pour instancier un groupe de forme.
 * Elle implémente la classe ElementDessin.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Iterator;

public class DessinComposite implements ElementDessin{
    private String nom;
    private List<ElementDessin> enfants = new ArrayList<>();

    public DessinComposite(String nom) {
        this.nom = nom;
    }

    public void ajouter(ElementDessin e) {
        enfants.add(e);
    }

    public void enlever(ElementDessin e) {
        enfants.remove(e);
    }

    @Override
    public String getNom() {
        return nom;
    }

 /**
 * renvoie un itérateur.
 *
 * @return Iterator
 */
    @Override
    public Iterator<ElementDessin> getIterator() {
        return enfants.iterator();
    }
}
