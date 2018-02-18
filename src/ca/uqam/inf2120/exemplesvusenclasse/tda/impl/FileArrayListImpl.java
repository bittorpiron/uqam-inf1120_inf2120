/**
 * 
 */
package ca.uqam.inf2120.exemplesvusenclasse.tda.impl;

import java.util.ArrayList;
import java.util.List;

import ca.uqam.inf2120.exemplesvusenclasse.tda.File;
import ca.uqam.inf2120.exemplesvusenclasse.tda.FileVideException;

/**
 * Implantation de l'interface File<T>
 * 
 * @author Ismael Doukoure
 * @version 2008-01-22 
 * Modifié le 08 février 2014
 */
public class FileArrayListImpl<T> implements File<T> {
	
	// Liste dans laquelle les éléments
	// sont stockés.
	List<T> liste;

	/**
	 * Constructeur sans argument
	 */
	public FileArrayListImpl() {
		liste = new ArrayList<T>();
	}

	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.exemplesvusenclasse.tda.File#enfiler(java.lang.Object)
	 */
	@Override
	public void enfiler(T e) {
		  liste.add(e);
	}

	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.exemplesvusenclasse.tda.File#defiler()
	 */
	@Override
	public T defiler() throws FileVideException {
		
		if (estVide()) {
            throw new FileVideException("Impossible de defiler dans une file vide");
        }
        return liste.remove(0);
	}

	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.exemplesvusenclasse.tda.File#estVide()
	 */
	@Override
	public boolean estVide() {
		
		 return liste.isEmpty();
	}

	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.exemplesvusenclasse.tda.File#taille()
	 */
	@Override
	public int taille() {
		
		 return liste.size();
	}

	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.exemplesvusenclasse.tda.File#debut()
	 */
	@Override
	public T debut() throws FileVideException {
		
		if (estVide()) {
            throw new FileVideException("Impossible de retourner le premier dans une file vide");
        }
    	return liste.get(0);
	}

}
