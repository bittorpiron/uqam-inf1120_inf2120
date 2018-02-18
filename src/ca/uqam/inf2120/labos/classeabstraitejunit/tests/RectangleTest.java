package ca.uqam.inf2120.labos.classeabstraitejunit.tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.uqam.inf2120.labos.classeabstraitejunit.Rectangle;

/**
 * RectangleTest pour tester la classe Rectangle.
 * 
 * @author Gloire Lomani / Ismael Doukoure
 *
 */
public class RectangleTest {
	
	Rectangle rec;

	/**
	 * Initialise les données.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		rec = new Rectangle(8, 3);
	}

	/**
	 * Libère les données.
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		rec = null;
	}

	/**
	 * Teste la méthode calculerSurface().
	 */
	@Test
	public void testCalculerSurface() {
		rec.calculerSurface();
		
		assertEquals(rec.getSurface(), 24, 0.01);
	}

	/**
	 * Teste la méthode calculerPerimetre().
	 */
	@Test
	public void testCalculerPerimetre() {
		rec.calculerPerimetre();
		assertEquals(rec.getPerimetre(), 22, 0.01);
		
	}

}
