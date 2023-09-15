import java.util.Scanner;

/*  TP1
 *  Cours 420-201 - Introduction à la programmation
 *  Groupe : 3 – mardi & vendredi
 *  Nom : Seaborn
 *  Prénom : Dimitri
 *  DA : 2351867
 */
public class Voyage3DS2351867 {
    public Voyage3DS2351867() {
        demanderInfosEtAfficherVoyage();
    }

    private void demanderInfosEtAfficherVoyage() {
        double distance;
        double temps;
        double prixEssence;
        double litreEssence;

        distance = lireDouble("Quelle distance avez-vous parcourue? ");
        temps = lireDouble("En combien de temps (en heure)? ");
        prixEssence = lireDouble("Quel est le prix de l'essence? ");
        litreEssence = lireDouble("Combien de litres d'essence avez-vous utilisés? ");
        afficherInfoVoyage(distance, temps, prixEssence, litreEssence);
    }

    private double lireDouble(String question) {
        double reponse;

        reponse = Double.parseDouble(lireString(question));
        return reponse;
    }

    private void tester_afficherInfoVoyage() {
        afficherInfoVoyage(100, 1, 1.0, 10);
        afficherInfoVoyage(1, 0.3, 22, 10);
        afficherInfoVoyage(5.5, 1.2, 2.7, 3.24);
    }

    private void afficherInfoVoyage(double distance, double temps, double prixEssence, double litreEssence) {
        double vitesseMoyenne;
        double consommationMoyenneAu100Km;
        double prixVoyage;
        String str;

        vitesseMoyenne = calculerVitesseMoyenne(distance, temps);
        consommationMoyenneAu100Km = calculerConsommationAu100Km(litreEssence, distance);
        prixVoyage = calculerPrixVoyage(litreEssence, prixEssence);
        str = "==================================================================\n";
        str += "Vous avez parcouru " + distance + " km en " + temps + " heures.\n";
        str += "Le prix de l'essence est de $" + prixEssence + ".\n";
        str += "Vous avez utilisé " + litreEssence + " litres d'essence.\n";
        str += "La vitesse moyenne de la voiture est de : " + vitesseMoyenne + " km/heure.\n";
        str += "Cette voiture a une consommation moyenne de : " + consommationMoyenneAu100Km + " litres/100 km.\n";
        str += "Le voyage a coûté $" + prixVoyage + ".\n";
        str += "==================================================================";
        System.out.println(str);
    }

    private double calculerPrixVoyage(double litreUtilise, double prixEssence) {
        double prixVoyage;

        prixVoyage = litreUtilise * prixEssence;
        return prixVoyage;
    }

    private double calculerVitesseMoyenne(double distance, double temps) {
        double vitesseMoyenne;

        vitesseMoyenne = distance / temps;
        return vitesseMoyenne;
    }

    private double calculerConsommationAu100Km(double litreUtilise, double distance) {
        double consommation;

        consommation = (100 * litreUtilise) / distance;
        return consommation;
    }

    private String lireString(String question) {
        Scanner sc;
        String reponse;

        sc = new Scanner(System.in);
        afficherQuestion(question);
        reponse = sc.nextLine();
        return reponse;
    }

    private void afficherQuestion(String str) {
        System.out.print(str);
    }

    public static void main(String[] args) {
        new Voyage3DS2351867();
    }
}
