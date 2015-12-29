package Automate;

import java.util.Scanner;

public class AFD {

	public static void main(String[] args) {
		Scanner rep = new Scanner(System.in);
		System.out.println("Veuillez saisir : ");
		System.out.println("le nombre d'elements de votre alphabet : ");
		int nbrLettres;
		nbrLettres = rep.nextInt();
		while(nbrLettres<=0){
			System.out.println("Le nombre de lettre doit etre strictement positif ! Veuillez saisir à nouveau : ");
			nbrLettres = rep.nextInt();
		}
		String monAlphabet[] = new String[nbrLettres];
		for(int i=0;i<nbrLettres;i++){
			System.out.println("Entrez l'element n°"+(i+1)+" : ");
			monAlphabet[i] = rep.next();
		}
		System.out.println("Le nombre d'etat de votre automate : ");
		int nbrEtats;
		nbrEtats = rep.nextInt();
		while(nbrEtats<=0){
			System.out.println("Le nombre d'etats doit etre strictement positif ! Veuillez saisir à nouveau :");
			nbrEtats = rep.nextInt();
		}
		System.out.println("Le nombre d'etats finals : ");
		int nbrEtatsFinals;
		nbrEtatsFinals = rep.nextInt();
		while((nbrEtatsFinals<=0)||(nbrEtatsFinals>nbrEtats)){
			System.out.println("Le nombre d'etats finals doit etre strictement positif et inferieur au nombre d'états ! Veuillez saisir à nouveau : ");
			nbrEtatsFinals = rep.nextInt();
		}
		Automate monAutomate = new Automate(monAlphabet,nbrEtats,nbrEtatsFinals);
		System.out.println("Vous allez commencer à remplir la table de transition : ");
		System.out.println("Veuillez respecter les caractérisques d'un AFD ! (Un seul etat intial ET avec une lettre on peut aller SEULEMENT vers UN etat) ");
		System.out.println("Selon votre alphbet : ");
		monAutomate.affichageAlphabet();
		System.out.println("Remplissez-la introduisant les noms d'etats dont votre l'automate est construit ");
		System.out.println("Pour aucune transition introduisez le mot 'NIL' ");
		try {
			monAutomate.tableDeTransion();
		    } catch (ArrayIndexOutOfBoundsException e) {
		}
		rep.close();
		monAutomate.affichageTableTransition();
		
		}
		
		
		
		
		
		
			

	

}
