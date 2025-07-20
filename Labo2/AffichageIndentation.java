/**
 * Cette classe représente un affiche par indentation.
 * elle est utilisé lorsque l'on souhaite afficher le chemin avec des tab pour chaque niveau
 * Elle implémente l'interface strategieAffichage.
 */

import java.util.Collections;
import java.util.Iterator;

public class AffichageIndentation implements StrategieAffichage{
 
  /**
 * Affiche le chemin complet.
 *
 * @param e un elementDessin
 * @param niveau représente le niveau de l'élement
 * @return void
 */
    @Override   
    public void afficher(ElementDessin e, int niveau){
        Iterator<ElementDessin> it = e.getIterator();
        System.out.println("  ".repeat(niveau) + e.getNom());
        niveau ++;
        while(it.hasNext()) {
        ElementDessin enfant = it.next();
        afficher(enfant, niveau + 1);
        }
    }
}
