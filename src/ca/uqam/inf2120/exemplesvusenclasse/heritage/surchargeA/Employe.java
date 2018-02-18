/**
 * Employe.java
 */
package ca.uqam.inf2120.exemplesvusenclasse.heritage.surchargeA;

/**
 * @author Victor Piron
 * PIRV11026606
 * INF2120 Groupe 30 (Ismaël Doukoure)
 * piron.victor@courrier.uqam.ca  
 * @version 2014-02-02
 */
public class Employe extends Personne {

	public boolean equals(Object obj) {
		System.out.println("Employe-equals(Object)");
		return true;
		}
		public String toString() {
		System.out.println("Employe-toString()");
		return "";
	}

}
