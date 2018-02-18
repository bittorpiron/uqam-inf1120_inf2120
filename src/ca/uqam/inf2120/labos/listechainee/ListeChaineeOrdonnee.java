package ca.uqam.inf2120.labos.listechainee;

import ca.uqam.inf2120.labos.listechainee.utiles.Etudiant;
import ca.uqam.inf2120.labos.listechainee.utiles.Noeud;



/**
 * ListeChaineeOrdonnee contient une méthode d'insertion et 
 * une autre pour l'affichage.
 * 
 * UQAM - INF2120
 * 
 * @author Ismael Doukoure
 * @version Mars 2014
 * 
 */

public class ListeChaineeOrdonnee {

	/**
	 * Affiche tous les éléments d'une liste chaînée.
	 * 
	 * @param tete La référence du premier noeud dans la liste.
	 */
	public static void afficher(Noeud<Etudiant> tete) {
		
		if (tete != null) {
			Noeud<Etudiant> courant = tete;
			
			System.out.println("----Ma Liste D'étudiant----");
			while(courant != null && courant.getElement() != null) {				
				System.out.println(courant.getElement());
				courant = courant.getSuivant();
			}
		}

	}

	/**
	 * Insère l'élément passé en paramètre dans la liste selon l'ordre de grandeur
	 * et retourne la référence du 1er noeud de la liste (tete).
	 * 
	 * @param tete La référence du premier noeud dans la liste.
	 * @param etudiant L'étudiant à insérer
	 * @return La référence du premier noeud dans la liste.
	 */
	public static Noeud<Etudiant> insererEnOrdreCroissant(Noeud<Etudiant> tete, 
													   Etudiant etudiant) {
		if (etudiant != null) {
			
			if (tete == null) {
				tete = new Noeud<Etudiant>(etudiant);
			}
			else {
				Noeud<Etudiant> courant = tete;
				Noeud<Etudiant> precedent = null;
				while (courant != null && courant.getElement().compareTo(etudiant) < 0) {
					precedent = courant;
					courant = courant.getSuivant();
				}
				
				if (precedent == null) {
					tete = new Noeud<Etudiant>(etudiant, tete);
				}  else {
					precedent.setSuivant(new Noeud<Etudiant>(etudiant, courant));
				}
			}
		}

		return tete;

	}


	// Méthode main
	public static void main(String[] args) {

		Noeud<Etudiant> tete = null; // reference vers le premier noeud de la liste
		
		tete = insererEnOrdreCroissant(tete, new Etudiant("Gregoire", "tremblay", "TREG12345", 5));
		tete = insererEnOrdreCroissant(tete,new Etudiant("Thomas", "Virgon", "VIRT12345", 4));

		tete = insererEnOrdreCroissant(tete,new Etudiant("Valie", "Magne", "MAGV12345", 2));
		tete = insererEnOrdreCroissant(tete,new Etudiant("Karine", "Goute", "GOUK12345", 2));
		tete = insererEnOrdreCroissant(tete,new Etudiant("CCCC", "ABCD", "ABCC12345", 2));
		
		
		afficher(tete);
		

	}
}
