/**
 * Cette interafce représente un élément Dessin.
 * elle est utilisé pour instancier un groupe de forme ou une forme.
 * Elle implémente la classe ElementDessin.
 * Elle utilise le patron Composite
 */

import java.util.Iterator;

public interface ElementDessin {
    String getNom();
    Iterator<ElementDessin> getIterator();
}
