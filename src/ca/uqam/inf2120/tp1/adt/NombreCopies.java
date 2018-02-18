package ca.uqam.inf2120.tp1.adt;

/**
 * UQAM - Hiver 2014 - INF2120 - Groupe 30 - TP1
 * 
 * NombreCopie : Interface d�finissant les services d'ajustement du nombre 
 *               de copies d'un �l�ment donn�. Les services 'augmenter' et
 *               'diminuer' permettent respectivement d'augmenter ou de diminuer
 *               le nombre de copies. 
 *    
 * @author Ismael Doukoure
 * @version  12 f�vrier 2014
 */
 public interface NombreCopies {
	
	/**
	 * Augmente le nombre de copies.
	 * 
	 * @param nbCopies le nombre de copies � ajouter.
	 */
	 public void augmenter(int nbCopies);
	
	/**
	 * Diminue le nombre de copies.
	 * 
	 * @param nbCopies le nombre de copies � enlever.
	 */
	public void diminuer(int nbCopies);
	
	/**
	 * Retourner le nombre de copies.
	 * @return Nombre de copies
	 */
	public int obtenirNbCopies();
	
	

}
