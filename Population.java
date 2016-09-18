import java.util.Scanner;
import java.text.DecimalFormat;

public class Population {
    public static void main(String[] args) {

        DecimalFormat df = new DecimalFormat("#0.000");
        Scanner keyb = new Scanner(System.in);

        int anneeInitiale = 2011;        // annee initiale
        double tauxCroissance = 1.2;     // taux de croissance, en %
        double populationInitiale = 7.0; // population initiale, en milliard d'humains

        double populationCourante = populationInitiale; // population mondiale pour l'annee courante
        int anneeCourante = anneeInitiale;              // annee de calcul

        System.out.println("====---- PARTIE 1 ----====");
        System.out.println("Population en " + anneeCourante + " : " + df.format(populationCourante));

        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/


        // ===== PARTIE 1 =====
		// utilisez cette instruction pour poser votre question :
		
        int anneeFinale;
		do  {
			System.out.print("Quelle année (> " + anneeInitiale + ") ? ");
			anneeFinale = keyb.nextInt();
			
		} while (!(anneeInitiale < anneeFinale));
		
		int temps = anneeFinale - anneeInitiale;
		
		double resultat = populationInitiale * (Math.exp(temps*tauxCroissance/100));
		
		
		System.out.println("Population en " + anneeFinale + " : " + df.format(resultat) );

        // ===== PARTIE 2 =====
        System.out.println("\n====---- PARTIE 2 ----====");
        
        double populationAttendue;
        double populationEstimee;
        int i = 1;
        
        do  {
        	
        	System.out.print("Combien de milliards (> 7.0) ? ");
        	populationAttendue = keyb.nextDouble();
        	
        } while (!(populationInitiale < populationAttendue));
        
        
        do {
        	
        	populationEstimee = populationInitiale * (Math.exp(i * tauxCroissance/100));
        	
        	System.out.println("Population en " + (anneeInitiale + i) + " : " + df.format(populationEstimee));
        	i++;
        	
        	
        } while (populationEstimee < populationAttendue);
        



        // ===== PARTIE 3 =====
        System.out.println("\n====---- PARTIE 3 ----====");

        
        double populationAttendue2;
        populationEstimee = 7.0;
        Double populationBase = 7.0;
        i = 1;
        Double arrondisseur = 1000.0;
        
        
        
        do {
        	
        	if ((populationEstimee * (Math.exp(tauxCroissance/100))) >= (populationBase *2)) {
        		
        		
        		
            	populationEstimee = populationEstimee * (Math.exp(tauxCroissance/100));
            	
            	populationBase *= 2;
        		tauxCroissance /= 2;
            	
            	System.out.println("Population en " + (anneeInitiale + i) + " : " + df.format(populationEstimee) +" ; taux de croissance : " + tauxCroissance + "%");
            	i++;
        		
        	} else {
        		
        		populationEstimee = populationEstimee * (Math.exp(tauxCroissance/100));
            	System.out.println("Population en " + (anneeInitiale + i) + " : " + df.format(populationEstimee) +" ; taux de croissance : " + tauxCroissance + "%");
            	i++;
        		
        		
        	}
        	
        	
        } while (populationEstimee < populationAttendue);
        

        keyb.close();
        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/
    }
}
