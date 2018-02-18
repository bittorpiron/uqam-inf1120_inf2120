/**
 * Employe.java
 */
package ca.uqam.inf2120.exemplesvusenclasse.heritage.surchargeC;

/**
 * @author Victor Piron
 * PIRV11026606
 * INF2120 Groupe 30 (Ismaël Doukoure)
 * piron.victor@courrier.uqam.ca  
 * @version 2014-02-02
 */
public class Employe extends Personne {

		public void valider(Object o) {
		System.out.println("Employe-valider(Object)");
		}
		public void comparer(Employe emp) {
		System.out.println("Employe-comparer(Employe)");
		}
		public void demenager(Object o) {
		System.out.println("Employe - demenager(Object)");
		}

}
