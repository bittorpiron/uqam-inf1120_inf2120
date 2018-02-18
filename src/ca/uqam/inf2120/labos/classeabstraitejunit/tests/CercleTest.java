package ca.uqam.inf2120.labos.classeabstraitejunit.tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.uqam.inf2120.labos.classeabstraitejunit.Cercle;

/**
 * CercleTest pour tester la classe Cercle.
 * 
 * @author Gloire Lomani / Ismael Doukoure
 *
 */
public class CercleTest {
	private Cercle cercle;
	private double rayon;
	private final double PI = 3.14; 
	
	/**
	 * Initialise les données de tests.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		rayon = 3;
		cercle = new Cercle(rayon);
	}

	/**
	 * Libère les données de tests.
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		cercle = null;
	}

	/**
	 * Teste la méthode calculerSurface().
	 */
	@Test
	public void testCalculerSurface() {
		cercle.calculerSurface();
		
		double surface = PI * rayon * rayon;
		
		assertEquals(cercle.getSurface(), surface, 0.01);
		
		
	}

	/**
	 * Teste la méthode calculerPerimetre().
	 */
	@Test
	public void testCalculerPerimetre() {
		cercle.calculerPerimetre();
		
		double perim = 2 * PI * rayon;
		
		assertEquals(cercle.getPerimetre(), perim, 0.01);
	}

}
