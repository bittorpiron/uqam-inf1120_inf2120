package ca.uqam.inf2120.labos.collections.tests;

import ca.uqam.inf2120.labos.collections.Cours;
import ca.uqam.inf2120.labos.collections.Etudiant;

/**
 * ProgrammePrincipal pour tester la classe Cours.
 * 
 * @author Gloire Lomani / Ismael Doukoure
 *
 */
public class ProgrammePrincipal {


	public static void main(String[] args) {

		Cours cours = new Cours ("INF2120", "Programmation II", 21, "= Franck Daniel ");

		Etudiant etud1 = new Etudiant ("Fred", "Pinto", "PINF15029901", 2); 
		Etudiant etdu2 = new Etudiant ("Danielle","Champ", "CHAD16038801", 2); 
		Etudiant etud3 = new Etudiant ("Nanou", "Heraux", "HERN20559102", 1); 
		
		cours.ajouterEtudiant(etud1);
		cours.ajouterEtudiant(etdu2);
		cours.ajouterEtudiant(etud3);
		
		cours.afficherInfoCours();
	}

}











