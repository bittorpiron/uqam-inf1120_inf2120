/**
 * Enseignant.java
 */
package ca.uqam.inf2120.exemplesvusenclasse.heritage.surchargeD;

/**
 * @author Victor Piron
 * PIRV11026606
 * INF2120 Groupe 30 (Ismaël Doukoure)
 * piron.victor@courrier.uqam.ca  
 * @version 2014-02-02
 */
public class Enseignant extends Personne {

	public void valider(Personne pers) {
		System.out.println("Enseignant - valider(Personne)");
		}
		public void comparer(Object o) {
		System.out.println("Enseignant - comparer(Object)");
		}
		public void demenager(Object o) {
		System.out.println("Enseignant-demenager(Object)");
		}

}
