package Automate;
import java.util.Scanner;
public class Automate {
	private String alphabet[]; // Un tableau de chaines caract�res et non de caract�re car une letrre peut se consistuer de plusieurs caract�res
	private int nbrEtats;      // Cette variable nous aide pour d�finir la taille de notre table de transition
	private int nbrEtatsFinals;  // Pour savoir combient d'�tats finals l'automate dispose
	private String tableTransiton[][];  // Une matrice de chaines de caract�res car les noms des �tats peuvent se constituer de plusieurs caract�re (ex : E0,Q1,...)
	
	

	public Automate(String[] alphabet, int nbrEtats, int nbrEtatsFinals) {   // Le constructeur
		super();
		this.alphabet = alphabet;
		this.nbrEtats = nbrEtats;
		this.nbrEtatsFinals = nbrEtatsFinals;
		this.tableTransiton = new String[this.nbrEtats+1][this.alphabet.length+1]; 
	}


	void tableDeTransion(){            // La m�thode qui permet de remplir la table de transition
		this.tableTransiton[0][0] = ("Etats\\Alphabet");           // L'element au point (0,0) ne contient ni transition ni lettre 
		for(int i=0;i<=this.alphabet.length;i++){                // La boucle permet de remplir la premi�re ligne de la table avec les lettre de l'alphabet
			this.tableTransiton[0][i+1]= this.alphabet[i];
		}
		
		// On a fini de remplir l'alphabet maintenant on remplit l'ensemble de nos etats dans la premi�re colonne de la table 
		
		if(this.nbrEtats == 1){          // Cette condition est au cas o� notre automate est constitu� d'un seul �tat par cons�quent cet �tat est qualifi� oomme initial et final en meme temps
			this.tableTransiton[1][0] = (" --> * Eo");
		}
		else{               
			System.out.println("Es-ce que votre etat initial est en meme temps un etat final ? Veuillez r�pondre par 'oui' ou 'non' : ");
			Scanner rep = new Scanner(System.in);
		    String reponse = rep.next();
			while((reponse!="oui")||(reponse!="non")){
				System.out.println("R�ponse non identifi�e ! Veuillez r�pondre par 'oui' ou 'non' : ");
				reponse = rep.next();
			}
			rep.close();
			if(reponse.equals("non")){
				this.tableTransiton[1][1] = ("--> Eo");
			}
			else{
				this.tableTransiton[1][0] = (" --> * Eo");
			}
			for(int i=this.nbrEtatsFinals;i>0;i--){ // La boucle permet de remplir les �tats finals de la table 
				this.tableTransiton[0][i] = ("--> Ef"+String.valueOf(i));
			}
			// Apres avoir rempli l'�tat initiale et le(s) �tat(s) final(s) on continue par remplir le reste des �tats s'ils existent
			for(int i=2;i<(this.nbrEtats-this.nbrEtatsFinals);i++){ // On commence de 2 car le 1 conttient l'�tat initial et ( nbrEtats-nbrEtatsFinals ) pour ne pas d�border et �craser les �tats finals
			}
		}
		Scanner transition = new Scanner(System.in);
		for(int i=1;i<this.alphabet.length;i++){
			for(int j=1;j<this.nbrEtats;j++){
				System.out.println("Dans l'etat : "+this.tableTransiton[i][0]);
				System.out.println("Dans quel etats de fera la trasition avec la lettre : "+this.tableTransiton[0][j]);
				String etat;
				etat = transition.next();
				while(etatExiste(this.tableTransiton,etat)==false){ // V�rification ! (la m�thode est d�clar� un peu plus bas)
					System.out.println("L'etat saisi n'existe pas dans votre automate ! Veuillez saisir de nouveau : ");
					etat = transition.next();
				}
				this.tableTransiton[i][j] = etat;
			}
		}
		transition.close();
		
	}
	
	boolean etatExiste(String[][] tableDeTransition, String etat){ // La m�thode permet v�rifier si l'�tat existent parmis les �tats dont l'automate est consititu�
		int i=1;
		while((tableDeTransition[0][i]!=etat)&&(i<=this.nbrEtats)){
			i++;
		}
		if(i<=this.nbrEtats){
			return true;
		}
		else{
			return false;
		}
	}
	
    void affichageAlphabet(){
    	System.out.print("{");
    	for(int i=0;i<this.alphabet.length;i++){
			System.out.print(this.alphabet[i]+", ");
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
