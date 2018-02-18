package ca.uqam.inf2120.labos.interfaces.impl;

import java.util.ArrayList;
import java.util.List;

import ca.uqam.inf2120.labos.interfaces.Universite;

/**
 * UniversiteImpl : implèmente l'interface Universite.
 * 
 * @author Ismael Doukoure
 * @version Février 2014
 * 
 */
public class UniversiteImpl<T> implements Universite<T> {

	List<T> liste;

	/**
	 * Constructeur par défaut.
	 */
	public UniversiteImpl() {
		liste = new ArrayList<T>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ca.uqam.inf2120.labos.interfaces.Universite#ajouter(java.lang.Object)
	 */
	@Override
	public void ajouter(T elt) {

		if (!existe(elt)) {
			liste.add(elt);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.uqam.inf2120.labos.interfaces.Universite#existe(java.lang.Object)
	 */
	@Override
	public boolean existe(T elt) {

		boolean existe = false;

		if (elt != null) {
			existe = liste.indexOf(elt) >= 0;
		}

		return existe;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ca.uqam.inf2120.labos.interfaces.Universite#supprimer(java.lang.Object)
	 */
	@Override
	public boolean supprimer(T elt) {
		return liste.remove(elt);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.uqam.inf2120.labos.interfaces.Universite#obtenir(int)
	 */
	@Override
	public T obtenir(int position) {
		
		T e = null;
		if (position >= 0 && position < liste.size()) {
			e = liste.get(position);
		}
		
		return e;
	}

}
