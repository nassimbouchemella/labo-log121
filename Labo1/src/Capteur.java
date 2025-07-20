import java.util.ArrayList;
import java.util.List;

public abstract class Capteur {
   protected double valeur;
   private List<Observateur> list = new ArrayList<>();

   public void add(Observateur o){
       list.add(o);
   }

   public void remove (Observateur o){
       list.remove(o);
   }

   public void notifier(){
       for(Observateur obs : list){
           obs.update(valeur);
       }
   }

    public double getValeur(){
        return this.valeur;
    }

    public void setValeur(double valeur){
        this.valeur = valeur;
        System.out.println("--> Contrôleur : nouvelle valeur reçue : mesure de " + getType() + " = " + getValeur() + " " + getUnite());
        notifier();
    }

    public List<Observateur> getList(){
       return this.list;
    }

    public abstract String getUnite();
    public abstract String getType();

}
