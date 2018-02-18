package ca.uqam.inf2120.exemplesvusenclasse.classesabstraites.tests;

import ca.uqam.inf2120.exemplesvusenclasse.classesabstraites.Employe;
import ca.uqam.inf2120.exemplesvusenclasse.classesabstraites.Etudiant;

/**
 *  Titre : Classes abstraites
 * 	Description: Classe pour tester Personne et ses sous-classes
 * 
 * 	UQAM - INF2120
 * @author Ismael Doukoure
 * @version Septembre 2008
 * Modifié en Janvier 2014
 */

public final class ProgrammePrincipal {
	
    public static void main(String [] arguments) {
    	
       //déclaration et initialisation des instances des différentes classes
       Etudiant unEtudiant     = new Etudiant ("Fred","Pinto", "PINF15029901", 2);
       Employe unEmploye       = new Employe ("Danielle","Champ", "CHA01", 75000.70f);
   
       

      // affichage de la description des différents personnes
      System.out.println("---------------------------------------------------------------------") ;
      System.out.println("                VOICI LA DESCRIPTION DES DIFFÉRENTS PERSONNES          ") ;
      System.out.println("---------------------------------------------------------------------") ;
      System.out.println(unEtudiant) ;
      System.out.println("********************************************************") ;
      System.out.println(unEmploye) ;
      System.out.println("---------------------------------------------------------------------") ;
      
     }
}
