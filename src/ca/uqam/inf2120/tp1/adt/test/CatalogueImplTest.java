/**
 * CatalogueImplTest.java
 */
package ca.uqam.inf2120.tp1.adt.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.uqam.inf2120.tp1.adt.Catalogue;
import ca.uqam.inf2120.tp1.adt.impl.CatalogueImpl;

/**
 * @author Victor Piron
 * PIRV11026606
 * INF2120 Groupe 30 (Isma�l Doukoure)
 * piron.victor@courrier.uqam.ca  
 * @version 2014-02-15
 */
public class CatalogueImplTest {
	
	Catalogue<Alphabet> monCatalogue;

	Alphabet elmt1;
	Alphabet elmt2;
	Alphabet elmt3;
	Alphabet elmt4;
	
	/**
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		monCatalogue = new CatalogueImpl<Alphabet>();
		
		elmt1 = new Alphabet("a");
		elmt2 = new Alphabet(3, "b");
		elmt3 = new Alphabet(1, "a");	
		elmt4 = new Alphabet(4, "a");		
	}

	/**
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		
		monCatalogue = null;
		
	}

	/**
	 * Test method for {@link CatalogueImpl#ajouter(ca.uqam.inf2120.tp1.adt.NombreCopies)}.
	 */
	@Test
	public void testAjouterT() {
			
		assertNotEquals(true, monCatalogue.ajouter(elmt1));		
		elmt1.augmenter(1);
		assertEquals(true, monCatalogue.ajouter(elmt1));
		assertEquals(1, monCatalogue.element(0).obtenirNbCopies());
		
		assertEquals(true, monCatalogue.ajouter(elmt1));
		assertEquals("a", monCatalogue.element(0).obtenirLettre());
		assertEquals(2, monCatalogue.element(0).obtenirNbCopies());
		
		assertEquals(true, monCatalogue.ajouter(elmt2));
	}

	/**
	 * Test method for {@link CatalogueImpl#ajouter(List)}.
	 */
	@Test
	public void testAjouterList() {
		
		//remplir catalogue
		monCatalogue.ajouter(elmt2); //3 b
		monCatalogue.ajouter(elmt3); //1 a
		
		//Cas ajouter liste nulle	
		List<Alphabet> liste = null;	
		monCatalogue.ajouter(liste);
		assertEquals("b", monCatalogue.element(0).obtenirLettre());		
		assertEquals(1, monCatalogue.element(1).obtenirNbCopies());	
		assertEquals(4, monCatalogue.nbTotalCopies());	
		
		//Cas ajouter liste vide
		liste = new ArrayList<Alphabet>();
		monCatalogue.ajouter(liste);
		assertEquals("b", monCatalogue.element(0).obtenirLettre());		
		assertEquals(1, monCatalogue.element(1).obtenirNbCopies());	
		assertEquals(4, monCatalogue.nbTotalCopies());	

		//Cas ajouter liste dans catalogue
		//Ajouter des �l�ments � la liste � ajouter	
		liste.add(elmt3);//1 a
		liste.add(elmt4);//4 a   

		monCatalogue.ajouter(liste);		
		assertEquals("b", monCatalogue.element(0).obtenirLettre());		
		assertEquals(6, monCatalogue.element(1).obtenirNbCopies());		
		assertEquals(9, monCatalogue.nbTotalCopies());	
	}

	/**
	 * Test method for {@link CatalogueImpl#supprimer(ca.uqam.inf2120.tp1.adt.NombreCopies)}.
	 */
	@Test
	public void testSupprimerT() {
		//remplir catalogue		
		monCatalogue.ajouter(new Alphabet (8, "a"));		
		
		//Cas d'�l�ment pas dans la liste
		monCatalogue.supprimer(elmt2);
		assertEquals(8, monCatalogue.element(0).obtenirNbCopies());	
		
		//Cas d'�l�ment dans la liste
		monCatalogue.supprimer(elmt4);
		assertEquals(4, monCatalogue.element(0).obtenirNbCopies());			
		
	}

	/**
	 * Test method for {@link CatalogueImpl#supprimer(List)}.
	 */
	@Test
	public void testSupprimerList() {
		
		//remplir catalogue	(8a,9b)	
		monCatalogue.ajouter(new Alphabet (8, "a"));
		monCatalogue.ajouter(new Alphabet (9, "b"));		
	
		//liste a supprimer	
		List<Alphabet> liste = new ArrayList<Alphabet>();		

		
		//Cas de supprimer deux elements valides
		liste.add(new Alphabet (3, "a")); 
		liste.add(new Alphabet (1, "b"));
		
		List<Alphabet> listeNonSupprimes = monCatalogue.supprimer(liste);		
		
		assertNull(listeNonSupprimes);
		assertEquals(5, monCatalogue.element(0).obtenirNbCopies());		
		assertEquals(8, monCatalogue.element(1).obtenirNbCopies());		
				
		//Cas de supprimer 1 elements valide et un non valide
		liste.clear();		
		liste.add(new Alphabet (3, "a")); 
		liste.add(new Alphabet (1, "d"));
		
		//catalogue	(5a,8b)	
		listeNonSupprimes = monCatalogue.supprimer(liste);		
		
		assertEquals(1, listeNonSupprimes.size());
		assertEquals(2, monCatalogue.element(0).obtenirNbCopies());		
		assertEquals(8, monCatalogue.element(1).obtenirNbCopies());			
		
	}

	/**
	 * Test method for {@link CatalogueImpl#remplacer(ca.uqam.inf2120.tp1.adt.NombreCopies, ca.uqam.inf2120.tp1.adt.NombreCopies)}.
	 */
	@Test
	public void testRemplacer() {

		//remplir catalogue	(8a,9b)	
		monCatalogue.ajouter(new Alphabet (3, "b"));
		monCatalogue.ajouter(new Alphabet (6, "a"));
		
		//Cas element � remplacer pas dans la liste(Pas de changements)
		monCatalogue.remplacer(new Alphabet(3, "z"), elmt1);	
		assertEquals(6, monCatalogue.element(1).obtenirNbCopies());		

		//Cas nombre de copies <1 (Pas de changements)
		monCatalogue.remplacer(elmt1,  new Alphabet(-1, "c"));	
		assertEquals(6, monCatalogue.element(1).obtenirNbCopies());			

		//Cas element d�j� dans la liste(Pas de changements)
		monCatalogue.remplacer(elmt1,  new Alphabet(4, "a"));		
		assertEquals(6, monCatalogue.element(1).obtenirNbCopies());			
		
		//Cas de changements : b-3; c-2
		monCatalogue.remplacer(elmt1,  new Alphabet(2, "c"));		
		assertEquals(2, monCatalogue.element(1).obtenirNbCopies());		

	}

	/**
	 * Test method for {@link CatalogueImpl#element(int)}.
	 */
	@Test
	public void testElement() {

		// remplir catalogue (8a,9b)
		monCatalogue.ajouter(new Alphabet(8, "a"));
		monCatalogue.ajouter(new Alphabet(9, "b"));
		
		//Cas exception IndiceHorsBornesException
		try {
			monCatalogue.element(3);
		} catch (Exception e) {
			assertEquals("IndiceHorsBornesException",e.getClass().getSimpleName());
		}		
		
		//Cas exception IndiceHorsBornesException
		try {
			monCatalogue.element(-1);
		} catch (Exception e) {
			assertEquals("L'indice est n�gatif ou sup�rieur au nombre d'�l�ments dans la liste.", e.getMessage());
		}
		
		//Cas pas d'exception
		assertEquals("b", monCatalogue.element(1).obtenirLettre());

	}

	/**
	 * Test method for {@link CatalogueImpl#elements(int)}.
	 */
	@Test
	public void testElements() {
		
		//Cas catalogue vide		
		assertEquals(0, monCatalogue.elements(10).size());
		
		// remplir catalogue (8a,9b,3c)
		monCatalogue.ajouter(new Alphabet(8, "a"));
		monCatalogue.ajouter(new Alphabet(9, "b"));
		monCatalogue.ajouter(new Alphabet(3, "c"));		
		
		//Cas tout le catalogue 		
		assertEquals(3, monCatalogue.elements(9).size());
		
		//Cas un �l�ment du catalogue		
		assertEquals(1, monCatalogue.elements(5).size());		
		
		//Cas aucun �l�ment		
		assertEquals(0, monCatalogue.elements(2).size());
		
		//verifier apr�s suppresion d'un element
		monCatalogue.supprimer(new Alphabet(1, "c"));
		assertEquals(1, monCatalogue.elements(2).size());		
		
	}

	/**
	 * Test method for {@link CatalogueImpl#nbCopies(ca.uqam.inf2120.tp1.adt.NombreCopies)}.
	 */
	@Test
	public void testNbCopies() {
		//Cas catalogue vide		
		assertEquals(0, monCatalogue.nbCopies(new Alphabet (8, "a")));
		
		//remplir catalogue	(8a,9b)	
		monCatalogue.ajouter(new Alphabet (8, "a"));
		monCatalogue.ajouter(new Alphabet (9, "b"));	
		
		//Cas catalogue contient l'element � v�rifier	
		assertEquals(8, monCatalogue.nbCopies(new Alphabet (4, "a")));
	
		//Cas catalogue ne contient pas l'element � v�rifier	
		assertEquals(0, monCatalogue.nbCopies(new Alphabet ("z")));
		
	}

	/**
	 * Test method for {@link CatalogueImpl#nbTotalCopies()}.
	 */
	@Test
	public void testNbTotalCopies() {
		
		//Cas catalogue vide		
		assertEquals(0, monCatalogue.nbTotalCopies());
		
		//remplir catalogue	(8a,9b)	
		monCatalogue.ajouter(new Alphabet (8, "a"));
		monCatalogue.ajouter(new Alphabet (9, "b"));	
		
		//Cas catalogue avec elements
		assertEquals(17, monCatalogue.nbTotalCopies());
		
	}

	/**
	 * Test method for {@link CatalogueImpl#estEgale(ca.uqam.inf2120.tp1.adt.Catalogue)}.
	 */
	@Test
	public void testEstEgale() {
		
		//remplir catalogue	(8a,9b)	
		monCatalogue.ajouter(new Alphabet (8, "a"));
		monCatalogue.ajouter(new Alphabet (9, "b"));		
	
		//Cas La liste Catalogue a v�rifier est egale
		Catalogue<Alphabet> catalogueEgale = new CatalogueImpl<Alphabet>();	
		catalogueEgale.ajouter(new Alphabet (8, "a"));
		catalogueEgale.ajouter(new Alphabet (9, "b"));	

		assertEquals(true, monCatalogue.estEgale(catalogueEgale));	
		
		//Cas La liste Catalogue a v�rifier est nulle
		assertEquals(false, monCatalogue.estEgale(null));
		
		//Cas La liste Catalogue n'as pas le m�me nbr. copies
		Catalogue<Alphabet> cataloguePasNbrCopies = new CatalogueImpl<Alphabet>();	
		cataloguePasNbrCopies.ajouter(new Alphabet (5, "a"));
		cataloguePasNbrCopies.ajouter(new Alphabet (9, "b"));	

		assertEquals(false, monCatalogue.estEgale(cataloguePasNbrCopies));		

	}

	/**
	 * Test method for {@link CatalogueImpl#estVide()}.
	 */
	@Test
	public void testEstVide() {
		//Cas catalogue est vide
		assertEquals(true,monCatalogue.estVide());		

		//Cas catalogue n'est pas vide
		monCatalogue.ajouter(elmt2);		
		assertNotEquals(true,monCatalogue.estVide());
		
	}

	/**
	 * Test method for {@link CatalogueImpl#iterateur()}.
	 */
	@Test
	public void testIterateur() {
		
		//monCatalogue = b-3; a-6
		testAjouterList();
		ListIterator<Alphabet>  monIterator =  monCatalogue.iterateur();
		
		assertEquals( true, monIterator.hasNext());
		assertEquals( 0, monIterator.nextIndex());
		assertEquals( "b", monIterator.next().obtenirLettre());
		assertEquals( "a", monIterator.next().obtenirLettre());
		assertEquals( false, monIterator.hasNext());
		
		//Cas de deux iterateurs (differents pointeurs)
		assertEquals( true, monCatalogue.iterateur().hasNext());
	}
}
