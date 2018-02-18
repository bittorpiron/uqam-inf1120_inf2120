/**
 * 
 */
package ca.uqam.inf2120.exemplesvusenclasse.interfaces;

/**
 * La classe LangueEspagnole implémente l'interface LangueParlee.
 * 
 * UQAM - INF2120
 * 
 * @author Ismael Doukoure
 * @version Février 2014
 */
public class LangueEspagnole implements LangueParlee {

	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.exemplesvusenclasse.interfaces.LangueParlee#direBonjour()
	 */
	public void direBonjour() {
	      System.out.println("Hola");

	}

	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.exemplesvusenclasse.interfaces.LangueParlee#direAuRevoir()
	 */
	public void direAuRevoir() {
		System.out.println("Adiós");

	}

	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.exemplesvusenclasse.interfaces.LangueParlee#direMerci()
	 */
	public void direMerci() {
		System.out.println("Gracias");

	}

}
