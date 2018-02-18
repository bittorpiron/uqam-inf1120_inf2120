/**
 * CatalogueChaineeImpl.java
 */
package ca.uqam.inf2120.tp2.adt.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ca.uqam.inf2120.tp2.adt.Catalogue;
import ca.uqam.inf2120.tp2.adt.impl.CatalogueChaineeImpl;

/**
 * @author Victor Piron
 * PIRV11026606
 * INF2120 Groupe 30 (Isma�l Doukoure)
 * piron.victor@courrier.uqam.ca  
 * @version 2014-03-22
 */
public class CatalogueChaineeImplTest {
	
	Catalogue<Alphabet> monCatalogue;

	/**
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		monCatalogue = new CatalogueChaineeImpl<Alphabet>();
	
	}

	/**
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		
		monCatalogue = null;
		
	}

	/**
	 * Test method for {@link ca.uqam.inf2120.CatalogueChaineeImplTest.adt.impl.CatalogueChaineeImpl#ajouter(ca.uqam.inf2120.tp1.adt.NombreCopies)}.
	 */
	@Test
	public void testAjouter() {
			
		Alphabet elmt1 = new Alphabet("a");
		
		//Case pas d'ajout car nbr.copies non valide
		assertNotEquals(true, monCatalogue.ajouter(elmt1));	
		
		//Case d'ajout	
		elmt1.augmenter(1);
		assertEquals(true, monCatalogue.ajouter(elmt1));
		
		//Case d'ajout du nombre des copies
		assertEquals(true, monCatalogue.ajouter(elmt1));
		assertEquals(2, monCatalogue.nbTotalCopies());

		//Case d'ajout	
		assertEquals(true, monCatalogue.ajouter(new Alphabet(3, "b")));
	}

	/**
	 * Test method for {@link ca.uqam.inf2120.CatalogueChaineeImplTest.adt.impl.CatalogueChaineeImpl#ajouter(List)}.
	 */
	@Test
	public void testAjouterList() {
		
		//remplir catalogue
		monCatalogue.ajouter(new Alphabet(3, "b")); 
		monCatalogue.ajouter(new Alphabet(1, "a"));
		
		//Cas ajouter liste nulle	
		//liste a supprimer	
		List<Alphabet> liste = null;	
		monCatalogue.ajouter(liste);
		assertEquals(4, monCatalogue.nbTotalCopies());	
		
		//Cas ajouter liste vide
		//liste a supprimer	
		liste = new ArrayList<Alphabet>();	
		monCatalogue.ajouter(liste);
		assertEquals(4, monCatalogue.nbTotalCopies());	

		//Cas ajouter liste dans catalogue
		//Ajouter des �l�ments � la liste � ajouter	
		liste.add(new Alphabet(1, "a"));
		liste.add(new Alphabet(4, "a"));

		monCatalogue.ajouter(liste);		
		
		Iterator<Alphabet> it = monCatalogue.iterator();		
		assertEquals("b", ((Alphabet)it.next()).obtenirLettre());		
		assertEquals(6, ((Alphabet)it.next()).obtenirNbCopies());
		
		assertEquals(9, monCatalogue.nbTotalCopies());	
	}

	/**
	 * Test method for {@link ca.uqam.inf2120.CatalogueChaineeImplTest.adt.impl.CatalogueChaineeImpl#supprimer(ca.uqam.inf2120.tp1.adt.NombreCopies)}.
	 */
	@Test
	public void testSupprimer() {
		//remplir catalogue		
		monCatalogue.ajouter(new Alphabet (8, "a"));		
		
		//Cas d'�l�ment pas dans la liste
		assertEquals(false, monCatalogue.supprimer(new Alphabet(3, "b")));		
		
		//Cas d'�l�ment dans la liste
		assertEquals(true, monCatalogue.supprimer(new Alphabet(2, "a")));
		Iterator<Alphabet> it = monCatalogue.iterator();		
		assertEquals(6, ((Alphabet)it.next()).obtenirNbCopies());		
	}

	/**
	 * Test method for {@link ca.uqam.inf2120.CatalogueChaineeImplTest.adt.impl.CatalogueChaineeImpl#supprimer(List)}.
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
		
		assertNull(monCatalogue.supprimer(liste));
				
		//Cas de supprimer 1 elements valide et un non valide
		liste.clear();		
		liste.add(new Alphabet (3, "a")); 
		liste.add(new Alphabet (1, "d"));
		
		//catalogue	(5a,8b)	
		List<Alphabet> listeNonSupprimes = monCatalogue.supprimer(liste);		
		
		assertEquals(1, listeNonSupprimes.size());
		
		Iterator<Alphabet> it = monCatalogue.iterator();		
		assertEquals(2, ((Alphabet)it.next()).obtenirNbCopies());	
		assertEquals(8, ((Alphabet)it.next()).obtenirNbCopies());			
	}

	/**
	 * Test method for {@link ca.uqam.inf2120.CatalogueChaineeImplTest.adt.impl.CatalogueChaineeImpl#remplacer(ca.uqam.inf2120.tp1.adt.NombreCopies, ca.uqam.inf2120.tp1.adt.NombreCopies)}.
	 */
	@Test
	public void testRemplacer() {

		Alphabet elmARemplacer = new Alphabet ("a");
		//remplir catalogue	
		monCatalogue.ajouter(new Alphabet (3, "b"));
		monCatalogue.ajouter(new Alphabet (6, "a"));
		
		//Cas element � remplacer pas dans la liste(Pas de changements)
		assertEquals(false, monCatalogue.remplacer(new Alphabet(3, "z"),elmARemplacer));	

		//Cas nombre de copies <1 (Pas de changements)
		assertEquals(false, monCatalogue.remplacer(elmARemplacer,  new Alphabet(-1, "c")));	

		//Cas element d�j� dans la liste(Pas de changements)
		assertEquals(false, monCatalogue.remplacer(elmARemplacer,  new Alphabet(4, "a")));			
		
		//Cas de changements : b3, a6  ->  b3, c2  
		assertEquals(true, monCatalogue.remplacer(elmARemplacer,  new Alphabet(2, "c")));	
		
		Iterator<Alphabet> it = monCatalogue.iterator();
		assertEquals(3, ((Alphabet)it.next()).obtenirNbCopies());
		assertEquals(2, ((Alphabet)it.next()).obtenirNbCopies());
	}
	
	/**
	 * Test method for {@link ca.uqam.inf2120.CatalogueChaineeImplTest.adt.impl.CatalogueChaineeImpl#existe(ca.uqam.inf2120.tp1.adt.NombreCopies)}.
	 */
	@Test
	public void testExiste() {
		
		//Cas catalogue vide		
		assertEquals(false, monCatalogue.existe(new Alphabet (8, "a")));
		//remplir catalogue	(8a,9b)	
		monCatalogue.ajouter(new Alphabet (8, "a"));
		monCatalogue.ajouter(new Alphabet (9, "b"));
		//Cas catalogue existe		
		assertEquals(true, monCatalogue.existe(new Alphabet (6, "a")));
	}
	
	/**
	 * Test method for {@link ca.uqam.inf2120.CatalogueChaineeImplTest.adt.impl.CatalogueChaineeImpl#nbCopies(ca.uqam.inf2120.tp1.adt.NombreCopies)}.
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
	 * Test method for {@link ca.uqam.inf2120.CatalogueChaineeImplTest.adt.impl.CatalogueChaineeImpl#nbTotalCopies()}.
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
	 * Test method for {@link ca.uqam.inf2120.CatalogueChaineeImplTest.adt.impl.CatalogueChaineeImpl#estEgale(ca.uqam.inf2120.tp1.adt.Catalogue)}.
	 */
	@Test
	public void testEstEgale() {
		
		//Cas La liste Catalogue a v�rifier est nulle
		assertEquals(false, monCatalogue.estEgale(null));
		
		//Cas les deux listes sont vides
		Catalogue<Alphabet> catalogueTest = new CatalogueChaineeImpl<Alphabet>();
		assertEquals(true, monCatalogue.estEgale(catalogueTest));
		
		//remplir le catalogue	(8a,9b)	
		monCatalogue.ajouter(new Alphabet (8, "a"));
		monCatalogue.ajouter(new Alphabet (9, "b"));		
		
		//Cas La liste Catalogue a v�rifier est nulle
		assertEquals(false, monCatalogue.estEgale(null));		
	
		//Cas La liste Catalogue a v�rifier est vide
		assertEquals(false, monCatalogue.estEgale(catalogueTest));
		
		//Cas La liste Catalogue a v�rifier manque d'�l�ments
		catalogueTest.ajouter(new Alphabet (8, "a"));
		assertEquals(false, monCatalogue.estEgale(catalogueTest));		
		
		//Cas La liste Catalogue a v�rifier est egale
		catalogueTest.ajouter(new Alphabet (9, "b"));
		assertEquals(true, monCatalogue.estEgale(catalogueTest));		
		
		//Cas La liste Catalogue n'as pas le m�me nbr. copies
		Catalogue<Alphabet> cataloguePasNbrCopies = new CatalogueChaineeImpl<Alphabet>();	
		cataloguePasNbrCopies.ajouter(new Alphabet (5, "a"));
		cataloguePasNbrCopies.ajouter(new Alphabet (9, "b"));	

		assertEquals(false, monCatalogue.estEgale(cataloguePasNbrCopies));		

	}

	/**
	 * Test method for {@link ca.uqam.inf2120.CatalogueChaineeImplTest.adt.impl.CatalogueChaineeImpl#estVide()}.
	 */
	@Test
	public void testEstVide() {
		//Cas catalogue est vide
		assertEquals(true, monCatalogue.estVide());		

		//Cas catalogue n'est pas vide
		monCatalogue.ajouter(new Alphabet (8, "a"));		
		assertEquals(false, monCatalogue.estVide());
		
	}

	/**
	 * Test method for {@link ca.uqam.inf2120.CatalogueChaineeImplTest.adt.impl.CatalogueChaineeImpl#vider()}.
	 */
	@Test
	public void testVider() {
		//remplir catalogue	(8a,9b)	
		monCatalogue.ajouter(new Alphabet (8, "a"));
		monCatalogue.ajouter(new Alphabet (9, "b"));	
		
		assertEquals(false, monCatalogue.estVide());		
		monCatalogue.vider();		
		assertEquals(true, monCatalogue.estVide());
	
	}
	
	/**
	 * Test method for {@link ca.uqam.inf2120.CatalogueChaineeImplTest.adt.impl.CatalogueChaineeImpl#iterator()}.
	 */
	@Test
	public void testIterator() {
		
		//monCatalogue = b-3; a-6		
		testAjouterList();
		
		Iterator<Alphabet> monIterator = monCatalogue.iterator();	
		
		assertNotNull(monIterator);

		assertEquals( "b", monIterator.next().obtenirLettre());
		assertEquals( "a", monIterator.next().obtenirLettre());
		assertEquals( false, monIterator.hasNext());
		
		//Cas de deuxi�me iterateur (differents pointeurs)
		assertEquals( true, monCatalogue.iterator().hasNext());
		assertEquals( "b", monCatalogue.iterator().next().obtenirLettre());
	}
	
	/**
	 * Test method for {@link ca.uqam.inf2120.CatalogueChaineeImplTest.adt.impl.CatalogueChaineeImpl#hasNext()}.
	 */
	@Test
	public void testHasNext() {
		
		// Cas Catalogue Vide
		assertEquals( false, monCatalogue.iterator().hasNext());		

		// Cas Catalogue n'est pas vide (un �l�ment)
		monCatalogue.ajouter(new Alphabet (8, "a"));
		Iterator<Alphabet> monIterator = monCatalogue.iterator();	
		assertEquals( true, monIterator.hasNext());	
		
		monIterator.next(); //avancer
		assertEquals( false,monIterator.hasNext());	
		
		// Cas Catalogue n'est pas vide (deux �l�ment)		
		monCatalogue.ajouter(new Alphabet (2, "b"));
		assertEquals( true, monCatalogue.iterator().hasNext());	
		monIterator.next(); //avancer
		assertEquals( true,monIterator.hasNext());	
		
	}
	
	/**
	 * Test method for {@link ca.uqam.inf2120.CatalogueChaineeImplTest.adt.impl.CatalogueChaineeImpl#Next()}.
	 */
	@Test
	public void testNext() {
		
		//monCatalogue = b-3; a-6
		testAjouterList();
		Iterator<Alphabet> monIterator = monCatalogue.iterator();	
		
		assertEquals( "b", monIterator.next().obtenirLettre());
		assertEquals( "a", monIterator.next().obtenirLettre());
		assertEquals( false, monIterator.hasNext());
		
		//Cas de deux iterateurs (differents pointeurs)
		assertEquals( true, monCatalogue.iterator().hasNext());
	}
	
	/**
	 * Test method for {@link ca.uqam.inf2120.CatalogueChaineeImplTest.adt.impl.CatalogueChaineeImpl#Remove()}.
	 */
	@Test
	public void testRemove() {
		
		//monCatalogue = b-3; a-6
		testAjouterList();
		Iterator<Alphabet> monIterator = monCatalogue.iterator();		
		assertEquals( "b", monIterator.next().obtenirLettre());
		
		// TEST aucun changement
        monIterator.remove();
		assertEquals( "b", monCatalogue.iterator().next().obtenirLettre());
	}
	
}
