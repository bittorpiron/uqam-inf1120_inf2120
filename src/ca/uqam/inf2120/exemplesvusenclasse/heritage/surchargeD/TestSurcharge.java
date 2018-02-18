/**
 * TestSurcharge.java
 */
package ca.uqam.inf2120.exemplesvusenclasse.heritage.surchargeD;

/**
 * @author Victor Piron
 * PIRV11026606
 * INF2120 Groupe 30 (Ismaël Doukoure)
 * piron.victor@courrier.uqam.ca  
 * @version 2014-02-02
 */
public class TestSurcharge {

	public static void main(String[] args) {
		Enseignant ens = new Enseignant();
		ens.valider(ens);
		ens.comparer(ens);
		ens.demenager(ens);
		}

}
