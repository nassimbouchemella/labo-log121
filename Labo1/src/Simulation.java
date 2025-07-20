import java.util.Scanner;

public class Simulation {

    public static void main(String[] args){
        Capteur a = new CapteurTemperature();
        Capteur b = new CapteurCO2();
        Controleur controleur = new Controleur();

        Scanner scanner = new Scanner(System.in);

        a.add(controleur);
        b.add(controleur);

        while (true){
            try{
                System.out.println("Entrez une nouvelle température :");
                double temperature = Double.parseDouble(scanner.nextLine());
                a.setValeur(temperature);

                System.out.println("Entrez une nouvelle concentration de CO2 : ");
                double co2 = Double.parseDouble(scanner.nextLine());
                b.setValeur(co2);

                System.out.println("Voulez-vous continuer ?");
                String result = scanner.nextLine();
                if(result.equals("non")){
                    break;
                }

            }catch (NumberFormatException e){
                System.out.println("Une erreur est survenue, entrez des nombres valides.");
            }
        }
    }
}
