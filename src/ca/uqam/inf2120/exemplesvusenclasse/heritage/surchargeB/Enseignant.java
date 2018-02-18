/**
 * Enseignant.java
 */
package ca.uqam.inf2120.exemplesvusenclasse.heritage.surchargeB;

/**
 * @author Victor Piron
 * PIRV11026606
 * INF2120 Groupe 30 (Ismaël Doukoure)
 * piron.victor@courrier.uqam.ca  
 * @version 2014-02-02
 */
public class Enseignant extends Employe {
	public void valider(Enseignant ens) {
		System.out.println("Enseignant-valider(Enseignant)");
	}
}
