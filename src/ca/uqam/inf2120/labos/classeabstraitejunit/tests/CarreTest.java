package ca.uqam.inf2120.labos.classeabstraitejunit.tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.uqam.inf2120.labos.classeabstraitejunit.Carre;

/**
 * CarreTest pour tester la classe Carre.
 * 
 * @author Gloire Lomani / Ismael Doukoure
 *
 */
public class CarreTest {
	
	private Carre carre;
	
	/**
	 * Initialise les données de tests.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		carre = new Carre(2);
	}

	/**
	 * Libère les données de tests.
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		carre = null;
	}

	/**
	 * Teste  la méthode calculerSurface().
	 */
	@Test
	public void testCalculerSurface() {
		carre.calculerSurface();
		
		assertEquals(carre.getSurface(), 4, 0.01);
		
		carre.setCote(5);
		carre.calculerSurface();
		
		assertEquals(carre.getSurface(), 25, 0.01);
	}

	/**
	 * Teste la méthode calculerPerimetre().
	 * 
	 */
	@Test
	public void testCalculerPerimetre() {
		carre.calculerPerimetre();
		
		assertEquals((int)carre.getPerimetre(), 8);
	}

}
