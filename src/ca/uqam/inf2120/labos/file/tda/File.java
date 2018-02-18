package ca.uqam.inf2120.labos.file.tda;

/**
 * Interface File<T> contenant des éléments de type T.
 * 
 * @author Ismael Doukoure
 * @version 2008-01-27
 * Modifié le 08 février 2014
 */
public interface File<T> {

	/**
	 * Ajoute e à la queue de la file.
	 * 
	 * @param e l'élément à ajouter.
	 */
	public void enfiler(T e);

	/**
	 * Retire l'élément au début de la file.
	 * 
	 * @return L'élément retiré.
	 * @throws FileVideException Si la file est vide.
	 */
	public T defiler() throws FileVideException;

	/**
	 * Retourne vrai si et seulement si la file est vide.
	 * 
	 * @return true si la file est vide, sinon false.
	 */
	public boolean estVide();

	/**
	 * Retorune le nombre d'éléments dans la file.
	 * 
	 * @return Le nombre d'éléments.
	 */
	public int taille();

	/**
	 * Retourne l'élément en tête de file sans le retirer.
	 * 
	 * @return L'élément au début.
	 * @throws FileVideException Si la pile est vide.
	 */
	public T debut() throws FileVideException;
	

}
