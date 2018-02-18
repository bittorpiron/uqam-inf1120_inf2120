package ca.uqam.inf2120.labos.listechainee;

import java.util.Scanner;

import ca.uqam.inf2120.labos.listechainee.utiles.Noeud;

/**
 * ListeChainee contient quelques méthodes pour insérer dans une liste chaînée.
 * 
 * UQAM - INF2120
 * 
 * @author Ismael Doukoure
 * @version Mars 2014
 * 
 */

public class ListeChainee {

	/**
	 * Affiche tous les éléments d'une liste chaînée.
	 * 
	 * @param tete La référence du premier noeud dans la liste.
	 */
	public static void afficher(Noeud<String> tete) {
		
		if (tete != null) {
			Noeud<String> courant = tete;
			
			System.out.println("----Ma Liste----");
			while(courant != null && courant.getElement() != null) {				
				System.out.println(courant.getElement());
				courant = courant.getSuivant();
			}
		}

	}

	/**
	 * Insère l'élément passé en paramètre au début de la liste et
	 * retourne la référence du 1er noeud de la liste (tete).
	 * 
	 * @param tete La référence du premier noeud dans la liste.
	 * @param element L'élément à insérer
	 * @return La référence du premier noeud dans la liste.
	 */
	public static Noeud<String> insererDebut(Noeud<String> tete, String element) {
		
		if (element != null) {
			tete = new Noeud<String>(element, tete);
		}

		return tete;

	}

	/**
	 * Insère l'élément passé en paramètre à la fin de la liste et
	 * retourne la référence du 1er noeud de la liste (tete).
	 * 
	 * @param tete La référence du premier noeud dans la liste.
	 * @param element L'élément à insérer
	 * @return La référence du premier noeud dans la liste.
	 */
	public static Noeud<String> insererFin(Noeud<String> tete, String element) {
		
		if (element != null) {
			
			if (tete == null) {
				tete = new Noeud<String>(element);
			}
			else {
				Noeud<String> courant = tete;
				
				while (courant.getSuivant() != null) {
					courant = courant.getSuivant();
				}
				
				courant.setSuivant(new Noeud<String>(element));
			}
			
		}

		return tete;

	}

	// Méthode main
	public static void main(String[] args) {

		Noeud<String> tete = null; // reference vers le premier noeud de la liste
		String chaine; // contiendra la chaine lue au clavier et à inserer dans la liste
		boolean fin = false; // indicateur de controle de boucle
		Scanner clavier = new Scanner(System.in);
		
		do {

			System.out.print("Entrez une chaine :");
			chaine = clavier.nextLine();
			chaine = chaine.trim();


			System.out.println(); // Ligne vide
			if (chaine.isEmpty() ) { // fin de la boucle de lecture
				fin = true;
			} else {
				if (chaine.charAt(0) >= 'A' && chaine.charAt(0) <= 'Z') {
					tete = insererDebut(tete, chaine);
				}
				else {
					tete = insererFin(tete, chaine);
				}
			}
		} while (!fin); // tant que la lecture n'est pas finie
		clavier.close();

		afficher(tete);

	}
}
