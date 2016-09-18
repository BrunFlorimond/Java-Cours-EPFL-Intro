import java.util.Scanner;

class Romain {

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        int[] nombres = {1000, 500, 100, 50, 10, 5, 1 };
        String symboles = "MDCLXVI";

        /*******************************************
         * Complétez le programme à partir d'ici.
         *******************************************/
        String entree;
        int[] converti;
        final int MAX = 3999;
        
        
        boolean ok = true;
        
        
        ok = true;	
        System.out.print("Entrez un nombre en chiffres romains : ");
        entree = clavier.nextLine();
        entree = entree.toUpperCase();
        
        boolean verite = false;
        
        
	        for (int i = 0; i < entree.length();i++){
	        	     		
	        	char c = entree.charAt(i);
	        	
	        		
	        	for (int j = 0; j < symboles.length(); j++){
	        		
	        		verite = false;
	        		
	        		char d = symboles.charAt(j);
	        		
	        		if (c == d) {
	        			
	        			verite = verite | true;
	        			break;
	        			
	        		} else { verite = verite | false;}        		
	        		        		
	        	}    	
	        	
	        	ok = ok && verite;
	        	     	  	
	        	if(ok == false && i == entree.length()-1){System.out.println("Conversion impossible, nombre romain mal formé.");}
	        }
        
        
        
        if(ok == true){
        
	        converti = new int[entree.length()];
	        
	        String test = "";
	        int resultat = 0;

	        
			for (int i = 0; i < entree.length();i++){
	        	
				char c = entree.charAt(i);
				
				int index = symboles.indexOf(c);
				
				converti[i] = nombres[index];
 	
	        }
			
			for (int i = 0; i < converti.length;i++){
				
				if (!(i == converti.length-1)) {
				
					if (converti[i] < converti[i+1]){
						
						converti[i+1] = converti[i+1] - converti[i];
						converti[i] = 0;
						i =i+1;
						
					}
				
				}
				
				test = test + converti[i] + " ";
				resultat = resultat + converti[i];
				
				
			}
					
			
			System.out.println("arabes(" + entree + ") = " + resultat);
		
        }
		
		int entree2;
		
		do {
			
			System.out.print("Entrez un nombre (en chiffres arabes) compris entre 1 et " + MAX + " : ");
			
			entree2 = clavier.nextInt();
			
			
		}while (!(entree2 > 0 && entree2 < 4000));
		
		String entree2Str = String.valueOf(entree2);
		
		String resultat2 = "";
			
			
		if(entree2Str.length()==4){
			
			char c = entree2Str.charAt(0);
			
			if(Character.getNumericValue(c)<4){
				
				for(int i =0; i<Character.getNumericValue(c); i++){
					
					resultat2 = resultat2 + 'M';
					
				}
				
				
			} 
			
			
			c = entree2Str.charAt(1);
			
			if(Character.getNumericValue(c)<4){
				
				for(int i =0; i<Character.getNumericValue(c); i++){
					
					resultat2 = resultat2 + 'C';
					
				}
				
				
			} else if (Character.getNumericValue(c) == 4){
				
				resultat2 = resultat2 + "CD";
				
			} else if (Character.getNumericValue(c) == 5){
				
				resultat2 = resultat2 + "D";
				
			} else if (Character.getNumericValue(c) > 5 && Character.getNumericValue(c)<9){
				
				resultat2 = resultat2 + "D";
				
				for (int i = 0; i < (Character.getNumericValue(c)-5); i++){
					
					resultat2 = resultat2 + "C";
					
				}								  
				
			} else if (Character.getNumericValue(c) == 9){
				
				resultat2 = resultat2 + "CM";
				
			}
			
			
			c = entree2Str.charAt(2);
			
			if(Character.getNumericValue(c)<4){
				
				for(int i =0; i<Character.getNumericValue(c); i++){
					
					resultat2 = resultat2 + 'X';
					
				}
				
				
			} else if (Character.getNumericValue(c) == 4){
				
				resultat2 = resultat2 + "XL";
				
			} else if (Character.getNumericValue(c) == 5){
				
				resultat2 = resultat2 + "L";
				
			} else if (Character.getNumericValue(c) > 5 && Character.getNumericValue(c)<9){
				
				resultat2 = resultat2 + "L";
				
				for (int i = 0; i < (Character.getNumericValue(c)-5); i++){
					
					resultat2 = resultat2 + "X";
					
				}								  
				
			} else if (Character.getNumericValue(c) == 9){
				
				resultat2 = resultat2 + "XC";
				
			}
			
			c = entree2Str.charAt(3);
			
			if(Character.getNumericValue(c)<4){
				
				for(int i =0; i<Character.getNumericValue(c); i++){
					
					resultat2 = resultat2 + 'I';
					
				}
				
				
			} else if (Character.getNumericValue(c) == 4){
				
				resultat2 = resultat2 + "IV";
				
			} else if (Character.getNumericValue(c) == 5){
				
				resultat2 = resultat2 + "V";
				
			} else if (Character.getNumericValue(c) > 5 && Character.getNumericValue(c)<9){
				
				resultat2 = resultat2 + "V";
				
				for (int i = 0; i < (Character.getNumericValue(c)-5); i++){
					
					resultat2 = resultat2 + "I";
					
				}								  
				
			} else if (Character.getNumericValue(c) == 9){
				
				resultat2 = resultat2 + "IX";
				
			}
			
		} else if (entree2Str.length()==3){
			
			char c = entree2Str.charAt(0);
			
			if(Character.getNumericValue(c)<4){
				
				for(int i =0; i<Character.getNumericValue(c); i++){
					
					resultat2 = resultat2 + 'C';
					
				}
				
				
			} else if (Character.getNumericValue(c) == 4){
				
				resultat2 = resultat2 + "CD";
				
			} else if (Character.getNumericValue(c) == 5){
				
				resultat2 = resultat2 + "D";
				
			} else if (Character.getNumericValue(c) > 5 && Character.getNumericValue(c)<9){
				
				resultat2 = resultat2 + "D";
				
				for (int i = 0; i < (Character.getNumericValue(c)-5); i++){
					
					resultat2 = resultat2 + "C";
					
				}								  
				
			} else if (Character.getNumericValue(c) == 9){
				
				resultat2 = resultat2 + "CM";
				
			}
			
			
			c = entree2Str.charAt(1);
			
			if(Character.getNumericValue(c)<4){
				
				for(int i =0; i<Character.getNumericValue(c); i++){
					
					resultat2 = resultat2 + 'X';
					
				}
				
				
			} else if (Character.getNumericValue(c) == 4){
				
				resultat2 = resultat2 + "XL";
				
			} else if (Character.getNumericValue(c) == 5){
				
				resultat2 = resultat2 + "L";
				
			} else if (Character.getNumericValue(c) > 5 && Character.getNumericValue(c)<9){
				
				resultat2 = resultat2 + "L";
				
				for (int i = 0; i < (Character.getNumericValue(c)-5); i++){
					
					resultat2 = resultat2 + "X";
					
				}								  
				
			} else if (Character.getNumericValue(c) == 9){
				
				resultat2 = resultat2 + "XC";
				
			}
			
			c = entree2Str.charAt(2);
			
			if(Character.getNumericValue(c)<4){
				
				for(int i =0; i<Character.getNumericValue(c); i++){
					
					resultat2 = resultat2 + 'I';
					
				}
				
				
			} else if (Character.getNumericValue(c) == 4){
				
				resultat2 = resultat2 + "IV";
				
			} else if (Character.getNumericValue(c) == 5){
				
				resultat2 = resultat2 + "V";
				
			} else if (Character.getNumericValue(c) > 5 && Character.getNumericValue(c)<9){
				
				resultat2 = resultat2 + "V";
				
				for (int i = 0; i < (Character.getNumericValue(c)-5); i++){
					
					resultat2 = resultat2 + "I";
					
				}								  
				
			} else if (Character.getNumericValue(c) == 9){
				
				resultat2 = resultat2 + "IX";
				
			}
			
			
		
			
			
			
			
		} else if (entree2Str.length()==2){
			
			char c = entree2Str.charAt(0);
			
			if(Character.getNumericValue(c)<4){
				
				for(int i =0; i<Character.getNumericValue(c); i++){
					
					resultat2 = resultat2 + 'X';
					
				}
				
				
			} else if (Character.getNumericValue(c) == 4){
				
				resultat2 = resultat2 + "XL";
				
			} else if (Character.getNumericValue(c) == 5){
				
				resultat2 = resultat2 + "L";
				
			} else if (Character.getNumericValue(c) > 5 && Character.getNumericValue(c)<9){
				
				resultat2 = resultat2 + "L";
				
				for (int i = 0; i < (Character.getNumericValue(c)-5); i++){
					
					resultat2 = resultat2 + "X";
					
				}								  
				
			} else if (Character.getNumericValue(c) == 9){
				
				resultat2 = resultat2 + "XC";
				
			}
			
			c = entree2Str.charAt(1);
			
			if(Character.getNumericValue(c)<4){
				
				for(int i =0; i<Character.getNumericValue(c); i++){
					
					resultat2 = resultat2 + 'I';
					
				}
				
				
			} else if (Character.getNumericValue(c) == 4){
				
				resultat2 = resultat2 + "IV";
				
			} else if (Character.getNumericValue(c) == 5){
				
				resultat2 = resultat2 + "V";
				
			} else if (Character.getNumericValue(c) > 5 && Character.getNumericValue(c)<9){
				
				resultat2 = resultat2 + "V";
				
				for (int i = 0; i < (Character.getNumericValue(c)-5); i++){
					
					resultat2 = resultat2 + "I";
					
				}								  
				
			} else if (Character.getNumericValue(c) == 9){
				
				resultat2 = resultat2 + "IX";
				
			}
			
			
		} else if (entree2Str.length()==1){
			
			char c = entree2Str.charAt(0);
			
			if(Character.getNumericValue(c)<4){
				
				for(int i =0; i<Character.getNumericValue(c); i++){
					
					resultat2 = resultat2 + 'I';
					
				}
				
				
			} else if (Character.getNumericValue(c) == 4){
				
				resultat2 = resultat2 + "IV";
				
			} else if (Character.getNumericValue(c) == 5){
				
				resultat2 = resultat2 + "V";
				
			} else if (Character.getNumericValue(c) > 5 && Character.getNumericValue(c)<9){
				
				resultat2 = resultat2 + "V";
				
				for (int i = 0; i < (Character.getNumericValue(c)-5); i++){
					
					resultat2 = resultat2 + "I";
					
				}								  
				
			} else if (Character.getNumericValue(c) == 9){
				
				resultat2 = resultat2 + "IX";
				
			}
			
			
			
			
		}
		
		System.out.println("romains(" + entree2 + ") = " + resultat2);
		
		clavier.close();
        
        	
    
    
        /*******************************************
         * Ne rien modifier après cette ligne.
         *******************************************/
    }
}
