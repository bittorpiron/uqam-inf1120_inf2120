package ca.uqam.inf2120.exemplesvusenclasse.tda.impl;

import java.util.ArrayList;
import java.util.List;

import ca.uqam.inf2120.exemplesvusenclasse.tda.Pile;
import ca.uqam.inf2120.exemplesvusenclasse.tda.PileVideException;

/**
 * Implantation de l'interface Pile<T>
 * 
 * @author Ismael Doukoure
 * @version 2008-01-22 
 * Modifié le 08 février 2014
 */

public class PileArrayListImpl<T> implements Pile<T> {

	// Liste dans laquelle les éléments
	// sont stockés.
	List<T> liste;

	/**
	 * Constructeur sans arguments
	 */
	public PileArrayListImpl() {
		liste = new ArrayList<T>();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ca.uqam.inf2120.exemplesvusenclasse.tda.Pile#empiler(java.lang.Object)
	 */
	@Override
	public void empiler(T e) {
		liste.add(e);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.uqam.inf2120.exemplesvusenclasse.tda.Pile#depiler()
	 */
	@Override
	public T depiler() throws PileVideException{
		if (estVide()) {
			throw new PileVideException("On ne peut pas dépiler dans une pile vide");
		}
		return liste.remove(liste.size() - 1);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.uqam.inf2120.exemplesvusenclasse.tda.Pile#estVide()
	 */
	@Override
	public boolean estVide() {
		return liste.isEmpty();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.uqam.inf2120.exemplesvusenclasse.tda.Pile#taille()
	 */
	@Override
	public int taille() {
		return liste.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ca.uqam.inf2120.exemplesvusenclasse.tda.Pile#sommet()
	 */
	@Override
	public T sommet() throws PileVideException{
		if (estVide()) {
			throw new PileVideException("Pas de sommet pour une pile");
		}

		return liste.get(liste.size() - 1);
	}

}
