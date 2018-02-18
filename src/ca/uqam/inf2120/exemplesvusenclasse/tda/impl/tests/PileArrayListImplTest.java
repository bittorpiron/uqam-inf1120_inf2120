package ca.uqam.inf2120.exemplesvusenclasse.tda.impl.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.uqam.inf2120.exemplesvusenclasse.tda.Pile;
import ca.uqam.inf2120.exemplesvusenclasse.tda.PileVideException;
import ca.uqam.inf2120.exemplesvusenclasse.tda.impl.PileArrayListImpl;

/**
 * Classe de test de PileArrayListImpl
 * 
 * @author Ismael Doukoure
 * @version 08 février 2014 
 */
public class PileArrayListImplTest {
	
	Pile<Livre> unePile;
	Livre livre1;
	Livre livre2;
	Livre livre3;
	Livre livre4;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		unePile =  new PileArrayListImpl<Livre>();
		livre1 = new Livre("123-2-09-041234-1", "Java Débutant", "Fred Douglas", 210);
		livre2 = new Livre("103-2-08-051234-2", "Java Intermediaire", "Albert Soum", 310);
		livre3 = new Livre("120-2-07-031234-3", "Java Avancé", "Alpha D.", 510);
		livre4 = new Livre("978-2-07-061536-0", "Harry Potter et les reliques de la mort", "J. K. Rowling", 809);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		unePile =  null;
		livre1 = null;
		livre2 = null;
		livre3 = null;
		livre4 = null;
	}

	/**
	 * Test method for {@link ca.uqam.inf2120.exemplesvusenclasse.tda.impl.PileArrayListImpl#empiler(java.lang.Object)}.
	 */
	@Test
	public void testEmpiler() {
		
		unePile.empiler(livre1);
		unePile.empiler(livre2);
		unePile.empiler(livre3);
		unePile.empiler(livre4);
		
		assertEquals(4, unePile.taille());
	}

	/**
	 * Test method for {@link ca.uqam.inf2120.exemplesvusenclasse.tda.impl.PileArrayListImpl#depiler()}.
	 */
	@Test
	public void testDepiler() {
		
		try {
			unePile.depiler();
		} catch (PileVideException e) {
             assertEquals("PileVideException", e.getClass().getSimpleName());
		}
		
		unePile.empiler(livre1);
		unePile.empiler(livre2);
		unePile.empiler(livre3);
		unePile.empiler(livre4);
		
		assertEquals(4, unePile.taille());
		
		Livre unLivre = unePile.depiler();
		assertEquals(3, unePile.taille());
		assertEquals("978-2-07-061536-0", unLivre.getNumeroIsbn());
		
		unePile.depiler();
		unLivre = unePile.depiler();
		
		assertEquals("103-2-08-051234-2", unLivre.getNumeroIsbn());
		
	}

	/**
	 * Test method for {@link ca.uqam.inf2120.exemplesvusenclasse.tda.impl.PileArrayListImpl#estVide()}.
	 */
	@Test
	public void testEstVide() {
		
		assertTrue(unePile.estVide());
		
		unePile.empiler(livre1);
		unePile.empiler(livre2);
		unePile.empiler(livre3);
		unePile.empiler(livre4);
		
		assertFalse(unePile.estVide());
	}

	/**
	 * Test method for {@link ca.uqam.inf2120.exemplesvusenclasse.tda.impl.PileArrayListImpl#taille()}.
	 */
	@Test
	public void testTaille() {
		
       assertEquals(0, unePile.taille());
		
		unePile.empiler(livre1);
		unePile.empiler(livre2);
		
		assertEquals(2, unePile.taille());
	}

	/**
	 * Test method for {@link ca.uqam.inf2120.exemplesvusenclasse.tda.impl.PileArrayListImpl#sommet()}.
	 */
	@Test
	public void testSommet() {
		
		try {
			unePile.sommet();
		} catch (PileVideException e) {
             assertEquals("PileVideException", e.getClass().getSimpleName());
		}
		
		unePile.empiler(livre1);
		unePile.empiler(livre2);
		unePile.empiler(livre3);
		
		Livre unLivre = unePile.sommet();
		assertEquals("120-2-07-031234-3", unLivre.getNumeroIsbn());
	}

}
