package ca.uqam.inf2120.exemplesvusenclasse.junit.tests;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.uqam.inf2120.exemplesvusenclasse.junit.OperationsAvecNbArgumentsVariables;

/**
 * Classe de test de la classe OperationsAvecNbArgumentsVariables
 * 
 * @author Ismael Doukoure
 * @since 24/01/2011 - Dernière modification : 26/01/2014
 *
 */
public class OperationsAvecNbArgumentsVariablesTest {
	
	/**
	 * JUnit lance automatiquement la méthode setUp avant l'exécution 
	 * des méthodes de tests
	 * 
	 * Meilleure place pour initialiser les éléments en commun des méthodes 
	 * de test.
	 */
	@Before
	public void setUp() throws Exception {
		
	}

	
	/**
	 * JUnit lance automatiquement la méthode tearDown après l'exécution 
	 * des méthodes de tests
	 * 
	 * Meilleure place pour libérer les éléments en commun des méthodes 
	 * de test.
	 */
	@After
	public void tearDown() throws Exception {
		
	}

	/**
	 * Teste la methode additionner  de la classe OperationsAvecNbArgumentsVariables
	 * avec 2 arguments.
	 */
	@Test
	public void additionAvecDeuxNombres() {
		final long resultat = 
			OperationsAvecNbArgumentsVariables.additionner(10, 20);
		assertEquals(30, resultat);
	}
    
	/**
	 * Teste la methode additionner  de la classe OperationsAvecNbArgumentsVariables
	 * avec 5 arguments.
	 */
	@Test
	public void additionAvecCinqNombres() {
	  final long resultat = 
		  OperationsAvecNbArgumentsVariables.additionner(256, 512, 1024, 2048, 4096);
	  assertEquals(7936, resultat);
	}
	
	/**
	 * Teste la methode multiplier  de la classe OperationsAvecNbArgumentsVariables
	 * avec 2 arguments.
	 */
	@Test
	public void mutiplicationAvecDeuxNombres() {
		final long resultat = OperationsAvecNbArgumentsVariables.multiplier(10, 20);
		assertEquals(200, resultat);
	}
}
