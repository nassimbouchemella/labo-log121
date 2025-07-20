/**
 * Cette classe représente le contexte pour la stratégie.
 * elle est utilisé pour définir la stratégie choisie et l'exécuter.
 */

public class Context {
    private StrategieAffichage strategie;
    
    public void setStrategie(StrategieAffichage strategie){
        this.strategie = strategie;
    }

 /**
 * exécute la stratégie.
 *
 * @return Iterator
 */
    public void executer(ElementDessin e, int niveau){
        strategie.afficher(e,niveau);
    }
}
