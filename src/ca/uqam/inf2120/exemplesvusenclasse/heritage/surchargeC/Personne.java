/**
 * Persone.java
 */
package ca.uqam.inf2120.exemplesvusenclasse.heritage.surchargeC;

/**
 * @author Victor Piron
 * PIRV11026606
 * INF2120 Groupe 30 (Ismaël Doukoure)
 * piron.victor@courrier.uqam.ca  
 * @version 2014-02-02
 */
public class Personne {

	public void valider(Personne pers) {
		System.out.println("Personne-valider(Personne)");
		}
		public void comparer(Personne pers) {
		System.out.println("Personne-comparer(Personne)");
		}
		public void demenager(Personne pers) {
		System.out.println("Personne-demenager(Personne)");
		}
}


