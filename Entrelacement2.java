import java.util.Scanner;

class Entrelacement {

    private static Scanner clavier = new Scanner(System.in);
    public static void main(String[] args) {
        int[] tab1 = {1, 7, 6};
        int taille = tab1.length;
        int[] tab2 = new int[taille];

        System.out.println("Saisie du tableau : ");
        // lecture du second tableau
        for(int i = 0; i < taille; ++i) {
            System.out.println("Entrez une valeur pour l'élément " + i + " : ");
            tab2[i] = clavier.nextInt();
        }

        // affichage
        System.out.println("Les tableaux à entrelacer sont : ");
        for(int i = 0; i < taille; ++i) {
            System.out.print(tab1[i] + " " );
        }
        System.out.println();

        for(int i = 0; i < taille; ++i) {
            System.out.print(tab2[i] +  " " );
        }
        System.out.println();

        /*******************************************
        * Completez le programme a partir d'ici.
        *******************************************/
        
        int[] tab3 = new int[taille*2];
        
        int j = 0;
        
        for (int i = 0; i< taille;i++){
        	
        	tab3[j] = tab1[i];
        	j=j+2;
        	
        }
        
        j=1;
        
        for (int i = 0; i< taille;i++){
        	
        	tab3[j] = tab2[i];
        	j=j+2;
        	
        }
         
        String resultat = "";
        for (int elem : tab3){
        	
        	resultat = resultat + elem + " ";
        	
        }
        System.out.println("Le résultat est :");
        System.out.println(resultat);
        
        
        /*******************************************
        * Ne rien modifier apres cette ligne.
        *******************************************/

    }

}
