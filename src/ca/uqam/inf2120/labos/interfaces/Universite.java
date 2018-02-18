package ca.uqam.inf2120.labos.interfaces;


/**
 * 
 * Universite : Interface d�finissant les services de gestion des personnes
 * (Étudiants / Employés) d'une Université.
 * 
 * Université du Québec à Montréal INF2120 - Programmation II
 * 
 * @author Ismael Doukoure
 * @version 13 février 2014
 * 
 */
public interface Universite<T> {

	/**
	 * Ajoute "elt" dans la liste. Aucun ajout ne doit être fait 
	 * si "elt" existe déjà dans la liste.
	 * 
	 * @param elt élément à ajouter.
	 */
	public void ajouter(T elt);

	/**
	 * V�rifie si "elt" existe dans la liste.
	 * 
	 * @param elt élément dont l'existence doit être vérifiée.
	 * @return true si l'elt existe, sinon false.
	 */
	public boolean existe(T elt);

	/**
	 * Supprime "elt" de la liste.
	 * 
	 * @param elt élément à supprimer
	 * @return true si "elt" est supprimé, sinon false.
	 */
	public boolean supprimer(T elt);


	/**
	 * Retourne l'élément à la position précisée.
	 * 
	 * @param position la position de l'élément à  retourner
	 * @return T l'élément à retourner.
	 */
	public T obtenir(int position);

}
