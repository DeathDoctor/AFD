package Automate;
import java.util.Scanner;
import java.util.*;
public class Automate {
	private String alphabet[]; // Un tableau de chaines caractères et non de caractère car une letrre peut se consistuer de plusieurs caractères
	private int nbrEtats;      // Cette variable nous aide pour définir la taille de notre table de transition
	private int nbrEtatsFinals;  // Pour savoir combient d'états finals l'automate dispose
	private String tableTransiton[][];  // Une matrice de chaines de caractères car les noms des états peuvent se constituer de plusieurs caractère (ex : E0,Q1,...)
	
	

	public Automate(String[] alphabet, int nbrEtats, int nbrEtatsFinals) {   // Le constructeur
		super();
		this.alphabet = alphabet;
		this.nbrEtats = nbrEtats;
		this.nbrEtatsFinals = nbrEtatsFinals;
		this.tableTransiton = new String[this.nbrEtats+1][this.alphabet.length+1]; // ( +1 ) Pour avoir une case supplémantaire 
	}


	void tableDeTransion(){            // La méthode qui permet de remplir la table de transition
		this.tableTransiton[0][0] = ("Etats\\Alphabet");           // L'element au point (0,0) ne contient ni transition ni lettre 
		for(int i=0;i<this.alphabet.length;i++){                // La boucle permet de remplir la première ligne de la table avec les lettre de l'alphabet
			this.tableTransiton[0][i+1]= this.alphabet[i];
		}
		
		// On a fini de remplir l'alphabet maintenant on remplit l'ensemble de nos etats dans la première colonne de la table 
		
		if(this.nbrEtats == 1){    // Cette condition est au cas où notre automate est constitué d'un seul état par conséquent cet état est qualifié oomme initial et final en meme temps
			
			this.tableTransiton[1][0] = (" --> * Eo");
		}
		else{  
			
			System.out.println("Es-ce que votre etat initial est en meme temps un etat final ? Veuillez répondre par : ");
			System.out.println("1 - Pour 'oui' ");
			System.out.println("2 - Pour 'non ");
			Scanner rep = new Scanner(System.in);
		    int reponse; 
		    reponse = rep.nextInt();
		    
			while((reponse!=1)&&(reponse!=2)){
				System.out.println("Réponse non identifiée ! Veuillez répondre par '1' ou '2' : ");
				reponse = rep.nextInt();
			}
			
			rep.close();
			
			if(reponse==2){
				this.tableTransiton[1][1] = ("--> Eo ");
			}
			else{
				this.tableTransiton[1][0] = ("--> * Eo ");
			}
			
			int tmp = this.nbrEtats; // Cette variable nous permet d'avancer la fin notre première ligne pour remplir les états finals
			
			for(int i=this.nbrEtatsFinals;i>0;i--){ // La boucle permet de remplir les états finals de la table 
				this.tableTransiton[0][tmp] = ("* Ef"+String.valueOf(i));
				tmp--;
			}
			
			// Apres avoir rempli l'état initiale et le(s) état(s) final(s) on continue par remplir le reste des états s'ils existent
			
			for(int i=2;i<=(this.nbrEtats-this.nbrEtatsFinals);i++){ // On commence de 2 car le 1 conttient l'état initial et ( nbrEtats-nbrEtatsFinals ) pour ne pas déborder et écraser les états finals
				this.tableTransiton[0][i] = ("E"+String.valueOf(i-1));
			}
			
		}
		Scanner transition = new Scanner(System.in);
		for(int i=1;i<this.alphabet.length;i++){
			for(int j=1;j<this.nbrEtats;j++){
				System.out.println("Dans l'etat : "+this.tableTransiton[i][0]);
				System.out.println("Dans quel etats de fera la trasition avec la lettre : "+this.tableTransiton[0][j]);
				String etat;
				etat = transition.next();
				while((etatExiste(this.tableTransiton,etat))==false){ // Vérification ! (la méthode est déclaré un peu plus bas)
					System.out.println("L'etat saisi n'existe pas dans votre automate ! Veuillez saisir de nouveau : ");
					etat = transition.next();
				}
				this.tableTransiton[i][j] = etat;
			}
		}
		transition.close();
		
	}
	
	void affichageTableTransition(){         // La méthode qui permet d'afficher la table de transition 
		
		System.out.println("Voici la table de transition de votre AFD : ");
		for(int i=0;i<this.tableTransiton.length;i++){
			for(int j=0;j<this.tableTransiton[i].length;j++){
				System.out.print("| "+this.tableTransiton[i][j]+" ");
			}
			System.out.println("____________________________________________");
		}
	}
	
	boolean etatExiste(String[][] tableDeTransition, String etat){ // La méthode permet vérifier si l'état existent parmis les états dont l'automate est consititué
		int i=1;
		while(!(tableDeTransition[0][i].equals(etat))&&(i<=this.nbrEtats)){
			i++;
		}
		i = this.nbrEtats;
		if((i<=this.nbrEtats)){  // On compare maintenant à E0 et au(x) Ef(s) car dans la table de transition ils sont stockés comme : " --> Eo, * Ef1 , ...;" 
			return true;
		}
		else{
			if(etat.equals("E0")){
				return true;
			}
			else{
				i=1;
				String etatFinal="Ef"+String.valueOf(i);
				while((i<=this.nbrEtatsFinals)&&(!(etat.equals(etatFinal)))){
					i++;
					etatFinal="Ef"+String.valueOf(i);
				}
				if(i<=this.nbrEtatsFinals){
					return true;
				}
				else{
					return false;
				}
				
				
			}
			
		}
	}
	
	boolean lettreExiste(String lettre){  // La méthode qui permet de voir si une lettre existe dans notre alphabet
		int i=0;
		while(!(this.alphabet[i].equals(lettre))&&(i<=this.alphabet.length)){
			i++;
		}
		if(i<=this.alphabet.length){
			return true;
		}
		else{
			return false;
		}
		
	}
	
    void affichageAlphabet(){
    	System.out.print("{");
    	for(int i=0;i<this.alphabet.length;i++){
    		if(i==(this.alphabet.length - 1)){
    			System.out.print(this.alphabet[i]);
    		}
    		else{
    			System.out.print(this.alphabet[i]+",");
    		}
		}
		System.out.println("}");
    }

	
	
	
	
	
	public String[] getAlphabet() {
		return alphabet;
	}

	public void setAlphabet(String[] alphabet) {
		this.alphabet = alphabet;
	}

	public int getNbrEtats() {
		return nbrEtats;
	}

	public void setNbrEtats(int nbrEtats) {
		this.nbrEtats = nbrEtats;
	}

	public int getNbrEtatsFinals() {
		return nbrEtatsFinals;
	}

	public void setNbrEtatsFinals(int nbrEtatsFinals) {
		this.nbrEtatsFinals = nbrEtatsFinals;
	}

	public String[][] getTableTransiton() {
		return tableTransiton;
	}

	public void setTableTransiton(String[][] tableTransiton) {
		this.tableTransiton = tableTransiton;
	}
	
		
	
	
	
	
	
	
	
	
	

}
