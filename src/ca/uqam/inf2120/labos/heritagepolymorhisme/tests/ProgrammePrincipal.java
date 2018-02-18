package ca.uqam.inf2120.labos.heritagepolymorhisme.tests;

import ca.uqam.inf2120.labos.heritagepolymorhisme.Abonne;
import ca.uqam.inf2120.labos.heritagepolymorhisme.AbonneCable;
import ca.uqam.inf2120.labos.heritagepolymorhisme.AbonneIllico;
import ca.uqam.inf2120.labos.heritagepolymorhisme.AbonneInternet;

/**
 * 	ProgrammePrincipal: Classe pour tester Abonne et ses sous-classes
 * 
 * 	UQAM - INF2120
 * @author Ismael Doukoure
 * @version Février 2014
 */
public class ProgrammePrincipal {

	
	public static void main(String[] args) {
		
		// Création d'un tableau d'abonnés de taille = 3
		Abonne[] lesAbonnes = new Abonne[3];
		
		// Créer des objets d'abonnés
		lesAbonnes[0] = new AbonneInternet(" Fred Costin", 12345678, 
				        "222 Levesque, Montreal, Québec", 95.0f, "fred.costin@tvpourtous.ca");	
		
		lesAbonnes[1] = new AbonneCable(" Isi Bref", 98745645, 
		        		"222 Levesque, St-Eustache, Québec", 90.0f, 5);	
		
		lesAbonnes[2] = new AbonneIllico(" Conakry Guinee", 52896320, 
        		"222 Levesque, St-Eustache, Québec", 70.0f, 5, 2);	
		
		// Afficher les abonnés
		for (Abonne a : lesAbonnes) {
			a.afficher();
			System.out.println("\n----------------------------------");
		}
		

	}

}
