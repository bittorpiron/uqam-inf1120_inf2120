package ca.uqam.inf2120.labos.file.tda.impl.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.uqam.inf2120.labos.file.tda.File;
import ca.uqam.inf2120.labos.file.tda.FileVideException;
import ca.uqam.inf2120.labos.file.tda.impl.FileArrayListImpl;


/**
 * Classe de test de FileArrayListImpl
 * 
 * @author Victor Piron
 * @version 13 mars 2014 
 */
public class FileListeChaineeImplTest {
	
	File<Etudiant> uneFile;
	Etudiant etud1;
	Etudiant etud2;
	Etudiant etud3;
	Etudiant etud4;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		uneFile =  new FileArrayListImpl<Etudiant>();
		etud1 = new Etudiant ("Fred", "Pinto", "PINF15029901", 2);
		etud2 = new Etudiant ("Danielle","Champ", "CHAD16038801", 2);
		etud3 = new Etudiant ("Nanou", "Heraux", "HERN20559102", 1);
		etud4 = new Etudiant ("Diderot", "FrancParleur", "FRAD12099401", 5);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		
		uneFile = null;
		etud1 = null;
		etud2 = null;
		etud3 = null;
		etud4 = null;
	}

	/**
	 * Test method for {@link ca.uqam.inf2120.labos.file.tda.impl.FileTableauImpl#enfiler(java.lang.Object)}.
	 */
	@Test
	public void testEnfiler() {
		
		uneFile.enfiler(etud1);
		uneFile.enfiler(etud2);
		uneFile.enfiler(etud3);
		uneFile.enfiler(etud4);
		
		assertEquals(4, uneFile.taille());
		
	}

	/**
	 * Test method for {@link ca.uqam.inf2120.labos.file.tda.impl.FileTableauImpl#defiler()}.
	 */
	@Test
	public void testDefiler() {
		
		try {
			uneFile.defiler();
		} catch (FileVideException e) {
             assertEquals("Impossible de defiler dans une file vide", e.getMessage());
		}
		
		uneFile.enfiler(etud1);
		uneFile.enfiler(etud2);
		uneFile.enfiler(etud3);
		uneFile.enfiler(etud4);
		
		assertEquals(4, uneFile.taille());

		Etudiant unEtud = uneFile.defiler();
		assertEquals(3, uneFile.taille());
		assertEquals("PINF15029901", unEtud.getCodePermanent());
		
		unEtud = uneFile.defiler();
		
		assertEquals("CHAD16038801", unEtud.getCodePermanent());
	}

	/**
	 * Test method for {@link ca.uqam.inf2120.labos.file.tda.impl.FileTableauImpl#estVide()}.
	 */
	@Test
	public void testEstVide() {
		 assertTrue(uneFile.estVide());
			
		 uneFile.enfiler(etud1);
		 uneFile.enfiler(etud2);
		 uneFile.enfiler(etud3);
		 uneFile.enfiler(etud4);
			
	     assertFalse(uneFile.estVide());
	}

	/**
	 * Test method for {@link ca.uqam.inf2120.labos.file.tda.impl.FileTableauImpl#taille()}.
	 */
	@Test
	public void testTaille() {
		
		 assertEquals(0, uneFile.taille());
			
		 uneFile.enfiler(etud1);
		 uneFile.enfiler(etud2);
			
	      assertEquals(2, uneFile.taille());
	}

	/**
	 * Test method for {@link ca.uqam.inf2120.labos.file.tda.impl.FileTableauImpl#debut()}.
	 */
	@Test
	public void testDebut() {
		
		try {
			uneFile.debut();
		} catch (FileVideException e) {
             assertEquals("Impossible de retourner le premier dans une file vide", e.getMessage());
		}
		
		uneFile.enfiler(etud1);
		uneFile.enfiler(etud2);
		uneFile.enfiler(etud3);
		
		Etudiant unEtud = uneFile.defiler();
		assertEquals("PINF15029901", unEtud.getCodePermanent());
	}

}
