package ca.uqam.inf2120.labos.interfaces.impl.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.uqam.inf2120.labos.interfaces.Employe;
import ca.uqam.inf2120.labos.interfaces.Entreprise;
import ca.uqam.inf2120.labos.interfaces.impl.EntrepriseImpl;

/**
 * EntrepriseImplTest: pour tester la classe EntrepriseImpl.
 * 
 * @author Ismael Doukoure / Gloire Lomani
 *
 */
public class EntrepriseImplTest {
	
	Entreprise entreprise;
	Employe e1;
	Employe e2;
	Employe e3;
	
	/**
	 * Initialise les données.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		entreprise = new EntrepriseImpl();
		 e1 = new Employe("George", "Steven", "SG12345", (float) 12000);
		 e2 = new Employe("Greg", "David", "DG14785", (float) 2500);
	}

	/**
	 * Libère les données.
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		entreprise = null;
		e1 = null;
		e2 = null;
		e3 = null;
	}

	/**
	 * Teste la méthode ajouterEmploye(Employe)
	 */
	@Test
	public void testAjouterEmploye() {
		
		entreprise.ajouterEmploye(e1);
		assertTrue(entreprise.existe("SG12345"));
		
		entreprise.ajouterEmploye(e2);
		assertTrue(entreprise.existe("DG14785"));
		
		entreprise.ajouterEmploye(e3);
		assertFalse(entreprise.existe(null));
	}

	/**
	 * Teste la méthode existe(String).
	 */
	@Test
	public void testExiste() {
		entreprise.ajouterEmploye(e1);
		entreprise.ajouterEmploye(e2);
		
		assertTrue(entreprise.existe("SG12345"));
		assertFalse(entreprise.existe("0000"));
		assertFalse(entreprise.existe(null));
		
	}

	/**
	 * Teste la méthode supprimer(Employe)
	 */
	@Test
	public void testSupprimer() {
		
		entreprise.ajouterEmploye(e1);
		entreprise.ajouterEmploye(e2);
		
		assertTrue(entreprise.supprimer(e1));
		assertFalse(entreprise.supprimer(e3));
		assertFalse(entreprise.supprimer(e1));
	}

	/**
	 * Teste la méthode ObtenirEmployes()
	 */
	@Test
	public void testObtenirEmployes() {
		entreprise.ajouterEmploye(e1);
		entreprise.ajouterEmploye(e2);
		
		Employe[] tab = entreprise.obtenirEmployes();
		
		//il faudrait connaitre la logique d ajout pour les position d'element
		assertEquals(tab[0], e1);
		assertEquals(tab[1], e2);
		
	}

	/**
	 * Teste la méthode chercherEmploye(String)
	 */
	@Test
	public void testChercherEmploye() {
		
		entreprise.ajouterEmploye(e1);
		entreprise.ajouterEmploye(e2);
		
		assertEquals(e1, entreprise.chercherEmploye("SG12345"));
		assertNull(entreprise.chercherEmploye("000"));
	}

}
