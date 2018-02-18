/**
 * 
 */
package ca.uqam.inf2120.exemplesvusenclasse.interfaces;

/**
 * LangueParlee : Interface définissant les services pour dire "Bonjour",
 * "Au revoir" et "Merci" dans différentes langues parlées.
 * 
 * UQAM - INF2120
 * 
 * @author Ismael Doukoure
 * @version Février 2014
 */

public interface LangueParlee {

	/**
	 * Dire "Bonjour" dans une langue
	 */
	public abstract void direBonjour();

	/**
	 * Dire "Au revoir" dans une langue
	 */
	public abstract void direAuRevoir();

	/**
	 * Dire "Merci" dans une langue
	 */
	public abstract void direMerci();

}
