package ca.uqam.inf2120.labos.classeobjet.tests;

import ca.uqam.inf2120.labos.classeobjet.Proprietaire;
import ca.uqam.inf2120.labos.classeobjet.Voiture;

/**
 * TestProprietaireVoiture pour tester les classes Voiture et Proprietaire.
 * 
 * @author Ismael Doukoure
 * @version Février 2014
 *
 */
public class TestProprietaireVoiture {

	public static void main(String[] args) {

		// Création d'une voiture
		Voiture voiture = new Voiture("Mazda Tribute", "Rouge Feu Métalisé", 
									  2005, 4);
		
		// Création d'un propriétaire
		Proprietaire prop = new Proprietaire("Propescu", "Daniel", 45, voiture);
		
		// Affichage des informations
		prop.afficher();
		
		
	}
}
