/**
 * Enseignant.java
 */
package ca.uqam.inf2120.exemplesvusenclasse.heritage.surchargeC;

/**
 * @author Victor Piron
 * PIRV11026606
 * INF2120 Groupe 30 (Ismaël Doukoure)
 * piron.victor@courrier.uqam.ca  
 * @version 2014-02-02
 */
public class Enseignant extends Personne {

	public void valider(Employe emp) {
		System.out.println("Enseignant - valider(Employe)");
		}
		public void comparer(Object o) {
		System.out.println("Enseignant - comparer(Object)");
		}
		public void demenager(Enseignant ens) {
		System.out.println("Enseignant-demenager(Enseignant)");
		}
}
