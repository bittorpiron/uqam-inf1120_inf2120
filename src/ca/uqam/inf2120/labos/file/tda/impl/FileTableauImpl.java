package ca.uqam.inf2120.labos.file.tda.impl;

import ca.uqam.inf2120.labos.file.tda.File;
import ca.uqam.inf2120.labos.file.tda.FileVideException;

/**
 * FileTableauImpl<T> implémente l'interface File<T>
 * avec un tableau de taille statique.
 *  
 * @author Ismael Doukoure / Gloire Lomani
 * @version Février 2014.
 * 
 */
public class FileTableauImpl<T> implements File<T> {
	
	// Liste dans laquelle les éléments
	// sont stockés.
	public final int TAILLE_MAX = 25;
		
	private T [] tableau;
	private int nbElements;
	
	
	/**
	 * Constructeur sans argument
	 */
	@SuppressWarnings("unchecked")
	public FileTableauImpl() {
		tableau = (T[])new Object[TAILLE_MAX];
		nbElements = 0;
	}
	
	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.labos.file.tda.File#enfiler(java.lang.Object)
	 */
	@Override
	public void enfiler(T e) {
		
		if (nbElements >=  TAILLE_MAX) {
			throw new FilePleineException("Aucune place pour ajouter un autre élément");
		}
				
		tableau[nbElements] = e;
		nbElements++;
		
	}

	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.labos.file.tda.File#defiler()
	 */
	@Override
	public T defiler() throws FileVideException {
		
		if (nbElements == 0) {
			throw new FileVideException("Impossible de defiler dans une file vide");
		}
		
		T element = tableau[0];
		
		for (int i = 0; i < nbElements - 1; i++) {
			tableau[i] = tableau[i+1];
		}
		
		nbElements--;
		tableau[nbElements] = null;
		
		return element;
	}

	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.labos.file.tda.File#estVide()
	 */
	@Override
	public boolean estVide() {
		
		 return (nbElements == 0);
	}

	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.labos.file.tda.File#taille()
	 */
	@Override
	public int taille() {
		
		return nbElements;
	}

	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.labos.file.tda.File#debut()
	 */
	@Override
	public T debut() throws FileVideException {

		if (estVide()) {
            throw new FileVideException("Impossible de retourner le premier dans une file vide");
        }
		
    	return tableau[0];
	}
	

}
