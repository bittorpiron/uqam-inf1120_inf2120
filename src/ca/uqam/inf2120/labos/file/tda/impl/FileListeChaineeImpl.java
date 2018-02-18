/**
 * FileListeChaineeImpl.java
 */
package ca.uqam.inf2120.labos.file.tda.impl;

import ca.uqam.inf2120.exemplesvusenclasse.listechainee.Noeud;
import ca.uqam.inf2120.exemplesvusenclasse.tda.File;
import ca.uqam.inf2120.exemplesvusenclasse.tda.FileVideException;


/**
 * @author Victor Piron
 * PIRV11026606
 * INF2120 Groupe 30 (Ismaël Doukoure)
 * piron.victor@courrier.uqam.ca  
 * @version 2014-03-13
 * @param <T>
 */
public class FileListeChaineeImpl<T> implements File<T> {
	
	private Noeud<T> debut; // La référence vers le premier de la file
	private Noeud<T> fin;   // La référence vers le dernier de la file
	private int nbElements;  // Nombre d'élements dans la file
	
	/**
	 * Constructeur sans argument permet
	 * de créer une nouvelle file sous forme 
	 * de liste chaînée. 
	 */
	public FileListeChaineeImpl() {
		debut = null;
		fin = null;
		nbElements = 0;
	}
	
	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.labos.file.tda.File#enfiler(java.lang.Object)
	 */
	@Override
	public void enfiler(T nouveauElement) {
		
		// Créer un nouveau noeud avec le nouveau élément
		Noeud<T> unNoeud = new Noeud<T>(nouveauElement); 
		
		if (debut==null){
			
			debut = fin = unNoeud; 
			
		}else{
			// Initialiser la variable suivant du dernier objet avec le noveau element
			fin.setSuivant(unNoeud); 
			// Remplacer la référence par le nouveau fin (nouveau noeud)
			fin = unNoeud; 			
		}
		
		// Incrémente le nombre d'éléments
		nbElements++; 		
	}

	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.labos.file.tda.File#defiler()
	 */
	@Override
	public T defiler() {
		// Vérification si la file est vide
		if (estVide()) { 
			throw new FileVideException();
		}
		
		// Obtenir la réference vers l'élement du 1er noeud
		T element = debut.getElement();  		
		// Déplacer le debut sur le noeud suivant
		debut = debut.getSuivant();
		// Décrémenter le nombre d'éléments
		nbElements--; 
		
		return element;
	}

	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.labos.file.tda.File#estVide()
	 */
	@Override
	public boolean estVide() {
		return (debut == null);
	}

	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.labos.file.tda.File#taille()
	 */
	@Override
	public int taille() {

		return nbElements;
	}

	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.exemplesvusenclasse.tda.File#debut()
	 */
	@Override
	public T debut() throws FileVideException {
		if (estVide()) {
			throw new FileVideException();
		}
		
	   return debut.getElement(); 
	   
	}

}
