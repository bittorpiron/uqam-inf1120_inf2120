package ca.uqam.inf2120.exemplesvusenclasse.heritage.tests;

import ca.uqam.inf2120.exemplesvusenclasse.heritage.Employe;
import ca.uqam.inf2120.exemplesvusenclasse.heritage.Enseignant;
import ca.uqam.inf2120.exemplesvusenclasse.heritage.Etudiant;


/**
 *  Titre : Notion d'héritage
 * 	Description: Classe pour tester Personne et ses sous-classes
 * 
 * 	UQAM - INF2120
 * @author Ismael Doukoure
 * @version Septembre 2008
 * Modifié en Janvier 2014
 */

public final class ProgrammePrincipal {
	
    public static void main(String [] arguments) {
    	
       // déclaration des constantes
       final String DESCRIPTION_ETUDIANT   = "\n Étudiant " ;
       final String DESCRIPTION_EMPLOYE    = "\n Employé  " ;
       final String DESCRIPTION_ENSEIGNANT = "\n Enseignant  " ;
       


       //déclaration et initialisation des instances des différentes classes
       Etudiant unEtudiant     = new Etudiant ("Fred","Pinto", "PINF15029901", 2);
       Employe unEmploye       = new Employe ("Danielle","Champ", "CHA01", 75000.70f);
       Enseignant unEnseignant = new Enseignant ("Nanou", "Heraux", "HER02", 65000.55f, 2);
       

      // affichage de la description des différents personnes
      System.out.println("---------------------------------------------------------------------") ;
      System.out.println("                VOICI LA DESCRIPTION DES DIFFÉRENTS PERSONNES          ") ;
      System.out.println("---------------------------------------------------------------------") ;
      System.out.println(DESCRIPTION_ETUDIANT + unEtudiant) ;
      System.out.println("********************************************************") ;
      System.out.println(DESCRIPTION_EMPLOYE + unEmploye) ;
      System.out.println("********************************************************") ;
      System.out.println(DESCRIPTION_ENSEIGNANT + unEnseignant) ;
      System.out.println("---------------------------------------------------------------------") ;
      
     }
}
