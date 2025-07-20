/**
 * Cette classe représente un affiche par chemin complet.
 * elle est utilisé lorsque l'on souhaite afficher le chemin complet
 * Elle implémente l'interface strategieAffichage.
 */

import java.util.Collections;
import java.util.Iterator;

public class AffichageCheminComplet implements StrategieAffichage {
    
/**
 * Affiche un element.
 *
 * @param e un elementDessin
 * @param niveau le deuxième entier
 * @return void
 */
    @Override
    public void afficher(ElementDessin e, int niveau) {
        afficherAvecChemin(e, e.getNom());
    }

    /**
 * Affiche le chemin complet.
 *
 * @param e un elementDessin
 * @param chemin représente le niveau de la tab
 * @return void
 */

    private void afficherAvecChemin(ElementDessin e, String chemin) {
        System.out.println(chemin);
        Iterator<ElementDessin> it = e.getIterator();
        while (it.hasNext()) {
            ElementDessin enfant = it.next();
            afficherAvecChemin(enfant, chemin + "." + enfant.getNom());
        }
    }
}
