package ca.uqam.inf2120.exemplesvusenclasse.tda.impl;

import java.util.EmptyStackException;

import ca.uqam.inf2120.exemplesvusenclasse.listechainee.Noeud;
import ca.uqam.inf2120.exemplesvusenclasse.tda.Pile;



/**
 * Implémentation du tda Pile avec une liste chaînée.
 * 
 * @author Ismael Doukoure
 * @version 2008-02-03
 * Modifié le 12 mars 2014
 */
public class PileListeChaineeImpl<T> implements Pile<T> {
	
	private Noeud<T> sommet; // La référence vers le sommet de la pile
	private int nbElements;  // Nombre d'élements dans la pile
	
	/**
	 * Constructeur sans argument permet
	 * de créer une nouvelle pile sous forme 
	 * de liste chaînée. 
	 */
	public PileListeChaineeImpl() {
		sommet = null;
		nbElements = 0;
	}

	/* (non-Javadoc)
	 * @see adt.pile.Pile#empiler(java.lang.Object)
	 */
	public void empiler(T nouveauElement) {

		// Créer un nouveau noeud avec le nouveau élément
		Noeud<T> unNoeud = new Noeud<T>(nouveauElement); 
		// Initialiser la variable suivant du nouvel objet avec leSommet
		unNoeud.setSuivant(sommet); 
		// Remplacer la référence par le nouveau sommet (nouveau noeud)
		sommet = unNoeud; 
		// Incrémente le nombre d'éléments
		nbElements++;     

	}

	/* (non-Javadoc)
	 * @see adt.pile.Pile#depiler()
	 */
	public T depiler() {
		
		// Vérification si la pile est vide
		if (estVide()) { 
			throw new EmptyStackException();
		}
		
		// Obtenir la réference vers l'élement du 1er noeud
		T element = sommet.getElement();  
		// Déplacer le sommet sur le noeud suivant
		sommet = sommet.getSuivant();
		// Décrémenter le nombre d'éléments
		nbElements--; 
		
		return element; 
	}

	/* (non-Javadoc)
	 * @see adt.pile.Pile#estVide()
	 */
	public boolean estVide() {
		return (sommet == null);
	}

	/* (non-Javadoc)
	 * @see adt.pile.Pile#taille()
	 */
	public int taille() {
		return nbElements;
	}

	/* (non-Javadoc)
	 * @see adt.pile.Pile#sommet()
	 */
	public T sommet() {
		
		if (estVide()) {
			throw new EmptyStackException();
		}
		
	   return sommet.getElement(); 
	}

	/* (non-Javadoc)
	 * @see adt.pile.Pile#vider()
	 */
	public void vider() {
		sommet = null;
		// Reinitialiser le nombre d'éléments à 0
		nbElements = 0; 

	}


}
