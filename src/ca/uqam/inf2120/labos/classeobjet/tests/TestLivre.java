package ca.uqam.inf2120.labos.classeobjet.tests;

import ca.uqam.inf2120.labos.classeobjet.Livre;

/**
 * TestLivre pour tester la classe Livre.
 * 
 * @author Ismael Doukoure
 * @version Février 2014
 *
 */
public class TestLivre {

	public static void main(String[] args) {

		// Création d'un livre.
		Livre livre = new Livre("Java Débutant", "Fred Douglas");
		
		// Affichage du livre
		livre.afficher();
		
		
	}
}
