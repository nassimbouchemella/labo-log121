import java.util.ArrayList;
import java.util.List;

public class Controleur implements Observateur{
    private double tempCourante = 22.0;
    private double cO2Courant = 600.0;
    private boolean climatisation = false;
    private boolean ventilation = false;
    private boolean chauffage = false;

    public void reglerTemperature(double valeur){
        if(valeur<22.0){
            if(climatisation){
                System.out.println("--> Contrôleur : climatisation arrêtée.");
                climatisation = false;
            }
            if(!chauffage){
                System.out.println("--> Contrôleur : Chauffage démarré.");
                chauffage = true;
            }

        }else if(valeur>22.0){
            if(chauffage){
                System.out.println("--> Contrôleur : chauffage arrêtée.");
                chauffage = false;
            }
            if(!climatisation){
                System.out.println("--> Contrôleur : Climatisation démarrée.");
                climatisation = true;
            }
        }else{
            if(chauffage){
                System.out.println("--> Contrôleur : chauffage arrêtée.");
                chauffage = false;
            }
            if(climatisation){
                System.out.println("--> Contrôleur : climatisation arrêtée.");
                climatisation = false;
            }
        }
    }

    public void reglerCO2(double valeur){
        if(valeur<=1000.0){
            if(ventilation){
                System.out.println("--> Contrôleur : ventilation arrêtée.");
                ventilation = false;
            }
        }else if(!ventilation){
            System.out.println("--> Contrôleur : Ventilation démarrée.");
            ventilation = true;
        }
    }

    @Override
    public void update(double valeur) {
        if(valeur<=35.0 && valeur >= 10.0){
            tempCourante = valeur;
            reglerTemperature(tempCourante);
        }else{
            cO2Courant = valeur;
            reglerCO2(cO2Courant);
        }
    }
}
