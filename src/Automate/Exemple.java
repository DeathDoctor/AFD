package Automate;   

public class Exemple {
	                                                          // L'automate a*b*c* 
	
	public boolean appartenance(String mot[]){
		int lettre = 0;
		mot[mot.length+1] = null;     // J'affecte à la case n°(taille du tableau + 1) pour reconnaitre la fin du mot                         
		if(mot[lettre] == null){      // Pour le mot vide
			return true;               
			
		}
		else{   
			if(mot[lettre].equals("a")){          // Sinon on parcourt le tableau jusqu'à ce qu'on arrive à la fin c'est à dire null 
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
		mot[mot.length+1] = null;      // J'affecte à la case n°(taille du tableau + 1) pour reconnaitre la fin du mot
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
		for(int i=(mot.length);i>=0;){    // Je crée un nouveau mot en concaténant les éléments du tableau avec un parcourt qui commence de la fin et finit au début 
			mirroir = mirroir+mot[i];
		}
		System.out.println(mirroir);
	}

}
