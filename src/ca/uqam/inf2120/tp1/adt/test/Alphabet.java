package ca.uqam.inf2120.tp1.adt.test;

import ca.uqam.inf2120.tp1.adt.NombreCopies;

/**
 * Alphabet : Cette classe correspond à l'élément T et 
 * sera utilisé pour faire les tests unitaires
 *    
 * @author Ismael Doukoure - INF2120 - Groupe 30
 * @version 12 février 2014
 */
public class Alphabet implements NombreCopies{
	
	// Déclaration des attributs
	private String lettre;
	private int nbCopies;
	
	/**
	 * Constructeur avec 1 argument.
	 * 
	 * @param lettre La lettre
	 */
	public Alphabet(String lettre) {
		super();
		this.lettre = lettre;
	}

	/**
	 * Constructeur avec 2 arguments
	 * 
	 * @param nombre le nombre de la lettre
	 * @param lettre La lettre
	 */
	public Alphabet(int nombre, String lettre) {
		this.lettre = lettre;
		if (nombre >= 0) {
			this.nbCopies = nombre;
		}
	}
	
	/**
	 * Retourner l'attribut lettre.
	 * 
	 * @return String La lettre retournée
	 */
	public String obtenirLettre() {
		return lettre;
	}


	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.tp1.partie1.adt.NombreCopies#augmenter(int)
	 */
	public void augmenter(int nbCopies) {
		this.nbCopies = this.nbCopies + nbCopies;
	}
	
	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.tp1.partie1.adt.NombreCopies#diminuer(int)
	 */
	public void diminuer(int nbCopies) {
		this.nbCopies = this.nbCopies - nbCopies;
	}
	
	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.tp1.partie1.adt.NombreCopies#obtenirNbCopies(int)
	 */
	public int obtenirNbCopies() {
		return nbCopies;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object unAutreObjet) {
		
		// Si les 2 objets sont identiques, on doit retourner
		// vrai comme résultat.
	    if (this == unAutreObjet) {
			return true;
		}
		
		// Si unAutreObjet vaut null, on doit retourner
		// faux comme résultat.
		if (unAutreObjet == null) {
			return false;
		}
		
		// Si les 2 objets (this, unAutreObjet) ne sont pas de même
		// classe, ils ne peuvent pas être égaux, on doit retourner
		// faux comme résultat.
		if (this.getClass() != unAutreObjet.getClass()) {
			return false;
		}
		
		// Sachant que unAutreObjet n'est pas null et que unAutreObjet
		// et l'objet courant sont de même type, on peut se permettre
		// la conversion de UnAutreObjet en ElementQuantite
		Alphabet alphabet = (Alphabet)unAutreObjet;
		
		// Tester si les attributs ont les mêmes valeurs
		// SAUF l'attribut nombre.
		return (lettre.equals(alphabet.obtenirLettre()));
		
	}


}