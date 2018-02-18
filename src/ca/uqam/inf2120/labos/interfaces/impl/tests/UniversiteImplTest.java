package ca.uqam.inf2120.labos.interfaces.impl.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.uqam.inf2120.labos.interfaces.Etudiant;
import ca.uqam.inf2120.labos.interfaces.Universite;
import ca.uqam.inf2120.labos.interfaces.impl.UniversiteImpl;

/**
 * UniversiteImplTest: pour tester la classe UniversiteImpl.
 * 
 * @author Ismael Doukoure / Gloire Lomani
 * @version Février 2014
 *
 */
public class UniversiteImplTest {

	Universite<Etudiant> universite;
	Etudiant e1;
	Etudiant e2;
	Etudiant e3;

	/**
	 * Initialise les données de tests.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {

		universite = new UniversiteImpl<Etudiant>();

		e1 = new Etudiant("Jean", "Roger", "ROGJ12021785", 3);
		e2 = new Etudiant("Marck", "Duval", "DUVM12021785", 4);
	}

	/**
	 * Libère les données de tests.
	 */
	@After
	public void tearDown() throws Exception {

		universite = null;
		e1 = null;
		e2 = null;
		e3 = null;
	}

	/**
	 * Teste la méthode ajouter(Employe)
	 */
	@Test
	public void testAjouter() {
		
		universite.ajouter(e1);
		
		assertTrue(universite.existe(e1));
		assertFalse(universite.existe(e2));
		
		universite.ajouter(e2);
		assertTrue(universite.existe(e2));
		
		
	}

	/**
	 * Teste la méthode existe(Employe)
	 */
	@Test
	public void testExiste() {
		
		universite.ajouter(e1);
		
		assertTrue(universite.existe(e1));
		
		assertFalse(universite.existe(e2));
		
		universite.ajouter(e2);
		assertTrue(universite.existe(e2));
	}

	/**
	 * Teste la méthode supprimer(Employe)
	 */
	@Test
	public void testSupprimer() {
		
		assertFalse(universite.supprimer(e2));
		
		universite.ajouter(e1);
		universite.ajouter(e2);
		
		assertTrue(universite.supprimer(e2));
		
		assertFalse(universite.supprimer(e2));
		
	}

	/**
	 * Teste la méthode obtenir(Employe)
	 */
	@Test
	public void testObtenir() {
		
		assertNull(universite.obtenir(0));
		
		universite.ajouter(e1);
		universite.ajouter(e2);
		
		assertEquals(e1, universite.obtenir(0));
		
		assertNull(universite.obtenir(12));
		
	}

}
