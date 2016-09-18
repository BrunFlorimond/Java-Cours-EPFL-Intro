import java.util.Scanner;

class Cycliste {
    private static Scanner clavier = new Scanner(System.in);
    public static void main(String[] args) {

        double t = 0.0;    // temps, en min.
        double d = 0.0;    // distance, en km
        double v = 30.0;   // vitesse, en km/h
        double acc = 0.0;  // accélération, en km/h/min
        double p = 175.0;  // puissance, en W

        /******************************************
         * Completez le programme a partir d'ici.
         *******************************************/
        double masse = 0.0;
        double vitesseVent = 0.0;
        double vitesseVentDiff = 0.0;
        double distanceTotale = 0.0;
        double distanceSommet = 0.0;
        double penteAvantSommet = 0.0;
        double penteApresSommet = 0.0;
        double accPente = 0.0;
        double accVent = 0.0;
        double accPoussee = 0.0;
        boolean reachSommet = false;
        
        double dt = 1.0/60.0;
        double pmin = 10.0;
        
        
        
        do{
        	
            System.out.print("masse du cycliste (entre 40 et 180 ) ? ");
            masse = clavier.nextDouble();
        	
        	
        	
        } while(!(masse >= 40 && masse <= 180));
        
        do{
        	
            System.out.print("vent (entre -20 et +20 km/h) ? ");
            vitesseVent = clavier.nextDouble();
        	
        	
        	
        } while(!( vitesseVent>= -20 && vitesseVent <= 20));
        
        do{
        	
            System.out.print("distance du parcours (<= 200 km) ? ");
            distanceTotale = clavier.nextDouble();
        	
        	
        	
        } while(!(distanceTotale > 0 && distanceTotale<= 200));
        
        do{
        	
            System.out.print("distance au sommet du col (<= ");
            System.out.print(distanceTotale-10);
            System.out.print(" km) ? ");
            distanceSommet = clavier.nextDouble();
        	
        	
        	
        } while(!(distanceSommet>0 && distanceSommet <= (distanceTotale-10)));
        
        do{
        	
            System.out.print("pente moyenne jusqu'au sommet (<= 20 %) ? ");
            penteAvantSommet = clavier.nextDouble();
        	
        	
        	
        } while(!(penteAvantSommet <= 20 && penteAvantSommet > 0));
        
        do{
        	
            System.out.print("pente moyenne après le sommet (<= 20 %) ? ");
            penteApresSommet = clavier.nextDouble();
        	
        	
        	
        } while(!(penteApresSommet <= 20 && penteApresSommet > 0));
        

        // affichage des informations courantes
        
        do{
        	
            double roundedtime = Math.round(t);
            if (Math.abs(roundedtime - t) < 1e-5 && (int)roundedtime % 5 == 0) {
                System.out.format("%.0f, %.2f, %.2f, %.4f,  %.2f\n",
                                  t, d, v, acc, p);
            }
            
                        
            
            //calcul de la vitesse differentielle du vent
            vitesseVentDiff = v - vitesseVent;
            
            //calcul de la perte de puissance en raison de la fatigue
            
        	if (d < distanceSommet && p > pmin){
            	p = p - (0.5 * dt);
        	}
            
            
            //Calcul de l'acceleration
            
            //due a la pente
        	
        	if (d < distanceSommet) {
        		
        		accPente = -2118.96 * Math.sin(Math.atan(penteAvantSommet/100.0));
        		
        		
        		
        	} else {
        		
        		accPente = -2118.96 * Math.sin(Math.atan((-1.0)*penteApresSommet/100.0));
        		
        		
        	}
            
            
            //Due au vent
            
            	accVent = (-5*vitesseVentDiff*Math.abs(vitesseVentDiff))/ masse;
            	
            	
            //Due à sa poussee
            	
            	if ( v>0 && p > 0){
            		
            		accPoussee = 777.6 * (p/(v * masse));
            		
            		
            	} else {
            		
            		accPoussee = 0;
            		
            	}
            	
        	//TotalPoussee
            	acc = (accPente + accVent + accPoussee);
            	
            	if (Math.abs(acc) <= 1e-5) {
            		
            		acc = 0;
            		
            	}
            	
            	
        	//Calcul de la vitesse
            	
            	v = v + acc * dt;
            	
        	//Calcul de la distance
            	
            	d = d + v * (dt/60.0);
            	
          	//Ajout du pas de temps
            	
            	t = t + dt;
            	
            	if (d>distanceSommet) {
            		
            		if (reachSommet == false ) {
            			
            			System.out.format("## Bernard a atteint le sommet en %.0f min.\n", t);
            			
            			reachSommet = true;	
            			
            		}
            		
            		p = pmin;
            		
            	}
            	
            	if (v < 3) {
            		
                    System.out.println("## Bernard abandonne, il n'en peut plus");
                    System.out.format("%.0f, %.2f, %.2f, %.4f,  %.2f\n",
                                      t, d, v, acc, p);
            		
            		return;
            	}
            	
        	
        	
        } while(d<distanceTotale);


        


        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/

        System.out.println("## Bernard est arrivé");
        System.out.format("%.0f, %.2f, %.2f, %.4f, %.2f\n",
                          t, d, v, acc, p);
    }
}
