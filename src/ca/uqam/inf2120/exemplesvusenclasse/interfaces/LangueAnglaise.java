/**
 * 
 */
package ca.uqam.inf2120.exemplesvusenclasse.interfaces;

/**
 * La classe LangueAnglaise implémente l'interface LangueParlee.
 * 
 * UQAM - INF2120
 * 
 * @author Ismael Doukoure
 * @version Février 2014
 */
public class LangueAnglaise implements LangueParlee {

	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.exemplesvusenclasse.interfaces.LangueParlee#direBonjour()
	 */
	public void direBonjour() {
	      System.out.println("Hello");

	}

	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.exemplesvusenclasse.interfaces.LangueParlee#direAuRevoir()
	 */
	public void direAuRevoir() {
		System.out.println("Goodbye");

	}

	/* (non-Javadoc)
	 * @see ca.uqam.inf2120.exemplesvusenclasse.interfaces.LangueParlee#direMerci()
	 */
	public void direMerci() {
		System.out.println("Thanks");

	}

}
