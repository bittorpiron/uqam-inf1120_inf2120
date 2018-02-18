package ca.uqam.inf2120.exemplesvusenclasse.junit;


/**
 * I N F 2 1 2 0
 * 
 * Écrire un programme qui  saisit deux nombres réels un opérateur et fait l’opération selon le type d’opérateur saisi.
 * Les opérateurs possibles sont :
 *  	1)	'+'   = La somme des deux nombres.
 *  	2)	'-'    =  La soustraction entre les deux nombres.
 *  	3)	'*'    =  Le produit des deux nombres.
 *  	4)	'%'  =  Le reste de la division du 1er nombre par le 2e nombre.
 *  	5)	'/'   =  La division du 1er nombre par le 2e nombre (si le 2e nombre est égal à 0, afficher le message
 *  		« Impossible de diviser par 0 »
 *
 * @author Doukoure Ismael
 * @since 24/10/2009 - Dernière modification : 26/01/2014
 *
 */
public class Calculatrice {

	/**
	 * Additionne 2 nombres réels.
	 * @param nb1 Le 1er nombre
	 * @param nb2 Le 2e nombre
	 * @return La somme des nombres 1 et 2
	 */
	public double additionner(double nb1, double nb2) {

		// Déclaration d'une variable locale
		double resultat ;

		resultat = nb1 + nb2;

		return resultat;

	}

	/**
	 * Soustraire 2 nombres réels.
	 * @param nb1 Le 1er nombre
	 * @param nb2 Le 2e nombre
	 * @return La différence des nombres 1 et 2
	 */
	public double soustraire(double nb1, double nb2) {

		// Déclaration d'une variable locale
		double resultat ;

		resultat = nb1 - nb2;

		return resultat;

	}

	/**
	 * Multiplie 2 nombres réels.
	 * @param nb1 Le 1er nombre
	 * @param nb2 Le 2e nombre
	 * @return Le produit des nombres 1 et 2
	 */
	public double multiplier(double nb1, double nb2) {

		// Déclaration d'une variable locale
		double resultat ;

		resultat = nb1 * nb2;

		return resultat;

	}

	/**
	 * Diviser 2 nombres réels. Le 1er nombre
	 * doit être divisé par le second. Aucune validation
	 * n'est faite dans cette méthode, Assurez-vous
	 * que le 2e nombre soit différent de 0;
	 * @param nb1 Le 1er nombre
	 * @param nb2 Le 2e nombre
	 * @return Le quotient des nombres 1 et 2
	 */
	public double diviser(double nb1, double nb2) {

		// Déclaration d'une variable locale
		double resultat ;

		resultat = nb1 / nb2;

		return resultat;

	}

	/**
	 * Divise 2 nombres réels et retourne le reste de la division.
	 * @param nb1 Le 1er nombre
	 * @param nb2 Le 2e nombre
	 * @return Le reste de la division des nombres 1 et 2
	 */
	public double modulo(double nb1, double nb2) {

		// Déclaration d'une variable locale
		double resultat ;

		resultat = nb1 % nb2;

		return resultat;

	}

	
} // Calculatrice
