package Automate;   

public class Exemple {
	                                                          // L'automate a*b*c* 
	
	public boolean appartenance(String mot[]){
		int lettre = 0;
		mot[mot.length+1] = null;     // J'affecte � la case n�(taille du tableau + 1) pour reconnaitre la fin du mot                         
		if(mot[lettre] == null){      // Pour le mot vide
			return true;               
			
		}
		else{   
			if(mot[lettre].equals("a")){          // Sinon on parcourt le tableau jusqu'� ce qu'on arrive � la fin c'est � dire null 
				while(mot[lettre].equals("a")){
					lettre++;
				}
				if(mot[lettre].equals("b")){
					while(mot[lettre].equals("b")){
						lettre++;
				}
					if(mot[lettre].equals("c")){
						while(mot[lettre].equals("c")){
							lettre++;
						}
						if(mot[lettre] == null){
							return true;
					    }else return false;
			        }else return false;
			   }else return false;
		    }else return false;
	}
		
			
	}
	
	public void longueurMot(String mot[]){
		mot[mot.length+1] = null;      // J'affecte � la case n�(taille du tableau + 1) pour reconnaitre la fin du mot
		int longueur = 0;
		int lettre = 0;
		while(mot[lettre] != null){
			longueur++;
			lettre++;
		}
		System.out.println("La longueur du mot est : "+longueur);
	}
	
	public void mirroirMot(String mot[]){
		String mirroir = new String();
		for(int i=(mot.length);i>=0;){    // Je cr�e un nouveau mot en concat�nant les �l�ments du tableau avec un parcourt qui commence de la fin et finit au d�but 
			mirroir = mirroir+mot[i];
		}
		System.out.println(mirroir);
	}

}
