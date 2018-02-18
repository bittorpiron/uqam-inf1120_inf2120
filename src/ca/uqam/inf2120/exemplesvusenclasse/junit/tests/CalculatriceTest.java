package ca.uqam.inf2120.exemplesvusenclasse.junit.tests;


import junit.framework.TestCase;
import ca.uqam.inf2120.exemplesvusenclasse.junit.Calculatrice;

/**
 * Classe de test de la classe Calculatrice
 * 
 * @author Ismael Doukoure
 * 
 * @since 24/01/2011 
 *
 */
public class CalculatriceTest extends TestCase {
	
	Calculatrice calculatrice;
	double valeur1;
	double valeur2;

	/**
	 * JUnit lance automatiquement la méthode setUp avant l'exécution 
	 * des méthodes de tests
	 * 
	 * Meilleure place pour initialiser les éléments en commun des méthodes 
	 * de test.
	 */
	protected void setUp() throws Exception {
		super.setUp();
		calculatrice =  new Calculatrice();
		valeur1 = 100.0;
		valeur2 = 50.0;
		
	}

	
	/**
	 * JUnit lance automatiquement la méthode tearDown après l'exécution 
	 * des méthodes de tests
	 * 
	 * Meilleure place pour libérer les éléments en commun des méthodes 
	 * de test.
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		calculatrice = null;
		valeur1 = 0.0;
		valeur2 = 0.0;
	}

	/**
	 * Teste la methode additionner  de la classe Calculatrice
	 */
	public void testAdditionner() {
		double resultat = calculatrice.additionner(valeur1, valeur2);
		
		// Tester  le resultat obtenu
		assertEquals(150.0, resultat, 0.01);
		
	}

	/**
	 * Teste la methode soustraire  de la classe Calculatrice
	 */
	public void testSoustraire() {
		double resultat = calculatrice.soustraire(valeur1, valeur2);
		
		// Tester  le resultat obtenu
		assertEquals(50.0, resultat, 0.01);
	}

	/**
	 * Teste la methode multiplier  de la classe Calculatrice
	 */
	public void testMultiplier() {
		double resultat = calculatrice.multiplier(valeur1, valeur2);
		
		// Tester  le resultat obtenu
		assertEquals(5000.0, resultat, 0.01);
	}

	/**
	 * Teste la methode diviser  de la classe Calculatrice
	 */
	public void testDiviser() {
		
		double resultat = calculatrice.diviser(valeur1, valeur2);
		
		// Tester  le resultat obtenu
		assertEquals(2.0, resultat, 0.01);
	}
	
	/**
	 * Teste la methode diviser  de la classe Calculatrice
	 * avec 0 comme dénominateur
	 */
	public void testDiviserParZero() {
		
		
		double resultat =  calculatrice.diviser(valeur1, 0);
			
		// Tester  le resultat obtenu
		assertTrue(Double.isInfinite(resultat));
		
	}

	/**
	 * Teste la methode modulo  de la classe Calculatrice
	 */
	public void testModulo() {
		
		double resultat = calculatrice.modulo(valeur1, valeur2);
		
		// Tester  le resultat obtenu
		assertEquals(0.0, resultat, 0.01);
	}

}
