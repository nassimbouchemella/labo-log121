/**
 * Cette classe représente l'app.
 * elle est utilisé lorsque l'on lance l'application.
 */

import java.util.Scanner;
import java.util.Collections;
import java.util.Iterator;

public class DessinApplication {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le dessin à tester :");
        System.out.println("1- Dessin avec trois niveaux\n2- Dessin avec deux niveaux\n3- Dessin avec un niveau (une forme seulement)");
        int choix1 = Integer.parseInt(scanner.nextLine());

        DessinComposite d1 = new DessinComposite("Dessin1");
        switch(choix1){
            case 1:{
                ElementDessin c1 = new Cercle("Cercle1");
                DessinComposite d2 = new DessinComposite("Dessin2");
                    DessinComposite d3 = new DessinComposite("Dessin3");
                        ElementDessin c2 = new Cercle("Cercle2");
                        ElementDessin c3 = new Cercle("Cercle3");
                    DessinComposite d4 = new DessinComposite("Dessin4");
                        ElementDessin t1 = new Triangle("Triangle1");
                        ElementDessin t2 = new Triangle("Triangle2");
                    ElementDessin r1 = new Rectangle("Rectangle1");
                d3.ajouter(c2);
                d3.ajouter(c3);
                d4.ajouter(t1);
                d4.ajouter(t2);
                d2.ajouter(d3);
                d2.ajouter(d4);
                d2.ajouter(r1);
                d1.ajouter(c1);
                d1.ajouter(d2);
                break;
                }
            case 2:{
                DessinComposite d2 = new DessinComposite("Dessin2");
                    ElementDessin c1 = new Cercle("Cercle1");
                    ElementDessin c2 = new Cercle("Cercle2");
                    ElementDessin t1 = new Triangle("Triangle1");
                    ElementDessin t2 = new Triangle("Triangle2");
                    ElementDessin r1 = new Rectangle("Rectangle1");
                d2.ajouter(c1);
                d2.ajouter(c2);
                d2.ajouter(t1);
                d2.ajouter(t2);
                d2.ajouter(r1);
                d1.ajouter(d2);
                break;
                }
            case 3:{
                ElementDessin c1 = new Cercle("Cercle1");
                ElementDessin t1 = new Triangle("Triangle1");
                ElementDessin r1 = new Rectangle("Rectangle1");
                d1.ajouter(c1);
                d1.ajouter(t1);
                d1.ajouter(r1);
                break;
                }
            default:
                System.out.println("Choix invalide !");
                return;
        }

        System.out.println("Entrez la stratégie d'affichage à utiliser");
        System.out.println("1- Indentation\n2- Chemin complet");
        int choix2 = Integer.parseInt(scanner.nextLine());

        Context con = new Context();

        switch(choix2){
            case 1: 
                con.setStrategie(new AffichageIndentation());
                break;
            case 2: 
                con.setStrategie(new AffichageCheminComplet());
                break;
            default : 
                System.out.println("Erreur ! vous n'aveez pas séléctionné un bon paramètre !");
                break;

        }
        con.executer(d1,0);
        scanner.close();
    }
}
