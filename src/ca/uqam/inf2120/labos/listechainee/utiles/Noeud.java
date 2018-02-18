package ca.uqam.inf2120.labos.listechainee.utiles;

/**
 * Titre : Liste Chaînée 
 * Description: La classe Noeud représente l'unité de base
 * d'une liste chaînée.
 * 
 * UQAM - INF2120
 * 
 * @author Ismael Doukoure
 * @version Mars 2008 
 * Modifié le 12 Mars 2014
 */

public class Noeud<T> {
	
	private T element; // référence de l'information contenu dans le noeud
	private Noeud<T> suivant; // référence vers le noeud suivant

	/**
	 * Construire un noeud à vide. Les champs element et suivant seront
	 * initialisés à null.
	 */
	public Noeud() {
		this(null, null); // appel d'un autre constructeur
	}

	/**
	 * Construire un noeud avec une donnée. la référence du prochain 
	 * noeud est mise à nul.
	 * 
	 * @param element La donnée à stocker dans le noeud
	 */
	public Noeud(T element) {
		this(element, null); // appel d'un autre constructeur
	}

	/**
	 * Construire un noeud avec une donnée et le suivant du prochain.
	 * 
	 * @param element La donnée à stocker dans le noeud
	 * @param suivant La référence vers le noeud suivant
	 */
	public Noeud(T element, Noeud<T> suivant) {
		this.element = element;
		this.suivant = suivant;
	}

	/**
	 * Obtenir la donnée stockée dans le noeud
	 * 
	 * @return La référence vers l'objet element
	 */
	public T getElement() {
		return element;
	}

	/**
	 * Obtenir la référence du noeud suivant
	 * 
	 * @return La référence vers le noeud suivant
	 */
	public Noeud<T> getSuivant() {
		return suivant;

	}

	/**
	 * Permet d'initialiser ou modifier le noeud suivant.
	 * 
	 * @param la référence vers le noeud
	 */
	public void setSuivant(Noeud<T> unNoeud) {
		suivant = unNoeud;
	}

	/**
	 * Permet d'initialiser ou modifier la donnée
	 * 
	 * @param element La donnée à stocker
	 */
	public void setElement(T element) {
		this.element = element;

	}

} // Noeud

